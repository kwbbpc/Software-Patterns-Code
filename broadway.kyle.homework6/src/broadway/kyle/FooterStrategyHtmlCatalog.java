package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.HTML;

public class FooterStrategyHtmlCatalog extends FooterStrategy
{

    @Override
    public void build(HTML html)
    {
        html.add(FactoryCompositeTags.createAnchor("Edit Customer Details", createControllerActionLink("editCustomer", "catalog"), null));
        html.add(FactoryCompositeTags.createAnchor("View Cart", createControllerActionLink("viewCart", "catalog"), null));
        html.add(FactoryCompositeTags.createAnchor("Checkout", createControllerActionLink("purchase", "catalog"), null));
        html.add(FactoryCompositeTags.createAnchor("Undo UNDO-NAME", createControllerActionLink("undo", "catalog"), null));
        html.add(FactoryCompositeTags.createAnchor("Redo REDO-NAME", createControllerActionLink("redo", "catalog"), null));

    }
}
