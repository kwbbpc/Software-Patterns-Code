package broadway.kyle.compositeHtmlRendering;


public class TableHeader extends TagComposite
{

    @Override
    protected void initTags()
    {
        startTag = "<th>";
        endTag = "</th>";
    }

    /**
     * Default constructor with no text
     */
    public TableHeader()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a table tag
     */
    public TableHeader(String text)
    {
        initTags();

        //Create the text to write and add as a child to render
        add(new Text(text));

    }

}
