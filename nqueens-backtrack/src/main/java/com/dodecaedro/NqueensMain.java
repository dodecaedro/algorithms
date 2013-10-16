package com.dodecaedro;


import com.dodecaedro.backtrack.BacktrackAlgorithm;
import com.dodecaedro.backtrack.BacktrackNode;
import com.dodecaedro.backtrack.nqueens.NQueensNode;

/**
 * Hello world!
 */
public class NqueensMain {
  public static void main(String[] args) {
    BacktrackNode initialNode = new NQueensNode();
    BacktrackAlgorithm.solve(initialNode);
  }
}
