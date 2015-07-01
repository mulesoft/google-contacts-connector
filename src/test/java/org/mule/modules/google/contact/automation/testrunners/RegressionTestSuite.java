/**
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * <p/>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.contact.automation.testrunners;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.modules.google.contact.automation.RegressionTests;
import org.mule.modules.google.contact.automation.testcases.*;

@RunWith(Categories.class) @IncludeCategory(RegressionTests.class)

@SuiteClasses({
        AddGroupTestCases.class,
        BatchContactsTestCases.class,
        BatchInsertTestCases.class,
        BatchGroupsTestCases.class,
        BatchUpdateTestCases.class,
        BatchDeleteTestCases.class,
        CreateGroupTestCases.class,
        DeleteContactByIdTestCases.class,
        DeleteContactPhotoByIdTestCases.class,
        DeleteContactPhotoTestCases.class,
        DeleteContactTestCases.class,
        DeleteGroupByIdTestCases.class,
        DeleteGroupTestCases.class,
        DownloadPhotoByIdTestCases.class,
        DownloadPhotoTestCases.class,
        GetContactByIdTestCases.class,
        GetContactsTestCases.class,
        GetGroupByIdTestCases.class,
        GetGroupByNameTestCases.class,
        GetGroupsTestCases.class,
        InsertContactTestCases.class,
        UpdateContactPhotoTestCases.class,
        UpdateContactTestCases.class,
        UpdateGroupTestCases.class }) public class RegressionTestSuite {

}
