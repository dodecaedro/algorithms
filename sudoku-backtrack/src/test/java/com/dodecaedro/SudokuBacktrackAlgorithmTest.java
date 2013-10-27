package com.dodecaedro;

import com.dodecaedro.backtrack.BacktrackAlgorithm;
import com.dodecaedro.backtrack.sudoku.SudokuNodeOption1;
import com.dodecaedro.backtrack.sudoku.SudokuUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: jm
 * Date: 10/20/13 Time: 8:22 PM
 */
public class SudokuBacktrackAlgorithmTest {
  @Test
  public void solveTest() {
    SudokuNodeOption1 node = new SudokuNodeOption1();
    node.setBoard(SudokuUtils.generateSolutionBoard());

    for (int i=0; i< SudokuNodeOption1.SIDE_SIZE ; i++) {
      node.getBoard()[i][SudokuNodeOption1.SIDE_SIZE-1] = 0;
    }

    assertTrue(BacktrackAlgorithm.solve(node));
  }
}
