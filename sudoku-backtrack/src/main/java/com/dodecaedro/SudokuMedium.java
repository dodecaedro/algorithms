package com.dodecaedro;

import com.dodecaedro.backtrack.BacktrackAlgorithm;
import com.dodecaedro.backtrack.sudoku.SudokuNodeWithPruning;

/**
 * User: JM
 * Date: 27/10/13 * Time: 19:33
 */
public class SudokuMedium {

  public static void main(String[] args) {
    SudokuNodeWithPruning initialNode = new SudokuNodeWithPruning();
    int[][] board = new int[][]{
            {0,2,0, 0,0,3, 5,7,0},
            {0,0,4, 0,0,9, 0,0,0},
            {3,7,1, 0,0,0, 0,2,0},

            {0,0,0, 0,0,1, 7,5,6},
            {6,9,5, 4,0,7, 0,0,8},
            {1,8,7, 5,0,0, 0,9,0},

            {9,3,6, 7,4,5, 0,0,0},
            {0,0,0, 3,2,0, 0,4,0},
            {0,0,0, 1,0,0, 0,0,7}
    };

    initialNode.setBoard(board);
    System.out.println("Sudoku solver. Start processing...");
    long startTime = System.currentTimeMillis();
    BacktrackAlgorithm.solve(initialNode);
    System.out.println("Processing finished. Time spent: " + (System.currentTimeMillis() - startTime) + "ms");
  }

}
