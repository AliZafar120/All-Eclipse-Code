

import javax.swing.JTree;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;


/**
 * This class provides a method that expands a Jtree.
 * The code was downloaded from 
 * {@link http://www.jguru.com/faq/view.jsp?EID=513951}
 *
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 * @version 1.0
 */
public class TreeExpander
{
/**
 * Expands a given node in a JTree.
 *
 * @param tree      The JTree to expand.
 * @param model     The TreeModel for tree.     
 * @param node      The node within tree to expand.     
 * @param row       The displayed row in tree that represents
 *                  node.     
 * @param depth     The depth to which the tree should be expanded. 
 *                  Zero will just expand node, a negative
 *                  value will fully expand the tree, and a positive
 *                  value will recursively expand the tree to that
 *                  depth relative to node.
 */
      public static int expandJTreeNode( JTree tree, TreeModel model,
					 Object node, int row, int depth )
      {
	 if (node != null  &&  !model.isLeaf(node)) {
	    tree.expandRow(row);
	    if (depth != 0)
	    {
	       for (int index = 0;
		    row + 1 < tree.getRowCount()  &&  
		       index < model.getChildCount(node);
		    index++)
	       {
		  row++;
		  Object child = model.getChild(node, index);
		  if (child == null)
		     break;
		  TreePath path;
		  while ((path = tree.getPathForRow(row)) != null  &&
			 path.getLastPathComponent() != child)
		     row++;
		  if (path == null)
		     break;
		  row = expandJTreeNode(tree, model, child, row, depth - 1);
	       }
	    }
	 }
	 return row;
      } // expandJTreeNode()
}
