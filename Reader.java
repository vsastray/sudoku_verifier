/*
 * Name: vsastray
 * Date: 2017-09-11
 * File: Reader.java
 *
 * Read in user's input.
 */

import java.util.Scanner;

/**
 * The Reader class read in user's input.
 */
public class Reader {

	private final static int SIDE_LENGTH = 9;
	private int size;
	private int[][] sudoku;

	public Reader(int length) {
		this.size = length;
		this.sudoku = new int[this.size][this.size];
	}

	/**
	 * Read in Sudoku problem.
	 */
	public void readByRow() {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < this.size; i++) {
			System.out.printf("Row %d:\n", i + 1);
			for(int j = 0; j < this.size; j++) {
				System.out.printf("\tCol %d: ", j + 1);
				this.sudoku[i][j] = sc.nextInt();
			}
		}
	}

	public static void main(String[] args) {
		// read in
		System.out.println("Please enter your Sudoku below. Enter 0 for empty blocks.");
		Reader r = new Reader(SIDE_LENGTH);
		r.readByRow();
		// verify
		Verifier v = new Verifier(r.sudoku);
		boolean isvalid = v.checkIfValid();
		if(isvalid) {
			System.out.println("The Sudoku puzzle is valid. Need solution? (yes/no): ");
		}
	}

}

