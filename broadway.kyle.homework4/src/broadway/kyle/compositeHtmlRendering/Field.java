package broadway.kyle.compositeHtmlRendering;

import java.io.PrintStream;


public class Field extends TagNonComposite
{
    
    private String name;
    private String label;
    private String value;
    
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
    Field(String name, String label, String value)
    {
        initTags();
        
        this.name = name;
        this.label = label;
        this.value = value;
    }
    
    @Override
    public void render(PrintStream stream)
    {
        stream.print(startTag);
        stream.print(label + ": <input type=text name='" + name + "' value='" + value + "' />");
        stream.print(endTag);
    }

}
