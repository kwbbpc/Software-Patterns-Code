package com.javadude.beans;

import java.util.Map;

/**
 * A client through which we can perform actions on the system.
 */
public interface Client {
	/**
	 * Adds a listener that performs the actual work.
	 * @param commandListener the listener to add
	 */
	void addCommandListener(CommandListener commandListener);
	/**
	 * Removes a listener.
	 * @param commandListener the listener to remove
	 */
	void removeCommandListener(CommandListener commandListener);

	/**
	 * Request that a product be added to the current user's shopping cart.
	 * @param productId the id of the product to add
	 * @param quantity the number of that product to add
	 */
	void addToCart(String productId, int quantity) ;

	/**
	 * Request that a product be removed from the current user's shopping cart.
	 * @param productId the id of the product to remove
	 * @param quantity the number of that product to remove
	 */
	void removeFromCart(String productId, int quantity);

	/**
	 * Request that the specified items be returned to the shopping cart
	 * @param purchasedItems the items that had been purchased
	 */
	void returnPurchaseToCart(Map<String, Integer> purchasedItems);

	/**
	 * Purchase the items in the shopping cart.
	 */
	void purchaseCart();
}
