package broadway.kyle;

import java.beans.PropertyChangeEvent;
import java.util.HashMap;
import java.util.Map;

public class EventActionHistory implements EventAction
{

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        // If the change was to the history
        if (evt.getPropertyName() == "quantities")
        {
            System.out.println("");
            System.out.println("Customer history changed:");
            @SuppressWarnings("unchecked")
            Map<String, Integer> map = (HashMap<String, Integer>) evt.getNewValue();
            for (Map.Entry<String, Integer> iterMap : map.entrySet())
            {
                System.out.println("Product [" + iterMap.getKey() + "] x " + iterMap.getValue());
            }
        }
        // If the change was to anything else, just print the change.
        else
        {
            System.out.println("");
            System.out.println("History change recorded for " + evt.getPropertyName() + ": " + evt.getNewValue());
        }

    }
}
