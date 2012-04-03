package broadway.kyle;

import com.javadude.beans.Catalog;
import com.javadude.beans.Client;
import com.javadude.beans.Customer;
import com.javadude.beans.Product;
import com.javadude.beans.ProductHolder;
import com.javadude.command.UndoManager;

public class TestApp
{

    final static String customerEditPage = "CustomerEdit.html";
    final static String itemCatalogPage = "ItemCatalog.html";
    final static String itemDetailPage = "ItemDetail.html";
    final static String shoppingCartPage = "ShoppingCart.html";
    final static String purchaseHistoryPage = "PurchaseHistory.html";
    final static String purchaseConfirmPage = "PurchaseConfirmation.html";

    private static Customer customerJohn;
    private static Catalog catalog;
    private static ProductHolder cart;
    private static ProductHolder inventory;
    private static Client client;

    private static UndoManager commandManager;

    private static void Setup()
    {

        commandManager = FactoryHomework2.createUndoManager();

        customerJohn = FactoryHomework1.createCustomer("45681354", "John", "11 Street", "Germantown", "Maryland", "20874", "555-5555", "l3tm31n");
        catalog = FactoryHomework1.createCatalog();
        cart = FactoryHomework1.createProductHolder();
        inventory = FactoryHomework1.createProductHolder();
        client = FactoryHomework1.createClient();

        cart.setCatalog(catalog);

        customerJohn.setCart(cart);

        customerJohn.getBoughtItems().setCatalog(catalog);

        inventory.setCatalog(catalog);

        // Create an ordered command listener that will call it's listeners in a
        // Guaranteed order
        CommandListenerOrdered orderedCommandListener = FactoryHomework1.createCommandListenerOrdered();
        // history must be called before the cart
        orderedCommandListener.addCommandListener(FactoryHomework1.createCommandListenerHistory(customerJohn.getBoughtItems(), cart));
        // cart must be called after history
        orderedCommandListener.addCommandListener(FactoryHomework1.createCommandListenerCart(cart));

        // register the ordered command lister with the client
        client.addCommandListener(orderedCommandListener);
        // register the remaining listeners
        client.addCommandListener(FactoryHomework1.createCommandListenerInventory(inventory));
        client.addCommandListener(FactoryHomework1.createCommandListenerPrint());

        customerJohn.getBoughtItems().addPropertyChangeListener(FactoryPropertyChange.createPropertyChangeListener(FactoryHomework1.createEventActionHistory()));

        catalog.addPropertyChangeListener(FactoryPropertyChange.createPropertyChangeListener(FactoryHomework1.createEventActionCatalog()));

        cart.addPropertyChangeListener(FactoryPropertyChange.createPropertyChangeListener(FactoryHomework1.createEventActionCart()));

        inventory.addPropertyChangeListener(FactoryPropertyChange.createPropertyChangeListener(FactoryHomework1.createEventActionInventory()));

    }

    public static void main(String[] args)
    {

        Setup();

        Product product1 = FactoryHomework1.createProduct("1", "Product 1", 1, "The first product");
        Product product2 = FactoryHomework1.createProduct("2", "Product 2", 2, "The second product");
        Product product3 = FactoryHomework1.createProduct("3", "Product 3", 3, "The third product");
        Product product4 = FactoryHomework1.createProduct("4", "Product 4", 4, "The fourth product");
        Product product5 = FactoryHomework1.createProduct("5", "Product 5", 5, "The fifth product");
        Product product6 = FactoryHomework1.createProduct("6", "Product 6", 6, "The sixth product");
        Product product7 = FactoryHomework1.createProduct("7", "Product 7", 7, "The seventh product");
        Product product8 = FactoryHomework1.createProduct("8", "Product 8", 8, "The eigth product");
        Product product9 = FactoryHomework1.createProduct("9", "Product 9", 9, "The ninth product");
        Product product0 = FactoryHomework1.createProduct("10", "Product 10", 10, "The tenth product");

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

        inventory.addQuantity(product1.getId(), 50);
        inventory.addQuantity(product2.getId(), 10);
        inventory.addQuantity(product3.getId(), 5);
        inventory.addQuantity(product4.getId(), 65);
        inventory.addQuantity(product5.getId(), 43);
        inventory.addQuantity(product6.getId(), 12);
        inventory.addQuantity(product7.getId(), 32);
        inventory.addQuantity(product8.getId(), 11);
        inventory.addQuantity(product9.getId(), 33);
        inventory.addQuantity(product0.getId(), 12);

        //create the page directors and build the pages
        Director customerEditDirector = new DirectorCustomerEdit(new BuilderHtml(), customerJohn, commandManager);
        customerEditDirector.build(FactoryInputOutputStream.createFilePrintStream(customerEditPage).getPrintStream());

        Director itemDetailDirector = new DirectorItemDetail(new BuilderHtml(), product1, commandManager);
        itemDetailDirector.build(FactoryInputOutputStream.createFilePrintStream(itemDetailPage).getPrintStream());

        Director purchaseConfirmationDirector = new DirectorPurchaseConfirmation(new BuilderHtml(), commandManager);
        purchaseConfirmationDirector.build(FactoryInputOutputStream.createFilePrintStream(purchaseConfirmPage).getPrintStream());

        Director purchaseHistoryDirector = new DirectorPurchaseHistory(new BuilderHtml(), commandManager, customerJohn.getBoughtItems());
        purchaseHistoryDirector.build(FactoryInputOutputStream.createFilePrintStream(purchaseHistoryPage).getPrintStream());

        Director shoppingCartDirector = new DirectorShoppingCart(new BuilderHtml(), customerJohn.getCart(), commandManager);
        shoppingCartDirector.build(FactoryInputOutputStream.createFilePrintStream(shoppingCartPage).getPrintStream());

    }
}
