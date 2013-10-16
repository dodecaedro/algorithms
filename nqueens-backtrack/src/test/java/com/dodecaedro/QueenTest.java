package com.dodecaedro;

import com.dodecaedro.backtrack.nqueens.Queen;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueenTest {
  @Test
  public void queenEqualsTest() {
    Queen queen1 = new Queen(1, 1);
    Queen queen2 = new Queen(1, 1);
    Queen queen3 = new Queen(1, 2);

    assertTrue(queen1.equals(queen2));
    assertTrue(queen1.equals(queen1));
    assertFalse(queen1.equals(null));
    assertFalse(queen1.equals(queen3));
  }

  @Test
  public void testQueenRow() {
    Queen queen1 = new Queen(1, 1);
    Queen queen2 = new Queen(3, 1);
    Queen queen3 = new Queen(1, 2);

    assertTrue(queen1.isInSameXRow(queen2));
    assertFalse(queen1.isInSameXRow(queen3));
  }

  @Test
  public void testQueenColumn() {
    Queen queen1 = new Queen(2, 1);
    Queen queen2 = new Queen(2, 2);
    Queen queen3 = new Queen(3, 1);

    assertTrue(queen1.isInSameYColumn(queen2));
    assertFalse(queen1.isInSameYColumn(queen3));
  }

  @Test
  public void testQueenDiagonal() {
    Queen queen1 = new Queen(2, 2);
    Queen queen2 = new Queen(1, 1);
    Queen queen3 = new Queen(3, 1);
    Queen queen4 = new Queen(1, 3);
    Queen queen5 = new Queen(3, 3);

    Queen queen6 = new Queen(2, 1);

    assertTrue(queen1.isInSameDiagonal(queen2));
    assertTrue(queen1.isInSameDiagonal(queen3));
    assertTrue(queen1.isInSameDiagonal(queen4));
    assertTrue(queen1.isInSameDiagonal(queen5));

    assertFalse(queen1.isInSameDiagonal(queen6));

    Queen queen7 = new Queen(3, 4);
    Queen queen8 = new Queen(2, 1);

    assertFalse(queen7.isInSameDiagonal(queen8));
  }
}
