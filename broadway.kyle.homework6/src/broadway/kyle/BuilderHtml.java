package broadway.kyle;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.HTML;

import com.javadude.beans.Customer;
import com.javadude.beans.Product;
import com.javadude.beans.ProductHolder;
import com.javadude.command.UndoManager;

public class BuilderHtml implements Builder
{

    HTML html;

    Map<FooterType, FooterStrategy> footerStrategyMap = new HashMap<FooterType, FooterStrategy>();

    public BuilderHtml()
    {

        html = FactoryCompositeTags.createHTML();

        footerStrategyMap.put(FooterType.Catalog, new FooterStrategyHtmlCatalog());
        footerStrategyMap.put(FooterType.CustomerEdit, new FooterStrategyHtmlCustomerEdit());
        footerStrategyMap.put(FooterType.ItemDetail, new FooterStrategyHtmlItemDetail());
        footerStrategyMap.put(FooterType.PurchaseConfirmation, new FooterStrategyHtmlGeneric());
        footerStrategyMap.put(FooterType.PurchaseHistory, new FooterStrategyHtmlGeneric());
        footerStrategyMap.put(FooterType.ShoppingCart, new FooterStrategyHtmlShoppingCart());

    }

    @Override
    public void buildHeader(String header)
    {
        html.add(FactoryCompositeTags.createHeader(header));
    }

    @Override
    public void buildForm(Customer customer)
    {
        FormStrategy form = new FormStrategyHtmlCustomerEdit();
        html.add(form.build(customer));

    }

    @Override
    public void buildForm(Product product)
    {
        FormStrategy form = new FormStrategyHtmlItemDetail();
        html.add(form.build(product));

    }

    @Override
    public void buildTable(ProductHolder productHolder)
    {
        TableStrategy table = new TableStrategyHtmlCatalog();
        html.add(table.build(productHolder));

    }

    @Override
    public void buildParagraph(String text)
    {
        html.add(FactoryCompositeTags.createParagraph(text));

    }

    @Override
    public void buildPageTitle(String title)
    {

        html.add(FactoryCompositeTags.createTitle(title));

    }

    @Override
    public void buildFooterLinks(FooterType page, UndoManager commandManager)
    {
        FooterStrategy footer = footerStrategyMap.get(page);
        footer.build(html, commandManager);

    }

    @Override
    public void render(PrintStream stream)
    {
        html.render(stream);
    }

}
