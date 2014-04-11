/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.contact.automation.testcases;

import com.google.gdata.data.TextConstruct;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.google.contact.automation.RegressionTests;
import org.mule.modules.google.contact.automation.SmokeTests;
import org.mule.modules.google.contact.wrappers.GoogleContactGroupEntry;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class UpdateGroupTestCases extends GoogleContactsTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("updateGroup");

        GoogleContactGroupEntry groupEntry = runFlowAndGetPayload("create-group");
        TextConstruct title = getTestRunMessageValue("updateTitle");
        groupEntry.setTitle(title);

        upsertOnTestRunMessage("groupRef", groupEntry);
    }

    @Category({RegressionTests.class, SmokeTests.class})
    @Test
    public void testUpdateGroup() {
        try {
            // Wait for the remote google object to be created
            Thread.sleep(5000);

            TextConstruct title = getTestRunMessageValue("updateTitle");
            GoogleContactGroupEntry groupEntry = runFlowAndGetPayload("update-group");

            assertTrue(groupEntry != null);
            assertTrue(groupEntry.getTitle().getPlainText().equals(title.getPlainText()));

            upsertOnTestRunMessage("groupRef", groupEntry);

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
