package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.HTML;

public class FooterStrategyHtmlCustomerEdit extends FooterStrategy
{

    @Override
    public void build(HTML html)
    {
        html.add(FactoryCompositeTags.createAnchor("Cancel edit and show catalog", createControllerActionLink("viewCatalog", "customerEdit"), null));
        html.add(FactoryCompositeTags.createAnchor("Cancel edit and view cart", createControllerActionLink("viewCart", "customerEdit"), null));
        html.add(FactoryCompositeTags.createAnchor("Cancel edit and checkout", createControllerActionLink("purchase", "customerEdit"), null));
        html.add(FactoryCompositeTags.createAnchor("Undo UNDO-NAME", createControllerActionLink("undo", "customerEdit"), null));
        html.add(FactoryCompositeTags.createAnchor("Redo REDO-NAME", createControllerActionLink("redo", "customerEdit"), null));
    }

}
