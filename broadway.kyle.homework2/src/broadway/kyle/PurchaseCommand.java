package broadway.kyle;

import java.util.HashMap;
import java.util.Map;

import com.javadude.beans.Client;
import com.javadude.beans.ProductHolder;
import com.javadude.command.Command;

public class PurchaseCommand implements Command
{

    private Client client;
    private Map<String, Integer> oldQuantities;

    public PurchaseCommand(Client client, ProductHolder cart)
    {
        this.client = client;
        this.oldQuantities = new HashMap<String, Integer>(cart.getQuantities());
    }

    @Override
    public void execute()
    {
        client.purchaseCart();
    }

    @Override
    public void undo()
    {
        client.returnPurchaseToCart(oldQuantities);
    }

    @Override
    public void redo()
    {
        //Purchase the cart
        execute();
    }

    @Override
    public String getName()
    {
        return "purchase cart";
    }

}
