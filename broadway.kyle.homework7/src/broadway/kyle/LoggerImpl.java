package broadway.kyle;

public class LoggerImpl implements Logger
{

    @Override
    public void log(Severity severity, String message)
    {

        System.out.println(severity + ": " + message);

    }

}
