package com.dodecaedro;


import com.dodecaedro.backtrack.BacktrackAlgorithm;
import com.dodecaedro.backtrack.BacktrackNode;
import com.dodecaedro.backtrack.nqueens.NQueensNode;

/**
 * Hello world!
 */
public class NqueensMain {
  public static void main(String[] args) {
    System.out.println("Start processing...");
    long startTime = System.currentTimeMillis();
    BacktrackNode initialNode = new NQueensNode(8);
    BacktrackAlgorithm.solve(initialNode);
    System.out.println("Processing finished. Took " + (System.currentTimeMillis()-startTime) + "ms");
  }
}
