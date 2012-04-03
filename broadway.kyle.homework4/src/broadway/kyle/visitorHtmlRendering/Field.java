package broadway.kyle.visitorHtmlRendering;


public class Field extends TagNonComposite
{
    private String name;
    private String value;
    private String label;
    
    /**
     * Default constructor with no text
     */
    public Field()
    {
    }

    /**
     * @param text
     * The text to display in a field tag
     */
    Field(String name, String label, String value)
    {
        this.name = name;
        this.value = value;
        this.label = label;
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return value;
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
