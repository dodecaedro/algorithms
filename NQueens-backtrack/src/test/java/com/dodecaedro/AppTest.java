package com.dodecaedro;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.dodecaedro.backtrack.nqueens.NQueensNode;

/**
 * Unit test for simple App.
 */
public class AppTest {
  @Test
  public void testDanger() {
	NQueensNode node = new NQueensNode();
	node.addQueen(1, 1);
	node.addQueen(3, 2);
	node.addQueen(2, 1);
	node.addQueen(3, 1);
	
	assertFalse(node.isGoal());
  }
	
}
