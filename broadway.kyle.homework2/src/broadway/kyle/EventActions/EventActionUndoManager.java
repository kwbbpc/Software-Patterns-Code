package broadway.kyle.EventActions;

import java.beans.PropertyChangeEvent;

import javax.swing.JButton;

import broadway.kyle.EventAction;

import com.javadude.command.UndoManager;

public class EventActionUndoManager implements EventAction
{

    JButton undoButton;
    JButton redoButton;
    UndoManager undoManager;

    public EventActionUndoManager(JButton undoButton, JButton redoButton,
            UndoManager undoManager)
    {
        this.undoButton = undoButton;
        this.redoButton = redoButton;
        this.undoManager = undoManager;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        if ("undoName".equals(evt.getPropertyName()))
        {
            if (undoManager.getUndoName() == null)
            {
                undoButton.setText("Nothing to undo.");
                undoButton.setEnabled(false);
            }
            else
            {
                undoButton.setText("Undo " + undoManager.getUndoName());
                undoButton.setEnabled(true);
            }

        }
        else if ("redoName".equals(evt.getPropertyName()))
        {
            if (undoManager.getRedoName() == null)
            {
                redoButton.setText("Nothing to redo.");
                redoButton.setEnabled(false);
            }
            else
            {
                redoButton.setText("Redo " + undoManager.getRedoName());
                redoButton.setEnabled(true);
            }
        }

    }

}
