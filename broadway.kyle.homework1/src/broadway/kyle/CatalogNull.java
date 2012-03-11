package broadway.kyle;

import java.beans.PropertyChangeListener;
import java.util.Map;

import com.javadude.beans.Catalog;
import com.javadude.beans.Product;

public class CatalogNull implements Catalog
{

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        System.out.println("No catalog defined!");
        assert (false);

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        System.out.println("No catalog defined!");
        assert (false);

    }

    @Override
    public void addProduct(Product product)
    {
        System.out.println("No catalog defined!");
        assert (false);

    }

    @Override
    public void removeProduct(String productId)
    {
        System.out.println("No catalog defined!");
        assert (false);

    }

    @Override
    public Product getProduct(String productId)
    {
        System.out.println("No catalog defined!");
        assert (false);
        return null;
    }

    @Override
    public Map<String, Product> getProducts()
    {
        System.out.println("No catalog defined!");
        assert (false);
        return null;
    }

}
