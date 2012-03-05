package broadway.kyle;

import java.util.Map;

/**
 * Implements a particular action to take with go()
 *
 */
public interface ActionStrategy
{

    /**
     * Execute the particular action to take
     * 
     * @param strategy
     */
    void go(Map<String, String[]> strategy);

}
