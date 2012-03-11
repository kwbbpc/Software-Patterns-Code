package broadway.kyle.compositeHtmlRendering;


public class Header extends TagComposite
{

    @Override
    protected void initTags()
    {
        startTag = "<h1>";
        endTag = "</h1>";
    }

    /**
     * Default constructor with no text
     */
    public Header()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a body tag
     */
    public Header(String text)
    {
        initTags();

        //Create the text to write and add as a child to render
        add(new Text(text));

    }

}