
package org.mule.modules.google.contact.config;

import javax.annotation.Generated;
import org.mule.modules.google.contact.processors.UpdateContactPhotoMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:38:00-05:00", comments = "Build 3.4.3.1620.30ea288")
public class UpdateContactPhotoDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UpdateContactPhotoMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "contactId", "contactId");
        if (hasAttribute(element, "in-ref")) {
            if (element.getAttribute("in-ref").startsWith("#")) {
                builder.addPropertyValue("in", element.getAttribute("in-ref"));
            } else {
                builder.addPropertyValue("in", (("#[registry:"+ element.getAttribute("in-ref"))+"]"));
            }
        }
        parseProperty(builder, element, "accessTokenId");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
