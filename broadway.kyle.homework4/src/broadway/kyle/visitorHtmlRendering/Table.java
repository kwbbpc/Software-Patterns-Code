package broadway.kyle.visitorHtmlRendering;


public class Table extends TagComposite
{


    /**
     * Default constructor with no text
     */
    Table()
    {
    }

    /**
     * @param text
     * The text to display in a table tag
     */
    public Table(String text)
    {

        //Create the text to write and add as a child to render
        add(FactoryVisitorTags.createVisitorText(text));

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
