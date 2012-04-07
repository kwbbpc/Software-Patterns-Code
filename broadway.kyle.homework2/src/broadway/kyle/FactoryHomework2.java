package broadway.kyle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import broadway.kyle.ButtonActions.ActionAdd;
import broadway.kyle.ButtonActions.ActionButton;
import broadway.kyle.ButtonActions.ActionPurchase;
import broadway.kyle.ButtonActions.ActionRedo;
import broadway.kyle.ButtonActions.ActionRemove;
import broadway.kyle.ButtonActions.ActionUndo;
import broadway.kyle.EventActions.EventActionCustomer;
import broadway.kyle.EventActions.EventActionModel;
import broadway.kyle.EventActions.EventActionTextField;
import broadway.kyle.EventActions.EventActionTotalValue;
import broadway.kyle.EventActions.EventActionUndoManager;

import com.javadude.beans.Client;
import com.javadude.beans.Customer;
import com.javadude.beans.ProductHolder;
import com.javadude.command.Command;
import com.javadude.command.UndoManager;

public class FactoryHomework2
{

    public static Command createPurchaseCommand(Client client, ProductHolder cart)
    {
        return new PurchaseCommand(client, cart);
    }

    public static Command createRemoveFromCartCommand(Client client, String productId, int quantity)
    {
        return new RemoveFromCartCommand(client, productId, quantity);
    }

    public static Command createAddToCartCommand(Client client, String productId, int quantity)
    {
        return new AddToCartCommand(client, productId, quantity);
    }

    public static EventAction createEventActionModel(ProductTableModel table)
    {
        return new EventActionModel(table);
    }

    public static UI createUI(ProductHolder inventory, Customer customer, Client client)
    {
        return new UI(inventory, customer, client);
    }

    public static UndoManagerImpl createUndoManager()
    {
        return new UndoManagerImpl();
    }

    public static EventAction createEventActionTextField(Customer customer)
    {
        return new EventActionTextField(customer);
    }

    public static EventAction createEventActionCustomer(SimpleTextField idField, SimpleTextField nameField, SimpleTextField streetField, SimpleTextField cityField, SimpleTextField zipField, SimpleTextField phoneField, SimpleTextField passwordField)
    {
        return new EventActionCustomer(idField, nameField, streetField, cityField, zipField, phoneField, passwordField);
    }

    public static EventAction createEventActionTotalValue(JLabel cartTotalLabel, JLabel boughtItemsTotalLabel, Customer customer)
    {
        return new EventActionTotalValue(cartTotalLabel, boughtItemsTotalLabel, customer);
    }

    public static EventAction createEventActionUndoManager(JButton undoButton, JButton redoButton, UndoManager undoManager)
    {
        return new EventActionUndoManager(undoButton, redoButton, undoManager);
    }

    public static ActionListener createActionListener(final ActionButton action)
    {
        return new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                action.actionPerformed(e);
            }
        };
    }

    public static ActionButton createActionAdd(Client client, JTextField productIdField, JTextField quantityField, UndoManager undoManager)
    {
        return new ActionAdd(client, productIdField, quantityField, undoManager);
    }

    public static ActionButton createActionRemove(Client client, JTextField productIdField, JTextField quantityField, UndoManager undoManager)
    {
        return new ActionRemove(client, productIdField, quantityField, undoManager);
    }

    public static ActionButton createActionPurchase(Client client, Customer customer, UndoManager undoManager)
    {
        return new ActionPurchase(client, customer, undoManager);
    }

    public static ActionButton createActionUndo(UndoManager undoManager)
    {
        return new ActionUndo(undoManager);
    }

    public static ActionButton createActionRedo(UndoManager undoManager)
    {
        return new ActionRedo(undoManager);
    }

    public static JTextField createJTextField(String string)
    {
        return new JTextField(string);
    }

    public static JButton createJButton(String string)
    {
        return new JButton(string);
    }

    public static JLabel createJLabel()
    {
        return new JLabel();
    }

    public static Command createUpdateCustomerCommand(Customer customer, String id, String name, String street, String city, String zip, String phone, String password)
    {
        return new UpdateCustomerCommand(customer, id, name, street, city, zip, phone, password);
    }
}
