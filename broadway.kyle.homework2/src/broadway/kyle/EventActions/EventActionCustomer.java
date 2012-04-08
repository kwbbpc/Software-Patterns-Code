package broadway.kyle.EventActions;

import java.beans.PropertyChangeEvent;

import broadway.kyle.EventAction;
import broadway.kyle.SimpleTextField;

public class EventActionCustomer implements EventAction
{

    private SimpleTextField idField;
    private SimpleTextField nameField;
    private SimpleTextField streetField;
    private SimpleTextField cityField;
    private SimpleTextField zipField;
    private SimpleTextField phoneField;
    private SimpleTextField passwordField;

    public EventActionCustomer(SimpleTextField idField,
            SimpleTextField nameField, SimpleTextField streetField,
            SimpleTextField cityField, SimpleTextField zipField,
            SimpleTextField phoneField, SimpleTextField passwordField)
    {
        this.idField = idField;
        this.nameField = nameField;
        this.streetField = streetField;
        this.cityField = cityField;
        this.zipField = zipField;
        this.phoneField = phoneField;
        this.passwordField = passwordField;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        if ("id".equals(evt.getPropertyName()))
        {
            idField.setText(evt.getNewValue().toString());
        }
        else if ("name".equals(evt.getPropertyName()))
        {
            nameField.setText(evt.getNewValue().toString());
        }
        else if ("street".equals(evt.getPropertyName()))
        {
            streetField.setText(evt.getNewValue().toString());
        }
        else if ("city".equals(evt.getPropertyName()))
        {
            cityField.setText(evt.getNewValue().toString());
        }
        else if ("zip".equals(evt.getPropertyName()))
        {
            zipField.setText(evt.getNewValue().toString());
        }
        else if ("phone".equals(evt.getPropertyName()))
        {
            phoneField.setText(evt.getNewValue().toString());
        }
        else if ("password".equals(evt.getPropertyName()))
        {
            passwordField.setText(evt.getNewValue().toString());
        }

        //        System.out.println("Customer property [" + evt.getPropertyName() + "] changed from [" + evt.getOldValue() + "] to [" + evt.getNewValue() + "].");

    }

}
