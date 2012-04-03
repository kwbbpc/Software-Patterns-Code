package broadway.kyle.compositeHtmlRendering;

public class Body extends TagComposite
{

    @Override
    protected void initTags()
    {
        startTag = "<body>";
        endTag = "</body>";
    }

    /**
     * Default constructor with no text
     */
    Body()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a body tag
     */
    public Body(String text)
    {
        initTags();

        //Create the text to write and add as a child to render
        add(FactoryCompositeTags.createText(text));

    }

}
