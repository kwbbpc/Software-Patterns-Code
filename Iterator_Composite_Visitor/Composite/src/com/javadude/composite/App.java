package com.javadude.composite;

public class App {
	public static void main(String[] args) {
		Reporter fp1 = new Reporter("Mike", "Front Page");
		Reporter fp2 = new Reporter("Steve", "Front Page");
		Reporter s1 = new Reporter("Sue", "Sports");
		Reporter s2 = new Reporter("MacGuyver", "Sports");
		Editor fpe = new Editor("Pee Wee", "Front Page");
		Editor se = new Editor("Ahnold", "Sports");
		EditorInChief e = new EditorInChief("Curious George W");
		
		e.add(se);
		e.add(fpe);
		
		fpe.add(fp1);
		fpe.add(fp2);
		
		se.add(s1);
		se.add(s2);
		
		e.doWork();
	}
}
