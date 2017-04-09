
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.text.InternationalFormatter;
import java.text.NumberFormat;
import javax.swing.text.DocumentFilter;
import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
 * This class implements the second frame of the 
 * <code>PredictUnseenPoint</code> program.
 *
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 * @version 1.0
 */
class SecondFramePredict extends JFrame
   implements ActionListener 
{

      /**
       * The frame that created and displayed this frame
       *
       */
      private JFrame parent;

      /**
       * The same as {@link SecondFrameBuild#combolist_type}
       */
      private ArrayList<JComboBox> combolist_type;

      /**
       * The same as {@link SecondFrameBuild#combolist_role}
       */
      private ArrayList<JComboBox> combolist_role;

      /**
       * The same as {@link SecondFrameBuild#attr_names}
       */
      private List<String> attr_names;

      /**
       * The values of the attributes that will be entered by the user
       */
      private ArrayList<JComponent> values;

      /**
       * <code>is_already_edited[i]</code> is <code>true</code> if the <em>ith</em> 
       * attribute´s value has been entered by the user. Otherwise it is 
       * <code>false</code>
       */
      private boolean[] is_already_edited;

      /**
       * The decision tree that is used through the prediction
       *
       */
      private DecisionTree decision_tree;

      private JButton backbutton;
      private JButton functionbutton;
      private JButton exitbutton;


      /**
       * A temporal (sub)decision tree;
       *
       */
      DecisionTree tempdt;
	
      /**
       * Creates a new <code>SecondFramePredict</code> instance.
       *
       * @param parent  the frame that created and displayed this frame
       * @param dt_model_file_name the name of the file that contains the
       * decision tree and other importand data.
       * @exception FileNotFoundException if the file does not exist
       */
      public SecondFramePredict(JFrame parent, String dt_model_file_name)
	 throws FileNotFoundException
      {
	 this.parent = parent;
	 setTitle("Attribute values ");
	 setSize(800,500);
	 SecondMainPanel firstPanel = new SecondMainPanel();
	 setVariables( dt_model_file_name, firstPanel );
	 getContentPane().setLayout(new BorderLayout());
	 getContentPane().add(firstPanel, BorderLayout.CENTER);
	 getContentPane().add(buildButtonPanel(),BorderLayout.SOUTH);
	 init();

      }
      public void actionPerformed(ActionEvent e)
      {
	 if( e.getSource() == functionbutton )
	 {
	    if( functionbutton.getText() == "Value is set" )
	       doProperAction();
	    else
	       init();
	 }
	 else if( e.getSource() == exitbutton )
	    System.exit(0);
	 else if( e.getSource() == backbutton )
	 {
	    dispose();
	    parent.setVisible(true);
	 }

      }

      /**
       * This metod builds up the panel that contains the three buttons.
       */
      private JPanel buildButtonPanel()
      {
	 backbutton = new JButton("Back");
	 backbutton.addActionListener(this);
	 backbutton.setPreferredSize(new Dimension(150,50));

	 functionbutton = new JButton("Build model!");
	 functionbutton.addActionListener(this);
	 functionbutton.setPreferredSize(new Dimension(150,50));

	 exitbutton = new JButton("Exit");
	 exitbutton.addActionListener(this);
	 exitbutton.setPreferredSize(new Dimension(150,50));

	 JPanel buttonpanel = new JPanel( );
	 buttonpanel.add(backbutton);
	 buttonpanel.add(functionbutton);
	 buttonpanel.add(exitbutton);

	 return buttonpanel;
      }

      /**
       * This method reads the data from the file that contains
       * the decision tree, and then assigns read in values to the
       * members
       *
       * @param dt_model_file_name the name of the file that contains the
       * decision tree and other importand data.
       * @param mainPanel the main panel
       * @exception FileNotFoundException if the file does not exist
       */
      private  void setVariables(String dt_model_file_name, SecondMainPanel mainPanel) 
	 throws FileNotFoundException
      {
	 String[] st;
	 try
	 {
	    ObjectInputStream in = new ObjectInputStream(
	       new FileInputStream(dt_model_file_name));
	    decision_tree = (DecisionTree) in.readObject();
	    st = (String[]) in.readObject();
	    attr_names = Arrays.asList(st);
	    
	    combolist_type = new ArrayList<JComboBox>();
	    for( int index = 0; index<attr_names.size(); index++ )
	    {
	       JComboBox tempCombo = new JComboBox();
	       tempCombo.addItem(AttributeType.NOMINAL);
	       tempCombo.addItem(AttributeType.INTEGER);
	       tempCombo.addItem(AttributeType.REAL);
	       tempCombo.setSelectedItem((AttributeType) in.readObject());
	       tempCombo.setEnabled(false);
	       tempCombo.setFont(new Font("", Font.PLAIN, 10));
	       combolist_type.add(tempCombo);
	    }

	    combolist_role = new ArrayList<JComboBox>();
	    for( int index = 0; index<attr_names.size(); index++ )
	    {
	       JComboBox tempCombo = new JComboBox();
	       tempCombo.addItem(AttributeRole.INPUT);
	       tempCombo.addItem(AttributeRole.CLASS);
	       tempCombo.addItem(AttributeRole.UNUSED);
	       tempCombo.setSelectedItem((AttributeRole) in.readObject());
	       tempCombo.setEnabled(false);
	       combolist_role.add(tempCombo);
	    }
	    ArrayList<Integer> nom_attr_indices = 
	       (ArrayList<Integer>) in.readObject();
	    ArrayList<TreeSet<String>> nom_attr_values = 
	       (ArrayList<TreeSet<String>>) in.readObject();

	    JComponent tempcomp;
	    values = new ArrayList<JComponent>(attr_names.size());
	    is_already_edited = new boolean[attr_names.size()];
	    for( int index = 0; index<attr_names.size(); index++ )
	    {
	       if( combolist_role.get(index).getSelectedItem()  != 
		   AttributeRole.INPUT)
		  tempcomp = new JTextField();  //it wont be used!
	       else
	       {
		  if( combolist_type.get(index).getSelectedItem()  == 
		      AttributeType.INTEGER)
		     tempcomp = new JFormattedTextField( 
			new InternationalFormatter(
			   NumberFormat.getIntegerInstance() )
			{
			      protected DocumentFilter getDocumentFilter()
			      {
				 return filter;
			      }
			      private DocumentFilter filter = new IntFilter();
			});
		  else if( combolist_type.get(index).getSelectedItem()  == 
		      AttributeType.REAL)
		  {
		     tempcomp = new JFormattedTextField( 
			new InternationalFormatter( 
			   NumberFormat.getNumberInstance() )
			{
			      protected DocumentFilter getDocumentFilter()
			      {
				 return filter;
			      }
			      private DocumentFilter filter =new FloatFilter();
			});
		  }
		  else
		  {
		     tempcomp = new JComboBox( 
			nom_attr_values.get(nom_attr_indices.indexOf(index))
			.toArray());
		  }


	       }
	       tempcomp.setEnabled(false);
	       tempcomp.setFont(new Font("", Font.PLAIN, 10));
	       values.add(tempcomp);
	       is_already_edited[index]= false;
	    }
	    backbutton = new JButton("Back");
	    backbutton.addActionListener(this);
	    backbutton.setPreferredSize(new Dimension(150,50));

	    functionbutton = new JButton("Value is set");
	    functionbutton.addActionListener(this);
	    functionbutton.setPreferredSize(new Dimension(150,50));

	    exitbutton = new JButton("Exit");
	    exitbutton.addActionListener(this);
	    exitbutton.setPreferredSize(new Dimension(150,50));

	    String introtext = "Please give the value of the attributes.\n\n"
	       + "The required attributvalues and their order is "
	       + "determined by the decision tree. "
	       + "You can provide only one attribute value at a time."
	       + "Based on the value entered other attributevalue may be requested";

	    mainPanel.buildUp( 
	       introtext, st, combolist_type, combolist_role,
	       values );

	 }
	 catch( IOException exception )
	 {
	    JOptionPane.showMessageDialog( SecondFramePredict.this, "Exception" );
	    exception.printStackTrace();
	    System.exit(1);
	 }
	 catch( ClassNotFoundException exception )
	 {
	    JOptionPane.showMessageDialog( 
	       SecondFramePredict.this, "ClassNotFoundException" );
	    exception.printStackTrace();
	    System.exit(1);
	 }


      }

      /**
       * This method does the proper action when the value of
       * an attribute is set. Based on the value entered the decision
       * can be made (leaf is reached in the decision tree)
       * or the value of an other attribute is needed.
       */
      private void doProperAction()
      {
	 do
	 {
	    if( tempdt.isLeaf() )
	    {
	       JOptionPane.showMessageDialog( 
		  SecondFramePredict.this, "The prediction is: " + tempdt.toString() );
	       functionbutton.setText("New prediction");  
	       break;
	    }
	    else
	    {
	       String attr_name = tempdt.getConditionAttrName();
	       int index = attr_names.lastIndexOf(attr_name);
	       if( !is_already_edited[index] )
	       {
		  values.get(index).setEnabled(true);
		  values.get(index).setBackground(Color.orange);
		  values.get(index).requestFocusInWindow();
		  is_already_edited[index] = true;
		  functionbutton.setText("Value is set");
		  break;
	       }
	       else
	       {
		  if( combolist_type.get(index).getSelectedItem() == 
		      AttributeType.INTEGER )
		  {
		     Number attr_int_value = (Number) 
			((JFormattedTextField) values.get(index)).getValue();
		     tempdt = tempdt.properSubtree(
			new Integer(attr_int_value.intValue()));
		  }
		  else if( combolist_type.get(index).getSelectedItem() == 
		      AttributeType.REAL )
		  {
		     Number attr_int_value = (Number) 
			((JFormattedTextField) values.get(index)).getValue();
		     tempdt = tempdt.properSubtree(
			new Double(attr_int_value.doubleValue()));
		  }
		  else
		     tempdt = tempdt.properSubtree(
			((JComboBox) values.get(index)).getSelectedItem().toString());
		  values.get(index).setEnabled(false);		  
		  values.get(index).setBackground(
		     values.get(index).getParent().getBackground());
	       }
	    }
	 }
	 while(true);
      }

      /**
       * This method initializes the <code>is_already_edited</code>
       * array and clears the input fileds. Initialization is needed
       * either at the beginning or when new prediction is evoked.
       */
      private void init()
      {
	 tempdt = decision_tree;
	 for( int index = 0; index < values.size(); index++)
	 {
	    is_already_edited[index] = false;
	    if( combolist_role.get(index).getSelectedItem() == 
		      AttributeRole.INPUT &&
		combolist_type.get(index).getSelectedItem() != 
		AttributeType.NOMINAL)
	       ((JTextField) values.get(index)).setText("");
	 }
	 doProperAction();
      }
}
