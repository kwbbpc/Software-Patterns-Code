package broadway.kyle;

public class AlternateLogger
{

    public void error(String message)
    {
        System.err.println("Error: " + message);
    }

    public void warning(String message)
    {
        System.err.println("Warning: " + message);
    }

    public void info(String message)
    {
        System.err.println("Info: " + message);
    }

}
