package broadway.kyle;

import com.javadude.beans.Client;
import com.javadude.beans.ProductHolder;
import com.javadude.command.UndoManager;

public class FactoryHomework3
{

    public static AddToCartAction createAddToCartAction(Client client, UndoManager undoManager)
    {
        return new AddToCartAction(client, undoManager);
    }

    public static RemoveFromCartAction createRemoveFromCartAction(Client client, UndoManager undoManager)
    {
        return new RemoveFromCartAction(client, undoManager);
    }

    public static PurchaseAction createPurchaseAction(Client client, UndoManager commandManager, ProductHolder cart)
    {
        return new PurchaseAction(client, commandManager, cart);
    }

    public static UndoAction createUndoAction(UndoManager undoManager)
    {
        return new UndoAction(undoManager);
    }

    public static RedoAction createRedoAction(UndoManager undoManager)
    {
        return new RedoAction(undoManager);
    }

}
