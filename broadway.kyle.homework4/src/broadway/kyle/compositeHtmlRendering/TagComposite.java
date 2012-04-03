package broadway.kyle.compositeHtmlRendering;

import java.io.PrintStream;
import java.util.List;

import broadway.kyle.FactoryCollection;

/**
 * @author KBroadway
 * This type of tag allows a 
 * public add to the children to render.
 *
 *
 */
public abstract class TagComposite extends TagGeneric
{
    
    protected List<Renderer> toRenderSet = FactoryCollection.createArraylist();
    
    @Override
    public void render(PrintStream stream)
    {
        //Print the start tag
        stream.print(startTag);
        //Render all children
        for (Renderer renderer : toRenderSet)
        {
            renderer.render(stream);
        }
        //Print the end tag
        stream.print(endTag);
    }
    
    public TagComposite add(String text)
    {
        this.text = FactoryCompositeTags.createText(text);
        this.toRenderSet.add(this.text);
        return this;
    }

    public TagComposite add(Renderer toRender)
    {
        this.toRenderSet.add(toRender);
        return this;
    }
}
