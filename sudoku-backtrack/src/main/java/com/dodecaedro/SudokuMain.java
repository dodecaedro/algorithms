package com.dodecaedro;

import com.dodecaedro.backtrack.BacktrackAlgorithm;
import com.dodecaedro.backtrack.sudoku.SudokuNodeWithPruning;

/**
 * User: JM
 * Date: 28/10/13 * Time: 15:43
 */
public class SudokuMain {

  public static int[][] easyBoard1() {
    return new int[][]{
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
  }

  public static int[][] easyBoard2() {
    return new int[][]{
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
  }

  public static int[][] mediumBoard() {
    return new int[][]{
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
  }

  public static int[][] hardBoard() {
    return new int[][]{
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
  }

  public static void main(String[] args) {
    SudokuNodeWithPruning initialNode = new SudokuNodeWithPruning();
    initialNode.setBoard(hardBoard());
    System.out.println("Sudoku solver. Start processing...");
    long startTime = System.currentTimeMillis();
    BacktrackAlgorithm.solve(initialNode);
    System.out.println("Processing finished. Time spent: " + (System.currentTimeMillis() - startTime) + "ms");
  }
}
