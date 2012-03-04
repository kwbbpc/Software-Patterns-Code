package com.javadude.observer;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.javadude.annotations.Observable;

@Observable
public class WeatherStation {
	private List<SunListener> listeners = new ArrayList<SunListener>();
	public void addSunListener(SunListener listener) {
		synchronized (listeners) {
			listeners.add(listener);
		}
	}
	public void removeSunListener(SunListener listener) {
		synchronized (listeners) {
			listeners.remove(listener);
		}
	}
	
	@SuppressWarnings("serial")
	public WeatherStation() {
		new Frame() {{
			setLayout(new GridLayout(1,0,3,3));
			add(new Button("Rise") {{
				addActionListener(new ActionListener() {
					@Override public void actionPerformed(ActionEvent arg0) {
						fireSunRose(new Date());
					}});
			}});
			add(new Button("Set") {{
				addActionListener(new ActionListener() {
					@Override public void actionPerformed(ActionEvent arg0) {
						fireSunSet(new Date());
					}});
			}});
			addWindowListener(new WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					System.exit(0);
				}
			});
			setSize(300,200);
			setVisible(true);
		}};
	}
	
	private void fireSunRose(Date date) {
		List<SunListener> targets;
		synchronized (listeners) {
			targets = new ArrayList<SunListener>(listeners);
		}
		
		for (SunListener listener : targets) {
			listener.sunRose(date);
		}
	}
	private void fireSunSet(Date date) {
		List<SunListener> targets;
		synchronized (listeners) {
			targets = new ArrayList<SunListener>(listeners);
		}
		
		for (SunListener listener : targets) {
			listener.sunSet(date);
		}
	}
}
