package broadway.kyle.compositeHtmlRendering;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author KBroadway
 * This type of tag allows a 
 * public add to the children to render.
 *
 *
 */
public abstract class TagComposite extends TagGeneric
{
    
    protected List<Renderer> toRenderSet = new ArrayList<Renderer>();
    
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
