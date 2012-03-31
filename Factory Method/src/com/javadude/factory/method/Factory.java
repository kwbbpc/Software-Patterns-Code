package com.javadude.factory.method;

import java.io.InputStream;
import java.util.Properties;

public class Factory {
	private static Properties properties = new Properties();
	private static Class<? extends Mammal> mammalClass;
	static {
		new AutoFileCloser() {
			@SuppressWarnings("unchecked")
			@Override protected void doWork() throws Throwable {
				InputStream is = autoClose(Factory.class.getResourceAsStream("factory.properties"));
				properties.load(is);
				String mammalClassName = properties.getProperty("mammal.class");
				mammalClass = (Class<? extends Mammal>) Class.forName(mammalClassName);
			}};
	}
	public static Mammal createMammal() {
		try {
			return mammalClass.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
