package org.howard.edu.lsp.midterm.strategy;

/**
 * Uses a DiscountStrategy to calculate the final price.
 *
 * @author Nathan Hinds
 */
public class PriceCalculator {

    private DiscountStrategy strategy;

    /**
     * Constructs a PriceCalculator with a given discount strategy.
     *
     * @param strategy the discount strategy to use
     */
    public PriceCalculator(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Sets a new discount strategy.
     *
     * @param strategy the new discount strategy
     */
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates the final price using the current strategy.
     *
     * @param price the original price
     * @return the final discounted price
     */
    public double calculatePrice(double price) {
        return strategy.calculatePrice(price);
    }
}