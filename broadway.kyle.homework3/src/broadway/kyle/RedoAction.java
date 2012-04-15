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
    RedoAction(UndoManager undoManager)
    {
        this.commandManager = undoManager;
    }

    @Override
    public String go(Map<String, String[]> parameters)
    {

        //Redo
        if (commandManager != null)
        {
            commandManager.redo();
            return "Good";
        }
        else
        {
            System.out.println("Failed to redo: command manager does not exist.");
            assert (false);
            return "Bad";
        }

    }

}
