/**
 * 
 */
package com.dodecaedro.backtrack.nqueens;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.dodecaedro.backtrack.BacktrackNode;

/**
 * @author JM
 * 
 */
public class NQueensNode implements BacktrackNode {
	public static final int SIZE = 4;

	private List<Queen> queens;
	private List<BacktrackNode> childrenNodes;

	public NQueensNode() {
		queens = new ArrayList<Queen>();
		childrenNodes = new ArrayList<BacktrackNode>();
	}

	private NQueensNode(NQueensNode copy) {
		this();
		this.queens.addAll(copy.queens);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dodecaedro.Node#isLeaf()
	 */
	public boolean isLeaf() {
		// it's a leaf when it has all the queens, or there's no point in
		// continuing
		return queens.size() == SIZE || anyQueenInDanger();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dodecaedro.Node#isGoal()
	 */
	public boolean isGoal() {
		// the goal is to have all the n queens where none endangers any other
		return queens.size() == SIZE && !anyQueenInDanger();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dodecaedro.Node#generateChildrenNodes()
	 */
	private void generateChildrenNodes() {
		List<BacktrackNode> nodes = new ArrayList<BacktrackNode>();
		for (int y = 1; y <= SIZE; y++) {
			for (int x = 1; x <= SIZE; x++) {
				if (!hasQueen(x, y)) {
					// make a copy of the current node which includes current queens
					NQueensNode childrenNode = new NQueensNode(this);
					// each new node has 1 new queen
					childrenNode.addQueen(x, y);
					nodes.add(childrenNode);
				}
			}
		}
		this.childrenNodes.addAll(nodes);
	}

	public Collection<BacktrackNode> getChildrenNodes() {
		if (childrenNodes.isEmpty()) {
			generateChildrenNodes();	
		}
		return childrenNodes;
	}

	public boolean anyQueenInDanger() {
		for (Queen queen : this.queens) {
			for (Queen compareQueen : this.queens) {
				// don't compare a queen with herself
				if (!queen.equals(compareQueen)) {
					// is same horizontal row or vertical column?
					if (queen.isInSameXRow(compareQueen) || 
							queen.isInSameYColumn(compareQueen)) {
						System.out.println("Collision found: " + queen.toString() + 
								" collides with: " + compareQueen.toString() + " - same line");
						return true;
					} else {
						// is in the same diagonal?
					    if (queen.isInSameDiagonal(compareQueen)) {
					    	return true;
					    }
					}
				}
			}
		}
		return false;
	}

	private boolean hasQueen(int x, int y) {
		for (Queen queen : queens) {
			if (queen.getPositionX() == x && queen.getPositionY() == y) {
				return true;
			}
		}
		return false;
	}

	public void addQueen(int positionX, int positionY) {
		this.queens.add(new Queen(positionX, positionY));
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Path for this node: ");
		for (Queen queen : this.queens) {
			builder.append(queen.getPositionX()+":"+queen.getPositionY());
			builder.append(", ");
		}
		return builder.toString();
	}
}
