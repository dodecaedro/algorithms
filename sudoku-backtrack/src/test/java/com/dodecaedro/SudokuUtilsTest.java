package com.dodecaedro;

import com.dodecaedro.backtrack.sudoku.SudokuNodeOption1;
import com.dodecaedro.backtrack.sudoku.SudokuUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: jm
 * Date: 10/20/13 * Time: 8:27 PM
 */
public class SudokuUtilsTest {
  private SudokuNodeOption1 goalNode;

  @Before
  public void setUp() {
    goalNode = new SudokuNodeOption1();
    goalNode.setBoard(SudokuUtils.generateSolutionBoard());
  }

  @Test
  public void testAutogenerateGoal() {
    assertTrue(goalNode.isGoal());
    assertTrue(goalNode.isAllBoardFull());
    assertTrue(goalNode.isLeaf());
  }

}
