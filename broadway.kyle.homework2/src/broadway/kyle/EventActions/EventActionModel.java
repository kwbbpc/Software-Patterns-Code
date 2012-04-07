package broadway.kyle.EventActions;

import java.beans.PropertyChangeEvent;

import broadway.kyle.EventAction;
import broadway.kyle.ProductTableModel;

public class EventActionModel implements EventAction
{

    ProductTableModel table;

    public EventActionModel(ProductTableModel table)
    {
        this.table = table;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        if (table != null)
            table.fireTableDataChanged();
    }

}
