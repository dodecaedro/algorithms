package com.dodecaedro;

import com.dodecaedro.backtrack.BacktrackAlgorithm;
import com.dodecaedro.backtrack.sudoku.SudokuNodeWithPruning;

/**
 * User: JM
 * Date: 27/10/13 * Time: 19:39
 */
public class SudokuHard {
  public static void main(String[] args) {
    SudokuNodeWithPruning initialNode = new SudokuNodeWithPruning();
    int[][] board = new int[][]{
            {0,6,1, 2,0,0, 0,0,0},
            {2,0,0, 3,0,4, 0,0,0},
            {0,3,0, 0,0,9, 0,8,1},

            {0,2,0, 6,0,0, 0,0,7},
            {8,0,0, 0,4,0, 0,0,6},
            {3,0,0, 0,0,5, 0,2,0},

            {1,7,0, 8,0,0, 0,3,0},
            {0,0,0, 7,0,3, 0,0,9},
            {0,0,0, 0,0,1, 6,7,0}
    };

    initialNode.setBoard(board);
    System.out.println("Sudoku solver. Start processing...");
    long startTime = System.currentTimeMillis();
    BacktrackAlgorithm.solve(initialNode);
    System.out.println("Processing finished. Time spent: " + (System.currentTimeMillis() - startTime) + "ms");
  }
}
