package com.javadude.command;

/**
 * A command to be executed and possibly undone/redone
 */
public interface Command {
	/**
	 * Execute this command.
	 */
	void execute();

	/**
	 * Undo this command.
	 */
	void undo();

	/**
	 * Redo this command.
	 */
	void redo();

	/**
	 * @return a string representation of the name of this command
	 *          (to display on Undo/Redo buttons/menus)
	 */
	String getName();
}
