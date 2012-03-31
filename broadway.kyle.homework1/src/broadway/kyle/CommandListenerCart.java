package broadway.kyle;

import java.util.Map;

import com.javadude.beans.CommandListener;
import com.javadude.beans.ProductHolder;

public class CommandListenerCart implements CommandListener
{

    // The customer who this command listener is managing
    private ProductHolder cart;

    CommandListenerCart(ProductHolder cart)
    {
        this.cart = cart;
    }

    @Override
    public void addToCart(String productId, int quantity)
    {
        // add the products to the cart
        cart.addQuantity(productId, quantity);
    }

    @Override
    public void removeFromCart(String productId, int quantity)
    {
        // remove the products from the cart
        cart.removeQuantity(productId, quantity);
    }

    @Override
    public void returnPurchaseToCart(Map<String, Integer> purchasedItems)
    {
        for (Map.Entry<String, Integer> iterToAdd : purchasedItems.entrySet())
        {
            // add the products to the customer's cart
            cart.addQuantity(iterToAdd.getKey(), iterToAdd.getValue());
        }
    }

    @Override
    public void purchaseCart()
    {
        cart.clear();
    }

}
