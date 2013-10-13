package com.dodecaedro;

import com.dodecaedro.backtrack.BacktrackAlgorithm;
import com.dodecaedro.backtrack.sudoku.SudokuNode;

/**
 * Hello world!
 * 
 */
public class SudokuMain {
	public static void main(String[] args) {
		SudokuNode initialNode = new SudokuNode();
		BacktrackAlgorithm.solve(initialNode);
	}
}
