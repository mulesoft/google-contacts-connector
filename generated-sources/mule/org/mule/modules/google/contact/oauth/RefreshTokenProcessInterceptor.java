
package org.mule.modules.google.contact.oauth;

import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.google.contact.adapters.GoogleContactsConnectorOAuth2Adapter;
import org.mule.modules.google.contact.process.ProcessCallback;
import org.mule.modules.google.contact.process.ProcessInterceptor;
import org.mule.modules.google.contact.processors.AbstractExpressionEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:38:00-05:00", comments = "Build 3.4.3.1620.30ea288")
public class RefreshTokenProcessInterceptor<T >
    extends AbstractExpressionEvaluator
    implements ProcessInterceptor<T, GoogleContactsConnectorOAuth2Adapter>
{

    private static Logger logger = LoggerFactory.getLogger(RefreshTokenProcessInterceptor.class);
    private final ProcessInterceptor<T, GoogleContactsConnectorOAuth2Adapter> next;

    public RefreshTokenProcessInterceptor(ProcessInterceptor<T, GoogleContactsConnectorOAuth2Adapter> next) {
        this.next = next;
    }

    public T execute(ProcessCallback<T, GoogleContactsConnectorOAuth2Adapter> processCallback, GoogleContactsConnectorOAuth2Adapter object, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        T result = null;
        Exception cause = null;
        try {
            result = this.next.execute(processCallback, object, messageProcessor, event);
            return result;
        } catch (Exception e) {
            if (processCallback.getManagedExceptions()!= null) {
                for (Class exceptionClass: ((List<Class> ) processCallback.getManagedExceptions())) {
                    if (exceptionClass.isInstance(e)) {
                        if (((OAuth2Adapter) object).getRefreshToken()!= null) {
                            if (logger.isDebugEnabled()) {
                                logger.debug("A managed exception has been thrown. Attempting to refresh access token.");
                            }
                            try {
                                ((OAuth2Adapter) object).refreshAccessToken(((GoogleContactsConnectorOAuth2Adapter) object).getAccessTokenUrl());
                            } catch (Exception newException) {
                                if (logger.isDebugEnabled()) {
                                    logger.debug("Another exception was thrown while attempting to refresh the access token. Throwing original exception back up", newException);
                                }
                                throw e;
                            }
                            result = this.next.execute(processCallback, object, messageProcessor, event);
                            return result;
                        }
                    }
                }
            }
            throw e;
        }
    }

    public T execute(ProcessCallback<T, GoogleContactsConnectorOAuth2Adapter> processCallback, GoogleContactsConnectorOAuth2Adapter object, Filter filter, MuleMessage event)
        throws Exception
    {
        throw new UnsupportedOperationException();
    }

}
