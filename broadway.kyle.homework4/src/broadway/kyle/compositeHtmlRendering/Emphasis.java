package broadway.kyle.compositeHtmlRendering;

public class Emphasis extends TagComposite
{

    @Override
    protected void initTags()
    {
        startTag = "<em>";
        endTag = "</em>";
    }

    /**
     * Default constructor with no text
     */
    public Emphasis()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a body tag
     */
    public Emphasis(String text)
    {
        initTags();

        //Create the text to write and add as a child to render
        add(new Text(text));

    }

}
