package broadway.kyle.EventActions;

import java.beans.PropertyChangeEvent;

import javax.swing.JLabel;

import broadway.kyle.EventAction;

import com.javadude.beans.Customer;

public class EventActionTotalValue implements EventAction
{

    private JLabel cartTotalLabel;
    private JLabel boughtItemsTotalLabel;
    private Customer customer;

    public EventActionTotalValue(JLabel cartTotalLabel,
            JLabel boughtItemsTotalLabel, Customer customer)
    {
        this.cartTotalLabel = cartTotalLabel;
        this.boughtItemsTotalLabel = boughtItemsTotalLabel;
        this.customer = customer;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        if ("totalValue".equals(evt.getPropertyName()))
        {
            boughtItemsTotalLabel.setText(Integer.toString(customer.getBoughtItems().getTotalValue()));
            cartTotalLabel.setText(Integer.toString(customer.getCart().getTotalValue()));
        }

        System.out.println("Cart value changed to [" + customer.getBoughtItems().getTotalValue() + "].");
        System.out.println("Cart value changed to [" + customer.getCart().getTotalValue() + "].");

    }

}
