


/**
 * This class represents an exception that is thrown when 
 * an attribute has more tht 32 different values.
 *
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 * @version 1.0
 */
class TooMuchValueException extends Exception
{

      /**
       * The name of the attribute that caused the exception
       */
      private String name_of_attribute;
      public TooMuchValueException(String name_of_attribute)
      {
	 this.name_of_attribute = name_of_attribute;
      }
      public String get_name_of_attribute()
      {
	 return name_of_attribute;
      }
}
