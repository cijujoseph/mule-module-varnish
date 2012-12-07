
package org.mule.modules.varnish.config;

import javax.annotation.Generated;
import org.mule.modules.varnish.processors.BanUrlMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.3.2", date = "2012-12-07T01:33:30-03:00", comments = "Build UNNAMED.1372.db235f3")
public class BanUrlDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(BanUrlMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "url", "url");
        parseProperty(builder, element, "host", "host");
        parseProperty(builder, element, "port", "port");
        parseProperty(builder, element, "secret", "secret");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
