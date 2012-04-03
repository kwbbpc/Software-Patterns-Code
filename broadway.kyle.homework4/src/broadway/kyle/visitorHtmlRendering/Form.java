package broadway.kyle.visitorHtmlRendering;

public class Form extends TagComposite
{
    
    private String url;

    public Form()
    {
    }

    /**
     * @param url
     * The action (url) to do on submission
     */
    Form(String url)
    {
        this.url = url;

    }

    public String getUrl()
    {
        return url;
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
