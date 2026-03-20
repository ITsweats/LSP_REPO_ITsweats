package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver class to test different discount strategies.
 *
 * @author Nathan Hinds
 */
public class Driver {

    public static void main(String[] args) {

        double price = 100.0;

        // REGULAR
        PriceCalculator calculator = new PriceCalculator(new RegularDiscount());
        System.out.println("REGULAR: " + calculator.calculatePrice(price));

        // MEMBER
        calculator.setStrategy(new MemberDiscount());
        System.out.println("MEMBER: " + calculator.calculatePrice(price));

        // VIP
        calculator.setStrategy(new VipDiscount());
        System.out.println("VIP: " + calculator.calculatePrice(price));

        // HOLIDAY
        calculator.setStrategy(new HolidayDiscount());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(price));
    }
}