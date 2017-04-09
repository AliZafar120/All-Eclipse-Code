
import java.util.TreeSet;
import java.util.Iterator;


/**
 * This class represent a Condition that applies to attribute of type
 * nominal. In the case of nominal attributes only equality can be tested.
 * Hence the condition is like "the value of an attribute is in a set of 
 * attribute's value". 
 *
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 * @version 1.0
 */
class ConditionNominal extends Condition
{

      private TreeSet<String> theSubSet;
      public ConditionNominal(String attribut_name, TreeSet<String> theSubSet)
      {
	 super(attribut_name);
	 this.theSubSet = theSubSet;
      }
      public String toString()
      {
	 String ret = super.toString() + " is in {";
	 for( Iterator<String> string_iter = theSubSet.iterator(); 
	      string_iter.hasNext(); )
	    ret += string_iter.next() + ", ";
	 ret = ret.substring(0, ret.length()-2) + "}";
	 
	 return ret;
      }
      public boolean meetsCondition(Object attribute_value)
      {
	 return theSubSet.contains(attribute_value);
      }
}
