
package org.mule.modules.google.contact.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.google.contact.GoogleContactsConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>GoogleContactsConnectorProcessAdapter</code> is a wrapper around {@link GoogleContactsConnector } that enables custom processing strategies.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-03-26T12:34:14-05:00", comments = "Build M4.1875.17b58a3")
public class GoogleContactsConnectorProcessAdapter
    extends GoogleContactsConnectorLifecycleAdapter
    implements ProcessAdapter<GoogleContactsConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, GoogleContactsConnectorCapabilitiesAdapter> getProcessTemplate() {
        final GoogleContactsConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,GoogleContactsConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, GoogleContactsConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, GoogleContactsConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
