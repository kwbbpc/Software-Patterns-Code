package broadway.kyle;

import java.beans.PropertyChangeEvent;

public class EventActionCatalog implements EventAction
{

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        System.out.println("Catalog changed: " + evt.getNewValue());
    }
}
