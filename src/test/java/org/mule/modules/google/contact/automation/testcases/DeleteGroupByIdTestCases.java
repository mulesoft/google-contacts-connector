/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.contact.automation.testcases;

import com.google.gdata.util.ResourceNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.google.contact.automation.RegressionTests;
import org.mule.modules.google.contact.automation.SmokeTests;
import org.mule.modules.google.contact.wrappers.GoogleContactGroupEntry;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DeleteGroupByIdTestCases extends GoogleContactsTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("deleteGroupById");

        GoogleContactGroupEntry groupEntry = runFlowAndGetPayload("create-group");

        upsertOnTestRunMessage("id", extractEntryId(groupEntry));
    }

    @Category({ RegressionTests.class, SmokeTests.class })
    @Test
    public void testDeleteGroupById() {
        try {
            // Wait for the remote google object to be created.
            Thread.sleep(5000);

            runFlowAndGetPayload("delete-group-by-id");
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }

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

}