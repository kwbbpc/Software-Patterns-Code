package broadway.kyle;

import broadway.kyle.Builder.FooterType;
import broadway.kyle.Builder.TableType;

public class DirectorCatalog implements Director
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
        builder.buildPageTitle("Catalog");
        builder.buildHeader("Catalog");
        builder.buildTable(TableType.ProductDisplay);
        builder.buildFooterLinks(FooterType.Catalog);

    }

}
