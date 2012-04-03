package broadway.kyle.visitorHtmlRendering;





public class VisitorNullText extends VisitorText
{

    public VisitorNullText()
    {
        super("");
    }

    @Override
    public void accept(Visitor v)
    {
        //Attempt to print out null text
        assert (false);
        VisitorText text = FactoryVisitorTags.createVisitorText("");
        v.preVisit(text);
        v.postVisit(text);
    }

}
