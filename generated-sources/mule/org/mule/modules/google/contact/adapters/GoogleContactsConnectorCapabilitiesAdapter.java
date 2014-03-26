
package org.mule.modules.google.contact.adapters;

import javax.annotation.Generated;
import org.mule.modules.google.contact.GoogleContactsConnector;
import org.mule.modules.google.contact.basic.Capabilities;
import org.mule.modules.google.contact.basic.Capability;


/**
 * A <code>GoogleContactsConnectorCapabilitiesAdapter</code> is a wrapper around {@link GoogleContactsConnector } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:38:00-05:00", comments = "Build 3.4.3.1620.30ea288")
public class GoogleContactsConnectorCapabilitiesAdapter
    extends GoogleContactsConnector
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(Capability capability) {
        if (capability == Capability.LIFECYCLE_CAPABLE) {
            return true;
        }
        if (capability == Capability.OAUTH2_CAPABLE) {
            return true;
        }
        return false;
    }

}
