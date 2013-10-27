package com.dodecaedro;

import com.dodecaedro.backtrack.BacktrackAlgorithm;
import com.dodecaedro.backtrack.sudoku.SudokuNodeBlockBased;

/**
 * User: JM
 * Date: 27/10/13 * Time: 18:42
 */
public class SudokuMainEasy {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    SudokuNodeBlockBased initialNode = new SudokuNodeBlockBased();
    int[][] board = new int[][]{
            {1,2,3, 4,5,0, 7,8,9},
            {4,0,6, 7,8,9, 1,2,3},
            {7,8,9, 1,2,3, 0,5,6},

            {2,3,4, 5,6,7, 8,9,1},
            {5,6,7, 8,9,0, 2,3,4},
            {8,9,0, 2,3,4, 0,6,7},

            {3,4,5, 6,7,8, 9,1,2},
            {6,0,8, 9,1,2, 0,4,5},
            {9,1,2, 0,4,5, 6,7,8}
    };

    int[][] board2 = new int[][]{
            {0,2,3, 1,0,0, 8,0,0},
            {4,0,9, 0,8,5, 7,0,0},
            {6,5,8, 4,0,0, 1,0,0},

            {3,0,0, 5,0,0, 2,6,8},
            {5,8,6, 7,0,0, 0,1,9},
            {0,9,2, 0,6,0, 0,7,0},

            {0,0,0, 0,0,3, 0,4,0},
            {0,4,7, 2,0,8, 6,0,0},
            {0,3,5, 0,0,1, 0,0,0}
    };

    initialNode.setBoard(board2);
    System.out.println("Sudoku solver. Start processing...");
    BacktrackAlgorithm.solve(initialNode);
    System.out.println("Processing finished. Time spent: " + (System.currentTimeMillis() - startTime) + "ms");
  }
}
