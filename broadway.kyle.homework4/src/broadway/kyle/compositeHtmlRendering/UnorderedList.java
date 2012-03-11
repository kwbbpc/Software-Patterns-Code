package broadway.kyle.compositeHtmlRendering;


public class UnorderedList extends TagComposite
{

    @Override
    protected void initTags()
    {
        startTag = "<ul>";
        endTag = "</ul>";
    }

    /**
     * Default constructor with no text
     */
    public UnorderedList()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a table tag
     */
    public UnorderedList(String text)
    {
        initTags();

        //Create the text to write and add as a child to render
        add(new Text(text));

    }

}
