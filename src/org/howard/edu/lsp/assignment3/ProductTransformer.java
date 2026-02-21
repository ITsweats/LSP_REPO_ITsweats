package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Applies Assignment 2 transformations to ProductRecord objects.
 * Responsibilities:
 * - Uppercase product name
 * - Apply 10% discount for Electronics
 * - Round price to 2 decimals (HALF_UP)
 * - Re-label category to "Premium Electronics" if Electronics and price > 500.00 (after rounding)
 * - Compute PriceRange bucket from rounded price
 */
public class ProductTransformer {

  public List<ProductRecord> transformAll(List<ProductRecord> input) {
    List<ProductRecord> out = new ArrayList<>();
    for (ProductRecord r : input) {
      out.add(transformOne(r));
    }
    return out;
  }

  public ProductRecord transformOne(ProductRecord record) {
    // Name -> uppercase (matches A2)
    String name = record.getName();
    if (name != null) {
      record.setName(name.toUpperCase());
    }

    String category = record.getCategory();
    BigDecimal price = record.getPrice();

    // Electronics discount + rounding (matches A2)
    boolean wasElectronics = (category != null && category.equals("Electronics"));

    if (wasElectronics) {
      price = price.multiply(new BigDecimal("0.90"));
    }

    // Round to exactly 2 decimals (HALF_UP) (matches A2)
    price = price.setScale(2, RoundingMode.HALF_UP);
    record.setPrice(price);

    // Premium Electronics if > 500 after rounding (matches A2)
    if (wasElectronics && price.compareTo(new BigDecimal("500.00")) > 0) {
      category = "Premium Electronics";
      record.setCategory(category);
    }

    // Determine PriceRange from rounded price (matches A2)
    String priceRange;
    if (price.compareTo(new BigDecimal("10.00")) <= 0) {
      priceRange = "Low";
    } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
      priceRange = "Medium";
    } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
      priceRange = "High";
    } else {
      priceRange = "Premium";
    }

    record.setPriceRange(priceRange);
    return record;
  }
}