package com.javadude.factory.method;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple template-method wrapper for file I/O to handle exceptions
 */
public abstract class AutoFileCloser {
	private List<Closeable> closeables = new ArrayList<Closeable>();
	protected final <T extends Closeable> T autoClose(T closeable) {
		closeables.add(0, closeable);
		return closeable;
	}
	// TEMPLATE METHOD
	public AutoFileCloser() {
		Throwable pending = null;
		try {
			doWork(); // HOOK
		} catch (Throwable t) {
			pending = t;
		} finally {
			for (Closeable closeable : closeables) {
				try {
					closeable.close();
				} catch (Throwable t) {
					if (pending == null)
						pending = t;
				}
			}			
			if (pending != null) {
				if (pending instanceof RuntimeException)
					throw (RuntimeException) pending;
				else if (pending instanceof Error)
					throw (Error) pending;
				throw new RuntimeException(pending);
			}
		}
	}

	protected abstract void doWork() throws Throwable;
}
