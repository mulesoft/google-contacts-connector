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
import org.mule.modules.google.contact.automation.RegressionTests;
import org.mule.modules.google.contact.automation.SmokeTests;
import org.mule.modules.google.contact.wrappers.GoogleContactEntry;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class UpdateContactTestCases extends GoogleContactsTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("updateContact");

        GoogleContactEntry contactEntry = runFlowAndGetPayload("insert-contact");
        Occupation occupation = getTestRunMessageValue("updateTitle");
        contactEntry.setOccupation(occupation);

        upsertOnTestRunMessage("contactRef", contactEntry);
    }

    @Category({RegressionTests.class, SmokeTests.class})
    @Test
    public void testUpdateContact() {
        try {
            Occupation occupation = getTestRunMessageValue("updateTitle");
            GoogleContactEntry contactEntry = runFlowAndGetPayload("update-contact");

            assertTrue(contactEntry != null);
            assertTrue(contactEntry.getOccupation().getValue().equals(occupation.getValue()));

            upsertOnTestRunMessage("contactRef", contactEntry);

        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        // Wait for the remote google object to be refreshed
        Thread.sleep(5000);

        runFlowAndGetPayload("delete-contact");
    }
}
