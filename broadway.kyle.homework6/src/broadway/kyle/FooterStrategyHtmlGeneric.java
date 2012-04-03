package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.HTML;

import com.javadude.command.UndoManager;

public class FooterStrategyHtmlGeneric extends FooterStrategy
{

    @Override
    public void build(HTML html, UndoManager undoManager)
    {
        html.add(FactoryCompositeTags.createParagraph("").add(FactoryCompositeTags.createAnchor("Edit Customer Details", createControllerActionLink("editCustomer", "purchaseHistory"), null)));
        html.add(FactoryCompositeTags.createParagraph("").add(FactoryCompositeTags.createAnchor("View Catalog", createControllerActionLink("viewCatalog", "purchaseHistory"), null)));

        if (undoManager.getUndoName() != null)
            html.add(FactoryCompositeTags.createParagraph("").add(FactoryCompositeTags.createAnchor("Undo " + undoManager.getUndoName(), createControllerActionLink("undo", "purchaseHistory"), null)));
        if (undoManager.getRedoName() != null)
            html.add(FactoryCompositeTags.createParagraph("").add(FactoryCompositeTags.createAnchor("Redo " + undoManager.getRedoName(), createControllerActionLink("redo", "purchaseHistory"), null)));

    }

}
