package broadway.kyle;

import com.javadude.beans.Client;
import com.javadude.command.Command;

public class AddToCartCommand implements Command
{

    private Client client;
    private String productId;
    private int quantity;

    public AddToCartCommand(Client client, String productId, int quantity)
    {
        this.client = client;
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public void execute()
    {
        client.addToCart(productId, quantity);
    }

    @Override
    public void undo()
    {
        client.removeFromCart(productId, quantity);
    }

    @Override
    public void redo()
    {
        execute();
    }

    @Override
    public String getName()
    {
        return "add to cart";
    }

    @Override
    public String toString()
    {
        return getClass().getName() + ": Params[(Client:" + client.toString() + "), (ProductId:" + productId + "), (Quantity:" + quantity + ")]";

    }

}
