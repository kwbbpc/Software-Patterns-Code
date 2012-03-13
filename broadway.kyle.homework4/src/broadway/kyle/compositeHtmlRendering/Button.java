package broadway.kyle.compositeHtmlRendering;

import java.io.PrintStream;

public class Button extends TagNonComposite
{
    
    private String name;
    private String label;

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
        
        this.name = name;
        this.label = label;
    }
    
    @Override
    public void render(PrintStream stream)
    {
        stream.print(startTag);
        stream.print("<input type=submit name='" + name + "' value='" + label + "' />");
        stream.print(endTag);
    }

}
