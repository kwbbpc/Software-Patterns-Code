package examples.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class App
{

    public static void main(String[] args)
    {
        final Person scott = new Person();

        scott.addName("Scott");
        scott.setAddress("123 Sesame");
        scott.setPhone("867-5309");
        scott.setAge(45);

        final Person nancy = new Person();
        nancy.addName("Nancy");
        nancy.setAddress("123 Sesame");
        nancy.setPhone("855-5555");
        nancy.setAge(46);

        scott.addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                System.out.println("Scott: " + evt.getNewValue());
            }
        });

        nancy.addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                System.out.println("Nancy: " + evt.getNewValue());
            }
        });

        scott.addPropertyChangeListener("address", new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                nancy.setAddress(scott.getAddress());
            }
        });

        nancy.addPropertyChangeListener("address", new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                scott.setAddress(nancy.getAddress());
            }
        });

        scott.setAge(46);
        scott.setAddress("10048 swith sift");

    }
}
