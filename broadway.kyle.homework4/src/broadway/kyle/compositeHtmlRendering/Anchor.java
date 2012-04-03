package broadway.kyle.compositeHtmlRendering;

public class Anchor extends TagComposite
{

    @Override
    protected void initTags()
    {
        this.startTag = "<a>";
        this.endTag = "</a>";
    }

    public Anchor()
    {
        initTags();
    }

    /**
     * @param text
     * the text inside the anchor
     * @param href
     * the href to link to.  set to null if using name instead
     * @param name
     * the name to link to.  set to null if using href instead
     */
    Anchor(String text, String href, String name)
    {
        initTags();

        if (href != null && name != null)
        {
            //attempt to use both href and name at the same time
            assert (false);
        }

        //Create the text to write and add as a child to render
        add(FactoryCompositeTags.createText(text));

        if (href != null)
            this.startTag = "<a href=" + href + ">";
        else if (name != null)
            this.startTag = "<a name=" + name + ">";

    }

}
