package com.javadude.observer;

public class App {
	public static void main(String[] args) {
		WeatherStation weatherStation = new WeatherStation();
		
		Student billy = new Student("Billy");
		Student willy = new Student("Willy");
		Student silly = new Student("Silly");
		Student sally = new Student("Sally");
		
		weatherStation.addSunListener(sally);
		weatherStation.addSunListener(billy);
		weatherStation.addSunListener(willy);
		weatherStation.addSunListener(silly);
	}
}
