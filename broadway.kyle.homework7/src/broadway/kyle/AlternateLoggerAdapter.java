package broadway.kyle;

public class AlternateLoggerAdapter implements Logger
{

    AlternateLogger logger;

    public AlternateLoggerAdapter(AlternateLogger logger)
    {
        this.logger = logger;
    }

    @Override
    public void log(Severity severity, String message)
    {
        switch (severity)
        {
            case INFO:
                logger.info(message);
                break;
            case WARNING:
                logger.warning(message);
                break;
            case ERROR:
                logger.error(message);
                break;
            default:
                logger.error("Logger Error: Logging level not understood");
                logger.info(message);
                break;
        }

    }

}
