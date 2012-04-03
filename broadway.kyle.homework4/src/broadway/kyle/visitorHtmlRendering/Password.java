package broadway.kyle.visitorHtmlRendering;

public class Password extends TagNonComposite
{


    private String name;
    private String label;

    /**
     * Default constructor with no text
     */
    public Password()
    {
    }

    /**
     * @param text
     * The text to display in a body tag
     */
    Password(String name, String label)
    {

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
