package com.javadude.composite;

public class App {
	public static void main(String[] args) {
		Reporter fp1 = new Reporter("Mike", "Front Page");
		fp1.setWhatToDo(new ReporterToDo());
		Reporter fp2 = new Reporter("Steve", "Front Page");
		fp2.setWhatToDo(new ReporterToDo());
		Reporter s1 = new Reporter("Sue", "Sports");
		s1.setWhatToDo(new ReporterToDo());
		Reporter s2 = new Reporter("MacGuyver", "Sports");
		s2.setWhatToDo(new ReporterToDo());
		Editor fpe = new Editor("Pee Wee", "Front Page");
		fpe.setWhatToDo(new EditorToDo());
		Editor se = new Editor("Ahnold", "Sports");
		se.setWhatToDo(new EditorToDo());
		EditorInChief e = new EditorInChief("Curious George W");
		e.setWhatToDo(new EditorInChiefToDo());
		
		e.add(se);
		e.add(fpe);
		
		fpe.add(fp1);
		fpe.add(fp2);
		
		se.add(s1);
		se.add(s2);
		
		e.doWork();
	}
}
