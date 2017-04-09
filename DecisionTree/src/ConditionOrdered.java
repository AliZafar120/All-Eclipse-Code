

/**
 * This class represent a Condition that applies to attribute of type
 * ordinal. In the case of ordinal attributes the values can be compared.
 * Hence the condition is like "the value of an attribute is less than or 
 * equal to an attribute's value". 
 *
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 * @version 1.0
 */

import java.text.NumberFormat;
class ConditionOrdered extends Condition
{
      private Comparable theSplitValue;
      public ConditionOrdered(String attribut_name, Comparable theSplitValue)
      {
	 super(attribut_name);
	 this.theSplitValue = theSplitValue;
      }
      public String toString()
      {
	 NumberFormat pform = NumberFormat.getNumberInstance();

	 return super.toString() + " <= " + pform.format(theSplitValue);
      }

      public boolean meetsCondition(Object attribute_value)
      {
	 if( ((Comparable) attribute_value).compareTo(theSplitValue) > 0 )
	    return false;
	 else
	    return true;
      }
}
