package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.HTML;

import com.javadude.command.UndoManager;

public class FooterStrategyHtmlCustomerEdit extends FooterStrategy
{

    @Override
    public void build(HTML html, UndoManager undoManager)
    {
        html.add(FactoryCompositeTags.createParagraph("").add(FactoryCompositeTags.createAnchor("Cancel edit and show catalog", createControllerActionLink("viewCatalog", "customerEdit"), null)));
        html.add(FactoryCompositeTags.createParagraph("").add(FactoryCompositeTags.createAnchor("Cancel edit and view cart", createControllerActionLink("viewCart", "customerEdit"), null)));
        html.add(FactoryCompositeTags.createParagraph("").add(FactoryCompositeTags.createAnchor("Cancel edit and checkout", createControllerActionLink("purchase", "customerEdit"), null)));

        if (undoManager.getUndoName() != null)
            html.add(FactoryCompositeTags.createParagraph("").add(FactoryCompositeTags.createAnchor("Undo " + undoManager.getUndoName(), createControllerActionLink("undo", "customerEdit"), null)));
        if (undoManager.getRedoName() != null)
            html.add(FactoryCompositeTags.createParagraph("").add(FactoryCompositeTags.createAnchor("Redo " + undoManager.getRedoName(), createControllerActionLink("redo", "customerEdit"), null)));
    }

}
