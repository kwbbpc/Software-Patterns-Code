package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.HTML;

public class FooterStrategyHtmlShoppingCart extends FooterStrategy
{

    @Override
    public void build(HTML html)
    {
        html.add(FactoryCompositeTags.createAnchor("Edit Customer Details", createControllerActionLink("editCustomer", "cart"), null));
        html.add(FactoryCompositeTags.createAnchor("View Cart", createControllerActionLink("viewCart", "cart"), null));
        html.add(FactoryCompositeTags.createAnchor("Checkout", createControllerActionLink("purchase", "cart"), null));
        html.add(FactoryCompositeTags.createAnchor("Undo UNDO-NAME", createControllerActionLink("undo", "cart"), null));
        html.add(FactoryCompositeTags.createAnchor("Redo REDO-NAME", createControllerActionLink("redo", "cart"), null));

    }

}
