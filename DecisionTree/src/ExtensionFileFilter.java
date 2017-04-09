

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.TreeSet;


/**
 * This class implements a filter class that can easily be
 * used to filter files based on their extensions.
 *
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 * @version 1.0
 */
public class ExtensionFileFilter extends FileFilter
{
      /**
       * The set of extensions that are accepted.
       */
      TreeSet<String> extensions;
      String description;

      public ExtensionFileFilter()
      {
	 super();
	 extensions = new TreeSet<String>();
      }

      /**
       * This method adds an extension to the set of
       * extensions that are accepted
       *
       * @param an_extension a <code>String</code> 
       * value that gives the extension
       */
      public void add(String an_extension)
      {
	 extensions.add(an_extension);
      }

      /**
       * This method decides if a given file can be 
       * accepted (its extension is OK) or not
       *
       * @param f the file that has to be checked
       * @return a <code>boolean</code> value that is true is
       * the file si accepted, otherwise false.
       */
      public boolean accept(File f) 
      {
	 if (f.isDirectory()) 
	    return true;
	       
	 String the_extension = getExtension(f.getName());
	 if(the_extension != null) 
	 {
	    if(extensions.contains(the_extension))
	       return true;
	    else 
	       return false;
	 }
	 return false;
      }

      /**
       * Returns the description of this filter
       */
      public String getDescription() 
      {
	 return description;
      }

      /**
       * Sets the description of this filter
       */
      public void setDescription(String description) 
      {
	 this.description = description;
      }


      /**
       * This method retrieves the extension of a filename
       *
       * @param file_name the name of file
       * @return the extension of the file
       */
      public String getExtension(String file_name) 
      { 
	 String ext = null; 
	 int i = file_name.lastIndexOf('.'); 
	 if( i > 0 && i < file_name.length() - 1) 
	    ext = file_name.substring(i+1).toLowerCase(); 
	 return ext; 
      }
}
