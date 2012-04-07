package sample;

public class ChangeNameCommand extends Command
{

    private Person person;
    private String name;
    private String oldName;

    public ChangeNameCommand(Person person, String name)
    {
        this.person = person;
        this.name = name;
    }

    @Override
    public void execute()
    {
        oldName = person.getName();
        person.setName(name);
    }

    @Override
    public void undo()
    {
        person.setName(oldName);

    }

}
