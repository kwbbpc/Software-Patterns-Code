package broadway.kyle;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import com.javadude.beans.Customer;
import com.javadude.beans.ProductHolder;

public class CustomerImpl implements Customer
{

    // members
    private String id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String password;

    // product holders
    private ProductHolder cart = FactoryHomework1.createProductHolder();
    private ProductHolder boughtItems = FactoryHomework1.createProductHolder();

    // property change support
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

    /**
     * @param id
     * @param name
     * @param street
     * @param city
     * @param state
     * @param zip
     * @param phone
     * @param password
     */
    CustomerImpl(String id, String name, String street, String city,
            String state, String zip, String phone, String password)
    {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.password = password;
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

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        String old = this.street;
        this.street = street;
        pcs.firePropertyChange("street", old, street);
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        String old = this.city;
        this.city = city;
        pcs.firePropertyChange("city", old, city);
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        String old = this.state;
        this.state = state;
        pcs.firePropertyChange("state", old, state);
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        String old = this.zip;
        this.zip = zip;
        pcs.firePropertyChange("zip", old, zip);
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        String old = this.phone;
        this.phone = phone;
        pcs.firePropertyChange("phone", old, phone);
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        String old = this.password;
        this.password = password;
        pcs.firePropertyChange("password", old, password);
    }

    public ProductHolder getCart()
    {
        return cart;
    }

    public void setCart(ProductHolder cart)
    {
        ProductHolder old = this.cart;
        this.cart = cart;
        pcs.firePropertyChange("cart", old, cart);
    }

    public ProductHolder getBoughtItems()
    {
        return boughtItems;
    }

    public void setBoughtItems(ProductHolder boughtItems)
    {
        ProductHolder old = this.boughtItems;
        this.boughtItems = boughtItems;
        pcs.firePropertyChange("boughtItems", old, boughtItems);
    }

}
