package broadway.kyle;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FactoryInputOutputStream
{

    public static BufferedReader createBufferedReader(String filename)
    {

        try
        {

            FileInputStream fileStream = new FileInputStream(filename);
            DataInputStream dataStream = new DataInputStream(fileStream);
            return new BufferedReader(new InputStreamReader(dataStream));

        }
        catch (Exception e)
        {

            return null;
        }

    }

    public static FilePrintStream createFilePrintStream(String filename)
    {
        return new FilePrintStream(filename);
    }
}
