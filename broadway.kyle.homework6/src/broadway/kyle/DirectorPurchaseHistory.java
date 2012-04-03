package broadway.kyle;

import java.io.PrintStream;

import broadway.kyle.Builder.FooterType;

import com.javadude.beans.ProductHolder;
import com.javadude.command.UndoManager;

public class DirectorPurchaseHistory implements Director
{

    private Builder builder;

    private UndoManager commandManager;
    private ProductHolder productHolder;

    public DirectorPurchaseHistory(Builder builder, UndoManager commandManager,
            ProductHolder productHolder)
    {
        super();
        this.builder = builder;
        this.commandManager = commandManager;
        this.productHolder = productHolder;
    }

    public DirectorPurchaseHistory(UndoManager commandManager,
            ProductHolder productHolder)
    {
        super();
        this.commandManager = commandManager;
        this.productHolder = productHolder;
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
        builder.buildTable(productHolder);
        builder.buildParagraph(Integer.toString(productHolder.getTotalValue()));
        builder.buildFooterLinks(FooterType.PurchaseHistory, commandManager);

        builder.render(stream);
        stream.close();

    }

}
