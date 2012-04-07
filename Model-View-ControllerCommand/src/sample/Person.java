package sample;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person
{

    private String name;
    private String address;
    private String phone;
    private String fax;

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        pcs.removePropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
    {
        pcs.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener)
    {
        pcs.removePropertyChangeListener(propertyName, listener);
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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        String old = this.address;
        this.address = address;
        pcs.firePropertyChange("address", old, address);
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

    public String getFax()
    {
        return fax;
    }

    public void setFax(String fax)
    {
        String old = this.fax;
        this.fax = fax;
        pcs.firePropertyChange("fax", old, fax);
    }

}
