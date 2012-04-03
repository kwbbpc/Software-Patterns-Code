package broadway.kyle.visitorHtmlRendering;


public class ListItem extends TagComposite
{


    /**
     * Default constructor with no text
     */
    public ListItem()
    {
    }

    /**
     * @param text
     * The text to display in a body tag
     */
    ListItem(String text)
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
