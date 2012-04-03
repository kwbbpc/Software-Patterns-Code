package broadway.kyle;

import java.io.PrintStream;

import broadway.kyle.Builder.FooterType;

import com.javadude.command.UndoManager;

public class DirectorPurchaseConfirmation implements Director
{

    private Builder builder;

    private UndoManager commandManager;

    public DirectorPurchaseConfirmation(UndoManager commandManager)
    {
        super();
        this.commandManager = commandManager;
    }

    public DirectorPurchaseConfirmation(Builder builder,
            UndoManager commandManager)
    {
        super();
        this.builder = builder;
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

        builder.buildPageTitle("Thanks!");
        builder.buildHeader("Thank you for your purchase!");
        builder.buildFooterLinks(FooterType.PurchaseConfirmation, commandManager);

        builder.render(stream);
        stream.close();

    }

}
