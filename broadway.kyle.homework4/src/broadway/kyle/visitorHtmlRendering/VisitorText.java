package broadway.kyle.visitorHtmlRendering;


public class VisitorText implements Visitee
{
    private String text = "";

    public VisitorText(String text)
    {
        if (text != null)
        {
            this.text = text;
        }
        else
        {
            this.text = "";
        }
    }

    @Override
    public void accept(Visitor v)
    {
        v.preVisit(this);
        v.postVisit(this);
    }

    public String getText()
    {
        return text;
    }

}
