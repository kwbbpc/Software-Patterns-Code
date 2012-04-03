package broadway.kyle.compositeHtmlRendering;

public class Form extends TagComposite
{

    @Override
    protected void initTags()
    {
        this.startTag = "<form>";
        this.endTag = "</form>";
    }

    public Form()
    {
        initTags();
    }

    /**
     * @param url
     * The action (url) to do on submission
     */
    Form(String url)
    {
        initTags();

        if (url != null)
            this.startTag = "<form action='" + url + "' >";

    }
    
    Form(String url, String method)
    {
        initTags();

        if (url != null)
            this.startTag = "<form action='" + url + "' method='" + method + "'>";

    }

}
