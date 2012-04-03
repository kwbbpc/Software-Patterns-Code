package broadway.kyle;

import java.io.PrintStream;

import com.javadude.beans.Catalog;
import com.javadude.beans.Customer;
import com.javadude.beans.Product;
import com.javadude.beans.ProductHolder;
import com.javadude.command.UndoManager;

public interface Builder
{

    /**
     * @author KBroadway
     * 
     * The type of footer to be built
     *
     */
    public enum FooterType
    {
        CustomerEdit, Catalog, ItemDetail, PurchaseHistory, PurchaseConfirmation, ShoppingCart
    }

    public enum TableType
    {
        ShoppingCart, Catalog
    }

    /**
     * @param header
     * 
     * Builds an emphasised piece of text (a section header)
     * 
     */
    public void buildHeader(String header);

    /**
     * Builds a customer form
     * 
     * @param Customer
     * The customer to build the form for
     */
    public void buildForm(Customer customer);

    /**
     * Builds an item detail form
     * 
     * @param product
     * The product to build the form for
     */
    public void buildForm(Product product);

    /**
     * Builds a table
     * 
     * @param ProductHolder
     * The product holder to table-ize
     * 
     * @param Catalog
     * The catalog to look items up in
     */
    public void buildTable(TableType type, ProductHolder productHolder, Catalog catalog);

    /**
     * Builds a paragraph
     * 
     * @param text
     * The paragraph text
     * 
     */
    public void buildParagraph(String text);

    /**
     * Builds the page title section
     * 
     * @param title
     * The title to build
     */
    public void buildPageTitle(String title);

    /**
     * Builds a footer section, complete with whatever links
     * are needed.
     * 
     * @param page
     * the page type to build the footer for (each page might need a different footer)
     * 
     * 
     */
    public void buildFooterLinks(FooterType page, UndoManager commandManager);

    /**
     * 
     * Renders the page
     * 
     */
    public void render(PrintStream stream);

}
