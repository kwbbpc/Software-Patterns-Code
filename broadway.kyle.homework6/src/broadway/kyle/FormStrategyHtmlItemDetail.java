package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.Form;
import broadway.kyle.compositeHtmlRendering.Renderer;

import com.javadude.beans.Product;

public class FormStrategyHtmlItemDetail implements FormStrategy
{
    @Override
    public <T> Renderer build(T parameter)
    {

        Product product;

        try
        {
            product = (Product) parameter;
        }
        catch (java.lang.ClassCastException e)
        {
            assert (false);
            return null;
        }

        Form customerForm = FactoryCompositeTags.createForm("controller?action=addToCart&page=itemDetail", "post");
        customerForm.add(FactoryCompositeTags.createField("quantity", "Quantity", "1"));
        customerForm.add(FactoryCompositeTags.createButton("addToCart", "Add to Cart"));
        customerForm.add(FactoryCompositeTags.createHidden("id", product.getId()));
        return customerForm;
    }
}
