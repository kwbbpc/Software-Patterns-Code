package broadway.kyle.compositeHtmlRendering;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public abstract class TagGeneric implements Renderer
{
    protected static final NullText NULL_TEXT = new NullText();

    protected List<Renderer> toRenderSet = new ArrayList<Renderer>();
    protected Text text = NULL_TEXT;
    protected String startTag = "<>";
    protected String endTag = "</>";

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

    /**
     * Each tag must specify its own tags.  This method serves as
     * a reminder to do so.
     */
    protected abstract void initTags();

}