package broadway.kyle;

import java.util.Map;

import com.javadude.command.UndoManager;

public class UndoAction implements ActionStrategy
{

    private UndoManager commandManager;

    /**
     * Constructor.
     * 
     * @param undoManager
     * The undo manager handling execution
     */
    UndoAction(UndoManager undoManager)
    {
        this.commandManager = undoManager;
    }

    @Override
    public String go(Map<String, String[]> parameters)
    {

        //Undo
        if (commandManager != null)
        {
            commandManager.undo();
            return "Good";
        }
        else
        {
            System.out.println("Failed to undo: command manager does not exist.");
            assert (false);
            return "Bad";
        }

    }

}
