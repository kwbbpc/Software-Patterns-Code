package broadway.kyle;

import java.util.Map;

import com.javadude.beans.CommandListener;
import com.javadude.beans.ProductHolder;

public class CommandListenerHistory implements CommandListener
{

    ProductHolder history;
    ProductHolder cart;

    /**
     * @param history
     * @param cart
     */
    public CommandListenerHistory(ProductHolder history, ProductHolder cart)
    {
        this.history = history;
        this.cart = cart;
    }

    @Override
    public void addToCart(String productId, int quantity)
    {
        // do nothing
    }

    @Override
    public void removeFromCart(String productId, int quantity)
    {
        // do nothing
    }

    @Override
    public void returnPurchaseToCart(Map<String, Integer> purchasedItems)
    {
        // remove products from history
        for (Map.Entry<String, Integer> iterToRemove : purchasedItems.entrySet())
        {
            // remove the products from the bought items
            history.removeQuantity(iterToRemove.getKey(), iterToRemove.getValue());
        }
    }

    @Override
    public void purchaseCart()
    {
        // copy the cart contents to the history
        // remove products from history
        for (Map.Entry<String, Integer> iterCart : cart.getQuantities().entrySet())
        {
            // copy to the history
            history.addQuantity(iterCart.getKey(), iterCart.getValue());
        }

    }

}
