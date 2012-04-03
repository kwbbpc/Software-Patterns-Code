package broadway.kyle.compositeHtmlRendering;

public class TableRow extends TagComposite
{

    @Override
    protected void initTags()
    {
        startTag = "<tr>";
        endTag = "</tr>";
    }

    /**
     * Default constructor with no text
     */
    TableRow()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a table tag
     */
    public TableRow(String text)
    {
        initTags();

        //Create the text to write and add as a child to render
        add(FactoryCompositeTags.createText(text));
    }

}
