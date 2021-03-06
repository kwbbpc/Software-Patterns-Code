package broadway.kyle;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Map;

import com.javadude.beans.Catalog;
import com.javadude.beans.Product;
import com.javadude.beans.ProductHolder;

public class ProductHolderImpl implements ProductHolder
{

    // Quantity of products, keyed by productId
    private Map<String, Integer> quantities = FactoryCollection.createMap();

    // Catalog of products in the holder
    private static Catalog NULL_CATALOG = FactoryHomework1.createCatalogNull();
    private Catalog catalog = NULL_CATALOG;

    // Property Change Support
    private PropertyChangeSupport pcs = FactoryPropertyChange.createPropertyChangeSupport(this);

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        pcs.removePropertyChangeListener(listener);
    }

    @Override
    public void addQuantity(String productId, int quantity)
    {

        int oldTotalValue = getTotalValue();
        Map<String, Integer> oldMap = FactoryCollection.createMap(quantities);

        // Make sure the product to be added is in the catalog
        if (catalog.getProduct(productId) == null)
        {
            System.out.println("Could not add product quantity.  Product does not exist in catalog.");

            return;
        }

        // Do nothing if quantity is less than 0.
        if (quantity <= 0)
        {
            return;
        }

        Integer oldProductQuantity = quantities.get(productId);

        // the product already exists in the map. Add the quantity.
        if (oldProductQuantity != null)
        {
            quantity = oldProductQuantity + quantity;
        }
        // if it doesn't exist already, the old product quantity is 0.
        else
        {
            oldProductQuantity = 0;
        }

        // update the map
        quantities.put(productId, quantity);

        // fire the property change
        pcs.firePropertyChange("quantities", oldMap, quantities);
        pcs.firePropertyChange("totalValue", oldTotalValue, getTotalValue());

    }

    @Override
    public void removeQuantity(String productId, int quantityToRemove)
    {

        Map<String, Integer> oldMap = FactoryCollection.createMap(quantities);

        int oldTotalValue = getTotalValue();

        int newQuantity = 0;

        // Do nothing if quantity is less than 0.
        if (quantityToRemove < 0)
        {
            return;
        }

        //Get the old product quantity
        Integer oldProductQuantity = quantities.get(productId);

        //Check for the old product quantity
        if (oldProductQuantity == null)
        {
            oldProductQuantity = 0;
        }

        //remove the passed amount.
        newQuantity = oldProductQuantity - quantityToRemove;

        // If the product has been overdrawn
        if (newQuantity <= 0)
        {
            //set the new quantity to 0.
            newQuantity = 0;

            // remove the 0 quantity product from the map if present.
            quantities.remove(productId);
        }
        else
        {
            // update the map with the new quantity
            quantities.put(productId, newQuantity);
        }

        // fire the property change
        if (isEmpty())
        {
            pcs.firePropertyChange("empty", oldMap, quantities);
        }
        pcs.firePropertyChange("quantities", oldMap, quantities);
        pcs.firePropertyChange("totalValue", oldTotalValue, getTotalValue());

    }

    @Override
    public int getQuantity(String productId)
    {
        if (quantities.containsKey(productId))
        {
            return quantities.get(productId);
        }
        else
        {
            //if its not in the product map, there is 0 quantity.
            return 0;
        }

    }

    @Override
    public Map<String, Integer> getQuantities()
    {
        return quantities;
    }

    @Override
    public void clear()
    {

        int oldTotalValue = getTotalValue();

        Map<String, Integer> oldMap = FactoryCollection.createMap(quantities);
        if (oldMap.isEmpty())
        {
            oldMap = null;
        }

        quantities.clear();

        pcs.firePropertyChange("quantities", oldMap, quantities);
        pcs.firePropertyChange("empty", oldMap, quantities);
        pcs.firePropertyChange("totalValue", oldTotalValue, getTotalValue());

    }

    @Override
    public boolean isEmpty()
    {
        if (quantities == null)
        {
            //there is no product holder
            return true;
        }

        for (Map.Entry<String, Integer> iterProductMap : quantities.entrySet())
        {
            //if any of the products have a quantity
            if (iterProductMap.getValue() != 0)
            {
                //the product holder is not empty
                return false;
            }
        }

        //if the for loop finishes without returning, all quantities are 0.
        return true;

    }

    @Override
    public int getTotalValue()
    {
        int totalCost = 0;

        // Go through the product map and add up the total costs
        for (Map.Entry<String, Integer> iterProductMap : quantities.entrySet())
        {
            // get the product cost
            Product product = catalog.getProduct(iterProductMap.getKey());

            if (product != null)
            {
                // multiply by quantity and add to running total
                totalCost = totalCost + (product.getPrice() * iterProductMap.getValue());
            }
            else
            {
                System.out.println("Product Id [" + iterProductMap.getKey() + "] was not found in the catalog.  Excluding from total cost.");
            }

        }

        return totalCost;
    }

    @Override
    public Catalog getCatalog()
    {
        return catalog;
    }

    @Override
    public void setCatalog(Catalog catalog)
    {
        if (catalog == null)
        {
            catalog = NULL_CATALOG;
        }
        Catalog oldCatalog = this.catalog;
        this.catalog = catalog;
        pcs.firePropertyChange("catalog", oldCatalog, catalog);
    }

}
