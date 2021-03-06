package broadway.kyle.compositeHtmlRendering;


public class ListItem extends TagComposite
{

    @Override
    protected void initTags()
    {
        startTag = "<li>";
        endTag = "</li>";
    }

    /**
     * Default constructor with no text
     */
    public ListItem()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a body tag
     */
    ListItem(String text)
    {
        initTags();

        //Create the text to write and add as a child to render
        add(FactoryCompositeTags.createText(text));

    }

}
