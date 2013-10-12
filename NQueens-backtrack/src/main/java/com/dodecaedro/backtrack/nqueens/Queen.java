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
	
	public boolean isInXRow(int row) {
		return this.positionX == row; 
	}
	
	public boolean isInYColumn(int column) {
		return this.positionY == column;
	}
	
	public boolean isInDiagonal(int rowX, int columnY, int limit) {
		// move right and down
		int currentXRow = positionX+1;
		int currentYColumn = positionY+1;		
		while (currentXRow<=limit && currentYColumn<=limit) {
			if (rowX == currentXRow && columnY == currentYColumn) {
				System.out.println("Collision found: " + this.toString() + " collides with: " + rowX + ":" + columnY + " - same diagonal");
				return true;
			}
			currentXRow++;
			currentYColumn++;
		}
		
		// move left and up
		currentXRow = positionX-1;
		currentYColumn = positionY-1;		
		while (currentXRow>=1 && currentYColumn>=1) {
			if (rowX == currentXRow && columnY == currentYColumn) {
				System.out.println("Collision found: " + this.toString() + " collides with: " + rowX + ":" + columnY + " - same diagonal");
				return true;
			}
			currentXRow--;
			currentYColumn--;
		}
		
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
