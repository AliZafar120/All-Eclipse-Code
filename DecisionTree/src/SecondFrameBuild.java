

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.Math;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerNumberModel;

enum AttributeType {NOMINAL, INTEGER, REAL};
enum AttributeRole {INPUT, CLASS, UNUSED};
enum SelectionCriterion {ENTROPY, GINI, CHI, MPI};


/**
 * The <code>SecondFrameBuild</code> class is responsible to get the
 * parameters needed for the decision tree building algorithm.
 * The first group of parameters refer to the attributes of the reaining 
 * points, the second to the decision tree construction algorithm.

 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 */
class SecondFrameBuild extends JFrame
   implements ActionListener 
{

      /**
       * The <code>parent</code> is a frame that created the instance 
       * and then displayed this frame. If the back button is pressed we 
       * have to go back to the parent frame.
       *
       */
      private JFrame parent;

      /**
       * The <code>training_set_file_name</code> stores the name of the file
       * that contains the training points.
       */
      private String training_set_file_name;

      /**
       * The <code>all_attr_name</code> array stores the name of all 
       * attributes.
       */
      private String[] all_attr_name;

      /**
       * The <code>combolist_type</code> array stores combo boxes, each
       * belong to an attribute. The selected item will store the type
       * of the corresponding attribute. Two types of attribute exist: 
       * numeric and nominal. In the case of numeric attribute the condition
       * of a node in the decision tree is in the form 
       * <pre>if A is less or equal to c, </pre> where <em></em> denotes 
       * the attribute, * <em>c</em> is a constant that is determined by 
       * the algorithm. In the case of nominal attribute the condition is 
       * <pre>if A is an element of S</pre>, where <em>S</em> is a subset 
       * of the possible attribute values. <em>S</em> (similarly to <em>c</em>)
       * is determined automatically by the algorithm.
       *
       */
      private ArrayList<JComboBox> combolist_type;
      /**
       * The <code>combolist_role</code> array stores combo boxes, each
       * belong to an attribute. The selected item will store the role
       * of the corresponding attribute. There are three tyoes of role. 
       * If the role is <em>UNUSED</em> then the attribute will not be used
       * in any node of the decision tree. The can be exactly one 
       * <em>CLASS</em> attribute.
       */
      private ArrayList<JComboBox> combolist_role;

      /**
       * The <code>split_crit</code> is responsible for selecting
       * the splitting criterion used during the decision tree
       * induction algorithm.
       */
      private JComboBox split_crit;

      /**
       * The <code>train_point_need</code> stores the minimum number of 
       * traning point needed to spilt a node.
       *
       */
      private JSpinner train_point_need;

      /**
       * The <code>max_edges</code> stores the maximum number of child 
       * of a node.
       */
      private JSpinner max_edges;

      /**
       * The <code>max_depth</code> stores the maximum depth of the 
       * decision tree.
       */
      private JSpinner max_depth;
      /**
       * The <code>leaf_minimum_point</code> stores the minimum number of 
       * traning point needed in a leaf.
       *
       */
      private JSpinner leaf_minimum_point;

       /**
	* The button that starts builing the tree if it is pressed.
	*
	*/
       private JButton buildbutton;

      /**
       * If this button is pressed then the previus frame is displayed.
       *
       */
      private JButton backbutton;

      /**
       * A button to exit the program.
       *
       */
      private JButton exitbutton;

      /**
       * The <code>training_points</code> stores the training points. Each 
       * training point is a pair consisting of a class value and a list of
       * attribute values.
       */
      private ArrayList<Pair<String,ArrayList<Object>>> training_points;

      /**
       * The <code>attr_names</code> stores the name of attribute that has 
       * <em>INPUT</em> as role.
       */
      private ArrayList<String> attr_names;
	
	
      /**
       * Creates a new <code>SecondFrameBuild</code> instance.
       *
       * @param parent the <code>JFrame</code> that creates and makes 
       * this frame visible.
       * @param training_set_file_name a <code>String</code> value that 
       * stores the name of the file that contains the training points.
       * @exception FileNotFoundException if the specified file does not exist.
       */
      public SecondFrameBuild(JFrame parent, String training_set_file_name)
	 throws FileNotFoundException
      {
	 this.training_set_file_name = training_set_file_name;
	 this.parent = parent;
	 setTitle("Settings");
	 setSize(800,500);
	 SecondMainPanel firstPanel = new SecondMainPanel();
	 JPanel secondPanel = new JPanel();
	 try
	 {
	    buildFirstTab(firstPanel);
	    buildSecondTab(secondPanel);
			
	    JTabbedPane tabframe = new JTabbedPane();
	    tabframe.add("Basic", firstPanel);
	    tabframe.add("Advanced", secondPanel);
	    getContentPane().setLayout(new BorderLayout());
	    getContentPane().add(tabframe,BorderLayout.CENTER);
	    getContentPane().add(buildButtonPanel(),BorderLayout.SOUTH);

	 }
	 catch(IOException exception)
	 {
	    JOptionPane.showMessageDialog( 
	       SecondFrameBuild.this, "Exception!!!" );
	    System.exit(1);
	 }
      }
	
      /**
       * The <code>buildFirstTab</code> method builds up the first tab of the
       * second frame.
       *
       * @param firstPanel a <code>SecondMainPanel</code> that will be 
       * the contetn of the first tab
       * @exception FileNotFoundException if the specified file does not exist.
       * @exception IOException if an error occurs
       */
      private void buildFirstTab(SecondMainPanel firstPanel) 
	 throws FileNotFoundException, IOException 
      {
	 String introtext = "Please give the type and the role of "
	    + "the attributes.\n\n"
	    + "This implementation differs NOMINAL (unordered) and "
	    + "numeric (ordered) attributes. "
	    + "A numeric attribute can be either REAL or INTEGER. "
	    + "The three types are treated "
	    + "in a different way throughout the algorithm.\n\n"
	    + "For attribute role there are three choices. "
	    + "The attributes that should not play role in "
	    + "the classification (for example IDs) should be UNUSED."
	    + "The attribute that stores the class value should be "
	    + "CLASS. Choose INPUT for the remaining, i.e for the attributes "
	    +" that is zuggested to predict the value of the class attribute.";

	 BufferedReader training_set_file = 
	    new BufferedReader(new FileReader(training_set_file_name));
	 String first_line;
		
	 first_line = training_set_file.readLine();
	 all_attr_name = first_line.split(","); 
	 int index;
	 for(index = 0; index<all_attr_name.length; index++)
	    all_attr_name[index] = all_attr_name[index].trim();
	 combolist_type = new ArrayList<JComboBox>(all_attr_name.length);

	 for(index = 0; index<all_attr_name.length; index++)
	 {
	    JComboBox tempCombo = new JComboBox();
	    tempCombo.addItem(AttributeType.NOMINAL);
	    tempCombo.addItem(AttributeType.INTEGER);
	    tempCombo.addItem(AttributeType.REAL);
	    tempCombo.setFont(new Font("", Font.PLAIN, 10));
	    combolist_type.add(tempCombo);
	 }
		
	 combolist_role = new ArrayList<JComboBox>(all_attr_name.length);
	 for(index=0; index<all_attr_name.length; index++)
	 {
	    JComboBox tempCombo = new JComboBox();
	    tempCombo.addItem(AttributeRole.INPUT);
	    tempCombo.addItem(AttributeRole.CLASS);
	    tempCombo.addItem(AttributeRole.UNUSED);
	    combolist_role.add(tempCombo);
	 }
	 
	 firstPanel.buildUp( 
	    introtext, all_attr_name, combolist_type, combolist_role,
	    null );
	 setInitialTypes(training_set_file);
	 training_set_file.close();

      }

      /**
       * This metod builds up the panel that contains the three buttons.
       */
      private JPanel buildButtonPanel()
      {
	 backbutton = new JButton("Back");
	 backbutton.addActionListener(this);
	 backbutton.setPreferredSize(new Dimension(150,50));

	 buildbutton = new JButton("Build model!");
	 buildbutton.addActionListener(this);
	 buildbutton.setPreferredSize(new Dimension(150,50));

	 exitbutton = new JButton("Exit");
	 exitbutton.addActionListener(this);
	 exitbutton.setPreferredSize(new Dimension(150,50));

	 JPanel buttonpanel = new JPanel( );
	 buttonpanel.add(backbutton);
	 buttonpanel.add(buildbutton);
	 buttonpanel.add(exitbutton);

	 return buttonpanel;
      }
      /**
       * The <code>setInitialTypes</code> makes a recommendation to the type
       * of the attributes. This is done by reading the second line and
       * then checking each attribute value. If the attribute can be converted
       * to a double value, then tha recommendation is numeric, otherwise
       * it is nominal.
       *
       * @param training_set_file a <code>BufferedReader</code> that stores
       * the training points.
       */
      private void setInitialTypes(BufferedReader training_set_file)
      {
	 try
	 {
	    String second_line = training_set_file.readLine();
	    String[] attr_values = second_line.split(",");
	    if (attr_values.length == all_attr_name.length)
	       for(int index = 0; index < attr_values.length; index++)
	       {
		  try 
		  {
		     double a_double = Double.valueOf(attr_values[index].trim());
		     if( Math.ceil(a_double) == Math.floor(a_double) )
			combolist_type.get(index).setSelectedItem(
			   AttributeType.INTEGER);
		     else
			combolist_type.get(index).setSelectedItem(
			   AttributeType.REAL);
		  }
		  catch (NumberFormatException exception)
		  {
		     combolist_type.get(index).setSelectedItem(
			AttributeType.NOMINAL);
		  }
	    }
	 }
	 catch(IOException exception)
	 {
	    JOptionPane.showMessageDialog( 
	       SecondFrameBuild.this, "Exception!!!" );
	    System.exit(1);
	 }
      }


      /**
       * The <code>buildSecondTab</code> method build up the second tab.
       *
       * @param secondPanel the <code>JPanel</code> which is contained by 
       * the tab. This has to be built up.
       */
      private void buildSecondTab(JPanel secondPanel)
      {
	 Box hbox21 = Box.createHorizontalBox(); 
		
	 split_crit = new JComboBox();
	 split_crit.addItem(SelectionCriterion.ENTROPY);
	 split_crit.addItem(SelectionCriterion.GINI);
	 split_crit.addItem(SelectionCriterion.CHI);
	 split_crit.addItem(SelectionCriterion.MPI);
	 hbox21.add(Box.createHorizontalStrut(170));
	 hbox21.add(new JLabel("Splitting criterion:"));
	 hbox21.add(Box.createHorizontalGlue());
	 hbox21.add(split_crit);
	 hbox21.add(Box.createHorizontalStrut(200));
		
	 Box hbox22 = Box.createHorizontalBox(); 
	 train_point_need = new JSpinner(new SpinnerNumberModel(4,2,100,1));
	 hbox22.add(Box.createHorizontalStrut(170));
	 hbox22.add(new JLabel("Training points required to split a node: "));
	 hbox22.add(Box.createHorizontalGlue());
	 hbox22.add(train_point_need);
	 hbox22.add(Box.createHorizontalStrut(200));
		
	 Box hbox23 = Box.createHorizontalBox(); 
	 max_edges = new JSpinner(new SpinnerNumberModel(2,2,10,1));
	 max_edges.setEnabled(false);
	 hbox23.add(Box.createHorizontalStrut(170));
	 hbox23.add(new JLabel("Maximum number of edges of a node: "));
	 hbox23.add(Box.createHorizontalGlue());
	 hbox23.add(max_edges);
	 hbox23.add(Box.createHorizontalStrut(200));
		
	 Box hbox24 = Box.createHorizontalBox(); 
	 max_depth = new JSpinner(new SpinnerNumberModel(6,4,15,1));
	 hbox24.add(Box.createHorizontalStrut(170));
	 hbox24.add(new JLabel("Maximum depth of the tree: "));
	 hbox24.add(Box.createHorizontalGlue());
	 hbox24.add(max_depth);
	 hbox24.add(Box.createHorizontalStrut(200));
		
	 Box hbox25 = Box.createHorizontalBox(); 
	 leaf_minimum_point = new JSpinner(new SpinnerNumberModel(3,1,1000,1));
	 hbox25.add(Box.createHorizontalStrut(170));
	 hbox25.add(new JLabel("Minimum number of points in a leaf: "));
	 hbox25.add(Box.createHorizontalGlue());
	 hbox25.add(leaf_minimum_point);
	 hbox25.add(Box.createHorizontalStrut(200));

	 Box vbox2 = Box.createVerticalBox();
	 vbox2.add(Box.createVerticalStrut(80));
	 vbox2.add(hbox21);
	 vbox2.add(Box.createVerticalStrut(25));
	 vbox2.add(hbox22);
	 vbox2.add(Box.createVerticalStrut(25));
	 vbox2.add(hbox23);
	 vbox2.add(Box.createVerticalStrut(25));
	 vbox2.add(hbox24);
	 vbox2.add(Box.createVerticalStrut(25));
	 vbox2.add(hbox25);
	 vbox2.add(Box.createVerticalStrut(100));
		
	 secondPanel.add(vbox2);
      }
      public void actionPerformed(ActionEvent e)
      {
	 if( e.getSource() == buildbutton )
	 {
	    if( checkClass() && checkInputNr())
	    {
	       attr_names = new ArrayList<String>();
	       getInputAttrNames();
	       try 
	       {
		  BufferedReader training_set_file = 
		  new BufferedReader(new FileReader(training_set_file_name));
		  training_points = 
		     new ArrayList<Pair<String,ArrayList<Object>>>();       
		  getTrainingPoints(training_set_file);
		  TreeMap<String,TreeMap<String, Integer>> confusion_matrix = 
		     new TreeMap<String,TreeMap<String, Integer>>();
		  TreeMap<String, Integer> total_class_distr =
		     DecisionTree.buildClassDistribution(training_points);
		  DecisionTree decision_tree = 
		     new DecisionTree(training_points, total_class_distr);
		  decision_tree.setParameters( 
		     attr_names, ((Integer) max_depth.getValue()).intValue(),
		     (SelectionCriterion) split_crit.getSelectedItem(), 
		     ((Integer) train_point_need.getValue()).intValue(), 
		     ((Integer)leaf_minimum_point.getValue()).intValue() );
		  Pair<Integer, Integer> size = decision_tree.buildTree( 
		     training_points, 1, confusion_matrix, total_class_distr );
		  setVisible(false);
		  TreeFrame treeframe = new TreeFrame( this, decision_tree, 
						       confusion_matrix, size );
		  treeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  treeframe.setLocationRelativeTo(null);
		  treeframe.setVisible(true);
	       }
	       catch(FileNotFoundException ef)
	       {
		  // This has alrady been handled!
	       }
	       catch(NumberFormatException en)
	       {
	       }
	       catch(TooMuchValueException et)
	       {
		  String bad_attr_name = et.get_name_of_attribute();
		  JOptionPane.showMessageDialog(
		     SecondFrameBuild.this, 
		     "The attribute >" + bad_attr_name + 
		     "< has\nmore than 32 different values.\nThis requires "
		     + "too much computation.\nBy using random subset " +
		     "evaluation\nthe minimum split can be approximated"+
		     ",\nhowever this technique is not yet implemented.\n\n" +
		     "To change the role of the attribute to >UNUSED<\nand "+
		     "restart building the tree, press OK!", "information",
		     JOptionPane.INFORMATION_MESSAGE);
		  int index = Algorithms.firstOccurrence(
		     all_attr_name, bad_attr_name);
		  combolist_role.get(index).setSelectedItem(
		     AttributeRole.UNUSED);
		  actionPerformed(e);
	       }
	    }
	 }
	 else if( e.getSource() == backbutton  )
	 {
	    dispose();
	    parent.setVisible(true);
	 }
	 else if( e.getSource() == exitbutton )
	    System.exit(0);
      }

      /**
       * The <code>checkClass</code> method checks that the user selected 
       * exactly one attribute as the class attribute, and the type of this
       * selected attribute is nominal.
       *
       * @return a <code>boolean</code> value that is true if everything is
       * all right with the class attribute.
       */
      private boolean checkClass()
      {
	 boolean is_there_one = false;
	 for(int index = 0; index < combolist_role.size(); index++)
	    if( combolist_role.get(index).getSelectedItem() 
		== AttributeRole.CLASS )
	       if( is_there_one )
	       {
		  is_there_one = false;
		  break;
	       }
	       else
	       {
		  is_there_one = true;
		  if(combolist_type.get(index).getSelectedItem() != 
		      AttributeType.NOMINAL )
		  {
		     JOptionPane.showMessageDialog(
			SecondFrameBuild.this,"This implementation can only "+
			"handle class attributes of type Nominal.\nThe type " +
			"of >" + all_attr_name[index] + "< attribute has " +
			"been set to >Nominal<.", "information", 
			JOptionPane.INFORMATION_MESSAGE );
		     combolist_type.get(index).setSelectedItem(
			AttributeType.NOMINAL);
		  }
	       }
	 if( !is_there_one )
	    JOptionPane.showMessageDialog(SecondFrameBuild.this, 
	       "There has to be exactly one attribute with CLASS role!",
	       "error", JOptionPane.ERROR_MESSAGE);
	 return is_there_one;
      }

      /**
       * The <code>checkInputNr</code> method checks if there is one attribute
       * with INPUT role.
       *
       * @return a <code>boolean</code> that is false if there is no attribute 
       * with INPUT role, otherwise it is true.
       */
      private boolean checkInputNr()
      {
	 for(JComboBox acombo:combolist_role)
	    if( acombo.getSelectedItem() == AttributeRole.INPUT)
	       return true;
	 JOptionPane.showMessageDialog(SecondFrameBuild.this, 
	    "There has to be at least one attribute with input role!",
	    "error", JOptionPane.ERROR_MESSAGE);
	 return false;
      }

      /**
       * The <code>getInputAttrNames</code> method fills up the 
       * <code>attr_names</code> with the names of the attributes.
       *
       */
      private void getInputAttrNames()
      {
	 for( int index = 0; index < combolist_role.size(); index++ )
	    if( combolist_role.get(index).getSelectedItem() == AttributeRole.INPUT )
		  attr_names.add(all_attr_name[index]);
	    else;                                        // Not INPUT

      }

      /**
       * The <code>getTrainingPoints</code> method reads in the training
       * points from a file and inserts them into the array
       * <code>training_points</code>.
       *
       * @param training_set_file a <code>BufferedReader</code> value that
       * contains the training points.
       */
      private void getTrainingPoints(BufferedReader training_set_file)
	 throws NumberFormatException
      {
	 String a_line, a_class_value;
	 String[] attr_values;
	 ArrayList<Object> an_attribute_value_list;
	 int nr=0;
	 try
	 {
	    training_set_file.readLine();
	    while( (a_line = training_set_file.readLine()) != null )
	    {
	       if( a_line.trim().length() !=0 )
	       {
		  nr++;
		  an_attribute_value_list = new ArrayList<Object>();
		  a_class_value = "";    // just for the sake of the compiler

		  attr_values = a_line.split(",");
		  if (attr_values.length != all_attr_name.length)
		  {
		     JOptionPane.showMessageDialog(SecondFrameBuild.this, 
						   "The " + Integer.toString(nr)  +
						   "th row does not cointain exactly "
						   + Integer.toString(all_attr_name.length)+" attributes!",
						   "error", JOptionPane.ERROR_MESSAGE);
		     System.exit(1);
					
		  }
		  for(int index = 0; index < attr_values.length; index++)
		  {
		     attr_values[index] = attr_values[index].trim();
		     if( combolist_role.get(index).getSelectedItem() == 
			 AttributeRole.CLASS )
			a_class_value = attr_values[index];
		     else if( combolist_role.get(index).getSelectedItem() == 
			      AttributeRole.INPUT )
		     {
			try
			{
			   if( combolist_type.get(index).getSelectedItem() == 
			       AttributeType.INTEGER )
			      an_attribute_value_list.add(
				 new Integer(attr_values[index]));
			   else if( combolist_type.get(index).getSelectedItem()
				    == AttributeType.REAL )
			      an_attribute_value_list.add(
				 new Double(attr_values[index]));
			   else      // NOMINAL
			      an_attribute_value_list.add(attr_values[index]);
			}
			catch (NumberFormatException exception)
			{
			   JOptionPane.showMessageDialog(
			      SecondFrameBuild.this, "The " + 
			      Integer.toString(nr)+"th row contains a bad "+
			      "entry: " + attr_values[index]+ ".\nThe "
			      + all_attr_name[index] + " attribute should be " +
			      combolist_type.get(index).getSelectedItem() + 
			      ",\nhowever this value is not that type.\n\n " +
			      "Please change the type of the "+
			      all_attr_name[index] + " attribute",
			      "information", JOptionPane.INFORMATION_MESSAGE);
			   throw exception;
			}
		     }
		  }
		  training_points.add(new Pair<String,ArrayList<Object>>(
					 a_class_value,an_attribute_value_list));
	       }
	    }
	    training_set_file.close();
	 }
	 catch(IOException exception)
	 {
	    JOptionPane.showMessageDialog( 
	       SecondFrameBuild.this, "Exception" );
	    System.exit(1);
	 }
      }

      /**
       * The <code>saveAttrInfo</code> method saves the information about
       * the attributes. The inforamtion includes name, type, role of 
       * and for each nominal attributes the domain of it (i.e. the possible
       * attribute values). The domain is needed when we want to predict an
       * unseen object.
       *
       * @param out an <code>ObjectOutputStream</code> value
       */
      public void saveAttrInfo(ObjectOutputStream out)
      {
	 try 
	 {
	    out.writeObject(all_attr_name);
	    for(JComboBox acombo : combolist_type)
	       out.writeObject(acombo.getSelectedItem());
	    for(JComboBox acombo : combolist_role)
	       out.writeObject(acombo.getSelectedItem());

	    ArrayList<Integer> nom_attr_indices = new ArrayList<Integer>();
	    ArrayList<TreeSet<String>> nom_attr_values = 
	       new ArrayList<TreeSet<String>>();
	    int index;
	    for( index = 0; index < combolist_type.size(); index++)
	    {
	       if( combolist_role.get(index).getSelectedItem() == 
		   AttributeRole.INPUT &&
		  combolist_type.get(index).getSelectedItem() == 
		   AttributeType.NOMINAL)
	       {
		  nom_attr_indices.add(index);
		  nom_attr_values.add(new TreeSet<String>());
	       }
	    }

	    BufferedReader training_set_file = 
	       new BufferedReader(new FileReader(training_set_file_name));
	    training_set_file.readLine();
	    String a_line;
	    String[] attr_values;
	    while( (a_line = training_set_file.readLine()) != null )
	    {
	       attr_values = a_line.split(",");
	       index = 0;
	       for( Integer an_index : nom_attr_indices)
	       {
		  nom_attr_values.get(index).
		     add(attr_values[an_index.intValue()]);
		  index++;
	       }
	    }
	    out.writeObject(nom_attr_indices);
	    out.writeObject(nom_attr_values);
	    training_set_file.close();
	 }
	 catch( IOException exception )
	 {
	    JOptionPane.showMessageDialog( SecondFrameBuild.this, "Exception" );
	    exception.printStackTrace();
	    System.exit(1);
	 }
      }
}
	
