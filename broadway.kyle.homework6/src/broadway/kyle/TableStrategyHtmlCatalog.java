package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.FactoryCompositeTags;
import broadway.kyle.compositeHtmlRendering.Renderer;
import broadway.kyle.compositeHtmlRendering.Table;

public class TableStrategyHtmlCatalog implements TableStrategy
{

    @Override
    public Renderer build()
    {
        Table catalogTable = FactoryCompositeTags.createTable();
        catalogTable.add(FactoryCompositeTags.createTableRow() //
        .add(FactoryCompositeTags.createTableHeader("Id")) //
        .add(FactoryCompositeTags.createTableHeader("Name")) //
        .add(FactoryCompositeTags.createTableHeader("Quantity")) //
        .add(FactoryCompositeTags.createTableHeader("Price"))) //
        .add(FactoryCompositeTags.createTableRow() //
        .add(FactoryCompositeTags.createTableData("").add(FactoryCompositeTags.createAnchor("0001", "controller?action=viewItem&id=0001&page=catalog", null))) //
        .add(FactoryCompositeTags.createTableData("").add(FactoryCompositeTags.createAnchor("Screwdriver", "controller?action=viewItem&id=0001&page=catalog", null))) //
        .add(FactoryCompositeTags.createTableData("42")) //
        .add(FactoryCompositeTags.createTableData("$3.42"))) //
        .add(FactoryCompositeTags.createTableRow() //
        .add(FactoryCompositeTags.createTableData("").add(FactoryCompositeTags.createAnchor("0002", "controller?action=viewItem&id=0002&page=catalog", null))) //
        .add(FactoryCompositeTags.createTableData("").add(FactoryCompositeTags.createAnchor("Saw", "controller?action=viewItem&id=0002&page=catalog", null))) //
        .add(FactoryCompositeTags.createTableData("13")) //
        .add(FactoryCompositeTags.createTableData("$6.47"))); //

        return catalogTable;

    }
}
