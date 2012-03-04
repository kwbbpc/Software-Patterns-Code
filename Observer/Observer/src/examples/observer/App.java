package examples.observer;

public class App
{

    public static void main(String[] args)
    {
        WeatherStation weatherStation = new WeatherStation();

        Student bill = new Student("Billy");
        Student sill = new Student("Silly");
        Student will = new Student("Willy");
        Student cill = new Student("Cilly");
        Student yill = new Student("Yilly");

        weatherStation.addSunListener(bill);
        weatherStation.addSunListener(sill);
        weatherStation.addSunListener(will);
        weatherStation.addSunListener(cill);
        weatherStation.addSunListener(yill);
    }

}
