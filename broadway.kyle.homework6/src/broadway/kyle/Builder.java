package broadway.kyle;

public interface Builder
{

    /**
     * @author KBroadway
     * 
     * The type of form to be built
     *
     */
    public enum FormType
    {
        Customer, Detail
    }

    /**
     * @author KBroadway
     *
     *The Type of table to be built
     *
     */
    public enum TableType
    {
        ProductDisplay
    }

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

    /**
     * @param header
     * 
     * Builds an emphasised piece of text (a section header)
     * 
     */
    public void buildHeader(String header);

    /**
     * Builds a form
     * 
     * @param formToBuild
     * The type of form to build
     */
    public void buildForm(FormType formToBuild);

    /**
     * Builds a table
     * 
     * @param tableToBuild
     * The type of table to build
     */
    public void buildTable(TableType tableToBuild);

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
    public void buildFooterLinks(FooterType page);

}
