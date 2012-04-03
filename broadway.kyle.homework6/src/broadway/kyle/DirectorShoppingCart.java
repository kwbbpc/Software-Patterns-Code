package broadway.kyle;

import java.io.PrintStream;

import broadway.kyle.Builder.FooterType;

import com.javadude.beans.ProductHolder;
import com.javadude.command.UndoManager;

public class DirectorShoppingCart implements Director
{

    private Builder builder;

    private ProductHolder productHolder;
    private UndoManager commandManager;

    public DirectorShoppingCart(Builder builder, ProductHolder productHolder,
            UndoManager commandManager)
    {
        super();
        this.builder = builder;
        this.productHolder = productHolder;
        this.commandManager = commandManager;
    }

    public DirectorShoppingCart(ProductHolder productHolder,
            UndoManager commandManager)
    {
        super();
        this.productHolder = productHolder;
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
        builder.buildPageTitle("Shopping Cart");
        builder.buildHeader("Shopping Cart");
        builder.buildTable(productHolder);
        builder.buildFooterLinks(FooterType.ShoppingCart, commandManager);

        builder.render(stream);
        stream.close();

    }

}