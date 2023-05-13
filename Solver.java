/*
 * Name: vsastray
 * Date: 2017-09-12
 * File: Solver.java
 *
 * Solve Sudoku.
 */

/**
 * The Solver class solve a valid Sudoku.
 */
public class Solver {

	private int size;
	private int sudoku[][];

	public Solver(int sudoku[][]) {
		this.size = sudoku.length;
		// deep copy
		this.sudoku = new int[this.size][this.size];
		for(int i = 0; i < this.size; i++) {
			for(int j = 0; j < this.size; j++) {
				this.sudoku[i][j] = sudoku[i][j];
			}
		}
	}

	public void solve() {
		// find the first 0 in the Sudoku
		int i, j;
		for(i = 0; i < this.size; i++) {
			for(j = 0; j < this.size; j++) {
				if(this.sudoku[i][j] == 0) {
					break;
				}
			}
		}
		// start solving (try one by one)
		boolean issolved = false;
		int k = 1;
		while(!issolved && k <= this.size) {
			issolved = this.solve_rec(i, j, k);
			k++;
		}
	}

	private boolean solve_rec(int row, int col, int val) {
		this.sudoku[i][j] = val;

		// check if the Sudoku is still valid
		Verifier v = new Verifier(this.sudoku);
		if(!v.checkIfValid) {
			return false;
		}

		int i, j, k;
		boolean issolved;
		for(i = row; i < this.size; i++) {
			for(j = col; j < this.size; j++) {
				if(this.sudoku[i][j] == 0) {
					issolved = false;
					k = 1;
					while(k < this.size) {
						issolved = this.solve_rec(i, j, k);
						if(issolved) {
							return true;
						}
						k++;
					}
					return false;
				}
			}
		}

		// all solved
		return true;
	}

}