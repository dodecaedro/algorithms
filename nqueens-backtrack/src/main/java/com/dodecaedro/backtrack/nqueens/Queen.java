package com.dodecaedro.backtrack.nqueens;

public class Queen {
  private int positionX;
  private int positionY;

  public Queen(int x, int y) {
    this.positionX = x;
    this.positionY = y;
  }

  public int getPositionX() {
    return this.positionX;
  }

  public int getPositionY() {
    return this.positionY;
  }

  public boolean isInSameXRow(Queen otherQueen) {
    return this.positionY == otherQueen.positionY;
  }

  public boolean isInSameYColumn(Queen otherQueen) {
    return this.positionX == otherQueen.positionX;
  }

  public boolean isInSameDiagonal(Queen otherQueen) {
    // based on y = x + a
    // if they're on the same diagonal, y - x = a

    // first diagonal /
    if ((this.positionX - this.positionY) == (otherQueen.positionX - otherQueen.positionY)) {
      return true;
    }

    // in this case, it's y = -x +a
    // diagonal \
    if ((this.positionX + this.positionY) == (otherQueen.positionX + otherQueen.positionY)) {
      return true;
    }

    // not in any same diagonal
    return false;
  }

  @Override
  public boolean equals(Object otherObject) {
    if (!(otherObject instanceof Queen)) {
      return false;
    }
    Queen otherQueen = (Queen) otherObject;
    // same memory instance
    if (this == otherQueen) {
      return true;
    } else {
      return this.positionX == otherQueen.positionX && this.positionY == otherQueen.positionY;
    }
  }

  @Override
  public int hashCode() {
    return positionX * positionY * 13;
  }

  @Override
  public String toString() {
    return positionX + ":" + positionY;
  }
}
