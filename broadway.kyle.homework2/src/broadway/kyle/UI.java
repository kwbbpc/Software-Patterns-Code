package broadway.kyle;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import com.javadude.beans.Client;
import com.javadude.beans.Customer;
import com.javadude.beans.ProductHolder;
import com.javadude.command.UndoManager;

/**
 * The user interface for viewing what's going on in our model.
 * Please copy this class to your hw2 project and delete it from the starter
 *   code to avoid possible confusion in which one is being called.
 *
 * You should only be making changes to the code in the constructor; do not
 *   change any other code.
 */
public class UI extends JFrame
{
    private static final long serialVersionUID = 1L;

    private JLabel cartTotalLabel = new JLabel();
    private JLabel boughtItemsTotalLabel = new JLabel();

    private SimpleTextField idField;
    private SimpleTextField nameField;
    private SimpleTextField streetField;
    private SimpleTextField cityField;
    private SimpleTextField zipField;
    private SimpleTextField phoneField;
    private SimpleTextField passwordField;

    private JTextField productIdField = new JTextField("");
    private JTextField quantityField = new JTextField("");

    private JButton addButton = new JButton("Add to Cart");
    private JButton removeButton = new JButton("Remove from Cart");
    private JButton purchaseButton = new JButton("Purchase");
    private JButton undoButton = new JButton("Nothing to Undo");
    private JButton redoButton = new JButton("Nothing to Redo");

    private final Customer customer;
    private final Client client;

    public UI(ProductHolder inventory, Customer customer, Client client)
    {
        // DO NOT CHANGE THE FOLLOWING CODE
        this.customer = customer;
        this.client = client;
        undoButton.setEnabled(false);
        redoButton.setEnabled(false);
        getContentPane().setLayout(new BorderLayout(3, 3));
        JPanel tables = new JPanel(new GridLayout(0, 1, 5, 5));
        getContentPane().add(tables, BorderLayout.CENTER);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(createUser(customer), BorderLayout.NORTH);

        tables.add(createTable("Catalog", null, new ProductTableModel(inventory)));
        tables.add(createTable("Shopping Cart", cartTotalLabel, new ProductTableModel(customer.getCart())));
        tables.add(createTable("Bought Items", boughtItemsTotalLabel, new ProductTableModel(customer.getBoughtItems())));
        getContentPane().add(createActions(), BorderLayout.SOUTH);
        pack();

        setupController();
    }

    private void setupController()
    {
        // START YOUR CHANGES HERE
        final UndoManager undoManager = new UndoManagerImpl();

        // listen to each text field - when its "text" property changes, update the property in the
        //      customer
        PropertyChangeListener textFieldListener = new PropertyChangeListener()
        {

            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                if ("id".equals(evt.getPropertyName()))
                {
                    customer.setId(evt.getNewValue().toString());
                }
                else if ("name".equals(evt.getPropertyName()))
                {
                    customer.setName(evt.getNewValue().toString());
                }
                else if ("street".equals(evt.getPropertyName()))
                {
                    customer.setStreet(evt.getNewValue().toString());
                }
                else if ("city".equals(evt.getPropertyName()))
                {
                    customer.setCity(evt.getNewValue().toString());
                }
                else if ("zip".equals(evt.getPropertyName()))
                {
                    customer.setZip(evt.getNewValue().toString());
                }
                else if ("phone".equals(evt.getPropertyName()))
                {
                    customer.setPhone(evt.getNewValue().toString());
                }
                else if ("password".equals(evt.getPropertyName()))
                {
                    customer.setPassword(evt.getNewValue().toString());
                }

                System.out.println("Text field [" + evt.getPropertyName() + "] changed from [" + evt.getOldValue() + "] to [" + evt.getNewValue() + "].");

            }

        };
        //Add the listeners
        idField.addPropertyChangeListener(textFieldListener);
        nameField.addPropertyChangeListener(textFieldListener);
        streetField.addPropertyChangeListener(textFieldListener);
        cityField.addPropertyChangeListener(textFieldListener);
        zipField.addPropertyChangeListener(textFieldListener);
        phoneField.addPropertyChangeListener(textFieldListener);
        passwordField.addPropertyChangeListener(textFieldListener);

        // listen to the customer - when any of its String properties change, update the corresponding text field
        PropertyChangeListener customerListener = new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {

                if ("id".equals(evt.getPropertyName()))
                {
                    idField.setText(evt.getNewValue().toString());
                }
                else if ("name".equals(evt.getPropertyName()))
                {
                    nameField.setText(evt.getNewValue().toString());
                }
                else if ("street".equals(evt.getPropertyName()))
                {
                    streetField.setText(evt.getNewValue().toString());
                }
                else if ("city".equals(evt.getPropertyName()))
                {
                    cityField.setText(evt.getNewValue().toString());
                }
                else if ("zip".equals(evt.getPropertyName()))
                {
                    zipField.setText(evt.getNewValue().toString());
                }
                else if ("phone".equals(evt.getPropertyName()))
                {
                    phoneField.setText(evt.getNewValue().toString());
                }
                else if ("password".equals(evt.getPropertyName()))
                {
                    passwordField.setText(evt.getNewValue().toString());
                }

                System.out.println("Customer property [" + evt.getPropertyName() + "] changed from [" + evt.getOldValue() + "] to [" + evt.getNewValue() + "].");

            }

        };
        //add the customer listener
        customer.addPropertyChangeListener(customerListener);

        // listen for "totalValue" property changes (on the customer and his shopping cart)
        //      when these change, update the corresponding labels (by calling setText() on them)
        PropertyChangeListener totalValueListener = new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {

                if ("totalValue".equals(evt.getPropertyName()))
                {
                    boughtItemsTotalLabel.setText(Integer.toString(customer.getBoughtItems().getTotalValue()));
                    cartTotalLabel.setText(Integer.toString(customer.getCart().getTotalValue()));
                }

                System.out.println("Cart value changed to [" + customer.getBoughtItems().getTotalValue() + "].");
                System.out.println("Cart value changed to [" + customer.getCart().getTotalValue() + "].");

            }

        };
        customer.getBoughtItems().addPropertyChangeListener(totalValueListener);
        customer.getCart().addPropertyChangeListener(totalValueListener);

        // add ActionListeners to the following buttons:
        //      addButton: make undoManager execute AddToCartCommand (get product id/quantity from fields)
        //      removeButton: make undoManager execute RemoveFromCartCommand (get product id/quantity from fields)
        //      purchaseButton: make undoManager execute PurchaseCommand
        //      undoButton: call undoManager's undo()
        //      redoButton: call undoManager's redo()
        addButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                undoManager.execute(new AddToCartCommand(client, productIdField.getText(), Integer.parseInt(quantityField.getText())));
            }
        });
        removeButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                undoManager.execute(new RemoveFromCartCommand(client, productIdField.getText(), Integer.parseInt(quantityField.getText())));
            }

        });
        purchaseButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                undoManager.execute(new PurchaseCommand(client, customer.getCart()));
            }

        });
        undoButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                undoManager.undo();
            }

        });
        redoButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                undoManager.redo();
            }

        });

        // listen to undoManager - when his undoName or redoName properties change,
        //      update the text on the undoButton and redoButton  (eg: "Undo add item 42 to cart")
        //      if the text is null, set to "Nothing to Undo" (or Redo) and setEnabled(false) on button
        //      if the text is non-null, set to "Undo <<undo name>>" and setEnabled(true) on button
        PropertyChangeListener undoManagerListener = new PropertyChangeListener()
        {

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

        };
        undoManager.addPropertyChangeListener(undoManagerListener);

    }

    private JPanel createTable(String title, JLabel totalLabel, TableModel tableModel)
    {
        // DO NOT CHANGE ANYTHING IN THIS METHOD
        JPanel panel = new JPanel(new BorderLayout(3, 3));
        panel.setBorder(new TitledBorder(title));
        if (totalLabel != null)
        {
            JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            totalLabel.setText("0.00");
            bottom.add(new JLabel("Total: "));
            bottom.add(totalLabel);
            panel.add(bottom, BorderLayout.SOUTH);
        }
        JTable table = new JTable(tableModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createUser(Customer customer)
    {
        // DO NOT CHANGE ANYTHING IN THIS METHOD
        JPanel userData = new JPanel(new BorderLayout(3, 3));
        idField = new SimpleTextField(customer.getId());
        nameField = new SimpleTextField(customer.getName());
        streetField = new SimpleTextField(customer.getStreet());
        cityField = new SimpleTextField(customer.getCity());
        zipField = new SimpleTextField(customer.getZip());
        phoneField = new SimpleTextField(customer.getPhone());
        passwordField = new SimpleTextField(customer.getPassword());
        userData.setBorder(new TitledBorder("Customer"));
        JPanel labels = new JPanel(new GridLayout(0, 1, 2, 2));
        JPanel fields = new JPanel(new GridLayout(0, 1, 2, 2));
        userData.add(labels, BorderLayout.WEST);
        userData.add(fields, BorderLayout.CENTER);
        labels.add(new JLabel("ID"));
        labels.add(new JLabel("Name"));
        labels.add(new JLabel("Street"));
        labels.add(new JLabel("City"));
        labels.add(new JLabel("Zip"));
        labels.add(new JLabel("Phone"));
        labels.add(new JLabel("Password"));
        fields.add(idField);
        fields.add(nameField);
        fields.add(streetField);
        fields.add(cityField);
        fields.add(zipField);
        fields.add(phoneField);
        fields.add(passwordField);
        return userData;
    }

    private JPanel createActions()
    {
        // DO NOT CHANGE ANYTHING IN THIS METHOD
        JPanel actions = new JPanel(new BorderLayout(3, 3));
        actions.setBorder(new TitledBorder("Actions"));
        JPanel inputs = new JPanel(new GridLayout(1, 0, 5, 5));
        JPanel idPanel = new JPanel(new BorderLayout(3, 3));
        idPanel.add(new JLabel("Product Id:"), BorderLayout.WEST);
        idPanel.add(productIdField, BorderLayout.CENTER);
        inputs.add(idPanel);
        JPanel quantityPanel = new JPanel(new BorderLayout(3, 3));
        quantityPanel.add(new JLabel("Quantity:"), BorderLayout.WEST);
        quantityPanel.add(quantityField, BorderLayout.CENTER);
        inputs.add(quantityPanel);
        actions.add(inputs, BorderLayout.NORTH);
        JPanel buttons1 = new JPanel(new FlowLayout());
        JPanel buttons2 = new JPanel(new FlowLayout());

        buttons1.add(addButton);
        buttons1.add(removeButton);
        buttons1.add(purchaseButton);
        buttons2.add(undoButton);
        buttons2.add(redoButton);
        actions.add(buttons1, BorderLayout.CENTER);
        actions.add(buttons2, BorderLayout.SOUTH);
        return actions;
    }
}
