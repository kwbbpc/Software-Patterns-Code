package broadway.kyle;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javadude.beans.Catalog;
import com.javadude.beans.Client;
import com.javadude.beans.Customer;
import com.javadude.beans.Product;
import com.javadude.beans.ProductHolder;
import com.javadude.command.UndoManager;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    private Customer customer = FactoryHomework1.createCustomer("45681354", "John", "11 Street", "Germantown", "Maryland", "20874", "555-5555", "l3tm31n");
    private Catalog catalog = FactoryHomework1.createCatalog();
    private ProductHolder cart = FactoryHomework1.createProductHolder();
    private ProductHolder inventory = FactoryHomework1.createProductHolder();
    private Client client = FactoryHomework1.createClient();
    private UndoManager commandManager = FactoryHomework2.createUndoManager();
    private Map<String, ActionStrategy> strategyMap = FactoryCollection.createMap();

    @Override
    public void init() throws ServletException
    {

        cart.setCatalog(catalog);
        customer.setCart(cart);
        customer.getBoughtItems().setCatalog(catalog);
        inventory.setCatalog(catalog);

        addPropertyChangeListeners();

        initializeCatalogAndInventory();

        //launch the GUI
        FactoryHomework2.createUI(inventory, customer, client).setVisible(true);

        //Create the different strategies
        strategyMap.put("addToCart", FactoryHomework3.createAddToCartAction(client, commandManager));
        strategyMap.put("removeFromCart", FactoryHomework3.createRemoveFromCartAction(client, commandManager));
        strategyMap.put("purchaseCart", FactoryHomework3.createPurchaseAction(client, commandManager, cart));
        strategyMap.put("editCustomer", FactoryHomework3.createUpdateCustomerAction(customer, commandManager));
        strategyMap.put("undo", FactoryHomework3.createUndoAction(commandManager));
        strategyMap.put("redo", FactoryHomework3.createRedoAction(commandManager));

        super.init();
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller()
    {
        super();
    }

    /**
     * 
     * Add property change listeners to the customer, cart, catalog, and inventory
     * 
     */
    private void addPropertyChangeListeners()
    {

        customer.getBoughtItems().addPropertyChangeListener(FactoryPropertyChange.createPropertyChangeListener(FactoryHomework1.createEventActionHistory()));

        catalog.addPropertyChangeListener(FactoryPropertyChange.createPropertyChangeListener(FactoryHomework1.createEventActionCatalog()));

        cart.addPropertyChangeListener(FactoryPropertyChange.createPropertyChangeListener(FactoryHomework1.createEventActionCart()));

        inventory.addPropertyChangeListener(FactoryPropertyChange.createPropertyChangeListener(FactoryHomework1.createEventActionInventory()));

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

    }

    /**
     * Adds the initial values and products
     * To the catalog and inventory.
     * 
     */
    private void initializeCatalogAndInventory()
    {

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

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        //Template Method
        String actionString = request.getParameter("action");

        //find the requested action in the map and execute it
        if (actionString != null)
        {
            ActionStrategy action = strategyMap.get(actionString);
            if (action != null)
            {
                action.go(request.getParameterMap());
            }
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
    }

}
