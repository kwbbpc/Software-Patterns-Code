package broadway.kyle.compositeHtmlRendering;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class App
{

    public static void main(String[] args) throws FileNotFoundException
    {
        PrintStream stream = new PrintStream(new FileOutputStream("test.html"));

        HTML html = new HTML();
            html.
            add(new Head().
                    add("This is the HTML Head section").
                    add(new Title("This is the Title in the head section"))).
            
            add(new Body().
                    add(new Header("Here's a header in the body")).
                    add(new Strong("Strong text in the body section.")).
                    add(new Paragraph().
                            add("This is text for the paragraph").
                            add(new Emphasis("This is emphasized")).
                            add("This is not emphasized")).
                    add(new Paragraph().
                            add(new Table().
                                    add(new TableHeader("A new table header")).
                                    add(new TableRow().
                                            add(new TableData("data 1")).
                                            add(new TableData("data 2")).
                                            add(new TableData("data 3"))).
                                    add(new TableRow().
                                            add(new TableData("data 4")).
                                            add(new TableData("data 5")).
                                            add(new TableData("data 6")))).
                   add(new UnorderedList().
                                   add(new ListItem("UnorderedList 1")).
                                   add(new ListItem("UnorderedList 2")).
                                   add(new ListItem("UnorderedList 3"))).
                           add(new OrderedList().
                                   add(new ListItem("OrderedList 1")).
                                   add(new ListItem("OrderedList 2")).
                                   add(new ListItem("OrderedList 3"))).
                   add(new Paragraph().
                           add(new Anchor("This is an anchor href", "http://lmgtfy.com/?q=anchor", null))).
                   add(new Paragraph().
                           add(new Anchor("This is an anchor name", null, "name"))).
                   add(new Form("http://www.w3schools.com/html/html_form_action.asp").
                           add(new Field("user", "NameLabel", "NameValue")).
                           add(new Password("PasswordName", "PasswordLabel")).
                           add(new Button("ButtonName", "ButtonLabel")))));

        html.render(stream);

    }
}
