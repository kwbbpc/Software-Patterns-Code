package broadway.kyle.compositeHtmlRendering;


public abstract class TagGeneric implements Renderer
{
    protected static final CompositeNullText NULL_TEXT = FactoryCompositeTags.createNullText();


    protected CompositeText text = NULL_TEXT;
    protected String startTag = "<>";
    protected String endTag = "</>";



    /**
     * Each tag must specify its own tags.  This method serves as
     * a reminder to do so.
     */
    protected abstract void initTags();

}
