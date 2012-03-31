package broadway.kyle;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import com.javadude.beans.Product;

public class ProductImpl implements Product
{

    private int price;
    private String id;
    private String name;
    private String description;

    private PropertyChangeSupport pcs = FactoryPropertyChange.createPropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        pcs.removePropertyChangeListener(listener);
    }

    /**
     * @param id
     * @param name
     * @param price
     * @param description
     */
    public ProductImpl(String id, String name, int price, String description)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        int old = this.price;
        this.price = price;
        pcs.firePropertyChange("price", old, price);
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        String old = this.id;
        this.id = id;
        pcs.firePropertyChange("id", old, id);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        String old = this.name;
        this.name = name;
        pcs.firePropertyChange("name", old, name);
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        String old = this.description;
        this.description = description;
        pcs.firePropertyChange("description", old, description);
    }

}
