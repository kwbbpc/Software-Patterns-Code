package broadway.kyle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FilePrintStream
{

    private PrintStream stream = null;
    private FileOutputStream fileOutStream = null;

    public FilePrintStream(String filename)
    {
        try
        {
            fileOutStream = new FileOutputStream(filename);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error: " + e.getMessage());
            assert (false);
        }

        stream = new PrintStream(fileOutStream);
    }

    public void close()
    {
        if (fileOutStream != null)
        {

            try
            {
                fileOutStream.close();
            }
            catch (IOException e)
            {
                System.err.println("Error: " + e.getMessage());
                assert (false);
            }
        }
        else
        {
            System.out.println("Trying to close a file that doesn't exist!");
            assert (false);
        }
    }

    public PrintStream getPrintStream()
    {
        return stream;
    }

}
