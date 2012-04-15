package broadway.kyle;

import java.util.Map;

import com.javadude.beans.Client;
import com.javadude.command.Command;
import com.javadude.command.UndoManager;

public class RemoveFromCartAction implements ActionStrategy
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
    RemoveFromCartAction(Client client, UndoManager undoManager)
    {
        super();
        this.client = client;
        this.commandManager = undoManager;
    }

    /* (non-Javadoc)
     * @see broadway.kyle.ActionStrategy#go(java.util.Map)
     */
    @Override
    public String go(Map<String, String[]> parameters)
    {
        //Read the itemId
        String productId = ParameterParser.find(ParameterParser.itemId, parameters);

        //Read the quantity
        Integer quantity = Integer.parseInt(ParameterParser.find(ParameterParser.quantity, parameters));

        //Create the remove from cart command
        Command removeFromCartCommand = FactoryHomework2.createRemoveFromCartCommand(client, productId, quantity.intValue());
        if (commandManager != null)
        {
            commandManager.execute(removeFromCartCommand);
            return "Ok";
        }
        else
        {
            System.out.println("Failed to execute remove from cart: command manager does not exist.");
            assert (false);
            return "Bad";
        }

    }

}
