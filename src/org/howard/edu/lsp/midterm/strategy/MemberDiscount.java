package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for member customers (10% discount).
 *
 * @author Nathan Hinds
 */
public class MemberDiscount implements DiscountStrategy {

    /**
     * Applies a 10% discount to the original price.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}