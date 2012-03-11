package broadway.kyle;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

import com.javadude.beans.Catalog;
import com.javadude.beans.Product;

public class CatalogImpl implements Catalog
{

    PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    Map<String, Product> catalog = new HashMap<String, Product>();

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
    public void addProduct(Product product)
    {
        Map<String, Product> oldCatalog = new HashMap<String, Product>(catalog);
        catalog.put(product.getId(), product);
        // fire the property change event
        pcs.firePropertyChange("products", null, catalog);
    }

    @Override
    public void removeProduct(String productId)
    {
        Map<String, Product> oldCatalog = new HashMap<String, Product>(catalog);
        catalog.remove(productId);
        // fire the property change event
        pcs.firePropertyChange("products", null, catalog);
    }

    @Override
    public Product getProduct(String productId)
    {
        return catalog.get(productId);
    }

    @Override
    public Map<String, Product> getProducts()
    {
        return catalog;
    }

}
