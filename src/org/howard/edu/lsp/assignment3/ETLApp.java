package org.howard.edu.lsp.assignment3;

import java.io.File;
import java.io.IOException;

public class ETLApp {

  public static void main(String[] args) {
    String inputPath = "data/products.csv";
    String outputPath = "data/transformed_products.csv";

    int rowsRead = 0;
    int rowsTransformed = 0;
    int rowsSkipped = 0;

    File inputFile = new File(inputPath);
    if (!inputFile.exists()) {
      // Must match A2 exactly
      System.out.println("Input file not found: " + inputPath);
      return;
    }

    // Must match A2 exactly
    System.out.println("Found input file: " + inputPath);
    System.out.println("Will write output to: " + outputPath);

    ProductParser parser = new ProductParser();
    ProductTransformer transformer = new ProductTransformer();

    try (ProductCsvReader reader = new ProductCsvReader(inputPath);
         ProductCsvWriter writer = new ProductCsvWriter(outputPath)) {

      // Read the input header (matches A2)
      String inputHeader = reader.readHeader();

      // Write the output header (matches A2)
      writer.writeHeader();

      // Must match A2 exactly
      System.out.println("Input header was: " + inputHeader);

      String line;
      while ((line = reader.readNextLine()) != null) {
        rowsRead++;

        // Parse + validate + skip rules (matches A2 skip behavior)
        ProductRecord record = parser.parseOrNull(line);
        if (record == null) {
          rowsSkipped++;
          continue;
        }

        // Transform (matches A2 rules + ordering)
        ProductRecord transformed = transformer.transformOne(record);

        // Write output row (matches A2 format)
        writer.writeRecord(transformed);
        rowsTransformed++;

        // Must match A2 exactly (prints the transformed values)
        System.out.println("Parsed ID = " + transformed.getProductId());
        System.out.println("Parsed Price = " + transformed.getPrice());
      }

      // Final summary prints (must match A2 exactly)
      System.out.println("Rows read: " + rowsRead);
      System.out.println("Rows skipped: " + rowsSkipped);
      System.out.println("Rows transformed: " + rowsTransformed);
      System.out.println("Output written to: " + outputPath);

    } catch (IOException e) {
      // Must match A2 exactly
      System.out.println("Error processing files: " + e.getMessage());
      return;
    }
  }
}