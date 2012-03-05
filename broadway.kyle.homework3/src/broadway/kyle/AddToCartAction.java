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
     * Constructor for an add to cart action
     * 
     */
    public AddToCartAction(Client client, UndoManager undoManager)
    {
        this.client = client;
        this.commandManager = undoManager;

    }

    /* (non-Javadoc)
     * @see broadway.kyle.ActionStrategy#go(java.util.Map)
     * 
     * Add the item quantity to the cart
     * 
     */
    @Override
    public void go(Map<String, String[]> parameters)
    {

        String productId = null;
        Integer quantity = null;

        try
        {
            //Read the item id
            productId = (String) ParameterParser.find("itemId", parameters);

            //Read the quantity
            quantity = (Integer) ParameterParser.find("quantity", parameters);
        }
        catch (ClassCastException e)
        {
            productId = "";
            quantity = 0;
            System.out.println("AddToCartAction Failed: Could not find itemId or quantity parameters");
        }

        Command addToCartCommand = null;

        if (client != null)
        {
            //Create the add to cart command
            addToCartCommand = new AddToCartCommand(client, productId, quantity.intValue());
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
        else
        {
            System.out.println("Failed to add to cart: client does not exist.");
            assert (false);
        }

    }

}
