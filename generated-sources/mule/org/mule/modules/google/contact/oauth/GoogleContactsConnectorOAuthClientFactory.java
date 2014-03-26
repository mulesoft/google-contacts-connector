
package org.mule.modules.google.contact.oauth;

import java.io.Serializable;
import javax.annotation.Generated;
import org.mule.api.store.ObjectStore;
import org.mule.common.security.oauth.OAuthState;
import org.mule.modules.google.contact.adapters.GoogleContactsConnectorOAuth2Adapter;
import org.mule.security.oauth.BaseOAuthClientFactory;
import org.mule.security.oauth.OAuth2Adapter;
import org.mule.security.oauth.OAuth2Manager;

@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-03-26T12:34:14-05:00", comments = "Build M4.1875.17b58a3")
public class GoogleContactsConnectorOAuthClientFactory
    extends BaseOAuthClientFactory
{

    private GoogleContactsConnectorOAuthManager oauthManager;

    public GoogleContactsConnectorOAuthClientFactory(OAuth2Manager<OAuth2Adapter> oauthManager, ObjectStore<Serializable> objectStore) {
        super(oauthManager, objectStore);
        this.oauthManager = (GoogleContactsConnectorOAuthManager) oauthManager;
    }

    @Override
    protected Class<? extends OAuth2Adapter> getAdapterClass() {
        return GoogleContactsConnectorOAuth2Adapter.class;
    }

    @Override
    protected void setCustomAdapterProperties(OAuth2Adapter adapter, OAuthState state) {
        GoogleContactsConnectorOAuth2Adapter connector = ((GoogleContactsConnectorOAuth2Adapter) adapter);
        connector.setApplicationName(oauthManager.getApplicationName());
        connector.setScope(oauthManager.getScope());
    }

    @Override
    protected void setCustomStateProperties(OAuth2Adapter adapter, OAuthState state) {
        GoogleContactsConnectorOAuth2Adapter connector = ((GoogleContactsConnectorOAuth2Adapter) adapter);
    }

}
