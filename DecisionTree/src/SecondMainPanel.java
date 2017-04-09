

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



/**
 * The <code>SecondMainPanel</code> is a kind of template panel used by
 * the <code>SecondFrameBuild</code> and <code>SecondFramePredict</code>.
 * It contains an intro text, a panel that belong to the attributes and 
 * a panel with three buttons. The attributepanel contains the name, type, 
 * role of the attributes and optionally a <code>JComponent</code> where
 * values can be provided. If the type of the attribute is numeric, then
 * the component is a text field (only digits are accepted), otherwise it
 * is a JComboBox.
 *
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 * @version 1.0
 */
class SecondMainPanel extends JPanel
{
      public SecondMainPanel()
      {
      }

      /**
       * This method build up the panel.
       *
       * @param introtext a <code>String</code> that contains the intoductory 
       * text
       * @param all_attr_name a <code>String[]</code> that contains all 
       * attribute names
       */
      public void buildUp(
	 String introtext, String[] all_attr_name, 
	 ArrayList<JComboBox> combolist_type,
	 ArrayList<JComboBox> combolist_role, ArrayList<JComponent> values)
      {
	 JTextArea intro = new JTextArea(introtext);
	 intro.setEditable(false);
	 intro.setLineWrap(true);
	 intro.setWrapStyleWord(true);
	 intro.setColumns(30);
	 intro.setFocusable(false);
	 intro.setBackground(getBackground());
	 intro.setBorder( BorderFactory.createTitledBorder(
			     BorderFactory.createEtchedBorder(),
			     "usage"));
	 JPanel intropanel = new JPanel(
	    new FlowLayout(FlowLayout.CENTER));
	 intropanel.add(intro);

	 Box hbox = Box.createHorizontalBox();
	 JPanel temppanel;
	 if( values == null )
	    temppanel = new JPanel(new GridLayout(3,1, 8, 15));
	 else
	    temppanel = new JPanel(new GridLayout(4,1, 8, 15));

	 temppanel.add(new JLabel("Name:"));
	 temppanel.add(new JLabel("Type:"));
	 temppanel.add(new JLabel("Role:"));
	 if( values != null )
	    temppanel.add(new JLabel("Values:"));
	 hbox.add(Box.createHorizontalStrut(10));
	 hbox.add(temppanel);
	 for( int index =0; index< all_attr_name.length; index++ )
	 {
	    if( values == null )
	       temppanel = new JPanel(new GridLayout(3,1, 10, 10));
	    else 
	       temppanel = new JPanel(new GridLayout(4,1, 10, 10));
	    temppanel.add(new JLabel(all_attr_name[index]));
	    temppanel.add(combolist_type.get(index));
    	    temppanel.add(combolist_role.get(index));
	    if( values != null )
	       temppanel.add(values.get(index));
	    hbox.add(Box.createHorizontalStrut(10));
	    hbox.add(temppanel);
	 }
	 hbox.add(Box.createHorizontalStrut(10));

	 JScrollPane attrpane = new JScrollPane(hbox);
	 if( values == null )
	    attrpane.setPreferredSize(new Dimension(780,120));
	 else 
	    attrpane.setPreferredSize(new Dimension(780,160));
	 
	 Box vbox = Box.createVerticalBox();
	 vbox.add(intropanel);
	 vbox.add(Box.createVerticalStrut(20));
	 vbox.add(attrpane);
	 add(vbox);
      }
}
