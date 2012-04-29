package broadway.kyle;

import java.util.Map;

/**
 * @author KBroadway
 *
 * Holds a map of action-result and next Page pairs.
 * 
 * Translates the possible actions from a page into the next page
 * specific per page.
 *
 *
 */
public interface Transition
{

    /**
     * @author KBroadway
     * Maps an action-result with the next Page to go to
     */

    public Map<String, Page> getNextPageMap();

    public void setNextPageMap(Map<String, Page> nextPageMap);

}
