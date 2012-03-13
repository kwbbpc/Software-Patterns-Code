package broadway.kyle.compositeHtmlRendering;

import java.io.PrintStream;

public class Password extends TagNonComposite
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
        
        this.name = name;
        this.label = label;

    }
    
    @Override
    public void render(PrintStream stream)
    {
        stream.print(startTag);
        stream.print(label + ": <input type='password' name='" + name + "' />");
        stream.print(endTag);
    }

}
