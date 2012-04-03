package broadway.kyle.compositeHtmlRendering;

import broadway.kyle.FactoryInputOutputStream;
import broadway.kyle.FilePrintStream;
import broadway.kyle.test.Tester;

public class CompositeApp
{

    public static void main(String[] args)
    {
        
        String outputFile = "CompositeTest.html";
        
        try
        {
            
            
            FilePrintStream stream = FactoryInputOutputStream.createFilePrintStream(outputFile);
    
            HTML html = FactoryCompositeTags.createHTML();
                html.
                add(FactoryCompositeTags.createHead().
                        add("This is the HTML Head section").
                        add(FactoryCompositeTags.createTitle("This is the Title in the head section"))).
                
                add(FactoryCompositeTags.createBody().
                        add(FactoryCompositeTags.createHeader("Here's a header in the body")).
                        add(FactoryCompositeTags.createStrong("Strong text in the body section.")).
                        add(FactoryCompositeTags.createParagraph().
                                add("This is text for the paragraph").
                                add(FactoryCompositeTags.createEmphasis("This is emphasized")).
                                add("This is not emphasized")).
                        add(FactoryCompositeTags.createParagraph().
                                add(FactoryCompositeTags.createTable().
                                        add(FactoryCompositeTags.createTableHeader("A new table header")).
                                        add(FactoryCompositeTags.createTableRow().
                                                add(FactoryCompositeTags.createTableData("data 1")).
                                                add(FactoryCompositeTags.createTableData("data 2")).
                                                add(FactoryCompositeTags.createTableData("data 3"))).
                                        add(FactoryCompositeTags.createTableRow().
                                                add(FactoryCompositeTags.createTableData("data 4")).
                                                add(FactoryCompositeTags.createTableData("data 5")).
                                                add(FactoryCompositeTags.createTableData("data 6")))).
                       add(FactoryCompositeTags.createUnorderedList().
                                       add(FactoryCompositeTags.createListItem("UnorderedList 1")).
                                       add(FactoryCompositeTags.createListItem("UnorderedList 2")).
                                       add(FactoryCompositeTags.createListItem("UnorderedList 3"))).
                               add(FactoryCompositeTags.createOrderedList().
                                       add(FactoryCompositeTags.createListItem("OrderedList 1")).
                                       add(FactoryCompositeTags.createListItem("OrderedList 2")).
                                       add(FactoryCompositeTags.createListItem("OrderedList 3"))).
                       add(FactoryCompositeTags.createParagraph().
                               add(FactoryCompositeTags.createAnchor("This is an anchor href", "http://lmgtfy.com/?q=anchor", null))).
                       add(FactoryCompositeTags.createParagraph().
                               add(FactoryCompositeTags.createAnchor("This is an anchor name", null, "name"))).
                       add(FactoryCompositeTags.createForm("http://www.w3schools.com/html/html_form_action.asp").
                               add(FactoryCompositeTags.createField("user", "NameLabel", "NameValue")).
                               add(FactoryCompositeTags.createPassword("PasswordName", "PasswordLabel")).
                               add(FactoryCompositeTags.createButton("ButtonName", "ButtonLabel")))));
    
           
                html.render(stream.getPrintStream());
                
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
