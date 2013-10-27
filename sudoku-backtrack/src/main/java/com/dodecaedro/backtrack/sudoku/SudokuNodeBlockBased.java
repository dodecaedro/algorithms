package com.dodecaedro.backtrack.sudoku;

import com.dodecaedro.backtrack.BacktrackNode;

import java.util.*;

/**
 * User: JM
 * Date: 26/10/13 * Time: 20:45
 */
public class SudokuNodeBlockBased implements BacktrackNode {
  public final static int SIDE_SIZE = 9;
  private int[][] board = new int[SIDE_SIZE][SIDE_SIZE];

  public SudokuNodeBlockBased(){}

  public SudokuNodeBlockBased(SudokuNodeBlockBased copy) {
    this.board = SudokuUtils.copyUsingForLoop(copy.getBoard());
  }

  @Override
  public boolean isLeaf() {
    return isAllBoardFull() || isAnyNumberRepeated();
  }

  @Override
  public boolean isGoal() {
    return isAllBoardFull() && !isAnyNumberRepeated();
  }

  @Override
  public Collection<BacktrackNode> getChildrenNodes() {
    int[] fullestBlock = getMostLimitedBlock();
    int blockPosX=fullestBlock[0];
    int blockPosY=fullestBlock[1];

    Collection<BacktrackNode> children = fillBlock(blockPosX,blockPosY,availableNumbersForBlock(fullestBlock));

    return children;
  }

  @Override
  public void processSolution() {
    System.out.println("Solution found!");
    for (int posY = 0 ; posY < SIDE_SIZE ; posY ++) {
      if (posY % 3 == 0) {
        System.out.println("");
      }
      System.out.print("|");
      for (int posX = 0 ; posX < SIDE_SIZE ; posX ++) {
        if (posX % 3 == 0) {
          System.out.print("  ");
        }
        System.out.print(" " + board[posY][posX] + " |");

      }
      System.out.println("");
      System.out.println("-------------------------------------------");
    }
  }

  public boolean isAnyNumberRepeated() {
    return isAnyNumberRepeatedRow() || isAnyNumberRepeatedColumn()
            || isAnyNumberRepeatedAnyBlock();
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

  public Collection<BacktrackNode> fillBlock(int startBlockX, int startBlockY,
                                                    Collection<Integer> availableNumbers) {

    if (availableNumbers.isEmpty()) {
      return Collections.<BacktrackNode>singletonList(this);
    }

    List<BacktrackNode> children = new ArrayList<BacktrackNode>();
    int currentNumber = availableNumbers.iterator().next();

    Set<Integer> remainingNumbers = new HashSet<Integer>(availableNumbers);
    remainingNumbers.remove(currentNumber);

    for (int blockIndex = 0 ; blockIndex < SIDE_SIZE ; blockIndex++) {
      int posX = (blockIndex % 3) + startBlockX;
      int posY = (blockIndex / 3) + startBlockY;

      if (!isPositionUsed(posX, posY) &&
              !existsNumberInRow(currentNumber, posY) &&
              !existsNumberInColumn(currentNumber, posX)) {
        SudokuNodeBlockBased child = new SudokuNodeBlockBased(this);
        child.setValuePositionXY(currentNumber, posX, posY);
        if (child.haveAdjacentBlocksSolution(startBlockX, startBlockY)) {
          children.addAll(child.fillBlock(startBlockX, startBlockY, remainingNumbers));
        }
      }
    }
    return children;
  }

  public int[] getMostLimitedBlock() {
    Iterator<int[]> blockIterator = SudokuUtils.blocks.values().iterator();
    int[] blockCoordinates = new int[]{0,0};
    int currentUsedNumber = 0;

    while (blockIterator.hasNext()) {
      int[] currentBlock = blockIterator.next();
      int usedNumbers = numberPositionsUsedBlock(currentBlock[0],currentBlock[1]);

      if (usedNumbers < 9 && usedNumbers > currentUsedNumber) {
        currentUsedNumber = usedNumbers;
        blockCoordinates = currentBlock;
        if (currentUsedNumber == 8) {
          return blockCoordinates;
        }
      }
    }

    return blockCoordinates;
  }

  public int numberPositionsUsedBlock(int startX, int startY) {
    int numbers = 0;
    for (int posY = startY ; posY < startY+3 ; posY++) {
      for (int posX = startX ; posX < startX+3 ; posX++) {
        if (board[posY][posX] != 0) numbers++;
      }
    }
    return numbers;
  }

  public int[][] getBoard() {
    return board;
  }

  public void setBoard(int[][] board) {
    this.board = board;
  }

  public Collection<Integer> availableNumbersForBlock(int[] startCoordinates) {
    Set<Integer> numbers = new TreeSet<Integer>();
    numbers.addAll(SudokuUtils.numbers);

    for (int posY = startCoordinates[1] ; posY < startCoordinates[1]+3 ; posY++) {
      for (int posX = startCoordinates[0] ; posX < startCoordinates[0]+3 ; posX++) {
        if (board[posY][posX] != 0) numbers.remove(board[posY][posX]);
      }
    }
    return numbers;
  }

  public boolean existsNumberInRow(int number, int row) {
    for (int colIndex = 0 ; colIndex < SIDE_SIZE ; colIndex ++) {
      if (board[row][colIndex] == number) return true;
    }
    return false;
  }

  public boolean existsNumberInColumn(int number, int column) {
    for (int rowIndex = 0 ; rowIndex < SIDE_SIZE ; rowIndex ++) {
      if (board[rowIndex][column] == number) return true;
    }
    return false;
  }

  public boolean existsNumberInBlock(int number, int blockStartX, int blockStartY) {
    for (int blockIndex = 0 ; blockIndex < SIDE_SIZE ; blockIndex++) {
      if (number == board[(blockIndex/3)+blockStartY][(blockIndex%3)+blockStartX]) {
        return true;
      }
    }

    return false;
  }

  public boolean isAnyNumberRepeatedAnyBlock() {
    Iterator<int[]> blockIterator = SudokuUtils.blocks.values().iterator();

    while(blockIterator.hasNext()) {
      int[] blockCoordinates = blockIterator.next();
      if (isAnyNumberRepeatedBlock(blockCoordinates[0],blockCoordinates[1])) {
        return true;
      }
    }
    return false;
  }

  public boolean isAnyNumberRepeatedBlock(int startX, int startY) {
    // from 0 to 8, then translate it to positions in the block
    for (int referenceElement = 0 ; referenceElement < SIDE_SIZE -1 ; referenceElement++) {
      for (int compareElement = referenceElement+1 ; compareElement < SIDE_SIZE ; compareElement++) {
        if (board[(compareElement / 3) + startY][(compareElement % 3) + startX] ==
                board[(referenceElement / 3) + startY][(referenceElement % 3) + startX] &&
                board[(compareElement / 3) + startY][(compareElement % 3) + startX] != 0) {
          return true;
        }
      }
    }
    return false;
  }

  public Collection<Integer> availableNumbersPosition(int posX, int posY) {
    if (board[posY][posX] != 0) {
      return Collections.emptyList();
    }

    Set<Integer> numbers = new TreeSet<Integer>();
    numbers.addAll(SudokuUtils.numbers);

    // remove all numbers already used in that row
    for (int row = 0 ; row < SIDE_SIZE ; row++) {
      numbers.remove(board[posY][row]);
    }

    // remove all numbers used already in that column
    for (int column=0 ; column < SIDE_SIZE ; column++) {
      numbers.remove(board[column][posX]);
    }

    // remove all numbers used in that block
    int[] belongingBlock = getBlockBelongsPosition(posX, posY);
    for (int blockIndex = 0 ; blockIndex < 9 ; blockIndex++) {
      numbers.remove(board[(blockIndex/3)+belongingBlock[1]][(blockIndex%3)+belongingBlock[0]]);
    }

    return numbers;
  }

  public static int[] getBlockBelongsPosition(int posX, int posY) {
    return new int[]{posX-(posX%3), posY-(posY%3)};
  }

  public boolean isPositionUsed(int positionX, int positionY) {
    return this.board[positionY][positionX] != 0;
  }

  public void setValuePositionXY(int value, int positionX, int positionY) {
    this.board[positionY][positionX] = value;
  }

  public boolean hasBlockSolution(int blockStartX, int blockStartY) {
    // it has solution if all the empty cells have at least 1 solution

    for (int blockIndex = 0 ; blockIndex < SIDE_SIZE ; blockIndex++) {
      int posX = (blockIndex % 3) + blockStartX;
      int posY = (blockIndex / 3) + blockStartY;

      if (!isPositionUsed(posX, posY)) {
        if (availableNumbersPosition(posX, posY).size() == 0) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean haveAdjacentBlocksSolution(int blockStartX, int blockStartY) {
    // blocks in same row
    for (int colIndex = 0 ; colIndex < SIDE_SIZE ; colIndex+=3) {
      if (colIndex != blockStartX) {
        if (!hasBlockSolution(colIndex, blockStartY)) {
          return false;
        }
      }
    }

    // blocks in same column
    for (int rowIndex = 0 ; rowIndex < SIDE_SIZE ; rowIndex+=3) {
      if (rowIndex != blockStartY) {
        if (!hasBlockSolution(blockStartX, rowIndex)) {
          return false;
        }
      }
    }

    return true;
  }
}
