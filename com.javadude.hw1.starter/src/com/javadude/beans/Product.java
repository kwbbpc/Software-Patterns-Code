package com.javadude.beans;

/**
 * A product that can be purchased.
 * properties: read/write/bound: id, name, description, price
 */
public interface Product extends PropertyChangeNotifier {
	/** @return the id of the product */
	String getId();

	/**
	 * Set the product id
	 * @param id the product id
	 */
	void setId(String id);

	/** @return the name of the product */
	String getName();

	/**
	 * Set the product name
	 * @param id the product name
	 */
	void setName(String name);

	/** @return the description of the product */
	String getDescription();

	/**
	 * Set the product description
	 * @param id the product description
	 */
	void setDescription(String description);

	/** @return the price of the product (whole dollars) */
	int getPrice();

	/**
	 * Set the product price (in whole dollars)
	 * @param id the product price
	 */
	void setPrice(int price);
}
