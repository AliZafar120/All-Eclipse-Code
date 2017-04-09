

import javax.swing.text.DocumentFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter.FilterBypass;

/**
   A filter that can be used to restricts the textfield 
   input to digits and a '-' sign.
*/
public class IntFilter extends DocumentFilter
{
      public void insertString(FilterBypass fb, int offset, 
			       String string, AttributeSet attr) 
	 throws BadLocationException 
      {
	 super.insertString(fb, offset, common(string), attr);
      }

      public void replace(FilterBypass fb, int offset, int length, 
			  String string, AttributeSet attr) 
	 throws BadLocationException 
      {
	 if(string != null) 
	 {
	    string =  common(string);
	 }
	 super.replace(fb, offset, length, string, attr);
      }

      private String common(String string)
      {
	 StringBuilder builder = new StringBuilder(string);
         for(int i = builder.length() - 1; i >= 0; i--)
         {
            int cp = builder.codePointAt(i);
            if(!Character.isDigit(cp) && cp != '-') 
            {
               builder.deleteCharAt(i);
               if(Character.isSupplementaryCodePoint(cp))
               {
                  i--;
                  builder.deleteCharAt(i);
               }
            }
         }
         return  builder.toString();
      }
}
