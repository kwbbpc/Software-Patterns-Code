package broadway.kyle;

import java.io.PrintStream;

import broadway.kyle.Builder.FooterType;

import com.javadude.beans.Product;
import com.javadude.command.UndoManager;

public class DirectorItemDetail implements Director
{

    private Builder builder;

    private Product product;
    private UndoManager commandManager;

    public DirectorItemDetail(Builder builder, Product product,
            UndoManager commandManager)
    {
        super();
        this.builder = builder;
        this.product = product;
        this.commandManager = commandManager;
    }

    public DirectorItemDetail(Product product, UndoManager commandManager)
    {
        super();
        this.product = product;
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
        builder.buildPageTitle(product.getId() + ": " + product.getName());
        builder.buildHeader(product.getId() + ": " + product.getName());
        builder.buildParagraph(product.getDescription());
        builder.buildForm(product);
        builder.buildFooterLinks(FooterType.ItemDetail, commandManager);

        builder.render(stream);
        stream.close();
    }

}
