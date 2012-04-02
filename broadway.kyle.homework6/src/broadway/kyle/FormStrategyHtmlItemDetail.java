package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.Form;
import broadway.kyle.compositeHtmlRendering.Renderer;

public class FormStrategyHtmlItemDetail implements FormStrategy
{
    @Override
    public Renderer build()
    {
        Form customerForm = FactoryCompositeTags.createForm("controller?action=addToCart&page=itemDetail", "post");
        customerForm.add(FactoryCompositeTags.createField("quantity", "Quantity", "1"));
        customerForm.add(FactoryCompositeTags.createButton("update", "Update"));
        customerForm.add(FactoryCompositeTags.createHidden("itemId", "0001"));
        return customerForm;
    }
}
