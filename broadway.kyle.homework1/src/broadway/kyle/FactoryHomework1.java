package broadway.kyle;

import com.javadude.beans.Catalog;
import com.javadude.beans.Client;
import com.javadude.beans.Customer;
import com.javadude.beans.Product;
import com.javadude.beans.ProductHolder;

public class FactoryHomework1
{

    public static Product createProduct(String id, String name, int price, String description)
    {
        return new ProductImpl(id, name, price, description);
    }

    public static ProductHolder createProductHolder()
    {
        return new ProductHolderImpl();
    }

    public static CommandListenerOrdered createCommandListenerOrdered()
    {
        return new CommandListenerOrdered();
    }

    public static CommandListenerHistory createCommandListenerHistory(ProductHolder history, ProductHolder cart)
    {
        return new CommandListenerHistory(history, cart);
    }

    public static CommandListenerCart createCommandListenerCart(ProductHolder cart)
    {
        return new CommandListenerCart(cart);
    }

    public static CommandListenerInventory createCommandListenerInventory(ProductHolder inventory)
    {
        return new CommandListenerInventory(inventory);
    }

    public static CommandListenerPrint createCommandListenerPrint()
    {
        return new CommandListenerPrint();
    }

    public static Customer createCustomer(String id, String name, String street, String city, String state, String zip, String phone, String password)
    {
        return new CustomerImpl(id, name, street, city, state, zip, phone, password);
    }

    public static Catalog createCatalog()
    {
        return new CatalogImpl();
    }

    public static Client createClient()
    {
        return new ClientImpl();
    }

    public static CatalogNull createCatalogNull()
    {
        return new CatalogNull();
    }

    public static EventAction createEventActionHistory()
    {
        return new EventActionHistory();
    }

    public static EventAction createEventActionCatalog()
    {
        return new EventActionCatalog();
    }

    public static EventAction createEventActionCart()
    {
        return new EventActionCart();
    }

    public static EventAction createEventActionInventory()
    {
        return new EventActionInventory();
    }

}
