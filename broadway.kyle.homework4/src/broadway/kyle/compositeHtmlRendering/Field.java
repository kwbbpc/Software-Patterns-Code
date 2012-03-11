package broadway.kyle.compositeHtmlRendering;


public class Field extends TagNonComposite
{
    @Override
    protected void initTags()
    {
        this.startTag = "<p>";
        this.endTag = "</p>";
    }

    /**
     * Default constructor with no text
     */
    public Field()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a field tag
     */
    public Field(String name, String label, String value)
    {
        initTags();

        //Create the text to write and add as a child to render
        this.toRenderSet.add(new Text(label + ": <input type=text name='" + name + "' value='" + value + "' />"));

    }

}
