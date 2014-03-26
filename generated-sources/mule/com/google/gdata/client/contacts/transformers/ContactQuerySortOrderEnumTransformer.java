
package com.google.gdata.client.contacts.transformers;

import javax.annotation.Generated;
import com.google.gdata.client.contacts.ContactQuery.SortOrder;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:38:00-05:00", comments = "Build 3.4.3.1620.30ea288")
public class ContactQuerySortOrderEnumTransformer
    extends AbstractTransformer
    implements DiscoverableTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;

    public ContactQuerySortOrderEnumTransformer() {
        registerSourceType(DataTypeFactory.create(String.class));
        setReturnClass(SortOrder.class);
        setName("ContactQuerySortOrderEnumTransformer");
    }

    protected Object doTransform(Object src, String encoding)
        throws TransformerException
    {
        SortOrder result = null;
        result = Enum.valueOf(SortOrder.class, ((String) src));
        return result;
    }

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

}
