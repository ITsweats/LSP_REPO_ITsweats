package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for holiday customers (15% discount).
 *
 * @author Nathan Hinds
 */
public class HolidayDiscount implements DiscountStrategy {

    /**
     * Applies a 15% discount to the original price.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}