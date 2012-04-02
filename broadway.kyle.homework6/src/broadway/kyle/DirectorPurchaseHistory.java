package broadway.kyle;

import broadway.kyle.Builder.FooterType;
import broadway.kyle.Builder.TableType;

public class DirectorPurchaseHistory implements Director
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
        builder.buildPageTitle("Purchase History");
        builder.buildHeader("Purchase History");
        builder.buildTable(TableType.ProductDisplay);
        builder.buildParagraph("Total Cost: $9.89");
        builder.buildFooterLinks(FooterType.PurchaseHistory);

    }

}
