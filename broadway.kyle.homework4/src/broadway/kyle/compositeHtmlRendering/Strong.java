package broadway.kyle.compositeHtmlRendering;


public class Strong extends TagComposite
{

    @Override
    protected void initTags()
    {
        startTag = "<strong>";
        endTag = "</strong>";
    }

    /**
     * Default constructor with no text
     */
    public Strong()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a body tag
     */
    Strong(String text)
    {
        initTags();

        //Create the text to write and add as a child to render
        add(FactoryCompositeTags.createText(text));

    }

}
