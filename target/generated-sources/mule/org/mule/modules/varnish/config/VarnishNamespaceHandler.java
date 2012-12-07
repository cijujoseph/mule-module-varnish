
package org.mule.modules.varnish.config;

import javax.annotation.Generated;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/varnish</code>.
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.2", date = "2012-12-07T01:33:30-03:00", comments = "Build UNNAMED.1372.db235f3")
public class VarnishNamespaceHandler
    extends NamespaceHandlerSupport
{


    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        registerBeanDefinitionParser("config", new VarnishModuleConfigDefinitionParser());
        registerBeanDefinitionParser("ban-url", new BanUrlDefinitionParser());
    }

}
