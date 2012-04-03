package broadway.kyle;

import java.io.PrintStream;

import broadway.kyle.Builder.FooterType;

import com.javadude.beans.Customer;
import com.javadude.command.UndoManager;

public class DirectorCustomerEdit implements Director
{

    private Builder builder;

    private Customer customer;
    private UndoManager commandManager;

    public DirectorCustomerEdit(Builder builder, Customer customer,
            UndoManager commandManager)
    {
        super();
        this.builder = builder;
        this.customer = customer;
        this.commandManager = commandManager;
    }

    public DirectorCustomerEdit(Customer customer, UndoManager commandManager)
    {
        super();
        this.customer = customer;
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

        builder.buildPageTitle("Customer Information");
        builder.buildHeader("Customer Information");
        builder.buildParagraph("Please edit the following information about yourself and press Update to submit your changes.");
        builder.buildForm(customer);
        builder.buildFooterLinks(FooterType.CustomerEdit, commandManager);

        builder.render(stream);
        stream.close();

    }
}
