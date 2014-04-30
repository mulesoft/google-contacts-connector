/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.contact.automation;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.modules.google.contact.automation.SmokeTests;
import org.mule.modules.google.contact.automation.testcases.*;

@RunWith(Categories.class)
@IncludeCategory(SmokeTests.class)

@SuiteClasses({
        AddGroupTestCases.class, BatchContactsTestCases.class,
        CreateGroupTestCases.class, DeleteContactByIdTestCases.class,
        DeleteContactPhotoByIdTestCases.class, DeleteContactPhotoTestCases.class,
        DeleteGroupByIdTestCases.class, DeleteGroupTestCases.class,
        DownloadPhotoTestCases.class, GetContactsTestCases.class,
        GetGroupsTestCases.class, InsertContactTestCases.class,
        UpdateContactTestCases.class, UpdateGroupTestCases.class
})
public class SmokeTestSuite {
}
