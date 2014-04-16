
package com.google.gdata.client.contacts.transformers;

import javax.annotation.Generated;
import com.google.gdata.client.contacts.ContactQuery.OrderBy;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-16T09:20:40-05:00", comments = "Build master.1915.dd1962d")
public class ContactQueryOrderByEnumTransformer
    extends AbstractTransformer
    implements DiscoverableTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;

    public ContactQueryOrderByEnumTransformer() {
        registerSourceType(DataTypeFactory.create(String.class));
        setReturnClass(OrderBy.class);
        setName("ContactQueryOrderByEnumTransformer");
    }

    protected Object doTransform(Object src, String encoding)
        throws TransformerException
    {
        OrderBy result = null;
        result = Enum.valueOf(OrderBy.class, ((String) src));
        return result;
    }

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

}
