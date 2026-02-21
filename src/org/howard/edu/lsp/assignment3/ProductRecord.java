package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents one product row in the ETL pipeline.
 * Holds both parsed and transformed values.
 */
public class ProductRecord {

  private int productId;
  private String name;
  private BigDecimal price;
  private String category;
  private String priceRange;

  public ProductRecord(int productId, String name, BigDecimal price, String category) {
    this.productId = productId;
    this.name = name;
    this.price = price;
    this.category = category;
  }

  // Getters
  public int getProductId() {
    return productId;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getCategory() {
    return category;
  }

  public String getPriceRange() {
    return priceRange;
  }

  // Setters (needed because transformer will modify some fields)
  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setPriceRange(String priceRange) {
    this.priceRange = priceRange;
  }
}