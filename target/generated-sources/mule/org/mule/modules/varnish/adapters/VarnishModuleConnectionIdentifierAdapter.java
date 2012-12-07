
package org.mule.modules.varnish.adapters;

import javax.annotation.Generated;
import org.mule.api.Connection;
import org.mule.modules.varnish.VarnishModule;


/**
 * A <code>VarnishModuleConnectionIdentifierAdapter</code> is a wrapper around {@link VarnishModule } that implements {@link org.mule.api.Connection} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.2", date = "2012-12-07T01:33:30-03:00", comments = "Build UNNAMED.1372.db235f3")
public class VarnishModuleConnectionIdentifierAdapter
    extends VarnishModuleProcessAdapter
    implements Connection
{


    public String getConnectionIdentifier() {
        return super.connectionId();
    }

}
