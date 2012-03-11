package broadway.kyle.compositeHtmlRendering;

public class Head extends TagComposite
{

    @Override
    protected void initTags()
    {
        startTag = "<Head>";
        endTag = "</Head>";
    }

    /**
     * Default constructor with no text
     */
    public Head()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a body tag
     */
    public Head(String text)
    {
        initTags();

        //Create the text to write and add as a child to render
        add(new Text(text));

    }

}