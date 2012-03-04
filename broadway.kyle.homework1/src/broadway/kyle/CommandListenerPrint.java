package broadway.kyle;

import java.util.Map;

import com.javadude.beans.CommandListener;

public class CommandListenerPrint implements CommandListener
{

    @Override
    public void addToCart(String productId, int quantity)
    {
        System.out.println("");
        System.out.println("Product [" + productId + "] x " + quantity + " added to cart.");
    }

    @Override
    public void removeFromCart(String productId, int quantity)
    {
        System.out.println("");
        System.out.println("Product [" + productId + "] x " + quantity + " removed from cart.");
    }

    @Override
    public void returnPurchaseToCart(Map<String, Integer> purchasedItems)
    {
        for (Map.Entry<String, Integer> iterProduct : purchasedItems.entrySet())
        {
            System.out.println("");
            // remove the products from the bought items
            System.out.println("Purchased product [" + iterProduct.getKey() + "] x " + iterProduct.getValue() + " returned to cart.");
        }
    }

    @Override
    public void purchaseCart()
    {
        System.out.println("");
        System.out.println("Cart purchased.");
    }

}
