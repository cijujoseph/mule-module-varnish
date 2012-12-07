
package org.mule.modules.varnish.processors;

import javax.annotation.Generated;

@Generated(value = "Mule DevKit Version 3.3.2", date = "2012-12-07T01:33:30-03:00", comments = "Build UNNAMED.1372.db235f3")
public abstract class AbstractConnectedProcessor
    extends AbstractExpressionEvaluator
{

    protected Object host;
    protected String _hostType;
    protected Object port;
    protected int _portType;
    protected Object secret;
    protected String _secretType;

    /**
     * Sets port
     * 
     * @param value Value to set
     */
    public void setPort(Object value) {
        this.port = value;
    }

    /**
     * Retrieves port
     * 
     */
    public Object getPort() {
        return this.port;
    }

    /**
     * Sets host
     * 
     * @param value Value to set
     */
    public void setHost(Object value) {
        this.host = value;
    }

    /**
     * Retrieves host
     * 
     */
    public Object getHost() {
        return this.host;
    }

    /**
     * Sets secret
     * 
     * @param value Value to set
     */
    public void setSecret(Object value) {
        this.secret = value;
    }

    /**
     * Retrieves secret
     * 
     */
    public Object getSecret() {
        return this.secret;
    }

}
