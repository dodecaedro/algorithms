package com.dodecaedro;


import com.dodecaedro.backtrack.nqueens.NQueensNode;
import com.dodecaedro.utils.Utils;

/**
 * Hello world!
 */
public class NqueensMain {
  public static void main(String[] args) {
    Utils.startBacktrack(new NQueensNode(8));
  }
}
