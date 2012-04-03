package broadway.kyle.compositeHtmlRendering;



public class FactoryCompositeTags
{

    public static CompositeText createText(String text)
    {
        return new CompositeText(text);
    }
    

    public static CompositeNullText createNullText()
    {
        return new CompositeNullText();
    }


    public static HTML createHTML()
    {
        return new HTML();
    }


    public static Head createHead()
    {
        return new Head();
    }


    public static Title createTitle(String text)
    {
        return new Title(text);
    }


    public static Body createBody()
    {
        return new Body();
    }


    public static Header createHeader(String text)
    {
        return new Header(text);
    }


    public static Strong createStrong(String text)
    {
        return new Strong(text);
    }


    public static Paragraph createParagraph()
    {
        return new Paragraph();
    }
    
    public static Paragraph createParagraph(String text)
    {
        return new Paragraph(text);
    }


    public static Emphasis createEmphasis(String text)
    {
        return new Emphasis(text);
    }


    public static Table createTable()
    {
        return new Table();
    }


    public static TableRow createTableRow()
    {
        return new TableRow();
    }


    public static TableHeader createTableHeader(String text)
    {
        return new TableHeader(text);
    }


    public static TableData createTableData(String text)
    {
        return new TableData(text);
    }


    public static UnorderedList createUnorderedList()
    {
        return new UnorderedList();
    }


    public static ListItem createListItem(String text)
    {
        return new ListItem(text);
    }


    public static OrderedList createOrderedList()
    {
        return new OrderedList();
    }


    public static Anchor createAnchor(String text, String href, String name)
    {
        return new Anchor(text, href, name);
    }


    public static Form createForm(String url)
    {
        return new Form(url);
    }
    
    public static Form createForm(String url, String method)
    {
        return new Form(url, method);
    }


    public static Field createField(String name, String label, String value)
    {
        return new Field(name, label, value);
    }


    public static Password createPassword(String name, String label)
    {
        return new Password(name, label);
    }


    public static Button createButton(String name, String label)
    {
        return new Button(name, label);
    }


    public static Hidden createHidden(String name, String value)
    {
        return new Hidden(name, value);
    }





}
