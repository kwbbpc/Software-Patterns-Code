package com.javadude.composite;

import java.util.HashMap;
import java.util.Map;

public class WhatToDoVisitor {
	private Map<Class<?>, WhatToDo> map = new HashMap<Class<?>, WhatToDo>();
	public void register(Class<?> c, WhatToDo w) {
		map.put(c, w);
	}
	public void preVisit(Employee e) {
		WhatToDo whatToDo = map.get(e.getClass());
		whatToDo.doBefore(e);
	}
	public void postVisit(Employee e) {
		WhatToDo whatToDo = map.get(e.getClass());
		whatToDo.doAfter(e);
	}
}
