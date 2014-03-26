
package org.mule.modules.google.contact.oauth;

import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.google.contact.adapters.GoogleContactsConnectorOAuth2Adapter;
import org.mule.modules.google.contact.process.ProcessCallback;
import org.mule.modules.google.contact.process.ProcessCallbackProcessInterceptor;
import org.mule.modules.google.contact.process.ProcessInterceptor;
import org.mule.modules.google.contact.process.ProcessTemplate;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:38:00-05:00", comments = "Build 3.4.3.1620.30ea288")
public class ManagedAccessTokenProcessTemplate<P >implements ProcessTemplate<P, GoogleContactsConnectorOAuth2Adapter>
{

    private final ProcessInterceptor<P, GoogleContactsConnectorOAuth2Adapter> processInterceptor;

    public ManagedAccessTokenProcessTemplate(OAuthManager<GoogleContactsConnectorOAuth2Adapter> oauthManager, MuleContext muleContext) {
        ProcessInterceptor<P, GoogleContactsConnectorOAuth2Adapter> processCallbackProcessInterceptor = new ProcessCallbackProcessInterceptor<P, GoogleContactsConnectorOAuth2Adapter>();
        ProcessInterceptor<P, GoogleContactsConnectorOAuth2Adapter> refreshTokenProcessInterceptor = new RefreshTokenProcessInterceptor<P>(processCallbackProcessInterceptor);
        ProcessInterceptor<P, GoogleContactsConnectorOAuth2Adapter> managedAccessTokenProcessInterceptor = new ManagedAccessTokenProcessInterceptor<P>(refreshTokenProcessInterceptor, oauthManager, muleContext);
        processInterceptor = managedAccessTokenProcessInterceptor;
    }

    public P execute(ProcessCallback<P, GoogleContactsConnectorOAuth2Adapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, messageProcessor, event);
    }

    public P execute(ProcessCallback<P, GoogleContactsConnectorOAuth2Adapter> processCallback, Filter filter, MuleMessage message)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, filter, message);
    }

}
