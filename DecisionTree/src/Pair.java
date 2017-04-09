

/**
 * This class represents a generic pair class. For the sake of efficiency 
 * data encapsulation is broken and the inner variables are
 * declared to be public. This class is a C++ struct rather
 * than a real class.
 *
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 * @version 1.0
 */

public class Pair<T1,T2>
{
      public T1 first;
      public T2 second;


      public Pair()
      {
	 first = null;
	 second = null;
      }

      public Pair(T1 first, T2 second)
      {
	 this.first = first;
	 this.second = second;
      }
}
