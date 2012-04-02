package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.HTML;

public class FooterStrategyHtmlGeneric extends FooterStrategy
{

    @Override
    public void build(HTML html)
    {
        html.add(FactoryCompositeTags.createAnchor("Edit Customer Details", createControllerActionLink("editCustomer", "purchaseHistory"), null));
        html.add(FactoryCompositeTags.createAnchor("View Catalog", createControllerActionLink("viewCatalog", "purchaseHistory"), null));
        html.add(FactoryCompositeTags.createAnchor("Undo UNDO-NAME", createControllerActionLink("undo", "purchaseHistory"), null));
        html.add(FactoryCompositeTags.createAnchor("Redo REDO-NAME", createControllerActionLink("redo", "purchaseHistory"), null));

    }

}
