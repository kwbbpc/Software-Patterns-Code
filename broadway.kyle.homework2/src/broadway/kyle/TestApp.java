package broadway.kyle;

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

        Customer customer = FactoryHomework1.createCustomer("45681354", "John", "11 Street", "Germantown", "Maryland", "20874", "555-5555", "l3tm31n");

        customer.getBoughtItems().addPropertyChangeListener(FactoryPropertyChange.createPropertyChangeListener(FactoryHomework1.createEventActionHistory()));

        Catalog catalog = FactoryHomework1.createCatalog();

        catalog.addPropertyChangeListener(FactoryPropertyChange.createPropertyChangeListener(FactoryHomework1.createEventActionCatalog()));

        ProductHolder cart = FactoryHomework1.createProductHolder();

        cart.addPropertyChangeListener(FactoryPropertyChange.createPropertyChangeListener(FactoryHomework1.createEventActionCart()));

        cart.setCatalog(catalog);

        customer.setCart(cart);

        customer.getBoughtItems().setCatalog(catalog);

        ProductHolder inventory = FactoryHomework1.createProductHolder();

        inventory.addPropertyChangeListener(FactoryPropertyChange.createPropertyChangeListener(FactoryHomework1.createEventActionInventory()));
        inventory.setCatalog(catalog);

        Client client = FactoryHomework1.createClient();

        Product product1 = FactoryHomework1.createProduct("1", "Product 1", 100, "The first product");
        Product product2 = FactoryHomework1.createProduct("2", "Product 2", 200, "The second product");
        Product product3 = FactoryHomework1.createProduct("3", "Product 3", 300, "The third product");
        Product product4 = FactoryHomework1.createProduct("4", "Product 4", 400, "The fourth product");
        Product product5 = FactoryHomework1.createProduct("5", "Product 5", 500, "The fifth product");
        Product product6 = FactoryHomework1.createProduct("6", "Product 6", 600, "The sixth product");
        Product product7 = FactoryHomework1.createProduct("7", "Product 7", 700, "The seventh product");
        Product product8 = FactoryHomework1.createProduct("8", "Product 8", 800, "The eigth product");
        Product product9 = FactoryHomework1.createProduct("9", "Product 9", 900, "The ninth product");
        Product product0 = FactoryHomework1.createProduct("10", "Product 10", 10000, "The tenth product");

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
        CommandListenerOrdered orderedCommandListener = FactoryHomework1.createCommandListenerOrdered();
        // history must be called before the cart
        orderedCommandListener.addCommandListener(FactoryHomework1.createCommandListenerHistory(customer.getBoughtItems(), cart));
        // cart must be called after history
        orderedCommandListener.addCommandListener(FactoryHomework1.createCommandListenerCart(cart));

        // register the ordered command lister with the client
        client.addCommandListener(orderedCommandListener);
        // register the remaining listeners
        client.addCommandListener(FactoryHomework1.createCommandListenerInventory(inventory));
        client.addCommandListener(FactoryHomework1.createCommandListenerPrint());

        client.addToCart("6", 19);
        client.removeFromCart("6", 2);
        client.purchaseCart();
        client.addToCart("10", 500);
        client.purchaseCart();

        Map<String, Integer> returns = FactoryCollection.createMap();
        returns.put("10", 100);

        client.returnPurchaseToCart(returns);

        FactoryHomework2.createUI(inventory, customer, client).setVisible(true);

    }
}
