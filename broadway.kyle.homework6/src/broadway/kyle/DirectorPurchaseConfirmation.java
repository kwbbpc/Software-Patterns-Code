package broadway.kyle;

import broadway.kyle.Builder.FooterType;

public class DirectorPurchaseConfirmation implements Director
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
        builder.buildPageTitle("Thanks!");
        builder.buildHeader("Thank you for your purchase!");
        builder.buildFooterLinks(FooterType.PurchaseConfirmation);

    }

}
