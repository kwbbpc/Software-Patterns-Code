package com.javadude.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class MyList<T> implements Iterable<T> {
	private List<T> stuff = new ArrayList<T>();

	public int size() {
		return stuff.size();
	}

	public boolean add(T e) {
		return stuff.add(e);
	}

	public T get(int index) {
		return stuff.get(index);
	}

	public T remove(int index) {
		return stuff.remove(index);
	}
	
	public Iterator<T> iterator() {
		return new MyListIterator();
	}
	private class MyListIterator implements Iterator<T> {
		private int index = 0;
		@Override public boolean hasNext() {
			return index != stuff.size();
		}

		@Override public T next() {
			if (!hasNext())
				throw new IllegalStateException();
			T thing = stuff.get(index);
			index++;
			return thing;
		}

		@Override
		public void remove() {
			index--;
			stuff.remove(index);
		}
	};
}
