package com.javadude.iterator;

import java.util.Iterator;

public class App {
	public static void main(String[] args) {
		MyList<String> stuff = new MyList<String>();
		
		stuff.add("Scott");
		stuff.add("Steve");
		stuff.add("Mary");
		stuff.add("Mike");
		
		Iterator<String> i = stuff.iterator();
		while (i.hasNext()) {
			String name = i.next();
			System.out.println(name);
			if ("Scott".equals(name))
				i.remove();
		}
		System.out.println("----");
		for (String string : stuff) {
			System.out.println(string);
		}
	}
}
