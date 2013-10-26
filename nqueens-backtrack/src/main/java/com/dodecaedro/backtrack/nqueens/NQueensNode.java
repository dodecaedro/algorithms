/**
 *
 */
package com.dodecaedro.backtrack.nqueens;

import com.dodecaedro.backtrack.BacktrackNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author JM
 */
public class NQueensNode implements BacktrackNode {
  public int boardSize = 4;

  private List<Queen> queens;
  private List<BacktrackNode> childrenNodes;

  public NQueensNode() {
    queens = new ArrayList<Queen>();
    childrenNodes = new ArrayList<BacktrackNode>();
  }

  public NQueensNode(int size) {
    this();
    setBoardSize(size);
  }

  private NQueensNode(NQueensNode copy) {
    this();
    this.queens.addAll(copy.queens);
    setBoardSize(copy.getBoardSize());
  }

  /*
   * (non-Javadoc)
   *
   * @see com.dodecaedro.Node#isLeaf()
   */
  @Override
  public boolean isLeaf() {
    // it's a leaf when it has all the queens, or there's no point in
    // continuing
    return queens.size() == boardSize || anyQueenInDanger();
  }

  /*
   * (non-Javadoc)
   *
   * @see com.dodecaedro.Node#isGoal()
   */
  @Override
  public boolean isGoal() {
    // the goal is to have all the n queens where none endangers any other
    return queens.size() == boardSize && !anyQueenInDanger();
  }

  /*
   * (non-Javadoc)
   *
   * @see com.dodecaedro.Node#generateChildrenNodes()
   */
  private void generateChildrenNodes() {
    List<BacktrackNode> nodes = new ArrayList<BacktrackNode>();
    for (int y = 1; y <= boardSize; y++) {
      for (int x = 1; x <= boardSize; x++) {
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

  @Override
  public Collection<BacktrackNode> getChildrenNodes() {
    if (childrenNodes.isEmpty()) {
      generateChildrenNodes();
    }
    return childrenNodes;
  }

  @Override
  public void processSolution() {
    System.out.println("Solution found: " + this.toString());
  }

  public boolean anyQueenInDanger() {
    /* compare every queen only with the immediate following
    * commutative property applies here, so if a != b, then there's
    * no need to compare b == a */
    for (int queenIndex = 0 ; queenIndex < queens.size() ; queenIndex++) {
      for (int compareQueenIndex = queenIndex+1 ; compareQueenIndex < queens.size()-1 ; compareQueenIndex++) {
        // is same horizontal row or vertical column?
        if ( queens.get(queenIndex).isInSameXRow(queens.get(compareQueenIndex)) ||
                queens.get(queenIndex).isInSameYColumn(queens.get(compareQueenIndex))) {
          return true;
        } else {
          // is in the same diagonal?
          if (queens.get(queenIndex).isInSameDiagonal(queens.get(compareQueenIndex))) {
            return true;
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
      builder.append(queen.getPositionX() + ":" + queen.getPositionY());
      builder.append(", ");
    }
    return builder.toString();
  }

  public int getBoardSize() {
    return boardSize;
  }

  public void setBoardSize(int boardSize) {
    this.boardSize = boardSize;
  }
}
