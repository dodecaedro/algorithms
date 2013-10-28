package com.dodecaedro;

import com.dodecaedro.backtrack.sudoku.SudokuUtils;

/**
 * User: JM
 * Date: 28/10/13 * Time: 15:37
 */
public class ArrayCopyCompareMain {
  public static void main(String[] args) {
    int[][] originalArray = SudokuUtils.generateSolutionBoard();

    int times=10000000;

    long startTime = System.currentTimeMillis();
    for (int i=0 ; i<times ; i++) {
      SudokuUtils.copyArrayUsingForLoop(originalArray);
    }
    System.out.println("Array copy with for loop. " + times + " times. Took: " +
            (System.currentTimeMillis() - startTime) + " ms.");


    long startTime2 = System.currentTimeMillis();
    for (int i=0 ; i<times ; i++) {
      SudokuUtils.copyArrayUsingSystemArrayCopy(originalArray);
    }
    System.out.println("Array copy with system.arraycopy. " + times + " times. Took: " +
            (System.currentTimeMillis() - startTime2) + " ms.");

  }
}
