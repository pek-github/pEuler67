package org.projecteuler.prob67;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A Triangle representing the numeric data structure of the problem
 * @author pek
 */
final class Triangle {
	private final List<Row> rows; // The Rows contained in the Triangle

	/**
	 * Constructor
	 * @param numbers A list of rows
	 */
	private Triangle (final List<Row> rows) {
		this.rows = rows;
	}
	
	/**
	 * Factory method idiom to create a Triangle from a given text file
	 * @param inputFile The filename of the text file to open and parse
	 * @return A new Triangle instance
	 */
	public static Triangle newTriangle (final String inputFile) {
		List<Row> readRows = new ArrayList<Row>();
		
		try (BufferedReader input = new BufferedReader(new FileReader(new File(inputFile)))) {
			String line;
			
			while ((line = input.readLine()) != null) {
				if (!line.trim().isEmpty()) {
					readRows.add(Row.newRow(line.trim()));
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File " + inputFile + " does not exist");
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println("Cannot read from file: " + inputFile);
			System.err.println(e.getMessage());
		}
		
		return new Triangle(readRows);
	}
	
	/**
	 * Returns how many rows this Triangle contains
	 */
	public int height() {
		return rows.size();
	}
	
	/**
	 * Returns an Iterable of all rows this Triangle contains
	 */
	public Iterable<Row> getRows() {
		return rows;
	}
	
	/**
	 * Useful for inspection
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Row row : rows) {
			sb.append(row).append("\n");
		}
		
		return sb.toString();
	} 
}
