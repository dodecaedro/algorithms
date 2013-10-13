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
		// first diagonal \
		if ((this.positionX-this.positionY)==(otherQueen.positionX-otherQueen.positionY)) {
			return true;
		}
		// now test /
		// down and left
		int posX = this.positionX;
		int posY = this.positionY;
		while(posX >= 0 && posY <= NQueensNode.SIZE) {
			posX--;
			posY++;
			if (posX == otherQueen.positionX && posY == otherQueen.positionY) {
				return true;
			}			
		}
		
        // up and right
		posX = this.positionX;
		posY = this.positionY;
		while(posX <= NQueensNode.SIZE && posX <= NQueensNode.SIZE) {
			posX++;
			posY--;
			if (posX == otherQueen.positionX && posY == otherQueen.positionY) {
				return true;
			}			
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
		return positionX +":"+ positionY;
	}
}
