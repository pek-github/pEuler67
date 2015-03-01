package org.projecteuler.prob67;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * A row of the Triangle, essentially containing integer numbers
 * @author pek
 */
final class Row {
	
	private final List<Integer> numbers; // The numbers in a Row

	/**
	 * Constructor
	 * @param numbers A list of integers
	 */
	private Row(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	/**
	 * Factory method idiom to create a Row from a given text file line
	 * @param line The line of the text file to parse
	 * @return A new Row instance
	 */
	public static Row newRow(final String line) {
		List<Integer> nums = new ArrayList<Integer>();
		Scanner scanner = new Scanner(line);
		
		while (scanner.hasNextInt()) {
			nums.add(scanner.nextInt());
		}
		
		scanner.close();
		return new Row(nums);
	}
	
	/**
	 * Factory method idiom to create an empty Row
	 * @return A new empty Row instance
	 */
	public static Row newEmptyRow() {
		return new Row(new ArrayList<Integer>());
	}
	
	/**
	 * It sums this Row with a given Row and returns a Row with the result
	 * @param that The other Row to add with
	 * @return The result
	 */
	public Row sumWithRow (final Row that) {
		if (this.isEmpty()) {
			return that;
		} else if (that.isEmpty()) {
			return this;
		} else {
			return this.sumWith(that);
		}
	}

	/**
	 * Helper method for 'sumWithRow'
	 * @param that The other Row to add with
	 * @return A new Row with the result
	 */
	private Row sumWith (final Row that) {
		List<Integer> nums = new ArrayList<Integer>();
		
		for (int i = 0; i < that.length(); i++) {
			if (i == 0) {
				nums.add(that.at(0) + this.at(0));
			} else if (i == that.length() - 1) {
				nums.add(that.at(that.length() - 1) + this.at(this.length() - 1));
			}  else {
				int max = Math.max(this.at(i), this.at(i -1));
				nums.add(that.at(i) + max);
			}
		}
		
		return new Row(nums);
	}
	
	/**
	 * Returns \a true if this Row is empty, \a false otherwise
	 */
	public boolean isEmpty() {
		return numbers.isEmpty();
	}

	/**
	 * Returns how many numbers this Row contains
	 */
	public int length() {
		return numbers.size();
	}
	
	/**
	 * Accesses and returns the Row element at a given index
	 * @param index The index of the desired element
	 * @return The Row element at a given index
	 * @throws IndexOutOfBoundsException if index is out of range
	 * (It is a Runtime Exception, thus only documented)
	 */
	private Integer at(final int index) {
		if (index < 0 || index >= this.length()) {
			String msg = "Index is " + index 
						+ " while length is " + this.length();
			throw new IndexOutOfBoundsException(msg);
		}
		
		return this.numbers.get(index);
	}
	
	/**
	 * Finds and returns the maximum integer in the Row
	 * @throws IllegalStateException if Row is empty
	 * (It is a Runtime Exception, thus only documented)
	 */
	public Integer max() {
		if (this.isEmpty()) {
			throw new IllegalStateException("The Row is empty; cannot calculate MAX.");
		}
		
		return Collections.max(this.numbers);
	}
	
	/**
	 * Useful for inspection
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Integer num : numbers) {
			sb.append(num).append(" ");
		}
		
		return sb.toString();
	}
	
}
