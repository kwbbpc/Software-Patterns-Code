package broadway.kyle;

import java.util.Map;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.Renderer;
import broadway.kyle.compositeHtmlRendering.Table;

import com.javadude.beans.Catalog;
import com.javadude.beans.Product;
import com.javadude.beans.ProductHolder;

public class TableStrategyHtmlCatalog implements TableStrategy
{

    @Override
    public Renderer build(ProductHolder productHolder, Catalog catalog)
    {

        Map<String, Integer> products = productHolder.getQuantities();

        Table catalogTable = FactoryCompositeTags.createTable();
        catalogTable.add(FactoryCompositeTags.createTableRow() //
        .add(FactoryCompositeTags.createTableHeader("Id")) //
        .add(FactoryCompositeTags.createTableHeader("Name")) //
        .add(FactoryCompositeTags.createTableHeader("Quantity")) //
        .add(FactoryCompositeTags.createTableHeader("Price"))); //

        for (Map.Entry<String, Integer> iterProduct : products.entrySet())
        {

            //get the product details from the catalog
            Product product = catalog.getProduct(iterProduct.getKey());

            //make a new table row
            catalogTable.add(FactoryCompositeTags.createTableRow() //
            .add(FactoryCompositeTags.createTableData("").add(FactoryCompositeTags.createAnchor(product.getId(), "controller?action=viewItem&id=" + product.getId() + "&page=catalog", null))) //
            .add(FactoryCompositeTags.createTableData("").add(FactoryCompositeTags.createAnchor(product.getName(), "controller?action=viewItem&id=" + product.getId() + "&page=catalog", null))) //
            .add(FactoryCompositeTags.createTableData(Integer.toString(iterProduct.getValue()))) //
            .add(FactoryCompositeTags.createTableData(Integer.toString(product.getPrice())))); //

        }

        return catalogTable;

    }
}
