package broadway.kyle;

import java.util.Map;

public class PagesBean implements Pages
{

    Map<String, Page> pageNameMap;

    public Map<String, Page> getPageNameMap()
    {
        return pageNameMap;
    }

    public void setPageNameMap(Map<String, Page> pageNameMap)
    {
        this.pageNameMap = pageNameMap;
    }

}
