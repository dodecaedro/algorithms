package com.dodecaedro.utils;

import com.dodecaedro.backtrack.BacktrackAlgorithm;
import com.dodecaedro.backtrack.BacktrackNode;

/**
 * User: jm
 * Date: 10/29/13 * Time: 9:15 PM
 */
public class Utils {
  private Utils(){}

  public static void startBacktrack(BacktrackNode initialNode) {
    System.out.println("Start processing...");
    long startTime = System.currentTimeMillis();
    BacktrackAlgorithm.solve(initialNode);
    System.out.println("Processing finished. Time spent: " + (System.currentTimeMillis() - startTime) + "ms");
  }
}
