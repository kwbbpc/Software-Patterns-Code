package broadway.kyle;

import broadway.kyle.Builder.FooterType;
import broadway.kyle.Builder.FormType;

public class DirectorCustomerEdit implements Director
{

    private Builder builder;

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
    public void build()
    {
        builder.buildPageTitle("Customer Information");
        builder.buildHeader("Customer Information");
        builder.buildParagraph("Please edit the following information about yourself and press Update to submit your changes.");
        builder.buildForm(FormType.Customer);
        builder.buildFooterLinks(FooterType.CustomerEdit);

    }
}
