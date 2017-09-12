/*
 * Name: vsastray
 * Date: 2017-09-11
 * File: Verifier.java
 *
 * Verify Sudoku.
 */

/**
 * The Verifier class check whether a Sudoku is valid.
 */
public class Verifier {

	private int sudoku[][];
	private int size;

	public Verifier(int sudoku[][]) {
		this.sudoku = sudoku;
		this.size = sudoku.length;
	}

	public boolean checkIfValid() {
		// check each row
		for(int i = 0; i < this.size; i++) {
			int flag[] = new int[this.size];
			int temp;
			for(int j = 0; j < this.size; j++) {
				temp = this.sudoku[i][j];
				// check if the number >= 0
				if(temp < 0) {
					System.out.println("Invalid: Negative number");
					return false;
				}
				// check if the number <= this.size
				if(temp > this.size) {
					System.out.println("Invalid: Large number");
					return false;
				}

				// check repetition
				if(temp != 0) {
					if(flag[temp - 1] != 0) {
						System.out.println("Invalid: Same number in one row");
						return false;
					} else {
						flag[temp - 1]++;
					}
				}
			}
		}

		// check each column
		for(int j = 0; j < this.size; j++) {
			int flag[] = new int[this.size];
			int temp;
			for(int i = 0; i < this.size; i ++) {
				temp = this.sudoku[i][j];

				// check repetition
				if(temp != 0) {
					if(flag[temp - 1] != 0) {
						System.out.println("Invalid: Same number in one column");
						return false;
					} else {
						flag[temp - 1]++;
					}
				}
			}
		}

		// check each subgrid
		int subsize = (int)Math.sqrt(this.size);
		int r_offset = 0;
		int c_offset = 0;
		for(int k = 0; k < this.size; k++) {
			int flag[] = new int[this.size];
			int temp;

			for(int i = 0; i < subsize; i++) {
				
				for(int j = 0; j < subsize; j++) {
					temp = this.sudoku[i + r_offset][j + c_offset];

					// check repetition
					if(temp != 0) {
						if(flag[temp - 1] != 0) {
							System.out.println("Invalid: Same number in one subgrid");
							return false;
						} else {
							flag[temp - 1]++;
						}
					}
				}
			}

			r_offset = (r_offset + subsize) % this.size;
			// if is to check subgrids in next line
			if(r_offset == 0) {
				c_offset += subsize;
			}
		}

		return true;
	}

}