package broadway.kyle;

import java.util.List;

import broadway.kyle.PageParameters.CatalogPage;
import broadway.kyle.compositeHtmlRendering.Renderer;

    
    

    public enum Pages implements Page
    {
        
        
        //Current State             //Event                         //Next State             //Action
        //------------------        --------------                  -------------            ---------------
        CustomerEdit{
                        public Page updateCustomerOk()      {return Catalog;                    }
                        public Page viewCatalogOk()         {return Catalog;                    }
                        public Page viewCartOk()            {return Cart;                       }
                        public Page purchaseOk()            {return Confirmation;               }
                        public Page purchaseBad()           {return Catalog;                    }

                        //indirect events (through command manager)
                        public Page addToCartOk()           {return Cart;                       }
                        public Page addToCartBad()          {return Catalog;                    }
                        public Page removeFromCartOk()      {return Cart;                       }
                        public Page removeFromCartBad()     {return Catalog;                    }
                        
                        
                        //how to build the page
                        public <T extends PageParameters> Object getPageRenderer(T paramT)
                        {
                            PageParameters.CustomerEdit params = (PageParameters.CustomerEdit) paramT;
                            return new DirectorCustomerEdit(params.builder, params.customer, params.commandManager);
                        }


        },
        
        //Current State             //Event                         //Next State             //Action
        //------------------        --------------                  -------------            ---------------
        Catalog{
                        public Page editCustomerOk()        {return CustomerEdit;               }
                        public Page viewCartOk()            {return Cart;                       }
                        public Page purchaseOk()            {return Confirmation;               }
                        public Page purchaseBad()           {return Catalog;                    }
                        public Page viewItemOk()            {return ItemDetail;                 }
                        
                        //indirect events (through command manager)
                        public Page addToCartOk()           {return Cart;                       }
                        public Page addToCartBad()          {return Catalog;                    }
                        public Page removeFromCartOk()      {return Cart;                       }
                        public Page removeFromCartBad()     {return Catalog;                    }
                        public Page updateCustomerOk()      {return CustomerEdit;               }
                        public Page updateCustomerBad()     {return CustomerEdit;               }
                        
                        
                        //how to build the page
                        public <T extends PageParameters> Object getPageRenderer(T paramT)
                        {
                            PageParameters.CatalogPage params = (PageParameters.CatalogPage) paramT;
                            return new DirectorCatalog(params.builder, params.inventory, params.catalog, params.commandManager);
                        }
            
        },
        
        //Current State             //Event                         //Next State             //Action
        //------------------        --------------                  -------------            ---------------
        ItemDetail{
                        public Page viewCatalogOk()         {return Catalog;                    }
                        public Page editCustomerOk()        {return CustomerEdit;               }
                        public Page viewCartOk()            {return Cart;                       }
                        public Page purchaseOk()            {return Confirmation;               }
                        public Page addToCartOk()           {return Cart;                       }
                        public Page addToCartBad()          {return Catalog;                    }
                        public Page purchaseBad()           {return Catalog;                    }
                        
                        //indirect events (through command manager)
                        public Page removeFromCartOk()      {return Cart;                       }
                        public Page removeFromCartBad()     {return Catalog;                    }
                        public Page updateCustomerOk()      {return CustomerEdit;               }
                        public Page updateCustomerBad()     {return CustomerEdit;               }
                        
                        
                        //how to build the page
                        public <T extends PageParameters> Object getPageRenderer(T paramT)
                        {
                            PageParameters.ItemDetail params = (PageParameters.ItemDetail) paramT;
                            return new DirectorItemDetail(params.builder, params.product, params.commandManager);
                        }
        },
        
        //Current State             //Event                         //Next State             //Action
        //------------------        --------------                  -------------            ---------------
        Confirmation{
                        public Page viewCatalogOk()         {return Catalog;                    }
                        public Page editCustomerOk()        {return CustomerEdit;               }
                        
                        //indirect events (through command manager)
                        public Page addToCartOk()           {return Cart;                       }
                        public Page addToCartBad()          {return Catalog;                    }
                        public Page removeFromCartOk()      {return Cart;                       }
                        public Page removeFromCartBad()     {return Catalog;                    }
                        public Page updateCustomerOk()      {return CustomerEdit;               }
                        public Page updateCustomerBad()     {return CustomerEdit;               }
                        
                        
                        //how to build the page
                        public <T extends PageParameters> Object getPageRenderer(T paramT)
                        {
                            PageParameters.Confirmation params = (PageParameters.Confirmation) paramT;
                            return new DirectorPurchaseConfirmation(params.builder, params.commandManager);
                        }
        },
        
        //Current State             //Event                         //Next State             //Action
        //------------------        --------------                  -------------            ---------------
        PurchaseHistory{
                        public Page viewCatalogOk()         {return Catalog;                    }
                        public Page editCustomerOk()        {return CustomerEdit;               }
                        
                        //indirect events (through command manager)
                        public Page addToCartOk()           {return Cart;                       }
                        public Page addToCartBad()          {return Catalog;                    }
                        public Page removeFromCartOk()      {return Cart;                       }
                        public Page removeFromCartBad()     {return Catalog;                    }
                        public Page updateCustomerOk()      {return CustomerEdit;               }
                        public Page updateCustomerBad()     {return CustomerEdit;               }
                        
                        
                        //how to build the page
                        public <T extends PageParameters> Object getPageRenderer(T paramT)
                        {
                            PageParameters.PurchaseHistory params = (PageParameters.PurchaseHistory) paramT;
                            return new DirectorPurchaseHistory(params.builder, params.commandManager, params.catalog, params.purchasedItems);
                        }
            
        },
        
        //Current State             //Event                         //Next State             //Action
        //------------------        --------------                  -------------            ---------------
        Cart{
                        public Page viewCatalogOk()         {return Catalog;                    }
                        public Page editCustomerOk()        {return CustomerEdit;               }
                        public Page purchaseOk()            {return Confirmation;               }
                        public Page purchaseBad()           {return Catalog;                    }
                        
                        //indirect events (through command manager)
                        public Page addToCartOk()           {return Cart;                       }
                        public Page addToCartBad()          {return Catalog;                    }
                        public Page removeFromCartOk()      {return Cart;                       }
                        public Page removeFromCartBad()     {return Catalog;                    }
                        public Page updateCustomerOk()      {return CustomerEdit;               }
                        public Page updateCustomerBad()     {return CustomerEdit;               }
            
                        
                        //how to build the page
                        public <T extends PageParameters> Object getPageRenderer(T paramT)
                        {
                            PageParameters.Cart params = (PageParameters.Cart) paramT;
                            return new DirectorShoppingCart(params.builder, params.cart, params.catalog, params.commandManager);
                        }

        };

        
        // default event handling

        @Override
        public Page updateCustomerOk()
        {
            return this;
        }

        @Override
        public Page updateCustomerBad()
        {
            return this;
        }

        @Override
        public Page editCustomerOk()
        {
            return this;
        }

        @Override
        public Page editCustomerBad()
        {
            return this;
        }

        @Override
        public Page addToCartOk()
        {
            return this;
        }

        @Override
        public Page addToCartBad()
        {
            return this;
        }

        @Override
        public Page removeFromCartOk()
        {
            return this;
        }

        @Override
        public Page removeFromCartBad()
        {
            return this;
        }

        @Override
        public Page viewCatalogOk()
        {
            return this;
        }

        @Override
        public Page viewCatalogBad()
        {
            return this;
        }

        @Override
        public Page viewCartOk()
        {
            return this;
        }

        @Override
        public Page viewCartBad()
        {
            return this;
        }

        @Override
        public Page purchaseOk()
        {
            return this;
        }

        @Override
        public Page purchaseBad()
        {
            return this;
        }

        @Override
        public Page viewItemOk()
        {
            return this;
        }

        @Override
        public Page viewItemBad()
        {
            return this;
        }
        
        @Override
        public Pages getType()
        {
            return this;
        }

    }

