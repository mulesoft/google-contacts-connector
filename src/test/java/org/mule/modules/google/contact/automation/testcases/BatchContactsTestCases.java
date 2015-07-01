/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.contact.automation.testcases;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.google.api.domain.BatchResult;
import org.mule.modules.google.contact.automation.RegressionTests;
import org.mule.modules.google.contact.automation.SmokeTests;
import org.mule.modules.google.contact.wrappers.GoogleContactEntry;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BatchContactsTestCases extends GoogleContactsTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("batchContacts");

        Integer numContacts = getTestRunMessageValue("numContacts");

        List<GoogleContactEntry> contactEntries = new ArrayList<GoogleContactEntry>();
        for (int i = 0; i < numContacts; i++) {
            GoogleContactEntry entry = runFlowAndGetPayload("insert-contact");
            contactEntries.add(entry);
        }

        upsertOnTestRunMessage("contactsRef", contactEntries);
    }

    @Category({ RegressionTests.class, SmokeTests.class })
    @Test
    public void testBatchContacts() {
        try {
            Integer numContacts = getTestRunMessageValue("numContacts");

            // Wait for the remote google object to be refreshed
            Thread.sleep(5000);

            List<BatchResult> batchResults = runFlowAndGetPayload("batch-contacts");
            assertTrue(batchResults.size() == numContacts);
            for (BatchResult result : batchResults) {
                assertTrue(result.getStatus().getReason().equals("Success"));
            }
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }
}