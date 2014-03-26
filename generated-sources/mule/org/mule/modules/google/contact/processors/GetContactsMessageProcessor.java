
package org.mule.modules.google.contact.processors;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.google.gdata.client.contacts.ContactQuery.OrderBy;
import com.google.gdata.client.contacts.ContactQuery.SortOrder;
import org.mule.api.MessagingException;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.api.processor.MessageProcessor;
import org.mule.common.DefaultResult;
import org.mule.common.Result;
import org.mule.common.metadata.DefaultListMetaDataModel;
import org.mule.common.metadata.DefaultMetaData;
import org.mule.common.metadata.DefaultPojoMetaDataModel;
import org.mule.common.metadata.DefaultSimpleMetaDataModel;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataModel;
import org.mule.common.metadata.OperationMetaDataEnabled;
import org.mule.common.metadata.datatype.DataType;
import org.mule.common.metadata.datatype.DataTypeFactory;
import org.mule.config.i18n.CoreMessages;
import org.mule.modules.google.contact.GoogleContactsConnector;
import org.mule.modules.google.contact.oauth.GoogleContactsConnectorOAuthManager;
import org.mule.modules.google.contact.process.ProcessAdapter;
import org.mule.modules.google.contact.process.ProcessCallback;
import org.mule.modules.google.contact.process.ProcessTemplate;
import org.mule.modules.google.contact.wrappers.GoogleContactEntry;
import org.mule.modules.google.oauth.invalidation.OAuthTokenExpiredException;


/**
 * GetContactsMessageProcessor invokes the {@link org.mule.modules.google.contact.GoogleContactsConnector#getContacts(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, com.google.gdata.client.contacts.ContactQuery.SortOrder, java.lang.Boolean, com.google.gdata.client.contacts.ContactQuery.OrderBy, java.lang.String)} method in {@link GoogleContactsConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:38:00-05:00", comments = "Build 3.4.3.1620.30ea288")
public class GetContactsMessageProcessor
    extends AbstractMessageProcessor<Object>
    implements Disposable, Initialisable, Startable, Stoppable, MessageProcessor, OperationMetaDataEnabled
{

    protected Object updatedMin;
    protected String _updatedMinType;
    protected Object updatedMax;
    protected String _updatedMaxType;
    protected Object datetimeFormat;
    protected String _datetimeFormatType;
    protected Object fullTextQuery;
    protected String _fullTextQueryType;
    protected Object maxResults;
    protected int _maxResultsType;
    protected Object firstResult;
    protected int _firstResultType;
    protected Object sortOrder;
    protected SortOrder _sortOrderType;
    protected Object showDeleted;
    protected Boolean _showDeletedType;
    protected Object orderBy;
    protected OrderBy _orderByType;
    protected Object groupId;
    protected String _groupIdType;

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    public void start()
        throws MuleException
    {
    }

    public void stop()
        throws MuleException
    {
    }

    public void dispose() {
    }

    /**
     * Set the Mule context
     * 
     * @param context Mule context to set
     */
    public void setMuleContext(MuleContext context) {
        super.setMuleContext(context);
    }

    /**
     * Sets flow construct
     * 
     * @param flowConstruct Flow construct to set
     */
    public void setFlowConstruct(FlowConstruct flowConstruct) {
        super.setFlowConstruct(flowConstruct);
    }

    /**
     * Sets updatedMax
     * 
     * @param value Value to set
     */
    public void setUpdatedMax(Object value) {
        this.updatedMax = value;
    }

    /**
     * Sets groupId
     * 
     * @param value Value to set
     */
    public void setGroupId(Object value) {
        this.groupId = value;
    }

    /**
     * Sets orderBy
     * 
     * @param value Value to set
     */
    public void setOrderBy(Object value) {
        this.orderBy = value;
    }

    /**
     * Sets firstResult
     * 
     * @param value Value to set
     */
    public void setFirstResult(Object value) {
        this.firstResult = value;
    }

    /**
     * Sets sortOrder
     * 
     * @param value Value to set
     */
    public void setSortOrder(Object value) {
        this.sortOrder = value;
    }

    /**
     * Sets datetimeFormat
     * 
     * @param value Value to set
     */
    public void setDatetimeFormat(Object value) {
        this.datetimeFormat = value;
    }

    /**
     * Sets showDeleted
     * 
     * @param value Value to set
     */
    public void setShowDeleted(Object value) {
        this.showDeleted = value;
    }

    /**
     * Sets maxResults
     * 
     * @param value Value to set
     */
    public void setMaxResults(Object value) {
        this.maxResults = value;
    }

    /**
     * Sets fullTextQuery
     * 
     * @param value Value to set
     */
    public void setFullTextQuery(Object value) {
        this.fullTextQuery = value;
    }

    /**
     * Sets updatedMin
     * 
     * @param value Value to set
     */
    public void setUpdatedMin(Object value) {
        this.updatedMin = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws MuleException
     */
    public MuleEvent process(final MuleEvent event)
        throws MuleException
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(GoogleContactsConnectorOAuthManager.class, false, event);
            final String _transformedUpdatedMin = ((String) evaluateAndTransform(getMuleContext(), event, GetContactsMessageProcessor.class.getDeclaredField("_updatedMinType").getGenericType(), null, updatedMin));
            final String _transformedUpdatedMax = ((String) evaluateAndTransform(getMuleContext(), event, GetContactsMessageProcessor.class.getDeclaredField("_updatedMaxType").getGenericType(), null, updatedMax));
            final String _transformedDatetimeFormat = ((String) evaluateAndTransform(getMuleContext(), event, GetContactsMessageProcessor.class.getDeclaredField("_datetimeFormatType").getGenericType(), null, datetimeFormat));
            final String _transformedFullTextQuery = ((String) evaluateAndTransform(getMuleContext(), event, GetContactsMessageProcessor.class.getDeclaredField("_fullTextQueryType").getGenericType(), null, fullTextQuery));
            final Integer _transformedMaxResults = ((Integer) evaluateAndTransform(getMuleContext(), event, GetContactsMessageProcessor.class.getDeclaredField("_maxResultsType").getGenericType(), null, maxResults));
            final Integer _transformedFirstResult = ((Integer) evaluateAndTransform(getMuleContext(), event, GetContactsMessageProcessor.class.getDeclaredField("_firstResultType").getGenericType(), null, firstResult));
            final SortOrder _transformedSortOrder = ((SortOrder) evaluateAndTransform(getMuleContext(), event, GetContactsMessageProcessor.class.getDeclaredField("_sortOrderType").getGenericType(), null, sortOrder));
            final Boolean _transformedShowDeleted = ((Boolean) evaluateAndTransform(getMuleContext(), event, GetContactsMessageProcessor.class.getDeclaredField("_showDeletedType").getGenericType(), null, showDeleted));
            final OrderBy _transformedOrderBy = ((OrderBy) evaluateAndTransform(getMuleContext(), event, GetContactsMessageProcessor.class.getDeclaredField("_orderByType").getGenericType(), null, orderBy));
            final String _transformedGroupId = ((String) evaluateAndTransform(getMuleContext(), event, GetContactsMessageProcessor.class.getDeclaredField("_groupIdType").getGenericType(), null, groupId));
            Object resultPayload;
            ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class> getManagedExceptions() {
                    return Arrays.asList(new Class[] {OAuthTokenExpiredException.class });
                }

                public boolean isProtected() {
                    return true;
                }

                public Object process(Object object)
                    throws Exception
                {
                    return ((GoogleContactsConnector) object).getContacts(_transformedUpdatedMin, _transformedUpdatedMax, _transformedDatetimeFormat, _transformedFullTextQuery, _transformedMaxResults, _transformedFirstResult, _transformedSortOrder, _transformedShowDeleted, _transformedOrderBy, _transformedGroupId);
                }

            }
            , this, event);
            overwritePayload(event, resultPayload);
            return event;
        } catch (MessagingException messagingException) {
            messagingException.setProcessedEvent(event);
            throw messagingException;
        } catch (Exception e) {
            throw new MessagingException(CoreMessages.failedToInvoke("getContacts"), event, e);
        }
    }

    @Override
    public Result<MetaData> getInputMetaData() {
        return new DefaultResult<MetaData>(null, (Result.Status.SUCCESS));
    }

    @Override
    public Result<MetaData> getOutputMetaData(MetaData inputMetadata) {
        return new DefaultResult<MetaData>(new DefaultMetaData(new DefaultListMetaDataModel(getPojoOrSimpleModel(GoogleContactEntry.class))));
    }

    private MetaDataModel getPojoOrSimpleModel(Class clazz) {
        DataType dataType = DataTypeFactory.getInstance().getDataType(clazz);
        if (DataType.POJO.equals(dataType)) {
            return new DefaultPojoMetaDataModel(clazz);
        } else {
            return new DefaultSimpleMetaDataModel(dataType);
        }
    }

}
