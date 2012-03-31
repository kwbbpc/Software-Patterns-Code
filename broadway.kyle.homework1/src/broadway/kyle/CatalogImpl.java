package broadway.kyle;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Map;

import com.javadude.beans.Catalog;
import com.javadude.beans.Product;

public class CatalogImpl implements Catalog
{

    PropertyChangeSupport pcs = FactoryPropertyChange.createPropertyChangeSupport(this);
    Map<String, Product> products = FactoryCollection.createMap();

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
        products.put(product.getId(), product);
        // fire the property change event
        pcs.firePropertyChange("products", null, products);
    }

    @Override
    public void removeProduct(String productId)
    {
        products.remove(productId);
        // fire the property change event
        pcs.firePropertyChange("products", null, products);
    }

    @Override
    public Product getProduct(String productId)
    {
        return products.get(productId);
    }

    @Override
    public Map<String, Product> getProducts()
    {
        return products;
    }

}
