/**
 *
 */
package com.dodecaedro.backtrack.sudoku;

import com.dodecaedro.backtrack.BacktrackNode;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author JM
 */
public class SudokuNode implements BacktrackNode {
  public final static int SIDE_SIZE = 9;
  private int[][] board = new int[SIDE_SIZE][SIDE_SIZE];
  public int currentNumber;

  public SudokuNode() {
    this.currentNumber = 0;
  }

  public SudokuNode(int startNumber) {
    this.currentNumber = startNumber;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.dodecaedro.backtrack.BacktrackNode#isLeaf()
   */
  @Override
  public boolean isLeaf() {
    return isAllBoardFull() || isAnyNumberRepeated();
  }

  /*
   * (non-Javadoc)
   *
   * @see com.dodecaedro.backtrack.BacktrackNode#isGoal()
   */
  @Override
  public boolean isGoal() {
    return isAllBoardFull() && !isAnyNumberRepeated();
  }

  /*
   * (non-Javadoc)
   *
   * @see com.dodecaedro.backtrack.BacktrackNode#getChildrenNodes()
   */
  @Override
  public Collection<BacktrackNode> getChildrenNodes() {
    Collection<BacktrackNode> children = new ArrayList<BacktrackNode>();
    currentNumber+=1;

    if (currentNumber > 9) {
      currentNumber = 1;
    }

    for (int posY = 0; posY < SIDE_SIZE; posY++) {
      for (int posX = 0; posX < SIDE_SIZE; posX++) {
        if (!isPositionUsed(posX, posY)) {
          SudokuNode childrenNode = new SudokuNode(currentNumber);
          childrenNode.setBoard(this.getBoard());
          childrenNode.setValuePositionXY(currentNumber, posX, posY);
          children.add(childrenNode);
        }
      }
    }
    return children;
  }

  @Override
  public void processSolution() {
    System.out.println("Solution found:" + this.toString());
  }

  public void setValuePositionXY(int value, int positionX, int positionY) {
    this.board[positionX][positionY] = value;
  }

  public boolean isAnyNumberRepeated() {
    return isAnyNumberRepeatedRow() || isAnyNumberRepeatedColumn()
        || isAnyNumberRepeatedBlock();
  }

  public boolean isAnyNumberRepeatedBlock() {

    for (int startBlockY = 0; startBlockY < SIDE_SIZE; startBlockY += 3) {
      for (int startBlockX = 0; startBlockX < SIDE_SIZE; startBlockX += 3) {
        if (isAnyNumberRepeatedBlock(startBlockX, startBlockX+2, startBlockY, startBlockY+2)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean isAnyNumberRepeatedBlock(int startX, int endX, int startY, int endY) {
    int[] values = new int[SIDE_SIZE];

    for (int posY = startY ; posY <= endY ; posY++) {
      for (int posX = startX ; posX <= endX ; posX++) {
        if (this.board[posX][posY] != 0) {
          values[this.board[posX][posY]-1]+=1;
        }
      }
    }

    for (int i=0 ; i < SIDE_SIZE ; i++) {
      if (values[i] > 1 ) {
        return true;
      }
    }
    return false;
  }

  public boolean isAnyNumberRepeatedColumn() {
    // for each X position
    for (int column = 0; column < SIDE_SIZE ; column++) {

      // for each element in that column
      for (int posY = 0; posY < SIDE_SIZE ; posY++) {
        // check only from that position to the end
        for (int posYCompare = posY+1 ; posYCompare < SIDE_SIZE ; posYCompare++) {
          if (this.board[column][posY] == this.board[column][posYCompare] && this.board[column][posY] != 0) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public boolean isAnyNumberRepeatedRow() {
    // for each Y position
    for (int row = 0 ; row < SIDE_SIZE ; row++) {

      // for each element in that row
      for (int posX = 0 ; posX < SIDE_SIZE ; posX++) {
        // check only from that position to the end
        for (int posXCompare = posX+1 ; posXCompare < SIDE_SIZE ; posXCompare++) {
          if (this.board[posX][row] == this.board[posXCompare][row] && this.board[posX][row] != 0) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public boolean isAllBoardFull() {
    for (int posY = 0; posY < SIDE_SIZE; posY++) {
      for (int posX = 0; posX < SIDE_SIZE; posX++) {
        if (board[posX][posY] == 0) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean isPositionUsed(int positionX, int positionY) {
    return this.board[positionX][positionY] != 0;
  }

  public int[][] getBoard() {
    return board;
  }

  public void setBoard(int[][] copyBoard) {
    this.board = copyUsingForLoop(copyBoard);
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
