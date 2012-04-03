package broadway.kyle;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FactoryPropertyChange
{

    public static PropertyChangeSupport createPropertyChangeSupport(Object sourceBean)
    {
        return new PropertyChangeSupport(sourceBean);
    }

    public static PropertyChangeListener createPropertyChangeListener(final EventAction onEvent)
    {

        PropertyChangeListener listener = new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                onEvent.propertyChange(evt);
            }
        };

        return listener;

    }
}
