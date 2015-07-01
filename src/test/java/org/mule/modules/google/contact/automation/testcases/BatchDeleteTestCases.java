/**
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * <p/>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.contact.automation.testcases;

import com.google.gdata.util.ResourceNotFoundException;
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

public class BatchDeleteTestCases extends GoogleContactsTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("batchDelete");

        Integer numContacts = getTestRunMessageValue("numContacts");

        List<GoogleContactEntry> contacts = new ArrayList<GoogleContactEntry>();
        for (int i = 0; i < numContacts; i++) {
            GoogleContactEntry entry = runFlowAndGetPayload("insert-contact");
            contacts.add(entry);
        }

        upsertOnTestRunMessage("contactsRef", contacts);
    }

    @Category({ RegressionTests.class })
    @Test
    public void testBatchDelete() {
        try {

            List<BatchResult> batchResults = runFlowAndGetPayload("batch-delete");

            Integer numContacts = getTestRunMessageValue("numContacts");
            assertTrue(batchResults.size() == numContacts);

            for (BatchResult result : batchResults) {
                assertTrue(result.getId().equals("delete") && result.getStatus().getReason().equals("Success"));
                upsertOnTestRunMessage("id", extractEntryId(result.getEntry()));
                try {
                    // Wait for the remote google object to be refreshed.
                    Thread.sleep(5000);

                    // Get the calendar, should throw an exception
                    runFlowAndGetPayload("get-group-by-id");
                } catch (Exception e) {
                    if (e.getCause() instanceof ResourceNotFoundException) {
                        ResourceNotFoundException googleException = (ResourceNotFoundException) e.getCause();
                        // Not found
                        assertTrue(googleException.getHttpErrorCodeOverride() == 404);
                        assertTrue(googleException.getMessage().equals("Not Found"));
                    } else
                        fail(ConnectorTestUtils.getStackTrace(e));
                }
            }

        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }
}