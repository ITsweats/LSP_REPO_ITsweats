package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Parses a raw CSV line into a ProductRecord or returns null if the row should be skipped.
 * This class mirrors Assignment 2's parsing + validation + skip behavior exactly.
 *
 * Responsibilities:
 * - Trim whitespace
 * - Remove wrapping quotes if the whole line is quoted
 * - Skip blank lines
 * - Split by comma into exactly 4 columns
 * - Parse productId (int) and price (BigDecimal)
 *
 * It does NOT:
 * - Apply transformations (uppercase, discount, rounding, etc.) -> ProductTransformer
 * - Write output -> ProductCsvWriter
 * - Track counters -> ETLApp
 */
public class ProductParser {

  public ProductRecord parseOrNull(String line) {
    if (line == null) {
      return null;
    }

    // Mirrors A2: cleanedLine = line.trim()
    String cleanedLine = line.trim();

    // Mirrors A2: remove wrapping quotes if line starts/ends with quote
    if (cleanedLine.startsWith("\"") && cleanedLine.endsWith("\"") && cleanedLine.length() >= 2) {
      cleanedLine = cleanedLine.substring(1, cleanedLine.length() - 1);
    }

    // Mirrors A2: skip blank lines
    if (cleanedLine.trim().isEmpty()) {
      return null;
    }

    // Mirrors A2: split into exactly 4 parts
    String[] parts = cleanedLine.split(",", -1);
    if (parts.length != 4) {
      return null;
    }

    String idStr = parts[0].trim();
    String name = parts[1].trim();
    String priceStr = parts[2].trim();
    String category = parts[3].trim();

    int productId;
    BigDecimal price;

    // Mirrors A2: try parse, otherwise skip
    try {
      productId = Integer.parseInt(idStr);
      price = new BigDecimal(priceStr);
    } catch (Exception e) {
      return null;
    }

    return new ProductRecord(productId, name, price, category);
  }
}