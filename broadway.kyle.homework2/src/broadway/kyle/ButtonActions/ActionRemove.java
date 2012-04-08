package broadway.kyle.ButtonActions;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import broadway.kyle.FactoryHomework2;

import com.javadude.beans.Client;
import com.javadude.command.UndoManager;

public class ActionRemove implements ActionButton
{

    private Client client;
    private JTextField productIdField;
    private JTextField quantityField;
    private UndoManager undoManager;

    public ActionRemove(Client client, JTextField productIdField2,
            JTextField quantityField2, UndoManager undoManager)
    {
        this.client = client;
        this.productIdField = productIdField2;
        this.quantityField = quantityField2;
        this.undoManager = undoManager;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        undoManager.execute(FactoryHomework2.createRemoveFromCartCommand(client, productIdField.getText(), Integer.parseInt(quantityField.getText())));
    }

}
