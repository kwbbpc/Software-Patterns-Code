package broadway.kyle.visitorHtmlRendering;


/**
 * @author KBroadway
 * This type of tag allows a 
 * public add to the children to render.
 *
 *
 */
public abstract class TagComposite extends TagGeneric
{
    public TagComposite add(String text)
    {
        this.text = FactoryVisitorTags.createVisitorText(text);
        this.visiteeSet.add(this.text);
        return this;
    }

    public TagComposite add(Visitee visitee)
    {
        this.visiteeSet.add(visitee);
        return this;
    }
}
