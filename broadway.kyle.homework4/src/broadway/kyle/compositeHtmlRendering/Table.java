package broadway.kyle.compositeHtmlRendering;


public class Table extends TagComposite
{

    @Override
    protected void initTags()
    {
        startTag = "<table>";
        endTag = "</table>";
    }

    /**
     * Default constructor with no text
     */
    Table()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a table tag
     */
    public Table(String text)
    {
        initTags();

        //Create the text to write and add as a child to render
        add(FactoryCompositeTags.createText(text));

    }

}
