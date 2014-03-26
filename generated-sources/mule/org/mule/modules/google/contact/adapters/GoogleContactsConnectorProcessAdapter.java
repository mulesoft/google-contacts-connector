
package org.mule.modules.google.contact.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.google.contact.GoogleContactsConnector;
import org.mule.modules.google.contact.process.ProcessAdapter;
import org.mule.modules.google.contact.process.ProcessCallback;
import org.mule.modules.google.contact.process.ProcessTemplate;
import org.mule.modules.google.contact.process.ProcessTemplate;


/**
 * A <code>GoogleContactsConnectorProcessAdapter</code> is a wrapper around {@link GoogleContactsConnector } that enables custom processing strategies.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:38:00-05:00", comments = "Build 3.4.3.1620.30ea288")
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
