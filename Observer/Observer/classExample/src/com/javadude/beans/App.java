package com.javadude.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


// scott@javadude.com

public class App {
	public static void main(String[] args) {
		final Person scott = new Person();
		scott.setName("Scott");
		scott.setAddress("123 Sesame");
		scott.setPhone("867-5309");
		scott.setAge(45);
		
		final Person nancy = new Person();
		nancy.setName("Nancy");
		nancy.setAddress("123 Sesame");
		nancy.setPhone("123-4567");
		nancy.setAge(45);
		
		scott.addPropertyChangeListener(new PropertyChangeListener() {
			@Override public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("Scott: " + evt.getPropertyName() + " changed from " + evt.getOldValue() + " to " + evt.getNewValue());
			}});
		nancy.addPropertyChangeListener(new PropertyChangeListener() {
			@Override public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("Nancy: " + evt.getPropertyName() + " changed from " + evt.getOldValue() + " to " + evt.getNewValue());
			}});
		scott.addPropertyChangeListener("address", new PropertyChangeListener() {
			@Override public void propertyChange(PropertyChangeEvent evt) {
				nancy.setAddress(scott.getAddress());
			}});
		nancy.addPropertyChangeListener("address", new PropertyChangeListener() {
			@Override public void propertyChange(PropertyChangeEvent evt) {
				scott.setAddress(nancy.getAddress());
			}});
		
		scott.setAge(46);
		scott.setAddress("10430 Swift Stream");
	}
}
