package broadway.kyle;

import java.io.PrintStream;

import broadway.kyle.Builder.FooterType;
import broadway.kyle.Builder.TableType;

import com.javadude.beans.Catalog;
import com.javadude.beans.ProductHolder;
import com.javadude.command.UndoManager;

public class DirectorPurchaseHistory implements Director
{

    private Builder builder;

    private UndoManager commandManager;
    private ProductHolder productHolder;
    private Catalog catalog;

    public DirectorPurchaseHistory(Builder builder, UndoManager commandManager,
            Catalog catalog, ProductHolder productHolder)
    {
        super();
        this.builder = builder;
        this.commandManager = commandManager;
        this.productHolder = productHolder;
        this.catalog = catalog;
    }

    public DirectorPurchaseHistory(UndoManager commandManager, Catalog catalog,
            ProductHolder productHolder)
    {
        super();
        this.commandManager = commandManager;
        this.productHolder = productHolder;
        this.catalog = catalog;
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

        builder.buildPageTitle("Purchase History");
        builder.buildHeader("Purchase History");
        builder.buildTable(TableType.Catalog, productHolder, catalog);
        builder.buildParagraph("Total Cost: " + Integer.toString(productHolder.getTotalValue()));
        builder.buildFooterLinks(FooterType.PurchaseHistory, commandManager);

        builder.render(stream);
        stream.close();

    }

}
