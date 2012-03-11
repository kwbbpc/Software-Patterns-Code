package broadway.kyle.compositeHtmlRendering;

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
        this.text = new Text(text);
        this.toRenderSet.add(this.text);
        return this;
    }

    public TagComposite add(Renderer toRender)
    {
        this.toRenderSet.add(toRender);
        return this;
    }
}
