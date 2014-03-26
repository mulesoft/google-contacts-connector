
package org.mule.modules.google.contact.config;

import javax.annotation.Generated;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/google-contacts</code>.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:38:00-05:00", comments = "Build 3.4.3.1620.30ea288")
public class GoogleContactsNamespaceHandler
    extends NamespaceHandlerSupport
{


    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        registerBeanDefinitionParser("config-with-oauth", new GoogleContactsConnectorConfigDefinitionParser());
        registerBeanDefinitionParser("authorize", new AuthorizeDefinitionParser());
        registerBeanDefinitionParser("unauthorize", new UnauthorizeDefinitionParser());
        registerBeanDefinitionParser("get-contacts", new GetContactsDefinitionParser());
        registerBeanDefinitionParser("get-contact-by-id", new GetContactByIdDefinitionParser());
        registerBeanDefinitionParser("insert-contact", new InsertContactDefinitionParser());
        registerBeanDefinitionParser("update-contact", new UpdateContactDefinitionParser());
        registerBeanDefinitionParser("add-group", new AddGroupDefinitionParser());
        registerBeanDefinitionParser("delete-contact-by-id", new DeleteContactByIdDefinitionParser());
        registerBeanDefinitionParser("delete-contact", new DeleteContactDefinitionParser());
        registerBeanDefinitionParser("download-photo-by-id", new DownloadPhotoByIdDefinitionParser());
        registerBeanDefinitionParser("download-photo", new DownloadPhotoDefinitionParser());
        registerBeanDefinitionParser("update-contact-photo", new UpdateContactPhotoDefinitionParser());
        registerBeanDefinitionParser("delete-contact-photo-by-id", new DeleteContactPhotoByIdDefinitionParser());
        registerBeanDefinitionParser("delete-contact-photo", new DeleteContactPhotoDefinitionParser());
        registerBeanDefinitionParser("get-groups", new GetGroupsDefinitionParser());
        registerBeanDefinitionParser("get-group-by-name", new GetGroupByNameDefinitionParser());
        registerBeanDefinitionParser("get-group-by-id", new GetGroupByIdDefinitionParser());
        registerBeanDefinitionParser("create-group", new CreateGroupDefinitionParser());
        registerBeanDefinitionParser("update-group", new UpdateGroupDefinitionParser());
        registerBeanDefinitionParser("delete-group-by-id", new DeleteGroupByIdDefinitionParser());
        registerBeanDefinitionParser("delete-group", new DeleteGroupDefinitionParser());
        registerBeanDefinitionParser("batch-contacts", new BatchContactsDefinitionParser());
        registerBeanDefinitionParser("batch-groups", new BatchGroupsDefinitionParser());
        registerBeanDefinitionParser("batch-insert", new BatchInsertDefinitionParser());
        registerBeanDefinitionParser("batch-update", new BatchUpdateDefinitionParser());
        registerBeanDefinitionParser("batch-delete", new BatchDeleteDefinitionParser());
    }

}
