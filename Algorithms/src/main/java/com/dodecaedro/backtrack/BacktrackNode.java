/**
 * 
 */
package com.dodecaedro.backtrack;

import java.util.Collection;

/**
 * @author JM
 *
 */
public interface BacktrackNode {
  boolean isLeaf();
  boolean isGoal();
  Collection<BacktrackNode> getChildrenNodes();
}
