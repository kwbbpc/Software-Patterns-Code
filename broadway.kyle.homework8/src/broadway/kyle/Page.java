package broadway.kyle;

import java.util.List;

import broadway.kyle.Pages;

public interface Page
{

    public <T extends PageParameters> Object getPageRenderer(T params);

    Page updateCustomerOk();

    Page updateCustomerBad();

    Page editCustomerOk();

    Page editCustomerBad();

    Page addToCartOk();

    Page addToCartBad();

    Page removeFromCartOk();

    Page removeFromCartBad();

    Page viewCatalogOk();

    Page viewCatalogBad();

    Page viewCartOk();

    Page viewCartBad();

    Page purchaseOk();

    Page purchaseBad();

    Page viewItemOk();

    Page viewItemBad();
    
    Pages getType();
    
    
    //Maps an enumeration of an action + result to a particular Page method to call.
    public enum actionResult{
        updateCustomerOk    {public Page call(Page currentPage) {return currentPage.updateCustomerOk();}},
        updateCustomerBad   {public Page call(Page currentPage) {return currentPage.updateCustomerBad();}},
        editCustomerOk      {public Page call(Page currentPage) {return currentPage.editCustomerOk();}},
        editCustomerBad     {public Page call(Page currentPage) {return currentPage.editCustomerBad();}},
        addToCartOk         {public Page call(Page currentPage) {return currentPage.addToCartOk();}},
        addToCartBad        {public Page call(Page currentPage) {return currentPage.addToCartBad();}},
        removeFromCartOk    {public Page call(Page currentPage) {return currentPage.removeFromCartOk();}},
        removeFromCartBad   {public Page call(Page currentPage) {return currentPage.removeFromCartBad();}},
        viewCatalogOk       {public Page call(Page currentPage) {return currentPage.viewCatalogOk();}},
        viewCatalogBad      {public Page call(Page currentPage) {return currentPage.viewCatalogBad();}},
        viewCartOk          {public Page call(Page currentPage) {return currentPage.viewCartOk();}},
        viewCartBad         {public Page call(Page currentPage) {return currentPage.viewCartBad();}},
        purchaseOk          {public Page call(Page currentPage) {return currentPage.purchaseOk();}},
        purchaseBad         {public Page call(Page currentPage) {return currentPage.purchaseBad();}},
        viewItemOk          {public Page call(Page currentPage) {return currentPage.viewItemOk();}},
        viewItemBad         {public Page call(Page currentPage) {return currentPage.viewItemBad();}};
        
        public abstract Page call(Page currentPage);
        
    }
}

