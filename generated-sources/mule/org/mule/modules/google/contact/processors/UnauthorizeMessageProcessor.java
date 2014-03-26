
package org.mule.modules.google.contact.processors;

import javax.annotation.Generated;
import org.mule.api.DefaultMuleException;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.construct.FlowConstructAware;
import org.mule.api.context.MuleContextAware;
import org.mule.api.processor.MessageProcessor;
import org.mule.config.i18n.CoreMessages;
import org.mule.modules.google.contact.adapters.GoogleContactsConnectorOAuth2Adapter;
import org.mule.modules.google.contact.connection.UnableToAcquireConnectionException;
import org.mule.modules.google.contact.oauth.GoogleContactsConnectorOAuthManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:38:00-05:00", comments = "Build 3.4.3.1620.30ea288")
public class UnauthorizeMessageProcessor
    extends AbstractMessageProcessor<GoogleContactsConnectorOAuthManager>
    implements FlowConstructAware, MuleContextAware, MessageProcessor
{

    private static Logger logger = LoggerFactory.getLogger(UnauthorizeMessageProcessor.class);

    /**
     * Unauthorize the connector
     * 
     * @param event MuleEvent to be processed
     * @throws MuleException
     */
    public MuleEvent process(MuleEvent event)
        throws MuleException
    {
        GoogleContactsConnectorOAuthManager moduleObject = null;
        try {
            moduleObject = findOrCreate(GoogleContactsConnectorOAuthManager.class, false, null);
        } catch (IllegalAccessException e) {
            throw new DefaultMuleException(CoreMessages.failedToStart("authorize"), e);
        } catch (InstantiationException e) {
            throw new DefaultMuleException(CoreMessages.failedToStart("authorize"), e);
        }
        GoogleContactsConnectorOAuth2Adapter connector = null;
        try {
            String _transformedToken = ((String) evaluateAndTransform(getMuleContext(), event, AbstractConnectedProcessor.class.getDeclaredField("_accessTokenIdType").getGenericType(), null, getAccessTokenId()));
            if (logger.isDebugEnabled()) {
                logger.debug(("Attempting to acquire access token using from store for user "+ _transformedToken.toString()));
            }
            connector = moduleObject.acquireAccessToken(_transformedToken);
            if (connector == null) {
                throw new UnableToAcquireConnectionException();
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug((("Access Token has been acquired for [tokenId="+ connector.getAccessTokenId())+"]"));
                }
                moduleObject.destroyAccessToken(_transformedToken, connector);
                if (logger.isDebugEnabled()) {
                    logger.debug((("Access token for [tokenId="+ connector.getAccessTokenId())+"] has been successfully destroyed"));
                }
            }
        } catch (Exception e) {
            throw new DefaultMuleException(CoreMessages.createStaticMessage("Unable to unauthorize the connector"), e);
        }
        return event;
    }

}
