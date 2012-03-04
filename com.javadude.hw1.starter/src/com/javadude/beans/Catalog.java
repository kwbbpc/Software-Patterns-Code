package com.javadude.beans;

import java.util.Map;

/**
 * A catalog of products. Each product is keyed by its product id.
 *
 * Properties: read/write/bound map: products
 */
public interface Catalog extends PropertyChangeNotifier {
	/**
	 * Add a product to the catalog. The product's id is used as the key.
	 * @param product the product to add to the catalog
	 */
	void addProduct(Product product);

	/**
	 * Remove a product from the catalog.
	 * @param productId the id of the product to remove
	 */
	void removeProduct(String productId);

	/**
	 * Lookup a product by its id.
	 * @param productId the product id to search for.
	 * @return the product if found; null if not found
	 */
	Product getProduct(String productId);

	/**
	 * Retrieve a map of all products in the catalog. Each product is
	 * keyed by its id.
	 * @return a read-only version of the product map
	 */
	Map<String, Product> getProducts();
}
