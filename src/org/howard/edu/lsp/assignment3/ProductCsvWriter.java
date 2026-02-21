package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Writes transformed ProductRecord rows to the output CSV.
 * Responsibilities:
 * - Open output file
 * - Write output header
 * - Write each transformed row in the exact A2 format
 */
public class ProductCsvWriter implements AutoCloseable {
  private final String outputPath;
  private final BufferedWriter writer;
  private boolean headerWritten = false;

  public ProductCsvWriter(String outputPath) throws IOException {
    this.outputPath = outputPath;
    this.writer = new BufferedWriter(new FileWriter(outputPath));
  }

  /**
   * Writes the fixed output header exactly as in Assignment 2.
   * Safe to call multiple times; it will only write once.
   */
  public void writeHeader() throws IOException {
    if (headerWritten) {
      return;
    }
    writer.write("ProductID,Name,Price,Category,PriceRange");
    writer.newLine();
    headerWritten = true;
  }

  /**
   * Writes one transformed record as:
   * productId,name,price,category,priceRange
   *
   * Must match A2 formatting:
   * - price written using toPlainString()
   */
  public void writeRecord(ProductRecord record) throws IOException {
    // Ensure header exists before any records
    if (!headerWritten) {
      writeHeader();
    }

    int productId = record.getProductId();
    String name = record.getName();
    BigDecimal price = record.getPrice();
    String category = record.getCategory();
    String priceRange = record.getPriceRange();

    writer.write(productId + "," + name + "," + price.toPlainString() + "," + category + "," + priceRange);
    writer.newLine();
  }

  public String getOutputPath() {
    return outputPath;
  }

  @Override
  public void close() throws IOException {
    writer.close();
  }
}
