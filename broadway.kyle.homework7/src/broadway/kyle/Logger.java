package broadway.kyle;

public interface Logger
{

    public enum Severity
    {
        ERROR, WARNING, INFO
    }

    void log(Severity severity, String message);

    boolean isLoggingEnabled();

}
