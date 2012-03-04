package broadway.kyle;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.table.AbstractTableModel;

import com.javadude.beans.ProductHolder;

/**
 * The start of a Swing table model for the UI. Copy this class into your
 * project and make changes. I would recommend deleting it from the starter
 * project after you've copied it so you're sure which one is being used.
 * 
 * This class maps a ProductHolder to Swing's TableModel. You'll need to write
 * code to convert the requests that Swing makes into requests against a
 * ProductHolder.
 * 
 * Shhhh... this class is actually an example of the Adapter pattern...
 * 
 * Note: The columns you should display are 
 * Id - the id of a product being held
 * Name - the name of a product being held Description - the description of a product being held 
 * Price - the price of a product being held 
 * Quantity - the number of instances of that product that is being held
 */
public class ProductTableModel extends AbstractTableModel
{
    private static final long serialVersionUID = 1L;
    private ProductHolder productHolder;

    private enum Column
    {
        Id, Name, Price, Quantity
    }

    //The model listener
    private PropertyChangeListener modelListener = new PropertyChangeListener()
    {
        @Override
        public void propertyChange(PropertyChangeEvent evt)
        {
            fireTableDataChanged();
        }
    };

    public ProductTableModel(ProductHolder productHolder)
    {
        if (this.productHolder != null)
        {
            //de-register if we already have a productHolder
            this.productHolder.removePropertyChangeListener(modelListener);
        }

        this.productHolder = productHolder;
        // TODO listen to the product holder for changes
        // when it changes, call fireTableDataChanged()
        this.productHolder.addPropertyChangeListener(modelListener);

    }

    @Override
    public String getColumnName(int columnIndex)
    {
        // TODO report the name of the specified column
        // the column names can be hardcoded in this method
        Column col = Column.values()[columnIndex];

        switch (col)
        {
            case Id:
                return "Id";
            case Name:
                return "Name";
            case Price:
                return "Price";
            case Quantity:
                return "Quantity";
            default:
                return "";

        }
    }

    @Override
    public int getColumnCount()
    {
        // TODO report the number of columns (you can hardcode this)
        return 4;
    }

    @Override
    public int getRowCount()
    {
        // TODO report the number of rows to display
        // this should be derived by looking at the productHolder
        int size = 0;
        if (productHolder != null)
        {
            size = productHolder.getQuantities().size();
        }
        return size;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        // lookup which row to display (the rows should be sorted by product id)
        // report the value for the specified column for that row

        //get the map of products and sort the product IDs
        ArrayList<String> productIdList = new ArrayList<String>(productHolder.getQuantities().keySet());
        Collections.sort(productIdList);

        //get the corresponding ID from the sorted list
        String productId = productIdList.get(rowIndex);

        //get the column type we're interested in
        Column col = Column.values()[columnIndex];

        if (productId != null && !productId.isEmpty())
        {
            switch (col)
            {
                case Id:
                    return productId;
                case Name:
                    return productHolder.getCatalog().getProduct(productId).getName();
                case Price:
                    return productHolder.getCatalog().getProduct(productId).getPrice();
                case Quantity:
                    return productHolder.getQuantities().get(productId);
                default:
                    return null;
            }

        }

        return null;
    }
}
