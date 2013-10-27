package com.dodecaedro;

import com.dodecaedro.backtrack.BacktrackNode;
import com.dodecaedro.backtrack.sudoku.SudokuNodeBlockBased;
import com.dodecaedro.backtrack.sudoku.SudokuUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * User: JM
 * Date: 26/10/13 * Time: 20:48
 */
public class SudokuNodeBlockTest {

  @Test
  public void testZerosBlock() {
    int[][] board = new int[][]{
            {0,3,0,6,0,5,0,0,0},
            {6,0,0,0,9,0,0,0,2},
            {0,7,0,1,0,0,0,0,6},
            {0,9,0,0,0,0,0,0,0},
            {8,1,0,0,5,0,0,6,9},
            {0,0,0,0,0,0,0,8,0},
            {4,0,0,0,0,3,0,2,0},
            {9,0,0,0,2,0,0,0,5},
            {0,0,0,9,0,8,0,3,0}
    };

    SudokuNodeBlockBased block = new SudokuNodeBlockBased();
    block.setBoard(board);

    assertEquals(block.numberPositionsUsedBlock(0, 0), 3);
    assertEquals(block.numberPositionsUsedBlock(0, 6), 2);
    assertEquals(block.numberPositionsUsedBlock(3, 6), 4);
  }

  @Test
  public void getMostLimitedBlock() {
    int[][] board = new int[][]{
            {0,3,0, 6,0,5, 1,3,4},
            {6,0,0, 0,9,0, 0,0,2},
            {0,7,0, 0,0,4, 0,0,6},

            {0,9,0, 0,0,0, 9,8,0},
            {8,1,0, 0,5,0, 0,6,9},
            {0,0,0, 0,0,0, 0,8,0},

            {4,0,0, 0,0,3, 0,2,0},
            {9,0,0, 0,2,0, 0,0,5},
            {0,0,0, 9,0,8, 0,3,0}
    };

    SudokuNodeBlockBased block = new SudokuNodeBlockBased();
    block.setBoard(board);
    int[] mostLimitedBlock = block.getMostLimitedBlock();
    assertEquals(6, mostLimitedBlock[0]);
    assertEquals(0, mostLimitedBlock[1]);
  }

  @Test
  public void getUserNumbersBlock() {
    int[][] board = new int[][]{
            {0,3,0, 6,0,5, 1,3,4},
            {6,0,0, 0,9,0, 0,0,2},
            {0,7,0, 0,0,4, 0,0,6},

            {0,9,0, 0,0,0, 7,8,0},
            {8,1,0, 0,5,0, 0,6,9},
            {0,0,0, 0,0,0, 0,8,0},

            {4,0,0, 0,0,3, 0,2,0},
            {9,0,0, 0,2,0, 0,0,5},
            {0,0,0, 9,0,8, 0,3,0}
    };

    SudokuNodeBlockBased block = new SudokuNodeBlockBased();
    block.setBoard(board);
    assertEquals(6, block.availableNumbersForBlock(new int[]{0, 0}).size());
    assertEquals(8, block.availableNumbersForBlock(new int[]{3, 3}).size());
    assertEquals(5, block.availableNumbersForBlock(new int[]{6, 3}).size());
  }

  @Test
     public void existsNumberInRowTest() {
    int[][] board = new int[][]{
            {0,3,0, 6,0,5, 1,3,4},
            {6,0,0, 0,9,0, 0,0,2},
            {0,7,0, 0,0,4, 0,0,6},

            {0,9,0, 0,0,0, 7,8,0},
            {8,1,0, 0,5,0, 0,6,9},
            {0,0,0, 0,0,0, 0,8,0},

            {4,0,0, 0,0,3, 0,2,0},
            {9,0,0, 0,2,0, 0,0,5},
            {0,0,0, 9,0,8, 0,3,0}
    };

    SudokuNodeBlockBased block = new SudokuNodeBlockBased();
    block.setBoard(board);
    assertFalse(block.existsNumberInRow(2, 0));
    assertTrue(block.existsNumberInRow(6, 0));

    assertFalse(block.existsNumberInRow(1, 3));
    assertTrue(block.existsNumberInRow(8, 3));
  }

  @Test
  public void existsNumberInColTest() {
    int[][] board = new int[][]{
            {0,3,0, 6,0,5, 1,3,4},
            {6,0,0, 0,9,0, 0,0,2},
            {0,7,0, 0,0,4, 0,0,6},

            {0,9,0, 0,0,0, 7,8,0},
            {8,1,0, 0,5,0, 0,6,9},
            {0,0,0, 0,0,0, 0,8,0},

            {4,0,0, 0,0,3, 0,2,0},
            {9,0,0, 0,2,0, 0,0,5},
            {0,0,0, 9,0,8, 0,3,0}
    };

    SudokuNodeBlockBased block = new SudokuNodeBlockBased();
    block.setBoard(board);
    assertFalse(block.existsNumberInColumn(2, 0));
    assertTrue(block.existsNumberInColumn(6, 0));

    assertFalse(block.existsNumberInColumn(1, 7));
    assertTrue(block.existsNumberInColumn(8, 7));
  }

  @Test
  public void repeatedInBlockTest() {
    int[][] board = new int[][]{
            {0,0,0, 1,2,3, 1,3,4},
            {0,0,0, 4,5,6, 0,0,2},
            {0,0,0, 7,8,9, 0,0,6},

            {0,9,0, 0,0,0, 7,8,0},
            {8,1,0, 0,5,0, 0,6,9},
            {0,0,0, 0,0,0, 0,8,0},

            {4,0,0, 1,2,3, 0,2,0},
            {9,0,0, 4,5,5, 0,0,5},
            {0,0,0, 7,8,9, 0,3,0}
    };

    SudokuNodeBlockBased block = new SudokuNodeBlockBased();
    block.setBoard(board);
    assertFalse(block.isAnyNumberRepeatedBlock(3, 0));
    assertTrue(block.isAnyNumberRepeatedBlock(3, 6));
  }

  @Test
  public void testBlockBelongingPosition() {
    int[] block1 = SudokuNodeBlockBased.getBlockBelongsPosition(4,5);
    assertEquals(3, block1[0]);
    assertEquals(3, block1[1]);

    int[] block2 = SudokuNodeBlockBased.getBlockBelongsPosition(7,6);
    assertEquals(6, block2[0]);
    assertEquals(6, block2[1]);
  }

  @Test
  public void availableNumbersPositionTest() {
    int[][] board = new int[][]{
            {1,0,0, 1,2,3, 1,3,4},
            {2,0,0, 2,5,6, 0,0,2},
            {3,0,0, 3,8,9, 0,0,6},

            {4,9,0, 0,2,0, 7,8,0},
            {5,1,0, 0,8,0, 0,6,9},
            {0,0,0, 6,0,0, 0,0,0},

            {0,0,0, 7,2,3, 0,2,0},
            {0,0,0, 8,5,5, 0,0,5},
            {0,0,0, 9,8,9, 0,3,0}
    };

    SudokuNodeBlockBased block = new SudokuNodeBlockBased();
    block.setBoard(board);


    Collection<Integer> availableNumbers = block.availableNumbersPosition(3,4);
    assertEquals(1, availableNumbers.size());
    assertEquals(4, availableNumbers.iterator().next().intValue());

    Collection<Integer> availableNumbers2 = block.availableNumbersPosition(0,5);
    assertEquals(2, availableNumbers2.size());
    assertTrue(availableNumbers2.contains(7));
    assertTrue(availableNumbers2.contains(8));
  }

  @Test
  public void existsNumberInBlockTest() {
    int[][] board = new int[][]{
            {1,2,3, 1,2,3, 1,3,4},
            {4,5,6, 2,5,6, 0,0,2},
            {7,8,9, 3,8,9, 0,0,6},

            {4,9,0, 0,2,0, 7,8,0},
            {5,1,0, 0,8,0, 0,6,9},
            {0,0,0, 6,0,0, 0,0,0},

            {0,0,0, 7,2,3, 0,2,0},
            {0,0,0, 8,5,5, 0,0,5},
            {0,0,0, 9,8,9, 0,3,0}
    };

    SudokuNodeBlockBased block = new SudokuNodeBlockBased();
    block.setBoard(board);

    assertTrue(block.existsNumberInBlock(5, 0, 0));
    assertFalse(block.existsNumberInBlock(4, 3, 0));
  }

  @Test
  public void hasBlockSolution() {
    int[][] board = new int[][]{
            {1,2,3, 4,5,6, 7,8,9},
            {4,5,6, 7,8,9, 1,2,3},
            {7,8,9, 1,2,3, 4,5,6},

            {2,3,4, 5,6,7, 8,9,1},
            {5,0,7, 8,9,1, 2,3,4},
            {8,9,1, 2,3,4, 5,6,7},

            {3,4,5, 6,7,8, 9,1,2},
            {6,7,8, 9,1,2, 3,4,5},
            {9,1,2, 3,4,5, 6,7,8}
    };

    SudokuNodeBlockBased block = new SudokuNodeBlockBased();
    block.setBoard(board);
    assertTrue(block.hasBlockSolution(0, 3));
  }

  @Test
  public void hasNotBlockSolution() {
    int[][] board = new int[][]{
            {1,2,3, 4,0,6, 7,8,9},
            {4,5,6, 7,8,9, 1,0,3},
            {7,6,9, 1,2,3, 4,5,6},

            {2,3,4, 5,6,7, 8,9,1},
            {5,0,7, 8,9,1, 2,3,4},
            {8,9,1, 2,3,4, 5,6,7},

            {3,4,5, 6,7,8, 9,1,2},
            {6,7,8, 9,1,2, 3,4,5},
            {9,1,0, 3,4,5, 6,7,8}
    };

    SudokuNodeBlockBased block = new SudokuNodeBlockBased();
    block.setBoard(board);
    assertFalse(block.hasBlockSolution(0, 3));
  }

  @Test
  public void haveAdjacentBlocksSolutionTest() {
    int[][] board = new int[][]{
            {1,2,3, 4,0,6, 7,8,9},
            {4,0,6, 7,8,9, 1,0,3},
            {7,8,9, 1,2,3, 4,5,6},

            {2,3,4, 5,6,7, 8,9,1},
            {5,0,7, 8,9,1, 2,3,4},
            {8,9,1, 2,3,4, 5,6,7},

            {3,4,5, 6,7,8, 9,1,2},
            {6,7,8, 9,1,2, 3,4,5},
            {9,1,0, 3,4,5, 6,7,8}
    };

    SudokuNodeBlockBased block = new SudokuNodeBlockBased();
    block.setBoard(board);
    assertTrue(block.haveAdjacentBlocksSolution(0, 0));
  }

  @Test
  public void haveNotAdjacentBlocksSolutionTest1() {
    int[][] board = new int[][]{
            {1,2,3, 4,0,6, 7,8,9},
            {4,5,6, 7,8,9, 1,0,3},
            {7,6,9, 1,2,3, 4,5,6},

            {2,3,4, 5,6,7, 8,9,1},
            {5,0,7, 8,9,1, 2,3,4},
            {8,9,1, 2,3,4, 5,6,7},

            {3,4,5, 6,7,8, 9,1,2},
            {6,7,8, 9,1,2, 3,4,5},
            {9,1,0, 3,4,5, 6,7,8}
    };

    SudokuNodeBlockBased block = new SudokuNodeBlockBased();
    block.setBoard(board);
    assertFalse(block.haveAdjacentBlocksSolution(0, 0));
  }

  @Test
  public void haveNotAdjacentBlocksSolutionTest2() {
    int[][] board = new int[][]{
            {1,2,3, 4,5,6, 7,8,9},
            {4,5,6, 7,8,9, 1,0,3},
            {7,8,9, 1,2,3, 4,5,6},

            {2,3,4, 5,6,7, 8,9,1},
            {5,6,7, 8,9,1, 2,3,4},
            {8,9,1, 2,3,4, 5,6,7},

            {3,4,5, 6,7,8, 9,1,2},
            {6,7,8, 9,1,2, 3,4,5},
            {9,1,2, 3,4,5, 6,2,8}
    };

    SudokuNodeBlockBased block = new SudokuNodeBlockBased();
    block.setBoard(board);
    assertFalse(block.haveAdjacentBlocksSolution(0, 0));
  }

  @Test
  public void fillBlockTest() {
    List<Integer> numbers = Arrays.asList(new Integer[]{7, 8, 9});

    SudokuNodeBlockBased block = new SudokuNodeBlockBased();
    block.setValuePositionXY(1, 0,0);
    block.setValuePositionXY(2, 1,0);
    block.setValuePositionXY(3, 2,0);
    block.setValuePositionXY(4, 0,1);
    block.setValuePositionXY(5, 1,1);
    block.setValuePositionXY(6, 2,1);

    Collection<BacktrackNode> children = block.fillBlock(0,0, numbers);
    assertEquals(6, children.size());
  }

  @Test
  public void fullestBlockTest1() {
    int[][] board = new int[][]{
            {1,2,3, 4,5,6, 7,8,9},
            {4,5,6, 7,0,9, 1,2,3},
            {7,8,9, 1,2,3, 0,0,6},

            {2,0,4, 5,6,7, 8,9,1},
            {5,6,0, 0,9,0, 0,3,0},
            {8,9,1, 2,3,4, 5,6,7},

            {0,0,0, 0,0,8, 0,1,2},
            {6,7,8, 9,1,2, 3,4,5},
            {9,1,2, 3,4,5, 6,7,8}
    };

    SudokuNodeBlockBased block = new SudokuNodeBlockBased();
    block.setBoard(board);
    int[] blockCoords = block.getMostLimitedBlock();
    assertEquals(3, blockCoords[0]);
    assertEquals(0, blockCoords[1]);
  }
}
