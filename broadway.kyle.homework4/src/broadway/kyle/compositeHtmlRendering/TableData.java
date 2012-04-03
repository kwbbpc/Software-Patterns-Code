package broadway.kyle.compositeHtmlRendering;


public class TableData extends TagComposite
{

    @Override
    protected void initTags()
    {
        startTag = "<td>";
        endTag = "</td>";
    }

    /**
     * Default constructor with no text
     */
    public TableData()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a table tag
     */
    TableData(String text)
    {
        initTags();

        //Create the text to write and add as a child to render
        add(FactoryCompositeTags.createText(text));

    }

}
