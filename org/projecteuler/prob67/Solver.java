package org.projecteuler.prob67;

/**
 * A solution for problems 18 and 67 of 'Project euler'.
 * The two problems are the same; only the size of the input varies.
 * That is, problem 67 is considered more challenging that 18.
 * An efficient algorithm can do them both, though.
 * @author pek
 */
final class Solver {

	/**
	 * It solves a given problem, 18 or 67
	 * @param problemId The id of the problem to solve
	 */
	public void solve(final int problemId) {
		printOpening(problemId);
		
		final String inputFileName = makeInputFileName(problemId);
		final Triangle triangle = Triangle.newTriangle(inputFileName);
		Row totalSum = Row.newEmptyRow();
		
		for (Row row : triangle.getRows()) {
			totalSum = totalSum.sumWithRow(row);
		}
		
		System.out.println("Maximum total is: " + totalSum.max());
		printClosing();
	}
	
	/**
	 * Creates and returns the name of the text file that 
	 * contains the input data for the problem
	 * @param problemId The id of the problem to solve
	 * @return
	 */
	private String makeInputFileName(final int problemId) {
		final String path = "/home/pek/workspace/projecteuler67/io/";
		final String fileNamePrefix = "p";
		final String fileNamePostfix = "_triangle.txt";
		final String fileNameId = String.format("%03d", problemId);
		
		final StringBuilder sb = new StringBuilder();
		sb.append(path).
			append(fileNamePrefix).
			append(fileNameId).
			append(fileNamePostfix);
		return sb.toString();
	}
	
	// -- methods for pretty display of solution ---
	
	private void printOpening(final int problemId) {
		String title 
			= String.format("Solution for \"Project Euler %d\" :", problemId);
		
		printLine();
		System.out.println(title);
	}
	
	private void printClosing() {
		printLine();
		System.out.println();
	}
	
	private void printLine() {
		System.out.println("----------------------------------------");
	}	
	
	/**
	 * Application starts here
	 * @param args No arguments needed
	 */
	public static void main(String[] args) {
		Solver solver = new Solver();
		solver.solve(18);
		solver.solve(67);
	}

}
