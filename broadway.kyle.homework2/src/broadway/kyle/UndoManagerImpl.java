package broadway.kyle;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.EmptyStackException;
import java.util.Stack;

import com.javadude.command.Command;
import com.javadude.command.UndoManager;

public class UndoManagerImpl implements UndoManager
{

    private Stack<Command> undoStack = FactoryCollection.createStack();
    private Stack<Command> redoStack = FactoryCollection.createStack();

    private PropertyChangeSupport pcs = FactoryPropertyChange.createPropertyChangeSupport(this);

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        pcs.addPropertyChangeListener(listener);

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        pcs.removePropertyChangeListener(listener);

    }

    @Override
    public void execute(Command command)
    {
        command.execute();
        //clear the redo stack anytime a new command is executed.
        String oldRedoCommand = getRedoName();
        redoStack.clear();
        pcs.firePropertyChange("redoName", oldRedoCommand, null);

        //push onto the undo stack
        String oldUndoCommand = getUndoName();
        undoStack.push(command);
        pcs.firePropertyChange("undoName", oldUndoCommand, getUndoName());

    }

    @Override
    public void undo()
    {
        //ensure there's something to undo
        if (undoStack.isEmpty())
        {
            System.out.println("nothing to undo.");
            return;
        }

        //undo the command
        Command lastCommand = undoStack.pop();
        lastCommand.undo();
        pcs.firePropertyChange("undoName", lastCommand.getName(), getUndoName());

        //push onto the redo stack
        String oldRedoCommand = getRedoName();
        redoStack.push(lastCommand);
        pcs.firePropertyChange("redoName", oldRedoCommand, getRedoName());

    }

    @Override
    public void redo()
    {
        //ensure there's something to redo
        if (redoStack.isEmpty())
        {
            System.out.println("nothing to redo.");
            return;
        }

        //redo the command
        Command lastCommand = redoStack.pop();
        lastCommand.redo();
        pcs.firePropertyChange("redoName", lastCommand.getName(), getRedoName());

        //push onto the undo stack
        String oldUndoCommand = getUndoName();
        undoStack.push(lastCommand);
        pcs.firePropertyChange("undoName", oldUndoCommand, getUndoName());
    }

    @Override
    public String getUndoName()
    {
        try
        {
            return undoStack.peek().getName();
        }
        catch (EmptyStackException e)
        {
            return null;
        }
    }

    @Override
    public String getRedoName()
    {
        try
        {
            return redoStack.peek().getName();
        }
        catch (EmptyStackException e)
        {
            return null;
        }
    }

}
