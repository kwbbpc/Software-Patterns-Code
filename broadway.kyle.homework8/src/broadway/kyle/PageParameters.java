package broadway.kyle;

import com.javadude.beans.Catalog;
import com.javadude.beans.Customer;
import com.javadude.beans.Product;
import com.javadude.beans.ProductHolder;
import com.javadude.command.UndoManager;

public abstract class PageParameters
{
    
    public Builder builder;
    public UndoManager commandManager;

    
    public static class CustomerEdit extends PageParameters
    {
        public Customer customer;
        
        public CustomerEdit(Builder builder, Customer customer, UndoManager commandManager)
        {
            
            this.builder = builder;
            this.customer = customer;
            this.commandManager = commandManager;
            
        }
    }
    
    public static class CatalogPage extends PageParameters
    {
        public ProductHolder inventory;
        public Catalog catalog;
        
        public CatalogPage(Builder builder, UndoManager commandManager, ProductHolder inventory, Catalog catalog)
        {
            this.builder = builder;
            this.commandManager = commandManager;
            this.inventory = inventory;
            this.catalog = catalog;
        }
        
        
    }
    
    public static class ItemDetail extends PageParameters
    {
        public Product product;

        public ItemDetail(Builder builder, UndoManager commandManager, Product product)
        {
            this.builder = builder;
            this.commandManager = commandManager;
            this.product = product;
        }
        
        
    }
    
    public static class Confirmation extends PageParameters
    {
        
        public Confirmation(Builder builder, UndoManager commandManager)
        {
            this.builder = builder;
            this.commandManager = commandManager;
        }
        
    }
    
    public static class PurchaseHistory extends PageParameters
    {
        public Catalog catalog;
        public ProductHolder purchasedItems;
        
        public PurchaseHistory(Builder builder, UndoManager commandManager, Catalog catalog, ProductHolder purchasedItems)
        {
            this.builder = builder;
            this.commandManager = commandManager;
            this.catalog = catalog;
            this.purchasedItems = purchasedItems;
        }
        
        
    }
    
    public static class Cart extends PageParameters
    {
        public Catalog catalog;
        public ProductHolder cart;
        
        public Cart(Builder builder, UndoManager commandManager, Catalog catalog, ProductHolder cart)
        {
            this.builder = builder;
            this.commandManager = commandManager;
            this.catalog = catalog;
            this.cart = cart;
        }
        
        
    }

}
