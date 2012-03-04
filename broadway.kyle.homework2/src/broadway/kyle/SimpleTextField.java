package broadway.kyle;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * This is a little helper class that converts Swing's Document change events
 *   into a "text" property change event. Don't worry about the details...
 */
public class SimpleTextField extends JTextField {
	private static final long serialVersionUID = 1L;

	public SimpleTextField(String initialValue) {
		super(initialValue);
		getDocument().addDocumentListener(new DocumentListener() {
			private void safeChange() {
				SwingUtilities.invokeLater(new Runnable() {
					@Override public void run() {
						firePropertyChange("text", null, getText());
					} });
			}
			@Override public void changedUpdate(DocumentEvent e) { safeChange(); }
			@Override public void insertUpdate(DocumentEvent e) { safeChange(); }
			@Override public void removeUpdate(DocumentEvent e) { safeChange(); }
		});
	}
}
