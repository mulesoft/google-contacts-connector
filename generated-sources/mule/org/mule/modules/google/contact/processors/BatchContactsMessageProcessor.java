
package org.mule.modules.google.contact.processors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MessagingException;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.NestedProcessor;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.construct.FlowConstructAware;
import org.mule.api.context.MuleContextAware;
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
import org.mule.modules.google.api.domain.BatchResult;
import org.mule.modules.google.contact.GoogleContactsConnector;
import org.mule.modules.google.contact.oauth.GoogleContactsConnectorOAuthManager;
import org.mule.modules.google.contact.process.NestedProcessorChain;
import org.mule.modules.google.contact.process.ProcessAdapter;
import org.mule.modules.google.contact.process.ProcessCallback;
import org.mule.modules.google.contact.process.ProcessTemplate;
import org.mule.modules.google.oauth.invalidation.OAuthTokenExpiredException;


/**
 * BatchContactsMessageProcessor invokes the {@link org.mule.modules.google.contact.GoogleContactsConnector#batchContacts(java.lang.String, java.util.List)} method in {@link GoogleContactsConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:38:00-05:00", comments = "Build 3.4.3.1620.30ea288")
public class BatchContactsMessageProcessor
    extends AbstractMessageProcessor<Object>
    implements Disposable, Initialisable, Startable, Stoppable, MessageProcessor, OperationMetaDataEnabled
{

    protected Object batchId;
    protected String _batchIdType;
    protected Object operations;
    protected List<NestedProcessor> _operationsType;

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
        if (operations instanceof List) {
            for (MessageProcessor messageProcessor: ((List<MessageProcessor> ) operations)) {
                if (messageProcessor instanceof Initialisable) {
                    ((Initialisable) messageProcessor).initialise();
                }
            }
        }
    }

    public void start()
        throws MuleException
    {
        if (operations instanceof List) {
            for (MessageProcessor messageProcessor: ((List<MessageProcessor> ) operations)) {
                if (messageProcessor instanceof Startable) {
                    ((Startable) messageProcessor).start();
                }
            }
        }
    }

    public void stop()
        throws MuleException
    {
        if (operations instanceof List) {
            for (MessageProcessor messageProcessor: ((List<MessageProcessor> ) operations)) {
                if (messageProcessor instanceof Stoppable) {
                    ((Stoppable) messageProcessor).stop();
                }
            }
        }
    }

    public void dispose() {
        if (operations instanceof List) {
            for (MessageProcessor messageProcessor: ((List<MessageProcessor> ) operations)) {
                if (messageProcessor instanceof Disposable) {
                    ((Disposable) messageProcessor).dispose();
                }
            }
        }
    }

    /**
     * Set the Mule context
     * 
     * @param context Mule context to set
     */
    public void setMuleContext(MuleContext context) {
        super.setMuleContext(context);
        if (operations instanceof List) {
            for (MessageProcessor messageProcessor: ((List<MessageProcessor> ) operations)) {
                if (messageProcessor instanceof MuleContextAware) {
                    ((MuleContextAware) messageProcessor).setMuleContext(context);
                }
            }
        }
    }

    /**
     * Sets flow construct
     * 
     * @param flowConstruct Flow construct to set
     */
    public void setFlowConstruct(FlowConstruct flowConstruct) {
        super.setFlowConstruct(flowConstruct);
        if (operations instanceof List) {
            for (MessageProcessor messageProcessor: ((List<MessageProcessor> ) operations)) {
                if (messageProcessor instanceof FlowConstructAware) {
                    ((FlowConstructAware) messageProcessor).setFlowConstruct(flowConstruct);
                }
            }
        }
    }

    /**
     * Sets batchId
     * 
     * @param value Value to set
     */
    public void setBatchId(Object value) {
        this.batchId = value;
    }

    /**
     * Sets operations
     * 
     * @param value Value to set
     */
    public void setOperations(Object value) {
        this.operations = value;
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
            final String _transformedBatchId = ((String) evaluateAndTransform(getMuleContext(), event, BatchContactsMessageProcessor.class.getDeclaredField("_batchIdType").getGenericType(), null, batchId));
            final List<NestedProcessor> _transformedOperations = new ArrayList<NestedProcessor>();
            if (operations!= null) {
                for (MessageProcessor messageProcessor: ((List<MessageProcessor> ) operations)) {
                    _transformedOperations.add(new NestedProcessorChain(event, getMuleContext(), messageProcessor));
                }
            }
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
                    return ((GoogleContactsConnector) object).batchContacts(_transformedBatchId, _transformedOperations);
                }

            }
            , this, event);
            overwritePayload(event, resultPayload);
            return event;
        } catch (MessagingException messagingException) {
            messagingException.setProcessedEvent(event);
            throw messagingException;
        } catch (Exception e) {
            throw new MessagingException(CoreMessages.failedToInvoke("batchContacts"), event, e);
        }
    }

    @Override
    public Result<MetaData> getInputMetaData() {
        return new DefaultResult<MetaData>(new DefaultMetaData(new DefaultListMetaDataModel(getPojoOrSimpleModel(NestedProcessor.class))));
    }

    @Override
    public Result<MetaData> getOutputMetaData(MetaData inputMetadata) {
        return new DefaultResult<MetaData>(new DefaultMetaData(new DefaultListMetaDataModel(getPojoOrSimpleModel(BatchResult.class))));
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
