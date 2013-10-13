package com.dodecaedro;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dodecaedro.backtrack.nqueens.NQueensNode;

/**
 * Unit test for simple App.
 */
public class NqueensNodeTest {
	private static NQueensNode nodeSafe;
	private static NQueensNode nodeDanger;
	private static NQueensNode nodeIncomplete;

	@BeforeClass
	public static void setUp() {
		nodeSafe = new NQueensNode();
		nodeSafe.addQueen(2, 1);
		nodeSafe.addQueen(4, 2);
		nodeSafe.addQueen(1, 3);
		nodeSafe.addQueen(3, 4);

		nodeDanger = new NQueensNode();
		nodeDanger.addQueen(1, 1);
		nodeDanger.addQueen(3, 2);
		nodeDanger.addQueen(2, 1);
		nodeDanger.addQueen(3, 1);
		
		nodeIncomplete = new NQueensNode();
		nodeIncomplete.addQueen(2, 1);
		nodeIncomplete.addQueen(4, 2);
	}

	@Test
	public void testDanger() {
		assertTrue(nodeDanger.anyQueenInDanger());
		assertFalse(nodeSafe.anyQueenInDanger());
	}

	@Test
	public void testGoal() {
        assertTrue(nodeSafe.isGoal());
        assertFalse(nodeDanger.isGoal());
        assertFalse(nodeIncomplete.isGoal());
	}

	@Test
	public void testLeaf() {
        assertTrue(nodeSafe.isLeaf());
        assertTrue(nodeDanger.isLeaf());
        assertFalse(nodeIncomplete.isLeaf());
	}

}
