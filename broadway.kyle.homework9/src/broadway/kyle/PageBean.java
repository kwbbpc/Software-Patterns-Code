package broadway.kyle;

public class PageBean implements Page
{

    String pageName;
    Transition transition;

    @Override
    public Transition getTransition()
    {
        return transition;
    }

    @Override
    public void setTransition(Transition transition)
    {
        this.transition = transition;
    }

    @Override
    public String getPageName()
    {
        return pageName;
    }

    @Override
    public void setPageName(String pageName)
    {
        this.pageName = pageName;
    }

}
