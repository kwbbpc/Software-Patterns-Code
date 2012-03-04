package sample;

import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class App
{

    public static void main(String[] args)
    {

        final Person p = new Person();

        p.addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                System.out.println(evt.getPropertyName() + " change from " + evt.getOldValue() + " to " + evt.getNewValue());
            }
        });

        new JFrame()
        {
            {
                setLayout(new GridLayout(0, 1, 3, 3));
                PersonUI ui = new PersonUI();
                ui.setModel(p);
                add(ui);
                ui = new PersonUI();
                ui.setModel(p);
                add(ui);
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setVisible(true);
            }
        };
    }
}
