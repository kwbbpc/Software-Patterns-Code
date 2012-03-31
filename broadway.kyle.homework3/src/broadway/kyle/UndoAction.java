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
    public void go(Map<String, String[]> parameters)
    {

        //Undo
        if (commandManager != null)
        {
            commandManager.undo();
        }
        else
        {
            System.out.println("Failed to undo: command manager does not exist.");
            assert (false);
        }

    }

}
