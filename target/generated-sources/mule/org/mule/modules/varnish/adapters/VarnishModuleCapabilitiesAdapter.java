
package org.mule.modules.varnish.adapters;

import javax.annotation.Generated;
import org.mule.api.Capabilities;
import org.mule.api.Capability;
import org.mule.modules.varnish.VarnishModule;


/**
 * A <code>VarnishModuleCapabilitiesAdapter</code> is a wrapper around {@link VarnishModule } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.2", date = "2012-12-07T01:33:30-03:00", comments = "Build UNNAMED.1372.db235f3")
public class VarnishModuleCapabilitiesAdapter
    extends VarnishModule
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
        if (capability == Capability.CONNECTION_MANAGEMENT_CAPABLE) {
            return true;
        }
        return false;
    }

}
