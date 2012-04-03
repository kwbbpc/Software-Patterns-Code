package broadway.kyle.compositeHtmlRendering;

public class Title extends TagComposite
{

    @Override
    protected void initTags()
    {
        startTag = "<title>";
        endTag = "</title>";
    }

    /**
     * Default constructor with no text
     */
    public Title()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a table tag
     */
    Title(String text)
    {
        initTags();

        //Create the text to write and add as a child to render
        add(FactoryCompositeTags.createText(text));

    }

}
