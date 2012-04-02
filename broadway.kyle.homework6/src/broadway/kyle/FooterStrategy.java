package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.HTML;

public abstract class FooterStrategy
{

    public abstract void build(HTML html);

    public String createControllerActionLink(String action, String page)
    {
        return "controller?action=" + action + "&page=" + page;
    }

}
