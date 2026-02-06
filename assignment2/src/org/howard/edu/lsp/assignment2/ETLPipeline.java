package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

	public static void main(String[] args) {
		String inputPath = "data/products.csv";
		String outputPath = "data/transformed_products.csv";
		
		int rowsRead = 0;
		int rowsTransformed = 0;
		int rowsSkipped = 0;

		File inputFile = new File(inputPath);
		if (!inputFile.exists()) {
		    System.out.println("Input file not found: " + inputPath);
		    return;
		}

		System.out.println("Found input file: " + inputPath);
		System.out.println("Will write output to: " + outputPath);
		
		try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
			     BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

			    // Read the input header 
			    String inputHeader = reader.readLine();

			    // Write the output header
			    writer.write("ProductID,Name,Price,Category,PriceRange");
			    writer.newLine();

			    System.out.println("Input header was: " + inputHeader);
			    
			    // Reads each line
			    String line;
			    while ((line = reader.readLine()) != null) {
			    	rowsRead++;

			    	// Removes wrapping quotes 
			    	String cleanedLine = line.trim();
			    	if (cleanedLine.startsWith("\"") && cleanedLine.endsWith("\"") && cleanedLine.length() >= 2) {
			    	    cleanedLine = cleanedLine.substring(1, cleanedLine.length() - 1);
			    	}
			    	
			    	// Skip blank lines
			    	if (cleanedLine.trim().isEmpty()) {
			    	    rowsSkipped++;
			    	    continue;
			    	}
			    	
			    	String[] parts = cleanedLine.split(",", -1);
			    	
			    	if (parts.length != 4) {
			            rowsSkipped++;
			            continue;
			        }

			    	
			    	String idStr = parts[0].trim();
			    	String name = parts[1].trim();
			    	name = name.toUpperCase();
			    	String priceStr = parts[2].trim();
			    	String category = parts[3].trim();

			    	int productId;
			    	BigDecimal price;

			    	try {
			    	    productId = Integer.parseInt(idStr);
			    	    price = new BigDecimal(priceStr);
			    	} catch (Exception e) {
			    	    rowsSkipped++;
			    	    continue;
			    	    
			    	}
			    	// Electronics discount + rounding
			    	boolean wasElectronics = category.equals("Electronics");

			    	if (wasElectronics) {
			    	    price = price.multiply(new BigDecimal("0.90"));
			    	}

			    	// Round to exactly 2 decimals 
			    	price = price.setScale(2, RoundingMode.HALF_UP);
			    	
			    	// Premium Electronics if > 500 after rounding
			    	if (wasElectronics && price.compareTo(new BigDecimal("500.00")) > 0) {
			    	    category = "Premium Electronics";
			    	}
			    	
			    	// Determine PriceRange
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
			    	
			    	writer.write(productId + "," + name + "," + price.toPlainString() + "," + category + "," + priceRange);
			    	writer.newLine();
			    	rowsTransformed++;
			    	
			    	System.out.println("Parsed ID = " + productId);
			    	System.out.println("Parsed Price = " + price);			    				    	


			    }
			    
			    System.out.println("Rows read: " + rowsRead);
			    System.out.println("Rows skipped: " + rowsSkipped);
			    System.out.println("Rows transformed: " + rowsTransformed);
			    System.out.println("Output written to: " + outputPath);
			    
			} catch (IOException e) {
			    System.out.println("Error processing files: " + e.getMessage());
			    return;
			}		
	}

}
