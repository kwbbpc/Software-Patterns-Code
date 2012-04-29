package broadway.kyle;

import java.util.Map;

/**
 * @author KBroadway
 *
 *
 * Holds a map of page-name to page.
 * 
 * 
 */
public interface Pages
{

    public Map<String, Page> getPageNameMap();

    public void setPageNameMap(Map<String, Page> pageNameMap);

}
