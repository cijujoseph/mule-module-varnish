
package org.mule.modules.varnish.connectivity;

import javax.annotation.Generated;


/**
 * A tuple of connection parameters
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.2", date = "2012-12-07T01:33:30-03:00", comments = "Build UNNAMED.1372.db235f3")
public class VarnishModuleConnectionKey {

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

    public VarnishModuleConnectionKey(String host, int port, String secret) {
        this.host = host;
        this.port = port;
        this.secret = secret;
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

    public int hashCode() {
        int hash = 1;
        hash = ((hash* 31)+ this.host.hashCode());
        return hash;
    }

    public boolean equals(Object obj) {
        return (((obj instanceof VarnishModuleConnectionKey)&&(this.host!= null))&&this.host.equals(((VarnishModuleConnectionKey) obj).host));
    }

}
