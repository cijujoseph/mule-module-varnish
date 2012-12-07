
package org.mule.modules.varnish.connectivity;

import javax.annotation.Generated;
import org.apache.commons.pool.impl.GenericKeyedObjectPool;
import org.mule.api.Capabilities;
import org.mule.api.Capability;
import org.mule.api.ConnectionManager;
import org.mule.api.MetadataAware;
import org.mule.api.MuleContext;
import org.mule.api.config.MuleProperties;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.process.ProcessAdapter;
import org.mule.api.process.ProcessTemplate;
import org.mule.api.retry.RetryPolicyTemplate;
import org.mule.config.PoolingProfile;
import org.mule.modules.varnish.VarnishModule;
import org.mule.modules.varnish.adapters.VarnishModuleConnectionIdentifierAdapter;


/**
 * A {@code VarnishModuleConnectionManager} is a wrapper around {@link VarnishModule } that adds connection management capabilities to the pojo.
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.2", date = "2012-12-07T01:33:30-03:00", comments = "Build UNNAMED.1372.db235f3")
public class VarnishModuleConnectionManager implements Capabilities, ConnectionManager<VarnishModuleConnectionKey, VarnishModuleConnectionIdentifierAdapter> , MetadataAware, MuleContextAware, Initialisable, ProcessAdapter<VarnishModuleConnectionIdentifierAdapter>
{

    /**
     * 
     */
    private String host;
    /**
     * 
     */
    private int port;
    /**
     * 
     */
    private String secret;
    /**
     * Mule Context
     * 
     */
    protected MuleContext muleContext;
    /**
     * Flow Construct
     * 
     */
    protected FlowConstruct flowConstruct;
    /**
     * Connector Pool
     * 
     */
    private GenericKeyedObjectPool connectionPool;
    protected PoolingProfile connectionPoolingProfile;
    protected RetryPolicyTemplate retryPolicyTemplate;
    private final static String MODULE_NAME = "varnish";
    private final static String MODULE_VERSION = "1.0-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.3.2";
    private final static String DEVKIT_BUILD = "UNNAMED.1372.db235f3";

    /**
     * Sets muleContext
     * 
     * @param value Value to set
     */
    public void setMuleContext(MuleContext value) {
        this.muleContext = value;
    }

    /**
     * Retrieves muleContext
     * 
     */
    public MuleContext getMuleContext() {
        return this.muleContext;
    }

    /**
     * Sets flowConstruct
     * 
     * @param value Value to set
     */
    public void setFlowConstruct(FlowConstruct value) {
        this.flowConstruct = value;
    }

    /**
     * Retrieves flowConstruct
     * 
     */
    public FlowConstruct getFlowConstruct() {
        return this.flowConstruct;
    }

    /**
     * Sets connectionPoolingProfile
     * 
     * @param value Value to set
     */
    public void setConnectionPoolingProfile(PoolingProfile value) {
        this.connectionPoolingProfile = value;
    }

    /**
     * Retrieves connectionPoolingProfile
     * 
     */
    public PoolingProfile getConnectionPoolingProfile() {
        return this.connectionPoolingProfile;
    }

    /**
     * Sets retryPolicyTemplate
     * 
     * @param value Value to set
     */
    public void setRetryPolicyTemplate(RetryPolicyTemplate value) {
        this.retryPolicyTemplate = value;
    }

    /**
     * Retrieves retryPolicyTemplate
     * 
     */
    public RetryPolicyTemplate getRetryPolicyTemplate() {
        return this.retryPolicyTemplate;
    }

    /**
     * Sets port
     * 
     * @param value Value to set
     */
    public void setPort(int value) {
        this.port = value;
    }

    /**
     * Retrieves port
     * 
     */
    public int getPort() {
        return this.port;
    }

    /**
     * Sets host
     * 
     * @param value Value to set
     */
    public void setHost(String value) {
        this.host = value;
    }

    /**
     * Retrieves host
     * 
     */
    public String getHost() {
        return this.host;
    }

    /**
     * Sets secret
     * 
     * @param value Value to set
     */
    public void setSecret(String value) {
        this.secret = value;
    }

    /**
     * Retrieves secret
     * 
     */
    public String getSecret() {
        return this.secret;
    }

    public void initialise() {
        GenericKeyedObjectPool.Config config = new GenericKeyedObjectPool.Config();
        if (connectionPoolingProfile!= null) {
            config.maxIdle = connectionPoolingProfile.getMaxIdle();
            config.maxActive = connectionPoolingProfile.getMaxActive();
            config.maxWait = connectionPoolingProfile.getMaxWait();
            config.whenExhaustedAction = ((byte) connectionPoolingProfile.getExhaustedAction());
            config.timeBetweenEvictionRunsMillis = 1800000;
            config.minEvictableIdleTimeMillis = 1800000;
        }
        connectionPool = new GenericKeyedObjectPool(new VarnishModuleConnectionFactory(this), config);
        if (retryPolicyTemplate == null) {
            retryPolicyTemplate = muleContext.getRegistry().lookupObject(MuleProperties.OBJECT_DEFAULT_RETRY_POLICY_TEMPLATE);
        }
    }

    public VarnishModuleConnectionIdentifierAdapter acquireConnection(VarnishModuleConnectionKey key)
        throws Exception
    {
        return ((VarnishModuleConnectionIdentifierAdapter) connectionPool.borrowObject(key));
    }

    public void releaseConnection(VarnishModuleConnectionKey key, VarnishModuleConnectionIdentifierAdapter connection)
        throws Exception
    {
        connectionPool.returnObject(key, connection);
    }

    public void destroyConnection(VarnishModuleConnectionKey key, VarnishModuleConnectionIdentifierAdapter connection)
        throws Exception
    {
        connectionPool.invalidateObject(key, connection);
    }

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

    @Override
    public<P >ProcessTemplate<P, VarnishModuleConnectionIdentifierAdapter> getProcessTemplate() {
        return new ManagedConnectionProcessTemplate(this, muleContext);
    }

    public VarnishModuleConnectionKey getDefaultConnectionKey() {
        return new VarnishModuleConnectionKey(getHost(), getPort(), getSecret());
    }

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
