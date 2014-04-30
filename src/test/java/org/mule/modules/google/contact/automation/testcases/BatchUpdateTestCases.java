/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.contact.automation.testcases;

import com.google.gdata.data.contacts.Occupation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.google.api.domain.BatchResult;
import org.mule.modules.google.contact.automation.RegressionTests;
import org.mule.modules.google.contact.wrappers.GoogleContactEntry;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BatchUpdateTestCases extends GoogleContactsTestParent {

    protected List<String> contactEntryIdList = new ArrayList<String>();

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("batchUpdate");

        Integer numContacts = getTestRunMessageValue("numContacts");

        for (int i = 0; i < numContacts; i++) {
            GoogleContactEntry entry = runFlowAndGetPayload("insert-contact");
            contactEntryIdList.add(extractEntryId(entry));
        }

        List<GoogleContactEntry> contactsRef = new ArrayList<GoogleContactEntry>();
        Occupation occupation = getTestRunMessageValue("updateInfo");
        for (String id : contactEntryIdList) {
            upsertOnTestRunMessage("id", id);
            GoogleContactEntry contactEntry = runFlowAndGetPayload("get-contact-by-id");
            contactEntry.setOccupation(occupation);
            contactsRef.add(contactEntry);
        }

        upsertOnTestRunMessage("contactsRef", contactsRef);
    }

    @Category({RegressionTests.class})
    @Test
    public void testBatchUpdate() {
        try {
            // Wait for the remote google object to be refreshed.
            Thread.sleep(5000);

            Integer numContacts = getTestRunMessageValue("numContacts");
            List<BatchResult> batchResults = runFlowAndGetPayload("batch-update");

            assertTrue(batchResults.size() == numContacts);
            for (BatchResult result : batchResults) {
                assertTrue(result.getId().equals("update") && result.getStatus().getReason().equals("Success"));
            }

        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        // Wait for the remote google object to be refreshed.
        Thread.sleep(5000);

        for (String id : contactEntryIdList) {
            upsertOnTestRunMessage("id", id);
            runFlowAndGetPayload("delete-contact-by-id");
        }
    }
}