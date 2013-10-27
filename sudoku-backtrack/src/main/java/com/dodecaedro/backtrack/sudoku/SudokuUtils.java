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

  public static Map<Integer, int[]> blocks;
  public static List<Integer> numbers = Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9});

  static {
    blocks = new TreeMap<Integer, int[]>();
    blocks.put(1, new int[]{0,0});
    blocks.put(2, new int[]{3,0});
    blocks.put(3, new int[]{6,0});
    blocks.put(4, new int[]{0,3});
    blocks.put(5, new int[]{3,3});
    blocks.put(6, new int[]{6,3});
    blocks.put(7, new int[]{0,6});
    blocks.put(8, new int[]{3,6});
    blocks.put(9, new int[]{6,6});
  }

  public static int[][] generateSolutionBoard() {
    final int n = 3;
    final int[][] field = new int[n*n][n*n];
    for (int i = 0; i < n*n; i++)
      for (int j = 0; j < n*n; j++)
        field[i][j] = (i*n + i/n + j) % (n*n) + 1;
    return field;
  }

  public static int[][] copyUsingForLoop(int[][] aArray) {
    int[][] copy = new int[aArray.length][aArray.length];
    for (int idy = 0; idy < aArray.length; ++idy) {
      for (int idx = 0; idx < aArray.length; ++idx) {
        copy[idx][idy] = aArray[idx][idy];
      }
    }
    return copy;
  }
}
