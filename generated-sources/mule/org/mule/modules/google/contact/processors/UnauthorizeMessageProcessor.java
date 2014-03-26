
package org.mule.modules.google.contact.processors;

import javax.annotation.Generated;
import org.mule.api.construct.FlowConstructAware;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.google.contact.oauth.GoogleContactsConnectorOAuthManager;
import org.mule.security.oauth.processor.BaseOAuth2UnauthorizeMessageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-03-26T12:34:14-05:00", comments = "Build M4.1875.17b58a3")
public class UnauthorizeMessageProcessor
    extends BaseOAuth2UnauthorizeMessageProcessor
    implements FlowConstructAware, MessageProcessor
{

    private static Logger logger = LoggerFactory.getLogger(UnauthorizeMessageProcessor.class);

    @Override
    protected Class<GoogleContactsConnectorOAuthManager> getOAuthManagerClass() {
        return GoogleContactsConnectorOAuthManager.class;
    }

}
