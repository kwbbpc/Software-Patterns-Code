package broadway.kyle;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

    private JLabel cartTotalLabel = FactoryHomework2.createJLabel();
    private JLabel boughtItemsTotalLabel = FactoryHomework2.createJLabel();

    private SimpleTextField idField;
    private SimpleTextField nameField;
    private SimpleTextField streetField;
    private SimpleTextField cityField;
    private SimpleTextField zipField;
    private SimpleTextField phoneField;
    private SimpleTextField passwordField;

    private JTextField productIdField = FactoryHomework2.createJTextField("");
    private JTextField quantityField = FactoryHomework2.createJTextField("");

    private JButton addButton = FactoryHomework2.createJButton("Add to Cart");
    private JButton removeButton = FactoryHomework2.createJButton("Remove from Cart");
    private JButton purchaseButton = FactoryHomework2.createJButton("Purchase");
    private JButton undoButton = FactoryHomework2.createJButton("Nothing to Undo");
    private JButton redoButton = FactoryHomework2.createJButton("Nothing to Redo");

    private final Customer customer;
    private final Client client;

    UI(ProductHolder inventory, Customer customer, Client client)
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
        final UndoManager undoManager = FactoryHomework2.createUndoManager();

        // listen to each text field - when its "text" property changes, update the property in the
        //      customer
        PropertyChangeListener textFieldListener = FactoryPropertyChange.createPropertyChangeListener(FactoryHomework2.createEventActionTextField(customer));

        //Add the listeners
        idField.addPropertyChangeListener(textFieldListener);
        nameField.addPropertyChangeListener(textFieldListener);
        streetField.addPropertyChangeListener(textFieldListener);
        cityField.addPropertyChangeListener(textFieldListener);
        zipField.addPropertyChangeListener(textFieldListener);
        phoneField.addPropertyChangeListener(textFieldListener);
        passwordField.addPropertyChangeListener(textFieldListener);

        // listen to the customer - when any of its String properties change, update the corresponding text field
        PropertyChangeListener customerListener = FactoryPropertyChange.createPropertyChangeListener(FactoryHomework2.createEventActionCustomer(idField, nameField, streetField, cityField, zipField, phoneField, passwordField));

        //add the customer listener
        customer.addPropertyChangeListener(customerListener);

        // listen for "totalValue" property changes (on the customer and his shopping cart)
        //      when these change, update the corresponding labels (by calling setText() on them)
        PropertyChangeListener totalValueListener = FactoryPropertyChange.createPropertyChangeListener(FactoryHomework2.createEventActionTotalValue(cartTotalLabel, boughtItemsTotalLabel, customer));
        customer.getBoughtItems().addPropertyChangeListener(totalValueListener);
        customer.getCart().addPropertyChangeListener(totalValueListener);

        // add ActionListeners to the following buttons:
        //      addButton: make undoManager execute AddToCartCommand (get product id/quantity from fields)
        //      removeButton: make undoManager execute RemoveFromCartCommand (get product id/quantity from fields)
        //      purchaseButton: make undoManager execute PurchaseCommand
        //      undoButton: call undoManager's undo()
        //      redoButton: call undoManager's redo()
        addButton.addActionListener(FactoryHomework2.createActionListener(FactoryHomework2.createActionAdd(client, productIdField, quantityField, undoManager)));

        removeButton.addActionListener(FactoryHomework2.createActionListener(FactoryHomework2.createActionRemove(client, productIdField, quantityField, undoManager)));

        purchaseButton.addActionListener(FactoryHomework2.createActionListener(FactoryHomework2.createActionPurchase(client, customer, undoManager)));

        undoButton.addActionListener(FactoryHomework2.createActionListener(FactoryHomework2.createActionUndo(undoManager)));

        redoButton.addActionListener(FactoryHomework2.createActionListener(FactoryHomework2.createActionRedo(undoManager)));

        // listen to undoManager - when his undoName or redoName properties change,
        //      update the text on the undoButton and redoButton  (eg: "Undo add item 42 to cart")
        //      if the text is null, set to "Nothing to Undo" (or Redo) and setEnabled(false) on button
        //      if the text is non-null, set to "Undo <<undo name>>" and setEnabled(true) on button
        PropertyChangeListener undoManagerListener = FactoryPropertyChange.createPropertyChangeListener(FactoryHomework2.createEventActionUndoManager(undoButton, redoButton, undoManager));

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
