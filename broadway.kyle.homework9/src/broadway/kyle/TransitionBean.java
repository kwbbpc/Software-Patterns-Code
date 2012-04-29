package broadway.kyle;

import java.util.Map;

public class TransitionBean implements Transition
{

    Map<String, Page> nextPageMap;

    @Override
    public Map<String, Page> getNextPageMap()
    {
        return nextPageMap;
    }

    @Override
    public void setNextPageMap(Map<String, Page> nextPageMap)
    {
        this.nextPageMap = nextPageMap;
    }

}
