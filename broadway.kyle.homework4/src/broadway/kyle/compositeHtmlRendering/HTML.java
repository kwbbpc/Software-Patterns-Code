package broadway.kyle.compositeHtmlRendering;


public class HTML extends TagComposite
{

    @Override
    protected void initTags()
    {
        startTag = "<html>";
        endTag = "</html>";
    }

    /**
     * Default constructor with no text
     */
    public HTML()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a body tag
     */
    public HTML(String text)
    {
        initTags();

        //Create the text to write and add as a child to render
        add(new Text(text));

    }

}
