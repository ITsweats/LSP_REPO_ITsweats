package org.howard.edu.lsp.midterm.strategy;

/**
 * Defines the strategy for calculating a discounted price.
 *
 * @author Nathan Hinds
 */
public interface DiscountStrategy {

    /**
     * Calculates the final price after applying the discount strategy.
     *
     * @param price the original price
     * @return the final discounted price
     */
    double calculatePrice(double price);
}