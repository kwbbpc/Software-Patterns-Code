package broadway.kyle;

import java.util.Map;

import com.javadude.beans.CommandListener;
import com.javadude.beans.ProductHolder;

public class CommandListenerInventory implements CommandListener
{

    ProductHolder inventory;

    CommandListenerInventory(ProductHolder inventory)
    {
        this.inventory = inventory;
    }

    @Override
    public void addToCart(String productId, int quantity)
    {
        // remove item from inventory
        inventory.removeQuantity(productId, quantity);

    }

    @Override
    public void removeFromCart(String productId, int quantity)
    {
        // add item to inventory
        inventory.addQuantity(productId, quantity);

    }

    @Override
    public void returnPurchaseToCart(Map<String, Integer> purchasedItems)
    {
        // do nothing

    }

    @Override
    public void purchaseCart()
    {
        // do nothing

    }

}
