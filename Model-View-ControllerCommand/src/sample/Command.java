package sample;

public abstract class Command
{

    public abstract void execute();

    public abstract void undo();

    void redo()
    {
        execute();
    };

    public String getName()
    {
        return "";
    };
}
