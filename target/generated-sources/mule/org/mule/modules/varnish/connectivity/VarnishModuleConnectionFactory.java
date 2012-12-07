
package org.mule.modules.varnish.connectivity;

import javax.annotation.Generated;
import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.modules.varnish.adapters.VarnishModuleConnectionIdentifierAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "Mule DevKit Version 3.3.2", date = "2012-12-07T01:33:30-03:00", comments = "Build UNNAMED.1372.db235f3")
public class VarnishModuleConnectionFactory implements KeyedPoolableObjectFactory
{

    private static Logger logger = LoggerFactory.getLogger(VarnishModuleConnectionFactory.class);
    private VarnishModuleConnectionManager connectionManager;

    public VarnishModuleConnectionFactory(VarnishModuleConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Object makeObject(Object key)
        throws Exception
    {
        if (!(key instanceof VarnishModuleConnectionKey)) {
            throw new RuntimeException("Invalid key type");
        }
        VarnishModuleConnectionIdentifierAdapter connector = new VarnishModuleConnectionIdentifierAdapter();
        if (connector instanceof Initialisable) {
            ((Initialisable) connector).initialise();
        }
        if (connector instanceof MuleContextAware) {
            ((MuleContextAware) connector).setMuleContext(connectionManager.getMuleContext());
        }
        if (connector instanceof Startable) {
            ((Startable) connector).start();
        }
        return connector;
    }

    public void destroyObject(Object key, Object obj)
        throws Exception
    {
        if (!(key instanceof VarnishModuleConnectionKey)) {
            throw new RuntimeException("Invalid key type");
        }
        if (!(obj instanceof VarnishModuleConnectionIdentifierAdapter)) {
            throw new RuntimeException("Invalid connector type");
        }
        try {
            ((VarnishModuleConnectionIdentifierAdapter) obj).disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            if (((VarnishModuleConnectionIdentifierAdapter) obj) instanceof Stoppable) {
                ((Stoppable) obj).stop();
            }
            if (((VarnishModuleConnectionIdentifierAdapter) obj) instanceof Disposable) {
                ((Disposable) obj).dispose();
            }
        }
    }

    public boolean validateObject(Object key, Object obj) {
        if (!(obj instanceof VarnishModuleConnectionIdentifierAdapter)) {
            throw new RuntimeException("Invalid connector type");
        }
        try {
            return ((VarnishModuleConnectionIdentifierAdapter) obj).validateConnection();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    public void activateObject(Object key, Object obj)
        throws Exception
    {
        if (!(key instanceof VarnishModuleConnectionKey)) {
            throw new RuntimeException("Invalid key type");
        }
        if (!(obj instanceof VarnishModuleConnectionIdentifierAdapter)) {
            throw new RuntimeException("Invalid connector type");
        }
        try {
            if (!((VarnishModuleConnectionIdentifierAdapter) obj).validateConnection()) {
                ((VarnishModuleConnectionIdentifierAdapter) obj).connect(((VarnishModuleConnectionKey) key).getHost(), ((VarnishModuleConnectionKey) key).getPort(), ((VarnishModuleConnectionKey) key).getSecret());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void passivateObject(Object key, Object obj)
        throws Exception
    {
    }

}
