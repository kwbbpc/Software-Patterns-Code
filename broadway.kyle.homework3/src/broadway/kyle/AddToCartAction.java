package broadway.kyle;

import java.util.Map;

import com.javadude.beans.Client;
import com.javadude.command.Command;
import com.javadude.command.UndoManager;

/**
 * @author KBroadway
 *
 *  This action strategy adds an item and quantity to
 *  the cart. 
 *
 *
 */
public class AddToCartAction implements ActionStrategy
{

    private Client client;
    private UndoManager commandManager;

    /**
     * Constructor.
     * 
     * 
     * @param client
     * The client to execute commands
     * @param commandManager
     * The undo manager handling execution
     */
    public AddToCartAction(Client client, UndoManager undoManager)
    {
        this.client = client;
        this.commandManager = undoManager;

    }

    /* (non-Javadoc)
     * @see broadway.kyle.ActionStrategy#go(java.util.Map)
     */
    @Override
    public void go(Map<String, String[]> parameters)
    {

        String productId = null;
        Integer quantity = null;

        //Read the item id
        productId = (String) ParameterParser.find(ParameterParser.itemId, parameters);
        //Read the quantity
        quantity = (Integer) ParameterParser.find(ParameterParser.quantity, parameters);

        //Create the add to cart command
        Command addToCartCommand = new AddToCartCommand(client, productId, quantity.intValue());
        if (commandManager != null)
        {
            commandManager.execute(addToCartCommand);
        }
        else
        {
            System.out.println("Failed to execute add to cart: command manager does not exist.");
            assert (false);
        }

    }

}
