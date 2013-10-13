package com.dodecaedro;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dodecaedro.backtrack.sudoku.SudokuNode;

/**
 * Unit test for simple App.
 */
public class SudokuTest {
	private static SudokuNode goalNode;
	private static SudokuNode nonCompleteNode;
	private static SudokuNode boardWithRepeatedNumbersInRow;
	private static SudokuNode boardWithRepeatedNumbersInColumn;
	private static SudokuNode boardWithRepeatedNumbersInBlock;

	@BeforeClass
	public static void setUp() {
		goalNode = new SudokuNode();

		goalNode.setValuePositionXY(6, 0, 0);
		goalNode.setValuePositionXY(4, 1, 0);
		goalNode.setValuePositionXY(5, 2, 0);
		goalNode.setValuePositionXY(7, 3, 0);
		goalNode.setValuePositionXY(8, 4, 0);
		goalNode.setValuePositionXY(2, 5, 0);
		goalNode.setValuePositionXY(3, 6, 0);
		goalNode.setValuePositionXY(9, 7, 0);
		goalNode.setValuePositionXY(1, 8, 0);

		goalNode.setValuePositionXY(2, 0, 1);
		goalNode.setValuePositionXY(1, 1, 1);
		goalNode.setValuePositionXY(3, 2, 1);
		goalNode.setValuePositionXY(6, 3, 1);
		goalNode.setValuePositionXY(9, 4, 1);
		goalNode.setValuePositionXY(4, 5, 1);
		goalNode.setValuePositionXY(5, 6, 1);
		goalNode.setValuePositionXY(7, 7, 1);
		goalNode.setValuePositionXY(8, 8, 1);

		goalNode.setValuePositionXY(7, 0, 2);
		goalNode.setValuePositionXY(9, 1, 2);
		goalNode.setValuePositionXY(8, 2, 2);
		goalNode.setValuePositionXY(1, 3, 2);
		goalNode.setValuePositionXY(3, 4, 2);
		goalNode.setValuePositionXY(5, 5, 2);
		goalNode.setValuePositionXY(4, 6, 2);
		goalNode.setValuePositionXY(2, 7, 2);
		goalNode.setValuePositionXY(6, 8, 2);

		goalNode.setValuePositionXY(9, 0, 3);
		goalNode.setValuePositionXY(3, 1, 3);
		goalNode.setValuePositionXY(2, 2, 3);
		goalNode.setValuePositionXY(4, 3, 3);
		goalNode.setValuePositionXY(7, 4, 3);
		goalNode.setValuePositionXY(6, 5, 3);
		goalNode.setValuePositionXY(1, 6, 3);
		goalNode.setValuePositionXY(8, 7, 3);
		goalNode.setValuePositionXY(5, 8, 3);

		goalNode.setValuePositionXY(1, 0, 4);
		goalNode.setValuePositionXY(8, 1, 4);
		goalNode.setValuePositionXY(4, 2, 4);
		goalNode.setValuePositionXY(2, 3, 4);
		goalNode.setValuePositionXY(5, 4, 4);
		goalNode.setValuePositionXY(3, 5, 4);
		goalNode.setValuePositionXY(9, 6, 4);
		goalNode.setValuePositionXY(6, 7, 4);
		goalNode.setValuePositionXY(7, 8, 4);

		goalNode.setValuePositionXY(5, 0, 5);
		goalNode.setValuePositionXY(7, 1, 5);
		goalNode.setValuePositionXY(6, 2, 5);
		goalNode.setValuePositionXY(8, 3, 5);
		goalNode.setValuePositionXY(1, 4, 5);
		goalNode.setValuePositionXY(9, 5, 5);
		goalNode.setValuePositionXY(2, 6, 5);
		goalNode.setValuePositionXY(4, 7, 5);
		goalNode.setValuePositionXY(3, 8, 5);

		goalNode.setValuePositionXY(8, 0, 6);
		goalNode.setValuePositionXY(6, 1, 6);
		goalNode.setValuePositionXY(9, 2, 6);
		goalNode.setValuePositionXY(3, 3, 6);
		goalNode.setValuePositionXY(2, 4, 6);
		goalNode.setValuePositionXY(1, 5, 6);
		goalNode.setValuePositionXY(7, 6, 6);
		goalNode.setValuePositionXY(5, 7, 6);
		goalNode.setValuePositionXY(4, 8, 6);

		goalNode.setValuePositionXY(4, 0, 7);
		goalNode.setValuePositionXY(2, 1, 7);
		goalNode.setValuePositionXY(1, 2, 7);
		goalNode.setValuePositionXY(5, 3, 7);
		goalNode.setValuePositionXY(6, 4, 7);
		goalNode.setValuePositionXY(7, 5, 7);
		goalNode.setValuePositionXY(8, 6, 7);
		goalNode.setValuePositionXY(3, 7, 7);
		goalNode.setValuePositionXY(9, 8, 7);

		goalNode.setValuePositionXY(3, 0, 8);
		goalNode.setValuePositionXY(5, 1, 8);
		goalNode.setValuePositionXY(7, 2, 8);
		goalNode.setValuePositionXY(9, 3, 8);
		goalNode.setValuePositionXY(4, 4, 8);
		goalNode.setValuePositionXY(8, 5, 8);
		goalNode.setValuePositionXY(6, 6, 8);
		goalNode.setValuePositionXY(1, 7, 8);
		goalNode.setValuePositionXY(2, 8, 8);

		int[][] original = goalNode.getBoard();
		int[][] nonCompleteArray = copyUsingForLoop(original);
		nonCompleteArray[1][0] = 0;        

		int[][] repeatedNumberArray = copyUsingForLoop(original);
		repeatedNumberArray[0][2] = 6;

		nonCompleteNode = new SudokuNode();
		nonCompleteNode.setBoard(nonCompleteArray);

		boardWithRepeatedNumbersInRow = new SudokuNode();
		boardWithRepeatedNumbersInRow.setBoard(repeatedNumberArray);
		
		boardWithRepeatedNumbersInColumn = new SudokuNode();
		
		int[][] repeatedNumberColumnArray = copyUsingForLoop(original);
		repeatedNumberColumnArray[2][0] = 6;
		boardWithRepeatedNumbersInColumn.setBoard(repeatedNumberColumnArray);
		
		boardWithRepeatedNumbersInBlock = new SudokuNode();
		int[][] repeatedNumberBlockArray = copyUsingForLoop(original);
		repeatedNumberBlockArray[1][4] = 7;
		boardWithRepeatedNumbersInBlock.setBoard(repeatedNumberBlockArray);
	}

	@Test
	public void testIsFull() {
		assertTrue(goalNode.isAllBoardFull());
		assertFalse(nonCompleteNode.isAllBoardFull());
	}

	@Test
	public void testNumberRepeatedRow() {
		assertFalse(goalNode.isAnyNumberRepeatedRow());
		assertTrue(boardWithRepeatedNumbersInRow.isAnyNumberRepeatedRow());
	}
	
	@Test 
	public void testNumberRepeatedColumn() {
		assertFalse(goalNode.isAnyNumberRepeatedColumn());
		assertTrue(boardWithRepeatedNumbersInColumn.isAnyNumberRepeatedColumn());		
	}
	
	@Test
	public void testNumberRepeatedBlock() {
		assertFalse(goalNode.isAnyNumberRepeatedBlock());
		assertTrue(boardWithRepeatedNumbersInBlock.isAnyNumberRepeatedBlock());		
	}
	
	@Test
	public void testGoal() {
		assertTrue(goalNode.isGoal());
		assertFalse(nonCompleteNode.isGoal());
		assertFalse(boardWithRepeatedNumbersInRow.isGoal());
		assertFalse(boardWithRepeatedNumbersInColumn.isGoal());
		assertFalse(boardWithRepeatedNumbersInBlock.isGoal());
	}
	
	@Test
	public void testLeaf() {
		assertTrue(goalNode.isLeaf());
		assertTrue(boardWithRepeatedNumbersInRow.isLeaf());
		assertTrue(boardWithRepeatedNumbersInColumn.isLeaf());
		assertTrue(boardWithRepeatedNumbersInBlock.isLeaf());
		assertFalse(nonCompleteNode.isLeaf());
		assertFalse(new SudokuNode().isLeaf());
	}

	private static int[][] copyUsingForLoop(int[][] aArray) {
		int[][] copy = new int[aArray.length][aArray.length];
		for (int idy = 0; idy < aArray.length; ++idy) {
			for (int idx = 0; idx < aArray.length; ++idx) {
				copy[idx][idy] = aArray[idx][idy];
			}
		}
		return copy;
	}
}
