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

    private static Customer customerJohn;
    private static Catalog catalog;
    private static ProductHolder cart;
    private static ProductHolder inventory;
    private static Client client;

    private static Product testProduct = new ProductImpl("TEST", "Test Product", 1, "A test product for testing");
    private static Product testProduct2 = new ProductImpl("TEST2", "Test Product2", 2, "A second test product for testing");

    public static void TestIsEmpty()
    {
        Setup();

        catalog.addProduct(testProduct);
        inventory.addQuantity(testProduct.getId(), 500);

        assert (cart.isEmpty() == true);
        cart.addQuantity("TEST", 1);
        assert (cart.isEmpty() != true);
        cart.removeQuantity("TEST", 1);
        assert (cart.isEmpty() == true);
        cart.addQuantity("TEST", 0);
        assert (cart.isEmpty() == true);

    }

    private static boolean CompareMaps(Map<String, Integer> m1, Map<String, Integer> m2)
    {
        boolean b = false;

        for (Map.Entry<String, Integer> e : m1.entrySet())
        {
            b = e.getValue().equals(m2.get(e.getKey()));
            if (!b)
                break;
        }

        return b;
    }

    public static void TestAddAndRemove()
    {
        Setup();

        //create the compare map
        Map<String, Integer> holderComparable3 = new HashMap<String, Integer>();
        holderComparable3.put("TEST", 3);
        Map<String, Integer> holderComparable2 = new HashMap<String, Integer>();
        holderComparable2.put("TEST", 2);
        Map<String, Integer> holderComparable1 = new HashMap<String, Integer>();
        holderComparable1.put("TEST", 1);
        Map<String, Product> catalogComparable = new HashMap<String, Product>();
        catalogComparable.put("TEST", testProduct);

        //Add the test product to the catalog and inventory
        catalog.addProduct(testProduct);
        inventory.addQuantity(testProduct.getId(), 3);
        //Test for the product in the catalog and inventory
        //        assert (catalog.getProducts().equals(catalogComparable));
        assert (CompareMaps(inventory.getQuantities(), holderComparable3));

        //Add all 3 items to the cart.
        client.addToCart(testProduct.getId(), 3);
        //Verify
        assert (CompareMaps(cart.getQuantities(), holderComparable3));
        assert (inventory.isEmpty());

        //Add a null item to the cart
        client.addToCart(null, 3);
        //Verify
        assert (CompareMaps(cart.getQuantities(), holderComparable3));
        assert (inventory.isEmpty());

        /* Cannot add null quantities
        * //Add a null quantity to the cart
        * client.addToCart(testProduct.getId(), null);
        * //Verify
        * assert(cart.getQuantities().equals(holderComparable));
        * assert(inventory.isEmpty());
        */

        //Add an item that doesn't exist
        client.addToCart("DNE", 1);
        //Verify
        assert (CompareMaps(cart.getQuantities(), holderComparable3));
        assert (inventory.isEmpty());

        //Overdraw the inventory
        client.addToCart(testProduct.getId(), 3);
        //Should fail to add to cart
        assert (CompareMaps(cart.getQuantities(), holderComparable3));
        assert (inventory.isEmpty());

        //Verify the total value
        assert (inventory.getTotalValue() == 0);
        assert (cart.getTotalValue() == 3);

        //Remove 1 from the cart
        client.removeFromCart(testProduct.getId(), 1);
        assert (CompareMaps(cart.getQuantities(), holderComparable2));
        assert (CompareMaps(inventory.getQuantities(), holderComparable1));
        assert (catalog.getProducts().equals(catalogComparable));
        assert (cart.getTotalValue() == 2);
        assert (inventory.getTotalValue() == 1);

        //Remove too many items from the cart
        client.removeFromCart(testProduct.getId(), 10);
        assert (cart.isEmpty());
        assert (CompareMaps(inventory.getQuantities(), holderComparable3));
        assert (inventory.getTotalValue() == 3);
        assert (cart.getTotalValue() == 0);

        assert (false);

    }

    private static boolean retFalse()
    {
        return false;
    }

    private static void Setup()
    {
        ClearMembers();

        cart.setCatalog(catalog);

        customerJohn.setCart(cart);

        customerJohn.getBoughtItems().setCatalog(catalog);

        inventory.setCatalog(catalog);

    }

    private static void AddPropertyChangeListeners()
    {

        customerJohn.getBoughtItems().addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                // If the change was to the history
                if (evt.getPropertyName() == "quantities")
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

        catalog.addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                System.out.println("Catalog changed: " + evt.getNewValue());
            }
        });

        cart.addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                // If the change was to the cart
                if (evt.getPropertyName() == "quantities")
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

        inventory.addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                // If the change was to the history
                if (evt.getPropertyName() == "quantities")
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

    }

    private static void ClearMembers()
    {
        customerJohn = new CustomerImpl("45681354", "John", "11 Street", "Germantown", "Maryland", "20874", "555-5555", "l3tm31n");
        catalog = new CatalogImpl();
        cart = new ProductHolderImpl();
        inventory = new ProductHolderImpl();
        client = new ClientImpl();
    }

    public static void main(String args[])
    {

        //Tests
        TestIsEmpty();
        TestAddAndRemove();

        Setup();

        AddPropertyChangeListeners();

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
