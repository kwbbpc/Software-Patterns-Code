package broadway.kyle;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

import com.javadude.beans.Catalog;
import com.javadude.beans.Client;
import com.javadude.beans.Customer;
import com.javadude.beans.Product;
import com.javadude.beans.ProductHolder;

public class TestApp
{

    public static void main(String args[])
    {

        Customer customerJohn = new CustomerImpl("45681354", "John", "11 Street", "Germantown", "Maryland", "20874", "555-5555", "l3tm31n");

        customerJohn.getBoughtItems().addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                // If the change was to the history
                if (evt.getPropertyName() == "productMap")
                {
                    System.out.println("");
                    System.out.println("Customer history changed:");
                    Map<String, Integer> map = (HashMap<String, Integer>) evt.getNewValue();
                    for (Map.Entry<String, Integer> iterMap : map.entrySet())
                    {
                        System.out.println("Product [" + iterMap.getKey() + "] x " + iterMap.getValue());
                    }
                }
                // If the change was to anything else, just print the change.
                else
                {
                    System.out.println("");
                    System.out.println("History change recorded for " + evt.getPropertyName() + ": " + evt.getNewValue());
                }
            }
        });

        Catalog catalog = new CatalogImpl();

        catalog.addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                System.out.println("Catalog changed: " + evt.getNewValue());
            }
        });

        ProductHolder cart = new ProductHolderImpl();

        cart.addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                // If the change was to the cart
                if (evt.getPropertyName() == "productMap")
                {
                    System.out.println("");
                    System.out.println("Customer cart changed:");
                    Map<String, Integer> map = (HashMap<String, Integer>) evt.getNewValue();
                    for (Map.Entry<String, Integer> iterMap : map.entrySet())
                    {
                        System.out.println("Product [" + iterMap.getKey() + "] x " + iterMap.getValue());
                    }
                }
                // If the change was to anything else, just print the change.
                else
                {
                    System.out.println("");
                    System.out.println("Cart change recorded for " + evt.getPropertyName() + ": " + evt.getNewValue());
                }
            }
        });

        cart.setCatalog(catalog);

        customerJohn.setCart(cart);

        customerJohn.getBoughtItems().setCatalog(catalog);

        ProductHolder inventory = new ProductHolderImpl();
        inventory.addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                // If the change was to the history
                if (evt.getPropertyName() == "productMap")
                {
                    System.out.println("");
                    System.out.println("Inventory changed:");
                    Map<String, Integer> map = (HashMap<String, Integer>) evt.getNewValue();
                    for (Map.Entry<String, Integer> iterMap : map.entrySet())
                    {
                        System.out.println("Product [" + iterMap.getKey() + "] x " + iterMap.getValue());
                    }
                }
                // If the change was to anything else, just print the change.
                else
                {
                    System.out.println("");
                    System.out.println("Inventory change recorded for " + evt.getPropertyName() + ": " + evt.getNewValue());
                }
            }
        });
        inventory.setCatalog(catalog);

        Client client = new ClientImpl();

        Product product1 = new ProductImpl("1", "Product 1", 100, "The first product");
        Product product2 = new ProductImpl("2", "Product 2", 200, "The second product");
        Product product3 = new ProductImpl("3", "Product 3", 300, "The third product");
        Product product4 = new ProductImpl("4", "Product 4", 400, "The fourth product");
        Product product5 = new ProductImpl("5", "Product 5", 500, "The fifth product");
        Product product6 = new ProductImpl("6", "Product 6", 600, "The sixth product");
        Product product7 = new ProductImpl("7", "Product 7", 700, "The seventh product");
        Product product8 = new ProductImpl("8", "Product 8", 800, "The eigth product");
        Product product9 = new ProductImpl("9", "Product 9", 900, "The ninth product");
        Product product0 = new ProductImpl("10", "Product 10", 10000, "The tenth product");

        catalog.addProduct(product1);
        catalog.addProduct(product2);
        catalog.addProduct(product3);
        catalog.addProduct(product4);
        catalog.addProduct(product5);
        catalog.addProduct(product6);
        catalog.addProduct(product7);
        catalog.addProduct(product8);
        catalog.addProduct(product9);
        catalog.addProduct(product0);

        inventory.addQuantity(product1.getId(), 500);
        inventory.addQuantity(product2.getId(), 10);
        inventory.addQuantity(product3.getId(), 5);
        inventory.addQuantity(product4.getId(), 513);
        inventory.addQuantity(product5.getId(), 5890);
        inventory.addQuantity(product6.getId(), 135);
        inventory.addQuantity(product7.getId(), 123);
        inventory.addQuantity(product8.getId(), 5841);
        inventory.addQuantity(product9.getId(), 589);
        inventory.addQuantity(product0.getId(), 1);

        // Create an ordered command listener that will call it's listeners in a
        // Guaranteed order
        CommandListenerOrdered orderedCommandListener = new CommandListenerOrdered();
        // history must be called before the cart
        orderedCommandListener.addCommandListener(new CommandListenerHistory(customerJohn.getBoughtItems(), cart));
        // cart must be called after history
        orderedCommandListener.addCommandListener(new CommandListenerCart(cart));

        // register the ordered command lister with the client
        client.addCommandListener(orderedCommandListener);
        // register the remaining listeners
        client.addCommandListener(new CommandListenerInventory(inventory));
        client.addCommandListener(new CommandListenerPrint());

        client.addToCart("6", 19);
        client.removeFromCart("6", 2);
        client.purchaseCart();
        client.addToCart("10", 500);
        client.purchaseCart();

        Map<String, Integer> returns = new HashMap<String, Integer>();
        returns.put("10", 100);

        client.returnPurchaseToCart(returns);

    }
}
