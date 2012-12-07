
package org.mule.modules.varnish.adapters;

import javax.annotation.Generated;
import org.mule.api.MetadataAware;
import org.mule.modules.varnish.VarnishModule;


/**
 * A <code>VarnishModuleMetadataAdapater</code> is a wrapper around {@link VarnishModule } that adds support for querying metadata about the extension.
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.2", date = "2012-12-07T01:33:30-03:00", comments = "Build UNNAMED.1372.db235f3")
public class VarnishModuleMetadataAdapater
    extends VarnishModuleCapabilitiesAdapter
    implements MetadataAware
{

    private final static String MODULE_NAME = "varnish";
    private final static String MODULE_VERSION = "1.0-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.3.2";
    private final static String DEVKIT_BUILD = "UNNAMED.1372.db235f3";

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

}
