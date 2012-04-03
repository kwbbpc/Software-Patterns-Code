package broadway.kyle.visitorHtmlRendering;

import java.util.List;

import broadway.kyle.FactoryCollection;

public abstract class TagGeneric implements Visitee
{
    protected static final VisitorNullText NULL_TEXT = FactoryVisitorTags.createVisitorNullText();

    protected List<Visitee> visiteeSet = FactoryCollection.createArraylist();
    protected VisitorText text = NULL_TEXT;
    
    public abstract void accept(Visitor v);
}
