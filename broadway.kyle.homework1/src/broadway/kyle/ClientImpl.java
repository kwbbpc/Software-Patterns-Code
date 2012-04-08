package broadway.kyle;

import java.util.List;
import java.util.Map;

import com.javadude.beans.Client;
import com.javadude.beans.CommandListener;

public class ClientImpl implements Client
{

    private List<CommandListener> listeners = FactoryCollection.createArraylist();

    @Override
    public void addCommandListener(CommandListener commandListener)
    {
        listeners.add(commandListener);
    }

    @Override
    public void removeCommandListener(CommandListener commandListener)
    {
        listeners.remove(commandListener);
    }

    @Override
    public void addToCart(String productId, int quantity)
    {
        //        System.out.println("");
        //        System.out.println("------------------------------------------------------------");
        //        System.out.println("Client: Product [" + productId + "] x " + quantity + " is being added to the cart.");
        for (CommandListener listener : listeners)
        {
            listener.addToCart(productId, quantity);
        }
    }

    @Override
    public void removeFromCart(String productId, int quantity)
    {
        //        System.out.println("");
        //        System.out.println("------------------------------------------------------------");
        //        System.out.println("Client: Product [" + productId + "] x " + quantity + " is being removed from the cart.");

        for (CommandListener listener : listeners)
        {
            listener.removeFromCart(productId, quantity);
        }
    }

    @Override
    public void returnPurchaseToCart(Map<String, Integer> purchasedItems)
    {
        //        System.out.println("");
        //        System.out.println("------------------------------------------------------------");
        //        for (Map.Entry<String, Integer> iterMap : purchasedItems.entrySet())
        //        {
        //                        System.out.println("Client: Previously purcahsed product [" + iterMap.getKey() + "] x " + iterMap.getValue() + " is being returned to the cart.");
        //        }

        for (CommandListener listener : listeners)
        {
            listener.returnPurchaseToCart(purchasedItems);
        }
    }

    @Override
    public void purchaseCart()
    {
        //        System.out.println("");
        //        System.out.println("------------------------------------------------------------");
        //        System.out.println("Client: The cart is being purchased.");

        for (CommandListener listener : listeners)
        {
            listener.purchaseCart();
        }
    }

}
