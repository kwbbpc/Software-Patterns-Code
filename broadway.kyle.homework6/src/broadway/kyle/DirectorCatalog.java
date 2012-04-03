package broadway.kyle;

import java.io.PrintStream;

import broadway.kyle.Builder.FooterType;

import com.javadude.beans.ProductHolder;
import com.javadude.command.UndoManager;

public class DirectorCatalog implements Director
{

    private Builder builder;
    private ProductHolder productHolder;
    private UndoManager commandManager;

    public DirectorCatalog(ProductHolder productHolder,
            UndoManager commandManager)
    {
        this.productHolder = productHolder;
        this.commandManager = commandManager;
    }

    public DirectorCatalog(ProductHolder productHolder,
            UndoManager commandManager, Builder builder)
    {
        this.productHolder = productHolder;
        this.commandManager = commandManager;
        this.builder = builder;
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

        builder.buildPageTitle("Catalog");
        builder.buildHeader("Catalog");
        builder.buildTable(productHolder);
        builder.buildFooterLinks(FooterType.Catalog, commandManager);

        builder.render(stream);
        stream.close();

    }

}
