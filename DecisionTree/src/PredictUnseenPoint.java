
import javax.swing.JFrame;


/**
 * This is the main class of the program that predicts a class value
 * of an unclassified point.
 *
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 * @version 1.0.2
 */
public class PredictUnseenPoint
{
      public static void main(String[] args)
      {
	 String introstring = "This program predicts the class value of "
	    + "an unseen (not yet classified) object. To do this a "
	    + "prediction model is needed. In this implementation "
	    + "we assume that the prediction model is a deciosion tree "
	    + "built by the BuildDTMode java program.";

	 String fileaskstring = "Please give the file that contains the "
	    + "decision tree. If default extension was used during "
	    + "the construction, than its extension is dtm (referring to"
	    + "decision tree model). ";

      	FirstFrame firstframe = 
	   new FirstFrame( introstring, fileaskstring, false );
      	firstframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	firstframe.setLocationRelativeTo(null);
      	firstframe.setVisible(true);
      }
}
