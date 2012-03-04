package examples.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person
{

    private String name;
    private String address;
    private String phone;
    private int age;

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        pcs.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName,
            PropertyChangeListener listener)
    {
        pcs.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        pcs.removePropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(String propertyName,
            PropertyChangeListener listener)
    {
        pcs.removePropertyChangeListener(propertyName, listener);
    }

    public String getName()
    {
        return name;
    }

    public void addName(String name)
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

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        int old = this.age;
        this.age = age;
        pcs.firePropertyChange("age", old, age);
    }

}
