


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.util.TreeMap;
import java.awt.GridLayout;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.BorderFactory;
import java.awt.Font;
import java.text.NumberFormat;



/**
 * The <code>TreeFrame</code> is responsible for the last frame. 
 * It contains the trie, confusion matrix, score functions, and 
 * three buttons.
 *
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 * @version 1.0
 */
class TreeFrame extends JFrame
   implements ActionListener 
{
      private JButton backbutton;
      private JButton savebutton;
      private JButton exitbutton;

      /**
       * The decision tree.
       *
       */
      private DecisionTree decision_tree;
      private SecondFrameBuild parent;

      private int nr_of_tr_points;

      public TreeFrame( 
	 SecondFrameBuild parent, DecisionTree decision_tree,
	 TreeMap<String, TreeMap<String, Integer>> confusion_matrix,
	 Pair<Integer, Integer> size )
      {
	 setTitle("Decision Tree");
	 setSize(800, 600);
	 this.decision_tree = decision_tree;
	 this.parent = parent;

	 DefaultMutableTreeNode top =
	    new DefaultMutableTreeNode(decision_tree);
	 decision_tree.buildJavaTree(top);
	 JTree tree = new JTree(top);
	 tree.getSelectionModel().setSelectionMode
	    (TreeSelectionModel.SINGLE_TREE_SELECTION);
	 TreeExpander.expandJTreeNode(tree, tree.getModel(), 
			 tree.getModel().getRoot(), 0, -1);
	 tree.setRootVisible(true);

	 JScrollPane dtpanel = new JScrollPane(tree);
	 dtpanel.setPreferredSize(new Dimension(350,400));

	 Dimension buttondim = new Dimension(150,50);
	 backbutton = new JButton("Back");
	 backbutton.addActionListener(this);
	 backbutton.setPreferredSize(buttondim);

	 savebutton = new JButton("Save model!");
	 savebutton.addActionListener(this);
	 savebutton.setPreferredSize(buttondim);
	 exitbutton = new JButton("Exit");
	 exitbutton.addActionListener(this);
	 exitbutton.setPreferredSize(buttondim);

	 JPanel buttonpanel = new JPanel();
	 buttonpanel.add(backbutton);
	 buttonpanel.add(savebutton);
	 buttonpanel.add(exitbutton);

	 JPanel matrixpanel = new JPanel(
	    new GridLayout(confusion_matrix.size()+2,
			   confusion_matrix.size()+3,5,0));
	 int proper_class_number = 
	    buildConfusionMatrixPanel(matrixpanel, confusion_matrix);

	 JPanel scorepanel = new JPanel();
	 scorepanel.setBorder(BorderFactory.createTitledBorder(
	       BorderFactory.createRaisedBevelBorder(),"Score"));
	 float proper_class_rate =
	    1.0f * proper_class_number / nr_of_tr_points;
	 NumberFormat pform = NumberFormat.getPercentInstance();
	 JLabel pcr = new JLabel(pform.format(proper_class_rate));
	 pcr.setFont(new Font("Serif", Font.BOLD, 20));
	 JLabel nol = new JLabel(String.valueOf(size.first));
	 nol.setFont(new Font("Serif", Font.BOLD, 20));
	 JLabel dot = new JLabel(String.valueOf(size.second));
	 dot.setFont(new Font("Serif", Font.BOLD, 20));

	 Box hbox21 = Box.createHorizontalBox();
	 hbox21.add(new JLabel("Proper class ratio: "));
	 hbox21.add(Box.createHorizontalGlue());
	 hbox21.add(pcr);

	 Box hbox22 = Box.createHorizontalBox();
	 hbox22.add(new JLabel("Number of leaves: "));
	 hbox22.add(Box.createHorizontalGlue());
	 hbox22.add(nol);

	 Box hbox23 = Box.createHorizontalBox();
	 hbox23.add(new JLabel("Depth of the tree: "));
	 hbox23.add(Box.createHorizontalGlue());
	 hbox23.add(dot);

	 Box vbox2 = Box.createVerticalBox();
	 vbox2.add(hbox21);
	 vbox2.add(Box.createVerticalStrut(15));
	 vbox2.add(hbox22);
	 vbox2.add(Box.createVerticalStrut(15));
	 vbox2.add(hbox23);
	 scorepanel.add(vbox2);
      
	 Box vbox = Box.createVerticalBox();
	 vbox.add(dtpanel);
	 Box hbox = Box.createHorizontalBox();
	 hbox.add(Box.createHorizontalStrut(10));
	 hbox.add(matrixpanel);
	 hbox.add(Box.createHorizontalStrut(10));
	 hbox.add(scorepanel);
	 hbox.add(Box.createHorizontalStrut(10));
	 hbox.add(buttonpanel);
	 hbox.add(Box.createHorizontalStrut(10));
	 vbox.add(hbox);
	 getContentPane().add(vbox);
      }
      public void actionPerformed(ActionEvent e)
      {
	 if( e.getSource() == backbutton )
	 {
	    dispose();
	    parent.setVisible(true);
	 }
	 else if( e.getSource() == savebutton )
	 {
	    JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new File("."));
	    chooser.setDialogTitle("Save decision tree model");
	    ExtensionFileFilter file_filter = new ExtensionFileFilter();
	    file_filter.add("dtm");
	    file_filter.setDescription(
	       "decision tree model (*.dtm)!");

	    chooser.setFileFilter(file_filter);

	    int returnVal = chooser.showSaveDialog(TreeFrame.this);
	    if( returnVal == JFileChooser.APPROVE_OPTION )
	    {
	       try 
	       {
		  String file_name = chooser.getSelectedFile().
		     getPath();
		  if( file_filter.getExtension(file_name) == null )
		     file_name += ".dtm";

		  ObjectOutputStream out = new ObjectOutputStream(
		     new FileOutputStream(file_name));
		  out.writeObject(decision_tree);
		  parent.saveAttrInfo(out);
		  out.close();
		  JOptionPane.showMessageDialog( TreeFrame.this, 
						 "The model has been saved!" );
	       }
	       catch( IOException exception )
	       {
		  JOptionPane.showMessageDialog( TreeFrame.this, "Exception" );
		  exception.printStackTrace();
		  System.exit(1);
	       }

	    }
	    
	 }
	 else if( e.getSource() == exitbutton )
	    System.exit(0);
      }

      /**
       * This method builds the confusion matrix.
       */
      private int buildConfusionMatrixPanel( JPanel matrixpanel,
	 TreeMap<String, TreeMap<String, Integer>> confusion_matrix)
      {
	 NumberFormat pform = NumberFormat.getPercentInstance();
	 int proper_class_number = 0;
	 matrixpanel.setBorder(BorderFactory.createTitledBorder(
	       BorderFactory.createRaisedBevelBorder(),"Confusion Matrix"));
	 int[] sumvector = new int[confusion_matrix.size()];
	 Arrays.fill(sumvector, 0);

	 matrixpanel.add(new JLabel());
	 nr_of_tr_points = 0;
	 Iterator<Map.Entry<String, TreeMap<String, Integer>>> entry_iter = 
	    confusion_matrix.entrySet().iterator();
	 Map.Entry<String, TreeMap<String, Integer>> an_entry;
	 while(entry_iter.hasNext())
	 {
	    an_entry = entry_iter.next();
	    matrixpanel.add(new JLabel("=>" + an_entry.getKey()));
	    nr_of_tr_points += Algorithms.sum(an_entry.getValue().values());
	 }
	 matrixpanel.add(new JLabel("sum"));
	 matrixpanel.add(new JLabel("ratio"));

	 entry_iter = confusion_matrix.entrySet().iterator();
	 Set<String> classes = confusion_matrix.keySet();
	 Iterator<String> classes_iter;	 
	 String a_class;

	 Integer an_Int, sum;
	 float a_percent;
	 while(entry_iter.hasNext())
	 {
	    an_entry = entry_iter.next();
	    matrixpanel.add(new JLabel(an_entry.getKey()));
	    sum = 0;
	    int index = 0;
	    for( classes_iter  = classes.iterator(); classes_iter.hasNext(); )
	    {
	       a_class = classes_iter.next();
	       an_Int = an_entry.getValue().get(a_class);
	       if( an_Int == null )
		  an_Int = 0;
	       sum += an_Int;
	       matrixpanel.add(new JLabel(an_Int.toString()));
	       sumvector[index] += an_Int;
	       index++;
	       if( a_class.equals(an_entry.getKey()) )
		  proper_class_number += an_Int;
	    }
	    matrixpanel.add(new JLabel(sum.toString()));
	    matrixpanel.add(new JLabel(
	       pform.format(1.0f * sum / nr_of_tr_points)));
	 }
	 matrixpanel.add(new JLabel("Sum"));
	 for( int an_int : sumvector )
	    matrixpanel.add(new JLabel(String.valueOf(an_int)));
	 matrixpanel.add(new JLabel(String.valueOf(nr_of_tr_points)));
	 matrixpanel.add(new JLabel(pform.format(1)));

	 return proper_class_number;
      }


}
