


/**
 * This class contains the mathematical functions that are not 
 * included in the standard Math package.
 *
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 * @version 1.0
 */
public class Mathi
{

      /**
       * Returns the value of the first argument raised to the 
       * power of the second argument.
       *
       * @param x the base
       * @param p the exponent
       * @return the value x<sup>p</sup>
       */
      public static int pow(int x, int p)
      { 
	 int ret = 1; 
	 for( int i = 0; i < p; i++ ) 
	    ret *= x;
	 return ret; 
      }
}
