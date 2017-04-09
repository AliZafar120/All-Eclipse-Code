

import javax.swing.JFrame;


/**
 * The <code>BuildDTModel</code> program is the main program of
 * decision tree building package. 
 *
 * @see bodon.mining.classification.decisiontree
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 * @version 1.2.2
 */
public class BuildDTModel
{
      public static void main(String[] args)
      {
	 String introstring = "This program builds "
	    + "a decision tree model using a purity-based algorithm. "
	    + "Decision tree is a kind of classifier; it classifies "
	    + "objects based on their attributes. \n"
	    + "To build a model a traning set must be provided. "
	    + "The training set contains the so called traning points, "
	    + "which are object that has been already classified. ";

	 String fileaskstring = 
	    "Please give the file that contains the training "
	    + "set in csv (comma separated value file) format. "
	    + "The first row of the file has to contain the names of"
	    + " the attributes. ";

      	FirstFrame firstframe = 
	   new FirstFrame( introstring, fileaskstring, true );
      	firstframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	firstframe.setLocationRelativeTo(null);
      	firstframe.setVisible(true);
      }
}

