/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.contact.automation.testcases;

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

public class BatchInsertTestCases extends GoogleContactsTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("batchInsert");
        Integer numContacts = getTestRunMessageValue("numContacts");

        List<GoogleContactEntry> contacts = new ArrayList<GoogleContactEntry>();
        for (int i = 0; i < numContacts; i++) {
            GoogleContactEntry entry = getTestRunMessageValue("contactRef");
            contacts.add(entry);
        }

        upsertOnTestRunMessage("contactsRef", contacts);

    }

    @Category({ RegressionTests.class })
    @Test
    public void testBatchInsert() {
        try {
            Integer numContacts = getTestRunMessageValue("numContacts");
            GoogleContactEntry dummyContactEntry = getTestRunMessageValue("contactRef");
            List<BatchResult> batchResults = runFlowAndGetPayload("batch-insert");

            assertTrue(batchResults.size() == numContacts);

            List<GoogleContactEntry> contactsRef = new ArrayList<GoogleContactEntry>();
            for (BatchResult result : batchResults) {
                assertTrue(result.getId().equals("insert") && result.getStatus().getReason().equals("Created"));

                upsertOnTestRunMessage("id", extractEntryId(result.getEntry()));
                GoogleContactEntry contactEntry = runFlowAndGetPayload("get-contact-by-id");
                assertTrue(contactEntry.getFamilyName().equals(dummyContactEntry.getFamilyName()));
                assertTrue(contactEntry.getEmailAddresses().size() == dummyContactEntry.getEmailAddresses().size());
                contactsRef.add(contactEntry);
            }

            upsertOnTestRunMessage("contactsRef", contactsRef);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        runFlowAndGetPayload("batch-delete");
    }
}