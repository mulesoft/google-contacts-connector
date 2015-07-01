/**
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * <p/>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google.contact.automation.testcases;

import com.google.common.collect.Lists;
import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Link;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.mule.api.config.MuleProperties;
import org.mule.api.store.ObjectStore;
import org.mule.api.store.ObjectStoreException;
import org.mule.common.security.oauth.OAuthState;
import org.mule.modules.google.contact.wrappers.GoogleContactBaseEntity;
import org.mule.modules.google.contact.wrappers.GoogleContactEntry;
import org.mule.modules.google.contact.wrappers.GoogleContactGroupEntry;
import org.mule.modules.tests.ConnectorTestCase;

import java.util.Iterator;
import java.util.List;

public class GoogleContactsTestParent extends ConnectorTestCase {

    // Set global timeout of tests to 10minutes
    @Rule
    public Timeout globalTimeout = new Timeout(600000);

    @Before
    public void init() throws ObjectStoreException, Exception {
        ObjectStore objectStore = muleContext.getRegistry().lookupObject(MuleProperties.DEFAULT_USER_OBJECT_STORE_NAME);
        objectStore.store("accessTokenId", (OAuthState) getBeanFromContext("connectorOAuthState"));
    }

    /*
     * Helper methods below
     */

    protected String extractEntryId(GoogleContactBaseEntity baseEntity) throws Exception {
        String split[] = baseEntity.getId().split("/");
        return split[split.length - 1];
    }

    protected String extractEntryId(BaseEntry baseEntry) throws Exception {
        String split[] = baseEntry.getId().split("/");
        return split[split.length - 1];
    }

    protected boolean isContactEntryInList(Iterator<GoogleContactEntry> iterator, GoogleContactEntry contactEntry) throws Exception {
        List<GoogleContactEntry> contactEntries = Lists.newArrayList(iterator);
        for (GoogleContactEntry googleContactEntry : contactEntries) {
            if (googleContactEntry.getId().equals(contactEntry.getId())) {
                return true;
            }
        }
        return false;
    }

    protected boolean isContactGroupEntryInList(Iterator<GoogleContactGroupEntry> iterator, GoogleContactGroupEntry groupEntry) throws Exception {
        List<GoogleContactGroupEntry> contactGroupEntries = Lists.newArrayList(iterator);
        for (GoogleContactGroupEntry contactGroupEntry : contactGroupEntries) {
            if (contactGroupEntry.getId().equals(groupEntry.getId())) {
                return true;
            }
        }
        return false;
    }

    protected boolean hasContactPhoto(GoogleContactEntry contactEntry) throws Exception {
        for (Link link : contactEntry.getLinks()) {
            if (link.getRel().contains("rel#photo") && link.getEtag() != null) {
                return true;
            }
        }
        return false;
    }
}
