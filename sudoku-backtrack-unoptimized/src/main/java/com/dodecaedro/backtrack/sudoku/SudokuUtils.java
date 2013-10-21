package com.dodecaedro.backtrack.sudoku;

/**
 * User: jm
 * Date: 10/20/13 * Time: 8:26 PM
 */
public class SudokuUtils {
  private SudokuUtils(){}

  public static int[][] generateSolutionBoard() {
    final int n = 3;
    final int[][] field = new int[n*n][n*n];
    for (int i = 0; i < n*n; i++)
      for (int j = 0; j < n*n; j++)
        field[i][j] = (i*n + i/n + j) % (n*n) + 1;
    return field;
  }
}
