package broadway.kyle.ButtonActions;

import java.awt.event.ActionEvent;

import broadway.kyle.FactoryHomework2;

import com.javadude.beans.Client;
import com.javadude.beans.Customer;
import com.javadude.command.UndoManager;

public class ActionPurchase implements ActionButton
{

    Client client;
    Customer customer;
    UndoManager undoManager;

    public ActionPurchase(Client client, Customer customer,
            UndoManager undoManager)
    {
        this.client = client;
        this.customer = customer;
        this.undoManager = undoManager;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        undoManager.execute(FactoryHomework2.createPurchaseCommand(client, customer.getCart()));
    }

}
