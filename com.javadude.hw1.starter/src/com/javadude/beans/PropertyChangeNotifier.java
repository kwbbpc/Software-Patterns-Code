package com.javadude.beans;

import java.beans.PropertyChangeListener;

/**
 * Describes a type that can notify interested parties about property changes.
 */
public interface PropertyChangeNotifier {
	/**
	 * Add a PropertyChangeListener to be notified when properties change
	 * @param listener the PropertyChangeListener to add
	 */
	void addPropertyChangeListener(PropertyChangeListener listener);

	/**
	 * Removes a PropertyChangeListener to be notified when properties change
	 * @param listener the PropertyChangeListener to remove
	 */
	void removePropertyChangeListener(PropertyChangeListener listener);
}
