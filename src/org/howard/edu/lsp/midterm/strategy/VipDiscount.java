package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for VIP customers (20% discount).
 *
 * @author Nathan Hinds
 */
public class VipDiscount implements DiscountStrategy {

    /**
     * Applies a 20% discount to the original price.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}