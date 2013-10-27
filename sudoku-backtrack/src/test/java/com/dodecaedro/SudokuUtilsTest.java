package com.dodecaedro;

import com.dodecaedro.backtrack.sudoku.SudokuNodeWithPruning;
import com.dodecaedro.backtrack.sudoku.SudokuUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: jm
 * Date: 10/20/13 * Time: 8:27 PM
 */
public class SudokuUtilsTest {
  private SudokuNodeWithPruning goalNode;

  @Before
  public void setUp() {
    goalNode = new SudokuNodeWithPruning();
    goalNode.setBoard(SudokuUtils.generateSolutionBoard());
  }

  @Test
  public void testAutogenerateGoal() {
    assertTrue(goalNode.isGoal());
    assertTrue(goalNode.isAllBoardFull());
    assertTrue(goalNode.isLeaf());
  }

}
