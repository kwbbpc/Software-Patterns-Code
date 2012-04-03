package broadway.kyle.visitorHtmlRendering;

public class Button extends TagNonComposite
{
    
    private String name;
    private String label;
    

    /**
     * Default constructor with no text
     */
    public Button()
    {
    }

    /**
     * @param text
     * The text to display in a body tag
     */
    Button(String name, String label)
    {
        //Create the text to write and add as a child to render
        this.name = name;
        this.label = label;
    }
    
    public String getName()
    {
        return name;
    }

    public String getLabel()
    {
        return label;
    }
    
    @Override
    public void accept(Visitor v)
    {
        v.preVisit(this);
        for (Visitee visitee : visiteeSet)
        {
            visitee.accept(v);
        }
        v.postVisit(this);
    }

}
