package broadway.kyle.compositeHtmlRendering;

import java.io.PrintStream;

public class Hidden extends TagNonComposite
{

    private String name;
    private String value;
    
    @Override
    protected void initTags()
    {
        startTag = "";
        endTag = "";
    }

    /**
     * Default constructor with no text
     */
    public Hidden()
    {
        initTags();
    }

    /**
     * @param text
     * The text to display in a body tag
     */
    Hidden(String name, String value)
    {
        initTags();
        
        this.name = name;
        this.value = value;

    }
    
    @Override
    public void render(PrintStream stream)
    {
        stream.print("<input type='hidden' name='" + name + "' value='" + value + "' />");
    }

}
