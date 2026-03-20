package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for regular customers (no discount applied).
 *
 * @author Nathan Hinds
 */
public class RegularDiscount implements DiscountStrategy {

    /**
     * Returns the original price with no discount.
     *
     * @param price the original price
     * @return the final price (unchanged)
     */
    @Override
    public double calculatePrice(double price) {
        return price;
    }
}