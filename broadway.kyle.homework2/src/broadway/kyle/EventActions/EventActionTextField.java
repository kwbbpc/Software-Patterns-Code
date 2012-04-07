package broadway.kyle.EventActions;

import java.beans.PropertyChangeEvent;

import broadway.kyle.EventAction;

import com.javadude.beans.Customer;

public class EventActionTextField implements EventAction
{

    Customer customer;

    public EventActionTextField(Customer customer)
    {
        this.customer = customer;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        if ("id".equals(evt.getPropertyName()))
        {
            customer.setId(evt.getNewValue().toString());
        }
        else if ("name".equals(evt.getPropertyName()))
        {
            customer.setName(evt.getNewValue().toString());
        }
        else if ("street".equals(evt.getPropertyName()))
        {
            customer.setStreet(evt.getNewValue().toString());
        }
        else if ("city".equals(evt.getPropertyName()))
        {
            customer.setCity(evt.getNewValue().toString());
        }
        else if ("zip".equals(evt.getPropertyName()))
        {
            customer.setZip(evt.getNewValue().toString());
        }
        else if ("phone".equals(evt.getPropertyName()))
        {
            customer.setPhone(evt.getNewValue().toString());
        }
        else if ("password".equals(evt.getPropertyName()))
        {
            customer.setPassword(evt.getNewValue().toString());
        }

        System.out.println("Text field [" + evt.getPropertyName() + "] changed from [" + evt.getOldValue() + "] to [" + evt.getNewValue() + "].");

    }

}
