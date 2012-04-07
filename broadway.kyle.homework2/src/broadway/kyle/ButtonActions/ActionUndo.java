package broadway.kyle.ButtonActions;

import java.awt.event.ActionEvent;

import com.javadude.command.UndoManager;

public class ActionUndo implements ActionButton
{

    UndoManager undoManager;

    public ActionUndo(UndoManager undoManager)
    {
        this.undoManager = undoManager;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        undoManager.undo();
    }

}
