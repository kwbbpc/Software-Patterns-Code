package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.Form;
import broadway.kyle.compositeHtmlRendering.Renderer;

public class FormStrategyHtmlCustomerEdit implements FormStrategy
{
    @Override
    public Renderer build()
    {
        Form customerForm = FactoryCompositeTags.createForm("controller?action=updateCustomer&page=customerEdit", "post");
        customerForm.add(FactoryCompositeTags.createField("id", "Id", "old value"));
        customerForm.add(FactoryCompositeTags.createField("name", "Name", "old value"));
        customerForm.add(FactoryCompositeTags.createField("street", "Street", "old value"));
        customerForm.add(FactoryCompositeTags.createField("city", "City", "old value"));
        customerForm.add(FactoryCompositeTags.createField("zip", "Zip Code", "old value"));
        customerForm.add(FactoryCompositeTags.createField("phone", "Phone", "old value"));
        customerForm.add(FactoryCompositeTags.createPassword("password", "Password"));
        customerForm.add(FactoryCompositeTags.createButton("update", "Update"));
        return customerForm;
    }
}
