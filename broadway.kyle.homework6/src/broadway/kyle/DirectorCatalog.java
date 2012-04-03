package broadway.kyle;

import java.io.PrintStream;

import broadway.kyle.Builder.FooterType;
import broadway.kyle.Builder.TableType;

import com.javadude.beans.Catalog;
import com.javadude.beans.ProductHolder;
import com.javadude.command.UndoManager;

public class DirectorCatalog implements Director
{

    private Builder builder;
    private ProductHolder productHolder;
    private Catalog catalog;
    private UndoManager commandManager;

    public DirectorCatalog(ProductHolder productHolder, Catalog catalog,
            UndoManager commandManager)
    {
        this.productHolder = productHolder;
        this.commandManager = commandManager;
    }

    public DirectorCatalog(Builder builder, ProductHolder productHolder,
            Catalog catalog, UndoManager commandManager)
    {
        this.productHolder = productHolder;
        this.commandManager = commandManager;
        this.catalog = catalog;
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
        builder.buildTable(TableType.Catalog, productHolder, catalog);
        builder.buildFooterLinks(FooterType.Catalog, commandManager);

        builder.render(stream);
        stream.close();

    }

}
