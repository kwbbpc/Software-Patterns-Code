package sample;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class PersonUI extends JPanel
{

    private static final long serialVersionUID = 1L;

    private JTextField nameField = new JTextField();
    private JTextField addressField = new JTextField();
    private JTextField phoneField = new JTextField();
    private JTextField faxField = new JTextField();

    private JButton saveButton = new JButton("Save");

    // COMAND PATTERN
    private JButton doButton = new JButton("Do");
    private JButton undoButton = new JButton("Undo");
    private JButton redoButton = new JButton("Redo");
    private ChangeNameCommand lastChangeNameCommand;
    private Stack<Command> stack = new Stack<Command>();

    private Person model;
    private PropertyChangeListener modelListener = new PropertyChangeListener()
    {
        @Override
        public void propertyChange(PropertyChangeEvent evt)
        {
            if ("name".equals(evt.getPropertyName()))
            {
                nameField.setText(model.getName());
            }
            else if ("phone".equals(evt.getPropertyName()))
            {
                phoneField.setText(model.getPhone());
            }
            else if ("address".equals(evt.getPropertyName()))
            {
                addressField.setText(model.getAddress());
            }
            else if ("fax".equals(evt.getPropertyName()))
            {
                faxField.setText(model.getFax());
            }
        }
    };

    /**
     * VERY IMPORTANT TO REGISTER OR DEREGISTER!!!!
     * 
     * if you forget to disconnect, and the piece is thrown away, it never gets
     * garbage collected!
     * 
     * @param model
     */
    public void setModel(Person model)
    {
        // if you already had a model
        if (this.model != null)
        {
            // disconnect
            this.model.removePropertyChangeListener(modelListener);
        }

        this.model = model;

        if (this.model != null)
        {
            // connect
            this.model.addPropertyChangeListener(modelListener);

            // fill out the model's data
            this.model.addPropertyChangeListener(modelListener);
            nameField.setText(model.getName());
            addressField.setText(model.getAddress());
            phoneField.setText(model.getPhone());
            faxField.setText(model.getFax());
        }
        else
        {
            // if you dont have a model, blank out the data
            nameField.setText("");
            addressField.setText("");
            phoneField.setText("");
            faxField.setText("");
        }

    }

    @SuppressWarnings("serial")
    public PersonUI()
    {

        addComponentListener(new ComponentListener()
        {

            @Override
            public void componentResized(ComponentEvent e)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void componentMoved(ComponentEvent e)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void componentShown(ComponentEvent e)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void componentHidden(ComponentEvent e)
            {
                // TODO Auto-generated method stub

            }

        });

        setLayout(new BorderLayout());
        add(new JPanel(new FlowLayout(FlowLayout.RIGHT))
        {
            {
                add(saveButton);
                add(undoButton);
                add(redoButton);
            }
        }, BorderLayout.SOUTH);
        add(new JPanel(new BorderLayout())
        {
            {
                add(new JPanel(new GridLayout(0, 1, 3, 3))
                {
                    {
                        add(new JLabel("Name"));
                        add(new JLabel("Address"));
                        add(new JLabel("Phone"));
                        add(new JLabel("Fax"));
                    }
                }, BorderLayout.WEST);
                add(new JPanel(new GridLayout(0, 1, 3, 3))
                {
                    {
                        add(nameField);
                        add(addressField);
                        add(phoneField);
                        add(faxField);
                    }
                }, BorderLayout.CENTER);

            }
        }, BorderLayout.NORTH);

        // Controller Part
        undoButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                stack.pop().undo();

            }

        });
        redoButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                stack.pop().redo();

            }

        });

        nameField.getDocument().addDocumentListener(new DocUpdater()
        {

            protected void change(String v)
            {
                Command c = new ChangeNameCommand(model, v);
                c.execute();
                stack.push(c);

            }
        });
        addressField.getDocument().addDocumentListener(new DocUpdater()
        {

            protected void change(String v)
            {
                model.setAddress(v);

            }
        });
        phoneField.getDocument().addDocumentListener(new DocUpdater()
        {

            protected void change(String v)
            {
                model.setPhone(v);

            }
        });
        faxField.getDocument().addDocumentListener(new DocUpdater()
        {

            protected void change(String v)
            {
                model.setFax(v);

            }

        });

    }

    private static abstract class DocUpdater implements DocumentListener
    {

        @Override
        public void insertUpdate(DocumentEvent e)
        {
            change0(e);

        }

        @Override
        public void removeUpdate(DocumentEvent e)
        {
            // change0(e);

        }

        @Override
        public void changedUpdate(DocumentEvent e)
        {
            // change0(e);

        }

        private void change0(DocumentEvent e)
        {
            final String v;
            try
            {
                v = e.getDocument().getText(0, e.getDocument().getLength());
                SwingUtilities.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        change(v);
                    }
                });
            }
            catch (BadLocationException e1)
            {
                // TODO Auto-generated catch block
                throw new RuntimeException(e1);
            }

        }

        protected abstract void change(String v);

    }
}
