package broadway.kyle;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.HashMap;
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

    private Customer customer = new CustomerImpl("45681354", "John", "11 Street", "Germantown", "Maryland", "20874", "555-5555", "l3tm31n");
    private Catalog catalog = new CatalogImpl();
    private ProductHolder cart = new ProductHolderImpl();
    private ProductHolder inventory = new ProductHolderImpl();
    private Client client = new ClientImpl();
    private UndoManager commandManager = new UndoManagerImpl();
    private Map<String, ActionStrategy> strategyMap = new HashMap<String, ActionStrategy>();

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
        new UI(inventory, customer, client).setVisible(true);

        //Create the different strategies
        strategyMap.put("addToCart", new AddToCartAction(client, commandManager));
        strategyMap.put("removeFromCart", new RemoveFromCartAction(client, commandManager));
        strategyMap.put("purchase", new PurchaseAction(client, commandManager, cart));
        strategyMap.put("undo", new UndoAction(commandManager));
        strategyMap.put("redo", new RedoAction(commandManager));

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

        customer.getBoughtItems().addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                // If the change was to the history
                if (evt.getPropertyName() == "quantities")
                {
                    System.out.println("");
                    System.out.println("Customer history changed:");
                    @SuppressWarnings("unchecked")
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
                    @SuppressWarnings("unchecked")
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
                    @SuppressWarnings("unchecked")
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

        // Create an ordered command listener that will call it's listeners in a
        // Guaranteed order
        CommandListenerOrdered orderedCommandListener = new CommandListenerOrdered();
        // history must be called before the cart
        orderedCommandListener.addCommandListener(new CommandListenerHistory(customer.getBoughtItems(), cart));
        // cart must be called after history
        orderedCommandListener.addCommandListener(new CommandListenerCart(cart));

        // register the ordered command lister with the client
        client.addCommandListener(orderedCommandListener);
        // register the remaining listeners
        client.addCommandListener(new CommandListenerInventory(inventory));
        client.addCommandListener(new CommandListenerPrint());

    }

    /**
     * Adds the initial values and products
     * To the catalog and inventory.
     * 
     */
    private void initializeCatalogAndInventory()
    {

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
