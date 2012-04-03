package broadway.kyle.visitorHtmlRendering;

public class Anchor extends TagComposite
{

    private String name;
    private String href;

    public Anchor()
    {
    }

    /**
     * @param text
     * the text inside the anchor
     * @param href
     * the href to link to.  set to null if using name instead
     * @param name
     * the name to link to.  set to null if using href instead
     */
    Anchor(String text, String href, String name)
    {

        this.href = href;
        this.name = name;

        //Create the text to write and add as a child to render
        add(FactoryVisitorTags.createVisitorText(text));


    }

    public String getName()
    {
        return name;
    }

    public String getHref()
    {
        return href;
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
