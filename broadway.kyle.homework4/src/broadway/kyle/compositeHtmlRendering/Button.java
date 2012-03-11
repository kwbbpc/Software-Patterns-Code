package broadway.kyle.compositeHtmlRendering;

public class Button extends TagNonComposite
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
    public Button()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a body tag
     */
    public Button(String name, String label)
    {
        initTags();

        //Create the text to write and add as a child to render
        this.toRenderSet.add(new Text("<input type=submit name='" + name + "' value='" + label + "' />"));

    }

}