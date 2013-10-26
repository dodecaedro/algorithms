package com.dodecaedro.backtrack;

/**
 * @author JM
 */
public class BacktrackAlgorithm {
  private BacktrackAlgorithm() {
  }

  /*
   * adapted pseudocode from:
   * http://www.cis.upenn.edu/~matuszek/cit594-2012/Pages/backtracking.html
   */
  public static boolean solve(BacktrackNode node) {
    if (node.isLeaf()) {
      if (node.isGoal()) {
        node.processSolution();
        return true;
      } else {
        return false;
      }
    } else {
      for (BacktrackNode childrenNode : node.getChildrenNodes()) {
        if (solve(childrenNode)) {
          return true;
        }
      }
      // no solution was found
      return false;
    }
  }
}
