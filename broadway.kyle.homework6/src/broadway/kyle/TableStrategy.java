package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.Renderer;

import com.javadude.beans.Catalog;
import com.javadude.beans.ProductHolder;

public interface TableStrategy
{
    public Renderer build(ProductHolder productHolder, Catalog catalog);
}
