package broadway.kyle.ButtonActions;

import java.awt.event.ActionEvent;

import com.javadude.command.UndoManager;

public class ActionRedo implements ActionButton
{

    UndoManager undoManager;

    public ActionRedo(UndoManager undoManager)
    {

        this.undoManager = undoManager;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        undoManager.redo();
    }

}
