package broadway.kyle;

import java.util.Map;

import com.javadude.command.UndoManager;

public class RedoAction implements ActionStrategy
{
    private UndoManager commandManager;

    /**
     * Constructor.
     * 
     * @param undoManager
     * The undo manager handling execution
     */
    public RedoAction(UndoManager undoManager)
    {
        this.commandManager = undoManager;
    }

    @Override
    public void go(Map<String, String[]> parameters)
    {

        //Redo
        if (commandManager != null)
        {
            commandManager.redo();
        }
        else
        {
            System.out.println("Failed to redo: command manager does not exist.");
            assert (false);
        }

    }

}