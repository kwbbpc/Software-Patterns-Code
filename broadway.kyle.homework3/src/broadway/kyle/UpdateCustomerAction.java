package broadway.kyle;

import java.util.Map;

import com.javadude.beans.Customer;
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
public class UpdateCustomerAction implements ActionStrategy
{

    private Customer customer;
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
    UpdateCustomerAction(Customer customer, UndoManager undoManager)
    {
        this.customer = customer;
        this.commandManager = undoManager;

    }

    /* (non-Javadoc)
     * @see broadway.kyle.ActionStrategy#go(java.util.Map)
     */
    @Override
    public String go(Map<String, String[]> parameters)
    {

        String id = ParameterParser.find(ParameterParser.id, parameters);
        String name = ParameterParser.find(ParameterParser.name, parameters);
        String street = ParameterParser.find(ParameterParser.street, parameters);
        String city = ParameterParser.find(ParameterParser.city, parameters);
        String zip = ParameterParser.find(ParameterParser.zip, parameters);
        String phone = ParameterParser.find(ParameterParser.phone, parameters);
        String password = ParameterParser.find(ParameterParser.password, parameters);

        //Create the add to cart command
        Command updateCustomerCommand = FactoryHomework2.createUpdateCustomerCommand(customer, id, name, street, city, zip, phone, password);
        if (commandManager != null)
        {
            commandManager.execute(updateCustomerCommand);
            return "Ok";
        }
        else
        {
            System.out.println("Failed to execute customer update: command manager does not exist.");
            assert (false);
            return "Bad";
        }

    }
}
