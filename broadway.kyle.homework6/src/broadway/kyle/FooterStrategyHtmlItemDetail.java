package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.HTML;

import com.javadude.command.UndoManager;

public class FooterStrategyHtmlItemDetail extends FooterStrategy
{

    @Override
    public void build(HTML html, UndoManager undoManager)
    {
        html.add(FactoryCompositeTags.createAnchor("Show Catalog", createControllerActionLink("viewCatalog", "itemDetail"), null));
        html.add(FactoryCompositeTags.createAnchor("Edit Customer Details", createControllerActionLink("editCustomer", "itemDetail"), null));
        html.add(FactoryCompositeTags.createAnchor("View Cart", createControllerActionLink("viewCart", "itemDetail"), null));
        html.add(FactoryCompositeTags.createAnchor("Checkout", createControllerActionLink("purchase", "itemDetail"), null));
        html.add(FactoryCompositeTags.createAnchor("Undo " + undoManager.getUndoName(), createControllerActionLink("undo", "itemDetail"), null));
        html.add(FactoryCompositeTags.createAnchor("Redo " + undoManager.getRedoName(), createControllerActionLink("redo", "itemDetail"), null));

    }

}
