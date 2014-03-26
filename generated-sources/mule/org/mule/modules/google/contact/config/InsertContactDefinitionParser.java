
package org.mule.modules.google.contact.config;

import javax.annotation.Generated;
import org.mule.modules.google.contact.processors.InsertContactMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:38:00-05:00", comments = "Build 3.4.3.1620.30ea288")
public class InsertContactDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(InsertContactMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        if (hasAttribute(element, "contact-ref")) {
            if (element.getAttribute("contact-ref").startsWith("#")) {
                builder.addPropertyValue("contact", element.getAttribute("contact-ref"));
            } else {
                builder.addPropertyValue("contact", (("#[registry:"+ element.getAttribute("contact-ref"))+"]"));
            }
        }
        parseProperty(builder, element, "accessTokenId");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
