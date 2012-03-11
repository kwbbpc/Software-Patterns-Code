package broadway.kyle.compositeHtmlRendering;

public class OrderedList extends TagComposite
{

    @Override
    protected void initTags()
    {
        startTag = "<ol>";
        endTag = "</ol>";
    }

    /**
     * Default constructor with no text
     */
    public OrderedList()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a body tag
     */
    public OrderedList(String text)
    {
        initTags();

        //Create the text to write and add as a child to render
        add(new Text(text));

    }

}
