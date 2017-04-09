import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;


public class GUI {
	 private static String folder_chosen="Choose a folder";
	public static void main( String[] args )
	   {
		   //adding panel to jframe
		
	      JPanel panel = new JPanel();  
	      JPanel pan= new JPanel();
	      JFrame application = new JFrame();
	      JButton button_choose_folder=new JButton(folder_chosen);
	      JButton button_open= new JButton("Open");
	      button_choose_folder.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent ae) {
	              JFileChooser fileChooser = new JFileChooser();
	              fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	              int returnValue = fileChooser.showOpenDialog(null);
	              if (returnValue == JFileChooser.APPROVE_OPTION) {
	                File selectedFile = fileChooser.getSelectedFile();
	                folder_chosen=fileChooser.getSelectedFile().getAbsolutePath();
	                System.out.println(folder_chosen);
	                button_choose_folder.setText(folder_chosen);
	              }
	            }
	          });
	      
	      
	      button_open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File dir = new File(folder_chosen);
				 if (dir.isDirectory()) { // make sure it's a directory
			            for (final File f : dir.listFiles(IMAGE_FILTER)) {
			                BufferedImage img = null;

			            }          
				 }
		}});
	      
	      
	      
	      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	      application.setSize( 300, 300 );
	      application.setVisible( true );
	      application.setLayout(new FlowLayout());
	
	      application.add( panel );
	      application.add(button_choose_folder);
	      application.add(button_open);
	     

	   } 
	
	 static final String[] EXTENSIONS = new String[]{
	        "gif", "png", "bmp" // and other formats you need
	    };
	 static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

	        @Override
	        public boolean accept(final File dir, final String name) {
	            for (final String ext : EXTENSIONS) {
	                if (name.endsWith("." + ext)) {
	                    return (true);
	                }
	            }
	            return (false);
	        }
	    };
	 
	 
	 static class ClickAction1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		
			
			JFileChooser fc= new JFileChooser();
			fc.setCurrentDirectory(new java.io.File("C:\\Users\\User\\Desktop"));
			fc.setDialogTitle("Image Chooser");
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
			     
			
		}
	 }

	 
	 


}

