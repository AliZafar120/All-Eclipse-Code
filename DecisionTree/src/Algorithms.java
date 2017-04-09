

import java.util.Collection;
import java.util.Iterator;


/**
 * This class contains methods that are not included in the standard 
 * <code>util</code> package.
 *
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 * @version 1.0
 */
public class Algorithms
{

      /**
       * This returns the sum of the integers placed in collection.
       *
       * @return the sum of the elements.
       */
      public static int sum(Collection<Integer> collection)
      {
	 int result = 0;
	 Iterator<Integer> iter = collection.iterator();
	 while(iter.hasNext())
	    result += iter.next();
	 return result;
      }

      /**
       * This method finds the first occurrence of an item in an array
       * an returns the index of this occurrnce.
       *
       * @param an_unordered_array the array
       * @param to_look_for the item whose first occurrence has to be found.
       * @return -1, if the item cannot be found in the array, otherwise 
       * the index of the first occurrence
       */
      public static <T> int firstOccurrence(T[] an_unordered_array,
					    T to_look_for)
      {
	 for( int index = 0; index<an_unordered_array.length; index++ )
	    if( an_unordered_array[index].equals(to_look_for) )
	       return index;
	 return -1;		  
      }
}

