package com.dodecaedro.backtrack.sudoku;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * User: jm
 * Date: 10/20/13 * Time: 8:26 PM
 */
public class SudokuUtils {
  private SudokuUtils(){}

  public static List<Integer> numbers = Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9});

  public static int[][] generateSolutionBoard() {
    final int n = 3;
    final int[][] field = new int[n*n][n*n];
    for (int i = 0; i < n*n; i++)
      for (int j = 0; j < n*n; j++)
        field[i][j] = (i*n + i/n + j) % (n*n) + 1;
    return field;
  }

  public static int[][] copyArray(int[][] aArray) {
    return copyArrayUsingSystemArrayCopy(aArray);
  }

  // for reference only to compare with other methods
  public static int[][] copyArrayUsingForLoop(int[][] aArray) {
    int[][] copy = new int[aArray.length][aArray.length];
    for (int idy = 0; idy < aArray.length; ++idy) {
      for (int idx = 0; idx < aArray.length; ++idx) {
        copy[idx][idy] = aArray[idx][idy];
      }
    }
    return copy;
  }

  public static int[][] copyArrayUsingSystemArrayCopy(int[][] src) {
    int length = src.length;
    int[][] target = new int[length][src[0].length];
    for (int i = 0; i < length; i++) {
      System.arraycopy(src[i], 0, target[i], 0, src[i].length);
    }
    return target;
  }
}
