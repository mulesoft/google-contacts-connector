/**
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * <p/>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.contact.automation.testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.google.contact.automation.RegressionTests;
import org.mule.modules.google.contact.wrappers.GoogleContactGroupEntry;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GetGroupByNameTestCases extends GoogleContactsTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("getGroupByName");

        GoogleContactGroupEntry groupEntry = runFlowAndGetPayload("create-group");

        upsertOnTestRunMessage("name", groupEntry.getTitle().getPlainText());
        upsertOnTestRunMessage("groupRef", groupEntry);
    }

    @Category({ RegressionTests.class })
    @Test
    public void testGetGroupByName() {
        try {
            GoogleContactGroupEntry originalGroupEntry = getTestRunMessageValue("groupRef");
            GoogleContactGroupEntry groupEntry = runFlowAndGetPayload("get-group-by-name");

            // Wait for the remote google object to be refreshed
            Thread.sleep(5000);

            assertTrue(groupEntry != null);
            assertTrue(groupEntry.getId().equals(originalGroupEntry.getId()));

        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        // Wait for the remote google object to be refreshed
        Thread.sleep(5000);

        runFlowAndGetPayload("delete-group");
    }
}