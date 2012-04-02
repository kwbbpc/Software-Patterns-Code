package broadway.kyle;

import broadway.kyle.Builder.FooterType;
import broadway.kyle.Builder.FormType;

public class DirectorItemDetail implements Director
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
        builder.buildPageTitle("0001: ScrewDriver");
        builder.buildHeader("0001: Screwdriver");
        builder.buildParagraph("This screwdriver allows you to screw anything up.");
        builder.buildForm(FormType.Detail);
        builder.buildFooterLinks(FooterType.ItemDetail);
    }

}
