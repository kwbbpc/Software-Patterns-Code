package broadway.kyle;

import java.io.PrintStream;

import broadway.kyle.Builder.FooterType;
import broadway.kyle.Builder.TableType;

import com.javadude.beans.Catalog;
import com.javadude.beans.ProductHolder;
import com.javadude.command.UndoManager;

public class DirectorShoppingCart implements Director
{

    private Builder builder;

    private ProductHolder productHolder;
    private UndoManager commandManager;
    private Catalog catalog;

    public DirectorShoppingCart(Builder builder, ProductHolder productHolder,
            Catalog catalog, UndoManager commandManager)
    {
        super();
        this.builder = builder;
        this.productHolder = productHolder;
        this.catalog = catalog;
        this.commandManager = commandManager;
    }

    public DirectorShoppingCart(ProductHolder productHolder, Catalog catalog,
            UndoManager commandManager)
    {
        super();
        this.productHolder = productHolder;
        this.catalog = catalog;
        this.commandManager = commandManager;
    }

    @Override
    public Builder getBuilder()
    {
        return builder;
    }

    @Override
    public void setBuilder(Builder builder)
    {
        this.builder = builder;
    }

    @Override
    public void build(PrintStream stream)
    {

        if (builder == null)
        {
            stream.close();
            return;
        }

        builder.buildPageTitle("Shopping Cart");
        builder.buildHeader("Shopping Cart");
        builder.buildTable(TableType.ShoppingCart, productHolder, catalog);
        builder.buildParagraph("Total Cost: " + productHolder.getTotalValue());
        builder.buildFooterLinks(FooterType.ShoppingCart, commandManager);

        builder.render(stream);
        stream.close();

    }

}