package com.javadude.command;

import com.javadude.beans.PropertyChangeNotifier;

/**
 * Manages execution of commands.
 * properties: read-only/derived/bound: undoName, redoName
 */
public interface UndoManager extends PropertyChangeNotifier {
	/**
	 * Execute the specified command. This command will be tracked so it can
	 *   be undone if needed.
	 * @param command the command to execute
	 */
	public void execute(Command command);

	/**
	 * Undo the last-executed command. This command will be tracked so it can
	 *   be redone if needed.
	 */
	public void undo();

	/**
	 * Redo the last-executed command. This command will be tracked so it can
	 *   be undone if needed.
	 */
	public void redo();

	/**
	 * @return the text that should be associated with an Undo button/menu
	 */
	public String getUndoName();

	/**
	 * @return the text that should be associated with a Redo button/menu
	 */
	public String getRedoName();
}
