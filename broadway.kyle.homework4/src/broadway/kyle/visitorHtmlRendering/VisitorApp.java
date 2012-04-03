package broadway.kyle.visitorHtmlRendering;

import java.io.FileNotFoundException;

import broadway.kyle.FactoryInputOutputStream;
import broadway.kyle.FilePrintStream;
import broadway.kyle.test.Tester;

public class VisitorApp
{
    
    public static void main(String[] args) throws FileNotFoundException
    {
        String outputFile = "VisitorTest.html";
        try
        {       
        
            FilePrintStream stream = FactoryInputOutputStream.createFilePrintStream(outputFile);
    
            HTML html = FactoryVisitorTags.createHTML();
                html.
                add(FactoryVisitorTags.createHead().
                        add("This is the HTML Head section").
                        add(FactoryVisitorTags.createTitle("This is the Title in the head section"))).
                
                add(FactoryVisitorTags.createBody().
                        add(FactoryVisitorTags.createHeader("Here's a header in the body")).
                        add(FactoryVisitorTags.createStrong("Strong text in the body section.")).
                        add(FactoryVisitorTags.createParagraph().
                                add("This is text for the paragraph").
                                add(FactoryVisitorTags.createEmphasis("This is emphasized")).
                                add("This is not emphasized")).
                        add(FactoryVisitorTags.createParagraph().
                                add(FactoryVisitorTags.createTable().
                                        add(FactoryVisitorTags.createTableHeader("A new table header")).
                                        add(FactoryVisitorTags.createTableRow().
                                                add(FactoryVisitorTags.createTableData("data 1")).
                                                add(FactoryVisitorTags.createTableData("data 2")).
                                                add(FactoryVisitorTags.createTableData("data 3"))).
                                        add(FactoryVisitorTags.createTableRow().
                                                add(FactoryVisitorTags.createTableData("data 4")).
                                                add(FactoryVisitorTags.createTableData("data 5")).
                                                add(FactoryVisitorTags.createTableData("data 6")))).
                       add(FactoryVisitorTags.createUnorderedList().
                                       add(FactoryVisitorTags.createListItem("UnorderedList 1")).
                                       add(FactoryVisitorTags.createListItem("UnorderedList 2")).
                                       add(FactoryVisitorTags.createListItem("UnorderedList 3"))).
                               add(FactoryVisitorTags.createOrderedList().
                                       add(FactoryVisitorTags.createListItem("OrderedList 1")).
                                       add(FactoryVisitorTags.createListItem("OrderedList 2")).
                                       add(FactoryVisitorTags.createListItem("OrderedList 3"))).
                       add(FactoryVisitorTags.createParagraph().
                               add(FactoryVisitorTags.createAnchor("This is an anchor href", "http://lmgtfy.com/?q=anchor", null))).
                       add(FactoryVisitorTags.createParagraph().
                               add(FactoryVisitorTags.createAnchor("This is an anchor name", null, "name"))).
                       add(FactoryVisitorTags.createForm("http://www.w3schools.com/html/html_form_action.asp").
                               add(FactoryVisitorTags.createField("user", "NameLabel", "NameValue")).
                               add(FactoryVisitorTags.createPassword("PasswordName", "PasswordLabel")).
                               add(FactoryVisitorTags.createButton("ButtonName", "ButtonLabel")))));
    
            
                Visitor visitor = FactoryVisitorTags.createVisitorImpl(stream.getPrintStream());
                html.accept(visitor);
                stream.close();
        
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.err.println("Error: " + e.getMessage()) ;
        }
        
        boolean testsPassed = false;
        for(int i = 0; i < args.length; ++i)
        {
            if(args[i].equals("-ea"))
            {
                Tester.CompareFiles(outputFile, Tester.BaseFile);
                testsPassed = true;
            }
        }
        
        if(!testsPassed)
            System.out.println("Warning: Automatic tests not performed. Enable assertions to test against a base file when making changes.");


    }
}
