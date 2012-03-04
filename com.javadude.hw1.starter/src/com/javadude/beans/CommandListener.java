package com.javadude.beans;

import java.util.Map;

/**
 * Allows separate actions to be associated with client requests.
 */
public interface CommandListener {
	/**
	 * The client is being asked to add items to a cart. This command listener
	 * can use this notification to perform an action.
	 * @param productId the id of the product being added to the cart
	 * @param quantity the number of that product being added
	 */
	void addToCart(String productId, int quantity);

	/**
	 * The client is being asked to remove items from a cart. This command
	 * listener can use this notification to perform an action.
	 * @param productId the id of the product being removed to the cart
	 * @param quantity the number of that product being removed
	 */
	void removeFromCart(String productId, int quantity);

	/**
	 * The client is being asked to return purchased items to a cart.
	 * This command listener can use this notification to perform an action.
	 * @param purchasedItems the items being returned
	 */
	void returnPurchaseToCart(Map<String, Integer> purchasedItems);

	/**
	 * The client is being asked to purchased items from a cart.
	 * This command listener can use this notification to perform an action.
	 */
	void purchaseCart();
}
