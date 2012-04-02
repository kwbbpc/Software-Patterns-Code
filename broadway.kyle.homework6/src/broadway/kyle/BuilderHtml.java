package broadway.kyle;

import java.util.HashMap;
import java.util.Map;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.HTML;

public class BuilderHtml implements Builder
{

    HTML html = FactoryCompositeTags.createHTML();

    Map<TableType, TableStrategy> tableStrategyMap;
    Map<FormType, FormStrategy> formStrategyMap;
    Map<FooterType, FooterStrategy> footerStrategyMap;

    public BuilderHtml()
    {

        //Set up the strategy maps
        tableStrategyMap = new HashMap<TableType, TableStrategy>();
        tableStrategyMap.put(TableType.ProductDisplay, new TableStrategyHtmlCatalog());

        formStrategyMap = new HashMap<FormType, FormStrategy>();
        formStrategyMap.put(FormType.Detail, new FormStrategyHtmlItemDetail());
        formStrategyMap.put(FormType.Customer, new FormStrategyHtmlCustomerEdit());

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
    public void buildForm(FormType formToBuild)
    {
        FormStrategy form = formStrategyMap.get(formToBuild);

        if (form != null)
            html.add(form.build());

    }

    @Override
    public void buildTable(TableType tableToBuild)
    {
        TableStrategy table = tableStrategyMap.get(tableToBuild);

        if (table != null)
            html.add(table.build());

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
    public void buildFooterLinks(FooterType page)
    {
        FooterStrategy footer = footerStrategyMap.get(page);

        if (footer != null)
            footer.build(html);

    }

}
