package broadway.kyle;

import com.javadude.beans.Client;
import com.javadude.command.Command;

public class RemoveFromCartCommand implements Command
{

    private Client client;
    private String productId;
    private int quantity;

    public RemoveFromCartCommand(Client client, String productId, int quantity)
    {
        this.client = client;
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public void execute()
    {
        client.removeFromCart(productId, quantity);
    }

    @Override
    public void undo()
    {
        client.addToCart(productId, quantity);
    }

    @Override
    public void redo()
    {
        execute();
    }

    @Override
    public String getName()
    {
        return "remove from cart";
    }

}
