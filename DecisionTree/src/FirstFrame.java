
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/**

 * The <code>FirstFrame</code> class implements the first frame of the
 * <code>BuildDTModel</code> and the <code>PredictUnseenint</code>
 * programs.  This frame shows an introductory text and ask for a
 * file. The file can be selected via a dialog box. When the file is
 * selected and the <pre>next</pre> button is pressed, then the second
 * frame is displayed.
 *
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 */
class FirstFrame extends JFrame
   implements ActionListener
{
      JButton selectbutton;
      JTextField tfilename;
      JButton nextbutton;
      boolean build_or_predict;

      /**
       * Creates a new <code>FirstFrame</code> instance.
       *
       * @param introstring an introductory <code>String</code> that
       * will be contained in the upper panel
       * @param fileaskstring a <code>String</code> that ask for a
       * name of a file
       * @param build_or_predict a <code>boolean</code> value that is
       * true if the frame was called by the <code>BuildDTModel</code>
       * class and false if was called by the
       * <code>PredictUnseenint</code> class
       */
      public FirstFrame(String introstring, String fileaskstring, 
			boolean build_or_predict)
      {
	 setTitle("Building decision tree model");
	 setSize(320, 450);
	 this.build_or_predict = build_or_predict;

		
	 JTextArea intro = new JTextArea(introstring);
	 intro.setEditable(false);
	 intro.setLineWrap(true);
	 intro.setWrapStyleWord(true);
	 intro.setColumns(22);
	 intro.setFocusable(false);
	 intro.setBackground(getContentPane().getBackground());
	 intro.setBorder(
	    BorderFactory.createTitledBorder(
	       BorderFactory.createRaisedBevelBorder(),"Introduction"));
//	 intro.setMinimumSize(intro.getPreferredSize());
	 intro.setMaximumSize(intro.getPreferredSize());

		
	 JTextArea askfile = new JTextArea(fileaskstring);
	 askfile.setEditable(false);
	 askfile.setLineWrap(true);
	 askfile.setWrapStyleWord(true);
	 askfile.setColumns(22);
	 askfile.setFocusable(false);
	 askfile.setBackground(getContentPane().getBackground());

	 askfile.setPreferredSize(new Dimension(200,200));
	 askfile.setMargin(new Insets(20,20,20,10));
		
	 tfilename = new JTextField(15);
	 tfilename.setMinimumSize(tfilename.getPreferredSize());
	 tfilename.setMaximumSize(tfilename.getPreferredSize());
		
	 selectbutton = new JButton("Select");
	 selectbutton.addActionListener(this);
		
	 nextbutton = new JButton("Next");
	 nextbutton.addActionListener(this);
	 JPanel nextbuttonpanel = new JPanel();
	 nextbuttonpanel.add(nextbutton);
		
	 Box vbox = Box.createVerticalBox();
	 vbox.add(Box.createVerticalStrut(10));
	 vbox.add(intro);
	 vbox.add(Box.createVerticalStrut(20));
	 vbox.add(askfile);
	 vbox.add(Box.createVerticalStrut(10));

	 Box hbox = Box.createHorizontalBox();
	 hbox.add(tfilename);
	 hbox.add(Box.createHorizontalStrut(10));
	 hbox.add(selectbutton);

	 String infostring = "  \u00A9Ferenc Bodon    ";
	 if( build_or_predict )
	    infostring += "BuildDTModel ";
	 else
	    infostring += "PredictUnseenPoint ";
	 infostring += "(version 1.2.2)";
	 JTextArea tauthor = new JTextArea(infostring);
	 tauthor.setFont(new Font("", Font.PLAIN, 9));
	 tauthor.setEditable(false);
	 tauthor.setBackground(getContentPane().getBackground());
	 Box hbox2 = Box.createHorizontalBox();
	 hbox2.add(tauthor);

	 vbox.add(hbox);
	 vbox.add(Box.createVerticalStrut(20));
	 vbox.add(nextbuttonpanel);
	 vbox.add(Box.createVerticalStrut(20));
	 vbox.add(hbox2);
	 getContentPane().add(vbox);
      }

      public void actionPerformed(ActionEvent e)
      {
	 Object source = e.getSource();
	 //Handle selectbutton action.
	 if( source == selectbutton )
	 {
	    JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new File("."));
	    chooser.setDialogTitle("Open training points file");
	    ExtensionFileFilter file_filter = new ExtensionFileFilter();
	    if( build_or_predict )
	    {
	       file_filter.add("csv");
	       file_filter.setDescription(
		  "comma separated value files (*.csv)!");
	    }
	    else
	    {
	       file_filter.add("dtm");
	       file_filter.setDescription(
		  "decision tree model (*.dtm)!");
	    }
	    chooser.setFileFilter(file_filter);

	    int returnVal = chooser.showDialog(FirstFrame.this,"Select");
	    if( returnVal == JFileChooser.APPROVE_OPTION )
	    {
	       tfilename.setText(chooser.getSelectedFile().getPath());
	    }
	 }
	 else if( source == nextbutton )
	 {
	    try
	    {
	       setVisible(false);
	       JFrame secondframe;
	       if( build_or_predict ) secondframe =  
		       new SecondFrameBuild(this, tfilename.getText());
	       else secondframe =  
		       new SecondFramePredict(this, tfilename.getText());

	       secondframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       secondframe.setLocationRelativeTo(null);
//	       secondframe.pack();
	       secondframe.setVisible(true);
	    }
	    catch(FileNotFoundException exception)
	    {
	       JOptionPane.showMessageDialog(
		  FirstFrame.this, 
		  "The file you have specified does not exist!");
	    }
	    catch(IOException exception)
	    {
	    }
		
	 }
      }
}
