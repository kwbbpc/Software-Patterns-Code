package broadway.kyle.compositeHtmlRendering;

public class Paragraph extends TagComposite
{

    @Override
    protected void initTags()
    {
        startTag = "<p>";
        endTag = "</p>";
    }

    /**
     * Default constructor with no text
     */
    Paragraph()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a body tag
     */
    public Paragraph(String text)
    {
        initTags();

        //Create the text to write and add as a child to render
        add(FactoryCompositeTags.createText(text));

    }

}
