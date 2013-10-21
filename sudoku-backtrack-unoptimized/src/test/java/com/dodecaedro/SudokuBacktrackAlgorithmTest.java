package com.dodecaedro;

import com.dodecaedro.backtrack.BacktrackAlgorithm;
import com.dodecaedro.backtrack.sudoku.SudokuNode;
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
    SudokuNode node = new SudokuNode();
    node.setBoard(SudokuUtils.generateSolutionBoard());

    for (int i=0; i<SudokuNode.SIDE_SIZE ; i++) {
      node.getBoard()[i][SudokuNode.SIDE_SIZE-1] = 0;
    }

    assertTrue(BacktrackAlgorithm.solve(node));
  }
}
