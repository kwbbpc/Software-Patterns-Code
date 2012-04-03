package broadway.kyle.test;

import java.io.BufferedReader;
import java.io.IOException;

import broadway.kyle.FactoryInputOutputStream;

public final class Tester
{
    
    public static final String BaseFile = "BaseComparisonTest.html";
    
    
    /**
     * @param outputFile
     * The newly generated file that needs testing
     * @param baseFile
     * The file to compare against
     */
    public static void CompareFiles(String outputFile, String baseFile)
    {

            
            BufferedReader testReader = FactoryInputOutputStream.createBufferedReader(outputFile);
            BufferedReader compareReader = FactoryInputOutputStream.createBufferedReader(baseFile);
            
            String strLine;
            try
            {
                while((strLine = testReader.readLine()) != null)
                {
                    assert(strLine.equals(compareReader.readLine()));
                }
            }
            catch (IOException e)
            {
                System.err.println("Error: " + e.getMessage());
            }
            
            System.out.println("tests passed");
            

        
    }

}
