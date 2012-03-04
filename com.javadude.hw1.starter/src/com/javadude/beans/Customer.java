package com.javadude.beans;

/**
 * Represents a customer who will be purchasing items.
 * properties:
 *   read/write/bound: id, name, street, city, zip, phone, password, cart
 */
public interface Customer extends PropertyChangeNotifier {
	/** @return the customer id */
	String getId();

	/**
	 * set the customer's id
	 * @param id the id to set
	 */
	void setId(String id);

	/** @return the customer name */
	String getName();

	/**
	 * set the customer's name
	 * @param id the name to set
	 */
	void setName(String name);

	/** @return the customer street */
	String getStreet();

	/**
	 * set the customer's street
	 * @param id the street to set
	 */
	void setStreet(String street);

	/** @return the customer city */
	String getCity();

	/**
	 * set the customer's city
	 * @param id the city to set
	 */
	void setCity(String city);

	/** @return the customer zip code */
	String getZip();

	/**
	 * set the customer's zip code
	 * @param id the zip code to set
	 */
	void setZip(String zip);

	/** @return the customer phone number */
	String getPhone();

	/**
	 * set the customer's phone number
	 * @param id the phone number to set
	 */
	void setPhone(String phone);

	/** @return the customer password */
	String getPassword();

	/**
	 * set the customer's password
	 * @param id the password to set
	 */
	void setPassword(String password);

	/** @return the customer's shopping cart */
	ProductHolder getCart();

	/**
	 * set the customer's shopping cart
	 * @param id the shopping cart to set
	 */
	void setCart(ProductHolder cart);

	/** @return the customer's collection of purchased items */
	ProductHolder getBoughtItems();

	/**
	 * set the customer's purchased items holder
	 * @param id the purchased items holder to set
	 */
	void setBoughtItems(ProductHolder cart);
}
