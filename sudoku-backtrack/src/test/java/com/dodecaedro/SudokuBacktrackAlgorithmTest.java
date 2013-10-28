package com.dodecaedro;

import com.dodecaedro.backtrack.BacktrackAlgorithm;
import com.dodecaedro.backtrack.sudoku.SudokuNodeWithPruning;
import com.dodecaedro.backtrack.sudoku.SudokuUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

/**
 * User: jm
 * Date: 10/20/13 Time: 8:22 PM
 */
public class SudokuBacktrackAlgorithmTest {

  @Before
  public void setUpOutput() {
    // process solution prints to screen. change it to different stream
    System.setOut(new PrintStream(new ByteArrayOutputStream()));
  }

  @Test
  public void solveTest() {
    SudokuNodeWithPruning node = new SudokuNodeWithPruning();
    node.setBoard(SudokuUtils.generateSolutionBoard());

    for (int i=0; i< SudokuNodeWithPruning.SIDE_SIZE ; i++) {
      node.getBoard()[i][SudokuNodeWithPruning.SIDE_SIZE-1] = 0;
    }

    assertTrue(BacktrackAlgorithm.solve(node));
  }

  @After
  public void cleanUpStreams() {
    System.setOut(null);
  }
}
