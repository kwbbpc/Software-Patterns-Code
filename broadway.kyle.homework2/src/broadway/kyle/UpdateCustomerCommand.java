package broadway.kyle;

import com.javadude.beans.Customer;
import com.javadude.command.Command;

public class UpdateCustomerCommand implements Command
{

    private Customer customer;
    private Customer oldCustomerData;

    private String id;
    private String name;
    private String street;
    private String city;
    private String zip;
    private String phone;
    private String password;

    public UpdateCustomerCommand(Customer customer, String id, String name,
            String street, String city, String zip, String phone,
            String password)
    {
        this.oldCustomerData = FactoryHomework1.createCustomer(customer.getId(), customer.getName(), customer.getStreet(), customer.getCity(), "", customer.getZip(), customer.getPhone(), customer.getPassword());
        this.customer = customer;

        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.password = password;
    }

    @Override
    public void execute()
    {
        customer.setId(id);
        customer.setName(name);
        customer.setStreet(street);
        customer.setCity(city);
        customer.setZip(zip);
        customer.setPhone(phone);
        customer.setPassword(password);
    }

    @Override
    public void undo()
    {
        customer.setId(oldCustomerData.getId());
        customer.setName(oldCustomerData.getName());
        customer.setStreet(oldCustomerData.getStreet());
        customer.setCity(oldCustomerData.getCity());
        customer.setZip(oldCustomerData.getZip());
        customer.setPhone(oldCustomerData.getPhone());
        customer.setPassword(oldCustomerData.getPassword());
    }

    @Override
    public void redo()
    {
        //Purchase the cart
        execute();
    }

    @Override
    public String getName()
    {
        return "customer edit";
    }

}
