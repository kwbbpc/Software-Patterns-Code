package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.Form;
import broadway.kyle.compositeHtmlRendering.Renderer;

import com.javadude.beans.Customer;

public class FormStrategyHtmlCustomerEdit implements FormStrategy
{
    @Override
    public <T> Renderer build(T parameter)
    {

        Customer customer;

        try
        {
            customer = (Customer) parameter;
        }
        catch (java.lang.ClassCastException e)
        {
            assert (false);
            return null;
        }

        Form customerForm = FactoryCompositeTags.createForm("controller?action=updateCustomer&page=customerEdit", "post");
        customerForm.add(FactoryCompositeTags.createField("id", "Id", customer.getId()));
        customerForm.add(FactoryCompositeTags.createField("name", "Name", customer.getName()));
        customerForm.add(FactoryCompositeTags.createField("street", "Street", customer.getStreet()));
        customerForm.add(FactoryCompositeTags.createField("city", "City", customer.getCity()));
        customerForm.add(FactoryCompositeTags.createField("zip", "Zip Code", customer.getZip()));
        customerForm.add(FactoryCompositeTags.createField("phone", "Phone", customer.getPhone()));
        customerForm.add(FactoryCompositeTags.createPassword("password", "Password"));
        customerForm.add(FactoryCompositeTags.createButton("update", "Update"));
        return customerForm;
    }

}
