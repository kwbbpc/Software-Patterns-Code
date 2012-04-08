package broadway.kyle;

import broadway.kyle.Logger.Severity;

import com.javadude.command.Command;

public class CommandDecorator implements Command
{

    Command command;
    Logger logger;

    public CommandDecorator(Logger logger, Command command)
    {
        this.logger = logger;
        this.command = command;
    }

    @Override
    public void execute()
    {
        logger.log(Severity.INFO, command.toString());
        command.execute();
    }

    @Override
    public void undo()
    {
        logger.log(Severity.INFO, command.toString());
        command.undo();

    }

    @Override
    public void redo()
    {
        logger.log(Severity.INFO, command.toString());
        command.redo();

    }

    @Override
    public String getName()
    {
        return command.getName();
    }

}
