
package org.mule.modules.google.contact.config;

import javax.annotation.Generated;
import org.mule.modules.google.contact.processors.BatchDeleteMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:38:00-05:00", comments = "Build 3.4.3.1620.30ea288")
public class BatchDeleteDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(BatchDeleteMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "operationId", "operationId");
        if (hasAttribute(element, "entries-ref")) {
            if (element.getAttribute("entries-ref").startsWith("#")) {
                builder.addPropertyValue("entries", element.getAttribute("entries-ref"));
            } else {
                builder.addPropertyValue("entries", (("#[registry:"+ element.getAttribute("entries-ref"))+"]"));
            }
        }
        parseProperty(builder, element, "accessTokenId");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
