

import java.io.Serializable;


/**
 * This is the abstract class of the condition. Conditions
 * can be found in inner nodes of a decision tree. Two types of 
 * condition exists according to the type of attribute the condition 
 * applies to.
 *
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 * @version 1.0
 */
abstract class Condition implements Serializable
{

      /**
       * The name of the attribute the condition applies to.
       */
      private String attribute_name;
      

      /**
       * Creates a new <code>Condition</code> instance.
       *
       * @param attribute_name a <code>String</code> value that gives
       * the name of the attribute the condition applies to.
       */
      public Condition(String attribute_name)
      {
	 this.attribute_name = attribute_name;
      }

      /**
       * This returns the name of the attribute the 
       * condition applies to.
       */
      public String getAttributeName()
      {
	 return attribute_name;
      }

      /**
       * This returns the string representation of the condition.
       * It is like "AGE <= 35".
       */
      public String toString()
      {
	 return attribute_name;
      }

      /**
       * This methods decides if a give value of the attribute fulfills
       * the condition or not.
       *
       * @param attribute_value a value of the attribute
       * @return a <code>boolean</code> value that is true if the value
       * fulfills the condition (like the value 25 of AGE, fulfills AGE<=35)
       */
      public abstract boolean meetsCondition(Object attribute_value);
}

