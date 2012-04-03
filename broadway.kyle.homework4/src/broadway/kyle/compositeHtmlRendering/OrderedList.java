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
    OrderedList()
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
        add(FactoryCompositeTags.createText(text));

    }

}
