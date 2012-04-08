package broadway.kyle;

public class LoggerImpl implements Logger
{

    boolean loggingEnabled;

    public LoggerImpl()
    {
        this.loggingEnabled = true;
    }

    public LoggerImpl(boolean enable)
    {
        this.loggingEnabled = enable;
    }

    @Override
    public void log(Severity severity, String message)
    {

        System.out.println(severity + ": " + message);

    }

    @Override
    public boolean isLoggingEnabled()
    {
        return loggingEnabled;
    }

}
