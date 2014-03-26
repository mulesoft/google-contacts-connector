
package org.mule.modules.google.contact.oauth;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.google.contact.adapters.GoogleContactsConnectorCapabilitiesAdapter;
import org.mule.modules.google.contact.process.ProcessCallback;
import org.mule.modules.google.contact.process.ProcessTemplate;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:38:00-05:00", comments = "Build 3.4.3.1620.30ea288")
public class OAuthProcessTemplate<P >implements ProcessTemplate<P, GoogleContactsConnectorCapabilitiesAdapter>
{

    private final GoogleContactsConnectorCapabilitiesAdapter object;

    public OAuthProcessTemplate(GoogleContactsConnectorCapabilitiesAdapter object) {
        this.object = object;
    }

    public P execute(ProcessCallback<P, GoogleContactsConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        if (processCallback.isProtected()) {
            ((OAuthAdapter) object).hasBeenAuthorized();
        }
        return processCallback.process(object);
    }

    public P execute(ProcessCallback<P, GoogleContactsConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
        throws Exception
    {
        if (processCallback.isProtected()) {
            ((OAuthAdapter) object).hasBeenAuthorized();
        }
        return processCallback.process(object);
    }

}
