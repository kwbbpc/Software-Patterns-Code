package broadway.kyle;

import java.util.Map;

import com.javadude.beans.Client;
import com.javadude.beans.ProductHolder;
import com.javadude.command.Command;
import com.javadude.command.UndoManager;

public class PurchaseAction implements ActionStrategy
{

    private Client client;
    private UndoManager commandManager;
    private ProductHolder cart;

    /**
     * Constructor.
     * 
     * 
     * @param client
     * The client to execute commands
     * @param commandManager
     * The undo manager handling execution
     * @param cart
     * The product holder that's holding the items to purchase
     */
    PurchaseAction(Client client, UndoManager commandManager, ProductHolder cart)
    {
        super();
        this.client = client;
        this.commandManager = commandManager;
        this.cart = cart;
    }

    @Override
    public String go(Map<String, String[]> parameters)
    {
        //create the purchase cart command
        Command purchaseCartCommand = FactoryHomework2.createPurchaseCommand(client, cart);

        //tell the command manager to execute it
        if (commandManager != null)
        {
            commandManager.execute(purchaseCartCommand);
            return "Good";
        }
        else
        {
            System.out.println("Failed to execute purchase cart: command manager does not exist.");
            assert (false);
            return "Bad";
        }
    }

}
