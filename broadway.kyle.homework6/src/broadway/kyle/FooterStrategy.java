package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.HTML;

import com.javadude.command.UndoManager;

public abstract class FooterStrategy
{

    public abstract void build(HTML html, UndoManager undoManager);

    public String createControllerActionLink(String action, String page)
    {
        return "controller?action=" + action + "&page=" + page;
    }

}
