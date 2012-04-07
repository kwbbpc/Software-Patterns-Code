package com.javadude.adapter;

public class PersonBean implements Person {
	private String name;
	private int age;
	/* (non-Javadoc)
	 * @see com.javadude.adapter.Person#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see com.javadude.adapter.Person#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see com.javadude.adapter.Person#getAge()
	 */
	@Override
	public int getAge() {
		return age;
	}
	/* (non-Javadoc)
	 * @see com.javadude.adapter.Person#setAge(int)
	 */
	@Override
	public void setAge(int age) {
		this.age = age;
	}
}
