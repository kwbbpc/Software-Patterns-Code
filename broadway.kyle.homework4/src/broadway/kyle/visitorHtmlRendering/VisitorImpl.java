package broadway.kyle.visitorHtmlRendering;

import java.io.PrintStream;

public class VisitorImpl implements Visitor
{
    

    
    
    PrintStream stream;
    
    VisitorImpl(PrintStream stream)
    {
        this.stream = stream;
    }

    @Override
    public void preVisit(Paragraph p)
    {
        stream.print("<p>");
    }

    @Override
    public void postVisit(Paragraph p)
    {
        stream.print("</p>");
        
    }

    @Override
    public void preVisit(TagGeneric t)
    {
        assert(false);
        
    }

    @Override
    public void postVisit(TagGeneric t)
    {
        assert(false);
        
    }

    @Override
    public void preVisit(Anchor a)
    {
        if(a.getHref() != null)
        {
            stream.print("<a href=" + a.getHref() + ">");           
        }
        else if(a.getName() != null)
        {
            stream.print("<a name=" + a.getName() + ">");           
        }
        else
        {
            stream.print("<a>");
        }
        
    }

    @Override
    public void postVisit(Anchor a)
    {
        stream.print("</a>");
        
    }

    @Override
    public void preVisit(Body a)
    {
        stream.print("<body>");
        
    }

    @Override
    public void postVisit(Body a)
    {
        stream.print("</body>");
        
    }

    @Override
    public void preVisit(Button a)
    {
        stream.print("<p><input type=submit name='" + a.getName() + "' value='" + a.getLabel() + "' />");
        
    }

    @Override
    public void postVisit(Button a)
    {
        stream.print("</p>");
        
    }

    @Override
    public void preVisit(Emphasis a)
    {
        stream.print("<em>");
        
    }

    @Override
    public void postVisit(Emphasis a)
    {
        stream.print("</em>");
        
    }

    @Override
    public void preVisit(Field a)
    {
        stream.print("<p>" + a.getLabel() + ": <input type=text name='" + a.getName() + "' value='" + a.getValue() + "' />");
        
    }

    @Override
    public void postVisit(Field a)
    {
        stream.print("</p>");
        
    }

    @Override
    public void preVisit(Form a)
    {
        stream.print("<form action='" + a.getUrl() + "' >");
        
    }

    @Override
    public void postVisit(Form a)
    {
        stream.print("</form>");
        
    }

    @Override
    public void preVisit(Head a)
    {
        stream.print("<Head>");
        
    }

    @Override
    public void postVisit(Head a)
    {
        stream.print("</Head>");
        
    }

    @Override
    public void preVisit(Header a)
    {
        stream.print("<h1>");
        
    }

    @Override
    public void postVisit(Header a)
    {
        stream.print("</h1>");
        
    }

    @Override
    public void preVisit(HTML a)
    {
        stream.print("<html>");
        
    }

    @Override
    public void postVisit(HTML a)
    {
        stream.print("</html>");
        
    }

    @Override
    public void preVisit(ListItem a)
    {
        stream.print("<li>");
        
    }

    @Override
    public void postVisit(ListItem a)
    {
        stream.print("</li>");
        
    }

    @Override
    public void preVisit(OrderedList a)
    {
        stream.print("<ol>");
        
    }

    @Override
    public void postVisit(OrderedList a)
    {
        stream.print("</ol>");
        
    }

    @Override
    public void preVisit(Password a)
    {
        stream.print("<p>" + a.getLabel() + ": <input type='password' name='" + a.getName() + "' />");
        
    }

    @Override
    public void postVisit(Password a)
    {
        stream.print("</p>");
        
    }

    @Override
    public void preVisit(Strong a)
    {
        stream.print("<strong>");
        
    }

    @Override
    public void postVisit(Strong a)
    {
        stream.print("</strong>");
        
    }

    @Override
    public void preVisit(Table a)
    {
        stream.print("<table>");
        
    }

    @Override
    public void postVisit(Table a)
    {
        stream.print("</table>");
        
    }

    @Override
    public void preVisit(TableData a)
    {
        stream.print("<td>");
        
    }

    @Override
    public void postVisit(TableData a)
    {
        stream.print("</td>");
        
    }

    @Override
    public void preVisit(TableHeader a)
    {
        stream.print("<th>");
        
    }

    @Override
    public void postVisit(TableHeader a)
    {
        stream.print("</th>");
        
    }

    @Override
    public void preVisit(TableRow a)
    {
        stream.print("<tr>");
        
    }

    @Override
    public void postVisit(TableRow a)
    {
        stream.print("</tr>");
        
    }

    @Override
    public void preVisit(VisitorText a)
    {
        stream.print(a.getText());        
    }

    @Override
    public void postVisit(VisitorText a)
    {
        //do nothing        
    }

    @Override
    public void preVisit(Title a)
    {
        stream.print("<title>");
        
    }

    @Override
    public void postVisit(Title a)
    {
        stream.print("</title>");
        
    }

    @Override
    public void preVisit(UnorderedList a)
    {
        stream.print("<ul>");
        
    }

    @Override
    public void postVisit(UnorderedList a)
    {
        stream.print("</ul>");
        
    }

}
