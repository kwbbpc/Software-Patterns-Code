package broadway.kyle.visitorHtmlRendering;

public interface Visitor
{
    
    void preVisit(TagGeneric t);
    void postVisit(TagGeneric t);
    
    void preVisit(Anchor a);
    void postVisit(Anchor a);
    
    void preVisit(Body a);
    void postVisit(Body a);
    
    void preVisit(Button a);
    void postVisit(Button a);
    
    void preVisit(Emphasis a);
    void postVisit(Emphasis a);
    
    void preVisit(Field a);
    void postVisit(Field a);
    
    void preVisit(Form a);
    void postVisit(Form a);
    
    void preVisit(Head a);
    void postVisit(Head a);
    
    void preVisit(Header a);
    void postVisit(Header a);
    
    void preVisit(HTML a);
    void postVisit(HTML a);
    
    void preVisit(ListItem a);
    void postVisit(ListItem a);
    
    void preVisit(OrderedList a);
    void postVisit(OrderedList a);
    
    void preVisit(Paragraph a);
    void postVisit(Paragraph a);
    
    void preVisit(Password a);
    void postVisit(Password a);
    
    void preVisit(Strong a);
    void postVisit(Strong a);
    
    void preVisit(Table a);
    void postVisit(Table a);
    
    void preVisit(TableData a);
    void postVisit(TableData a);
    
    void preVisit(TableHeader a);
    void postVisit(TableHeader a);
    
    void preVisit(TableRow a);
    void postVisit(TableRow a);
    
    void preVisit(VisitorText a);
    void postVisit(VisitorText a);
    
    void preVisit(Title a);
    void postVisit(Title a);
    
    void preVisit(UnorderedList a);
    void postVisit(UnorderedList a);
    
}
