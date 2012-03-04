package examples.observer;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherStation
{
    private List<SunListener> listeners = new ArrayList<SunListener>();

    public void addSunListener(SunListener listener)
    {
        listeners.add(listener);
    }

    public void removeSunListener(SunListener listener)
    {
        listeners.remove(listener);
    }

    // GUI
    public WeatherStation()
    {
        Frame frame = new Frame()
        {
            {
                setLayout(new GridLayout(1, 0, 3, 3));
                add(new Button("Rise")
                {
                    {
                        addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                fireSunRose(new Date());
                            }
                        });
                    }
                });
                add(new Button("Set")
                {
                    {
                        addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent arg0)
                            {
                                fireSunSet(new Date());
                            }
                        });
                    }
                });
                addWindowListener(new WindowAdapter()
                {
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);

                    }
                });
                setSize(300, 200);
                setVisible(true);

            }
        };
    }

    private void fireSunRose(Date date)
    {
        for (SunListener listener : listeners)
        {
            listener.sunRose(date);
        }
    }

    private void fireSunSet(Date date)
    {
        for (SunListener listener : listeners)
        {
            listener.sunSet(date);
        }
    }
}
