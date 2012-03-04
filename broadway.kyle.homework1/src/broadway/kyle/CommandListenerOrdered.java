package broadway.kyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.javadude.beans.CommandListener;

/**
 * @author KBroadway
 * @Description The order that you register with in this class is guaranteed to
 *              be call in that order.
 * 
 */
public class CommandListenerOrdered implements CommandListener
{

    // The list of listeners must remain a list, or other collection that
    // maintains order.
    private List<CommandListener> listeners = new ArrayList<CommandListener>();

    public void addCommandListener(CommandListener commandListener)
    {
        listeners.add(commandListener);
    }

    public void removeCommandListener(CommandListener commandListener)
    {
        listeners.remove(commandListener);
    }

    @Override
    public void addToCart(String productId, int quantity)
    {
        for (CommandListener listener : listeners)
        {
            listener.addToCart(productId, quantity);
        }
    }

    @Override
    public void removeFromCart(String productId, int quantity)
    {
        for (CommandListener listener : listeners)
        {
            listener.removeFromCart(productId, quantity);
        }
    }

    @Override
    public void returnPurchaseToCart(Map<String, Integer> purchasedItems)
    {
        for (CommandListener listener : listeners)
        {
            listener.returnPurchaseToCart(purchasedItems);
        }
    }

    @Override
    public void purchaseCart()
    {
        for (CommandListener listener : listeners)
        {
            listener.purchaseCart();
        }
    }

}
