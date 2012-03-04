package examples.observer;

import java.util.Date;

import examples.annotations.Observable;

@Observable
public class Student implements SunListener
{

    private String name;

    public Student(String name)
    {
        this.name = name;
    }

    @Override
    public void sunRose(Date date)
    {
        System.out.println(name + ": sun rose at " + date);

    }

    @Override
    public void sunSet(Date date)
    {
        System.out.println(name + ": sun set at " + date);
    }
}
