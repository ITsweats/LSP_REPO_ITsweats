package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads raw lines from the input CSV.
 * Responsibilities:
 * - Open the input file
 * - Read and return the header line
 * - Read raw data lines (one at a time)
 *
 * NOTE: This class does NOT:
 * - Trim quotes
 * - Split columns
 * - Validate row length
 * - Parse types
 * Those belong in ProductParser.
 */
public class ProductCsvReader implements AutoCloseable {
  private final String inputPath;
  private final BufferedReader reader;
  private boolean headerRead = false;

  public ProductCsvReader(String inputPath) throws IOException {
    this.inputPath = inputPath;
    this.reader = new BufferedReader(new FileReader(inputPath));
  }

  /**
   * Reads the first line of the CSV (the input header).
   * Must be called before reading data lines if you want the exact A2 behavior
   * of printing the input header.
   */
  public String readHeader() throws IOException {
    if (headerRead) {
      return null; // header already read
    }
    headerRead = true;
    return reader.readLine(); // may be null if file is empty
  }

  /**
   * Reads the next raw data line after the header.
   * Returns null when there are no more lines.
   */
  public String readNextLine() throws IOException {
    // If caller forgot to read header, we still ensure header is consumed first
    // so data processing starts after the first line.
    if (!headerRead) {
      readHeader();
    }
    return reader.readLine();
  }

  public String getInputPath() {
    return inputPath;
  }

  @Override
  public void close() throws IOException {
    reader.close();
  }
}