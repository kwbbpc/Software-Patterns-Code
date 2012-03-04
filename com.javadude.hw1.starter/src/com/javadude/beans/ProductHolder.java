package com.javadude.beans;

import java.util.Map;

/**
 * Holds a map of products and a number of each.
 * properties: read/write/bound map: quantities
 *             read-only/derived/bound: empty, totalValue
 */
public interface ProductHolder extends PropertyChangeNotifier {
	/**
	 * Adds the specified quantity of the product to the map
	 * @param productId the product being held
	 * @param quantity the number of items to add
	 */
	void addQuantity(String productId, int quantity);

	/**
	 * Removes the specified quantity of the product from the map
	 * @param productId the product being held
	 * @param quantity the number of items to remove
	 */
	void removeQuantity(String productId, int quantity);

	/**
	 * Get the number of a specific product that is being held
	 * @param productId the product being held
	 * @return the number of that product being held
	 */
	int getQuantity(String productId);

	/**
	 * Get a map of all products and their quantities being held
	 * @return the product map, keyed by product id
	 */
	Map<String, Integer> getQuantities();

	/**
	 * Clear the product map
	 */
	void clear();

	/**
	 * @return true if the map is empty; false otherwise
	 */
	boolean isEmpty();

	/**
	 * How much the product holder costs (all items)
	 * @return the aggregate value of all the items in the map in pennies
	 */
	int getTotalValue();

	/**
	 * @return The catalog containing descriptions of the products in this map
	 */
	Catalog getCatalog();

	/**
	 * Set the catalog that contains descriptions of the products in this map
	 * @param catalog the catalog
	 */
	void setCatalog(Catalog catalog);
}
