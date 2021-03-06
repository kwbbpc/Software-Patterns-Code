package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.HTML;

import com.javadude.command.UndoManager;

public class FooterStrategyHtmlShoppingCart extends FooterStrategy
{

    @Override
    public void build(HTML html, UndoManager undoManager)
    {
        html.add(FactoryCompositeTags.createParagraph("").add(FactoryCompositeTags.createAnchor("Edit Customer Details", createControllerActionLink("editCustomer", "cart"), null)));
        html.add(FactoryCompositeTags.createParagraph("").add(FactoryCompositeTags.createAnchor("View Catalog", createControllerActionLink("viewCatalog", "cart"), null)));
        html.add(FactoryCompositeTags.createParagraph("").add(FactoryCompositeTags.createAnchor("Checkout", createControllerActionLink("purchase", "cart"), null)));
        if (undoManager.getUndoName() != null)
            html.add(FactoryCompositeTags.createParagraph("").add(FactoryCompositeTags.createAnchor("Undo " + undoManager.getUndoName(), createControllerActionLink("undo", "cart"), null)));
        if (undoManager.getRedoName() != null)
            html.add(FactoryCompositeTags.createParagraph("").add(FactoryCompositeTags.createAnchor("Redo " + undoManager.getRedoName(), createControllerActionLink("redo", "cart"), null)));

    }

}
