package broadway.kyle.compositeHtmlRendering;

public class Password extends TagNonComposite
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
    public Password()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a body tag
     */
    public Password(String name, String label)
    {
        initTags();

        //Create the text to write and add as a child to render
        this.toRenderSet.add(new Text(label + ": <input type='password' name='" + name + "' />"));

    }

}
