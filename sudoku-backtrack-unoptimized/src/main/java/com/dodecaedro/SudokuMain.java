package com.dodecaedro;

import com.dodecaedro.backtrack.BacktrackAlgorithm;
import com.dodecaedro.backtrack.sudoku.SudokuNode;

/**
 * Hello world!
 */
public class SudokuMain {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    SudokuNode initialNode = new SudokuNode();
    int[][] board = new int[][]{{0,3,0,6,0,5,0,0,0},
        {6,0,0,0,9,0,0,0,2},
        {0,7,0,1,0,0,0,0,6},
        {0,9,0,0,0,0,0,0,0},
        {8,1,0,0,5,0,0,6,9},
        {0,0,0,0,0,0,0,8,0},
        {4,0,0,0,0,3,0,2,0},
        {9,0,0,0,2,0,0,0,5},
        {0,0,0,9,0,8,0,3,0}};
    initialNode.setBoard(board);
    System.out.println("Sudoku solver. Start processing...");
    BacktrackAlgorithm.solve(initialNode);
    System.out.println("Processing finished. Time spent: " + (System.currentTimeMillis() - startTime));
  }
}
