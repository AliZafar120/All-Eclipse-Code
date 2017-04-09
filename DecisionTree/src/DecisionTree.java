/*
 * Created on 2004.11.24.
 *
 */
/**
 * @author bodon
 *
 */

import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Collection;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;
import java.util.Map;
import java.text.NumberFormat;
import static java.lang.Math.*;


/**
 * This class represents a decision tree. A decision tree is a recursive
 * data structure. It has root node, some data associated with the root node
 * and a list of child, each child is a decision tree itself. If the
 * child list is empty then the root is a leaf, otherwise it is an inner node.
 * It is usefull to associate a decision to the inner node not just to the leaves.
 *
 * @author <a href="mailto:bodon@cs.bme.hu">Ferenc Bodon</a>
 */
class DecisionTree implements Serializable
{

      /**
       * The <code>min_score</code> will store the score value if the 
       * best split.
       */
      private static double min_score;


      /**
       * The <code>best_attr_index</code> stores the index of the attribute.
       * that results in the best split.
       */
      private static int best_attr_index;


      /**
       * The decision of the root node of this (sub)tree. That class 
       * value will be the decision that belong to the most 
       * training point classified to the root of this (sub)tree.
       */
      private String decision;

      /**
       * The confidence (rate of the properly classified training points)
       * of the decision.
       */
      private float confidence;

      /**
       * The <code>weight</code> (support) of the node, i.e how many 
       * training points are classified the root node of this (sub)tree.
       */
      private int weight;

      private double chi_value;
      /**
       * This stores the list of the children.
       *
       */
      private DecisionTree[] children;

      /**
       * This gives the condition if the root is an inner node. Otherwise
       * it is <code>null</code>.
       */
      private Condition condition;

      /**
       * This gives the class distribution of the training points that are
       * classified to the root. For each class value it is stored the number
       * of training points that have that class value and were classified to
       * this root.
       */
      private TreeMap<String, Integer> class_distribution;	

      /**
       * The name of attributes.
       */
      private static ArrayList<String> attr_names;


      /**
       * The maximum depth of the tree.
       *
       */
      private static int max_depth;


      /**
       * The selection criterion.
       *
       */
      private static SelectionCriterion the_selection;


      /**
       * An <code>int</code> value that stores the
       * minimum number of node that are needed to split a node.
       *
       */
      private static int training_point_need;

      /**
       * The minimum number of training nodes required in a leaf.
       *
       */
      private static int leaf_minimum_point;

      /**
       * Creates a new <code>DecisionTree</code> instance.
       *
       * @param training_points the list of the training points. 
       *
       */
      public DecisionTree(
	 ArrayList<Pair<String,ArrayList<Object>>> training_points,
	 TreeMap<String, Integer> total_class_distr )
      {
	 class_distribution = buildClassDistribution(training_points);
	 weight = training_points.size();
	 setDecision(total_class_distr);
      }
	

      /**
       * This method sets the static (general) parameters. .
       *
       * @param attr_names this will be assigned to
                          {@link DecisionTree#attr_names}
       * @param max_depth this will be assigned to
                          {@link DecisionTree#max_depth}
       * @param the_selection this will be assigned to
                          {@link DecisionTree#the_selection}
       * @param training_point_need this will be assigned to 
                          {@link DecisionTree#training_point_need}
       * @param leaf_minimum_point this will be assigned to 
                          {@link DecisionTree#leaf_minimum_point}
       */
      public void setParameters( 
	 ArrayList<String> attr_names, int max_depth,
	 SelectionCriterion the_selection, int training_point_need,
	 int leaf_minimum_point)
      {
	 this.attr_names = attr_names;
	 this.max_depth = max_depth;
	 this.the_selection = the_selection;
	 this.training_point_need = training_point_need;
	 this.leaf_minimum_point = leaf_minimum_point;
      }

      /**
       * The <code>buildTree</code> method creates the children if the
       * decison tree growing does not have to stop.
       *
       * @param training_points the list of the training points. 
       * @param actual_depth the depth of the root of this (sub)tree.
       * @param confusion_matrix a TreeMap that stores the confusion matrix.
       * @return a <code>Pair</code> that contains the size and the 
       * depth of the (sub)tree.
       * @exception TooMuchValueException if an there are more than 32 
       * different values of an attribute
       */
      public Pair<Integer,Integer> buildTree( 
	 ArrayList<Pair<String,ArrayList<Object>>> training_points, 
	 int actual_depth,
	 TreeMap<String, TreeMap<String, Integer>> confusion_matrix,
	 TreeMap<String, Integer> total_class_distr)
	 throws TooMuchValueException
      {
	 if( training_points.size() > training_point_need &&
	     actual_depth < max_depth && class_distribution.size() != 1 )
	 {
	    findBestSplit(training_points);
	    if( min_score != Double.MAX_VALUE )
	    {
	       ArrayList<Pair<String,ArrayList<Object>>> left_training_points =
		  new ArrayList<Pair<String,ArrayList<Object>>>(), 
		  right_training_points = 
		  new ArrayList<Pair<String,ArrayList<Object>>>();
	       divideTrainingPoints( training_points, left_training_points, 
				     right_training_points, best_attr_index );
	       children = new DecisionTree[2];
	       children[0] = new DecisionTree( left_training_points, 
					       total_class_distr );
	       Pair<Integer,Integer> size_left = children[0].buildTree( 
		  left_training_points, actual_depth + 1, 
		  confusion_matrix, total_class_distr );
	       children[1] = new DecisionTree( right_training_points,
					       total_class_distr );
	       Pair<Integer,Integer> size_right = children[1].buildTree( 
		  right_training_points, actual_depth + 1, 
		  confusion_matrix, total_class_distr );
	       if( children[0].isLeaf() && children[1].isLeaf() && 
		   children[0].decision.equals(children[1].decision) )
	       {
		  children = null;
		  return new Pair<Integer,Integer>(1,1);
	       }
	       else
	       {
		  if( size_left.second>size_right.second )
		     return new Pair<Integer,Integer>(
			size_left.first + size_right.first,
			size_left.second + 1);
		  else
		     return new Pair<Integer,Integer>(
			size_left.first + size_right.first,
			size_right.second + 1);
	       }
	    }
	 }
	 updateConfusionMatrix(training_points, confusion_matrix);
	 return new Pair<Integer,Integer>(1,1);
      }
      /**
       * The <code>findBestSplit</code> method finds the best split.
       *
       * @param training_points the list of the training points. 
       * @exception TooMuchValueException if an there are more than 32 
       * different values of an attribute
       */

      private void findBestSplit( 
	 ArrayList<Pair<String,ArrayList<Object>>> training_points )
	 throws TooMuchValueException
      {
	 best_attr_index = 0;
	 min_score = Double.MAX_VALUE;
	 double prev_min_score = Double.MAX_VALUE;
	 int index;

	 for(index = 0; index < attr_names.size(); index++ )
	 {
	    TreeMap<Object, TreeMap<String, Integer>> distr_lists = 
	       new TreeMap<Object, TreeMap<String, Integer>>();
	    buildAttrDistribution( training_points, 
				   index, distr_lists );
	    
	    if( training_points.get(0).second.get(index) instanceof String)
	    {
	       if (distr_lists.size()>32)
		  throw new TooMuchValueException(attr_names.get(index));
	       getBestScoreNominal( distr_lists, attr_names.get(index) );
	    }
	    else
	       getBestScoreNumeric( distr_lists, attr_names.get(index) );
	    if( min_score < prev_min_score )
	    {
	       best_attr_index = index;
	       prev_min_score = min_score;
	    }
	 }
      }

      /**
       * The <code>buildClassDistribution</code> method builds the 
       * class distribution.
       *
       * @param training_points the list of the training points. 
       */
      public static TreeMap<String, Integer> buildClassDistribution( 
	 ArrayList<Pair<String,ArrayList<Object>>> training_points )
      {
	 TreeMap<String, Integer> the_result = new TreeMap<String, Integer>();
	 String a_class;
	 Integer temp_class_occurrence;
	 for(Pair<String,ArrayList<Object>> a_training_point : training_points)
	 {
	    a_class = a_training_point.first;
	    temp_class_occurrence = the_result.get(a_class);
	    if( temp_class_occurrence != null ) 
	       the_result.put(a_class, temp_class_occurrence + 1);
	    else the_result.put(a_class, 1); 
	 }
	 return the_result;
      }

      /**
       * The <code>setDecision</code> method determindes the decision in 
       * the root. 
       */
      private void setDecision(TreeMap<String, Integer> total_class_distr)
      {
	 Map.Entry<String, Integer> an_entry;
	 int max_occurrence = 0;
	 for( Iterator<Map.Entry<String, Integer>> entry_iter = 
		 class_distribution.entrySet().iterator(); entry_iter.hasNext(); )
	 {
	    an_entry = entry_iter.next();
	    if( an_entry.getValue() > max_occurrence )
	    {
	       max_occurrence = an_entry.getValue();
	       decision = an_entry.getKey();
	       confidence = ((float) max_occurrence) / weight;
	       
	       double nr_of_tr_points = 
		  (double) Algorithms.sum(total_class_distr.values()),
		  k11 = (double) max_occurrence,
		  k1_ = total_class_distr.get(decision)==null? 0.0d :
		  total_class_distr.get(decision).doubleValue(),
		  k2_ = nr_of_tr_points - k1_,
		  k12 = k1_ - k11,
		  k_1 = (double) weight,
		  k_2 = nr_of_tr_points - k_1,
		  k21 = k_1 - k11,
		  k22 = k_2- k12;
	       
	       chi_value = 
		  Math.pow(Math.abs(k11 - k1_ * k_1 / nr_of_tr_points) - 0.5, 2.0)/
		  (k1_ * k_1 / nr_of_tr_points) +
		  Math.pow(Math.abs(k12 - k1_ * k_2 / nr_of_tr_points) - 0.5, 2.0)/
		  (k1_*k_2 / nr_of_tr_points) +
		  Math.pow(Math.abs(k21 - k2_ * k_1 / nr_of_tr_points) - 0.5, 2.0)/
		  (k2_ * k_1/nr_of_tr_points) +
		  Math.pow(Math.abs(k22 - k2_ * k_2 / nr_of_tr_points) - 0.5, 2.0)/
		  (k2_ * k_2 / nr_of_tr_points);
	    }

	 }

	 
      }

      /**
       * The <code>buildAttrDistribution</code> builds a class distribution
       * to each value of a specified attribute.
       *
       * @param training_points the list of the training points. 
       * @param index the index of the specified attribute
       * @param distr_lists this will be built. A distribution list is 
       * associated with each value of the attribute
       */
      private void buildAttrDistribution( 
	 ArrayList<Pair<String,ArrayList<Object>>> training_points, 
	 int index, TreeMap<Object, TreeMap<String, Integer>> distr_lists )
      {
	 Object the_attr_value;
	 Integer the_attr_occurrence, a_class_occurrence;
	 TreeMap<String, Integer> temp_distr;
	 String a_class;
	 for( Pair<String,ArrayList<Object>> a_training_point : training_points )
	 {
	    the_attr_value = a_training_point.second.get(index);
	    a_class = a_training_point.first;
	    temp_distr = distr_lists.get(the_attr_value);
	    if( temp_distr != null )
	    {
	       a_class_occurrence = temp_distr.get(a_class);
	       if( a_class_occurrence != null )
		  temp_distr.put( a_class, a_class_occurrence+1 );
	       else temp_distr.put(a_class, 1);
	    }
	    else 
	    {
	       temp_distr = new TreeMap<String, Integer>();
	       temp_distr.put(a_class, 1);
	    }
	    distr_lists.put(the_attr_value, temp_distr);
	 }
      }


      /**
       * This method evaluates a split. A split separates the training points
       * into two distinct set. This method assigns a value for the split. 
       * The more homogenous the two set of training points the better 
       * the split
       *
       * @param left_class_distr the distribution of the class value in 
       * the first set.
       * @param right_class_distr the distribution of the class value in 
       * the second set.
       * @return the score of the split. The smaller the value the 
       * better the split.
       */
      private double getScore( TreeMap<String, Integer> left_class_distr, 
			       TreeMap<String, Integer> right_class_distr )
      {
	 int occ_left = Algorithms.sum(left_class_distr.values()),
	    occ_right = Algorithms.sum(right_class_distr.values());
	 double p_left =  ((double) occ_left) / (occ_left + occ_right),
	    p_right = ((double) occ_right) / (occ_left + occ_right), p_temp;

	 if( the_selection != SelectionCriterion.MPI )
	 {
	    Iterator<Map.Entry<String, Integer>> entry_iter;
	    Map.Entry<String, Integer> an_entry;

	    double score_left, score_right;
	    if(the_selection == SelectionCriterion.GINI )
	    {
	       score_left = 1.0;
	       score_right = 1.0;
	    }
	    else
	    {
	       score_left = 0.0;
	       score_right = 0.0;
	    }

	    if(left_class_distr.size() != 1) // since 1.0/1.0 is not necessarly 1.0!!!
	    {
	       entry_iter = left_class_distr.entrySet().iterator();
	       while(entry_iter.hasNext())
	       {
		  an_entry = entry_iter.next();
		  p_temp = an_entry.getValue().doubleValue() / occ_left;
		  if( the_selection == SelectionCriterion.ENTROPY )
		     score_left += -p_temp * log(p_temp);
		  else if(the_selection == SelectionCriterion.GINI)
		     score_left -= p_temp * p_temp;
		  else
		  {
		     double p_temp2 = class_distribution.
			get(an_entry.getKey()).doubleValue() / weight;    
		     score_left -= p_temp * (p_temp / p_temp2 - 1.0);

		  }
	       }
	    }
	    if(right_class_distr.size() != 1) // since 1.0/1.0 is not necessarly 1.0!!!
	    {
	       entry_iter = right_class_distr.entrySet().iterator();
	       while(entry_iter.hasNext())
	       {
		  an_entry = entry_iter.next();
		  p_temp = an_entry.getValue().doubleValue() / occ_right;
		  if( the_selection == SelectionCriterion.ENTROPY )
		     score_right += -p_temp * log(p_temp);
		  else if(the_selection == SelectionCriterion.GINI )
		     score_right -= p_temp * p_temp;
		  else
		  {
		     double p_temp2 = class_distribution.
			get(an_entry.getKey()).doubleValue() / weight;    
		     score_right -= p_temp * (p_temp / p_temp2 - 1.0);
		  }

	       }
	    }
	    return p_left * score_left + p_right * score_right;

	 }
	 else
	 {
	    double score = 0.0;
	    Map.Entry<String, Integer> an_entry;
	    Iterator<Map.Entry<String, Integer>> entry_iter = 
		    class_distribution.entrySet().iterator();
	    double p_temp_left, p_temp_right;
	    while( entry_iter.hasNext() )
	    {
	       an_entry = entry_iter.next();
	       p_temp = an_entry.getValue().doubleValue()/weight;
	       if(left_class_distr.get(an_entry.getKey()) != null  )
	       {
		  p_temp_left = left_class_distr.get(
		     an_entry.getKey()).doubleValue()/occ_left;
		  if( right_class_distr.get(an_entry.getKey()) != null )
		  {
		     p_temp_right = right_class_distr.get(
			an_entry.getKey()).doubleValue()/occ_right;
		     score += p_temp_left * p_temp_right / p_temp;
		  }
	       }
	    }
	    score = p_left * p_right * (score - 1.0);
	    return score;
	 }
      }


      /**
       * This method adds or subtracks a class distribution form an other
       * class distrbution
       *
       * @param summary_class_distr this is the class distribution to the 
       * other is added to or subtracked from
       * @param distr_of_an_attr_value the class distribution that is 
       * added to or subtracked from the <code>summary_class_distr</code>
       * @param the_operation a <code>boolean</code> value that is true if 
       * the operation is addition, and false otherwise.
       */
      private void add_removeClassDistr( 
	 TreeMap<String, Integer> summary_class_distr, 
	 TreeMap<String, Integer> distr_of_an_attr_value,
	 boolean the_operation )
      {
	 Iterator<Map.Entry<String, Integer>> entry_iter = 
	    distr_of_an_attr_value.entrySet().iterator();
	 Map.Entry<String, Integer> an_entry;
	 Integer a_value_sum;
	 String a_key;
	 while(entry_iter.hasNext())
	 {
	    an_entry = entry_iter.next();
	    a_key = an_entry.getKey();
	    a_value_sum = summary_class_distr.get(a_key);
	    if(a_value_sum == null) a_value_sum = new Integer(0);
	    if(the_operation)   // addition
	       summary_class_distr.put(a_key, a_value_sum + an_entry.getValue() );
	    else               // subtraction
	       if(a_value_sum == an_entry.getValue()) 
		  summary_class_distr.remove(a_key );  //zeros are not cared!
	       else
		  summary_class_distr.put(a_key, a_value_sum - an_entry.getValue() );
	 }
      }


      /**
       * The <code>buildMaps</code> method builds to differrent data structure
       * from the class distribution. In <code>distr_lists</code> each value
       * of an attribute is associated with a class distribution. However, when
       * all subset of the possible attribute values have to be evaluated, than
       * each attribute value is associated with an index startin from 0. This 
       * method build a maping form the indices  to the attribute values
       * which is stored in <code>name_map</code>) and
       * sustitutes the values with the integers which result in the 
       * <code>distr_map</code> TreeMap
       *
       */
      private void buildMaps(
	 TreeMap<Object, TreeMap<String, Integer>> distr_lists, 
	 TreeMap<Integer, String>name_map, 
	 TreeMap<Integer, TreeMap<String, Integer>>distr_map)
      {
	 Iterator<Map.Entry<Object, TreeMap<String, Integer>>> entry_iter = 
	    distr_lists.entrySet().iterator();
	 Map.Entry<Object, TreeMap<String, Integer>> an_entry;
	 Integer index = 0;
	 while( entry_iter.hasNext() )
	 {
	    an_entry = entry_iter.next();
	    name_map.put(index, (String) an_entry.getKey());
	    distr_map.put(index, an_entry.getValue());
	    index++;
	 }

      }


      /**
       * This method splits <code>distr_map</code> class distribution to 
       * two class distribution. If <code>pattern[i]</code> is 1 than the 
       * i<sup>th</sup> attribute belongs to first group, otherwise to 
       * the second.
       *
       * @param distr_map this stores the class distribution to each indices.
       * @param left_class_distr the class distribution belong to the 
       * first group
       * @param right_class_distr the class distribution belong to the 
       * second group
       * @param pattern a <code>String</code> value that codes the division
       * of the attribute values.
       */
      private void  buildClassDistr(
	 TreeMap<Integer, TreeMap<String, Integer>> distr_map,
	 TreeMap<String, Integer> left_class_distr,  
	 TreeMap<String, Integer> right_class_distr, String pattern)
      {
	 left_class_distr.clear();
	 right_class_distr.clear();
	 for( int index = 0; index < pattern.length(); ++index )
	 {
	    if( pattern.charAt(index) == '0' )
	       add_removeClassDistr(right_class_distr, 
				    distr_map.get(index), true);
	    else
	       add_removeClassDistr(left_class_distr, 
				    distr_map.get(index), true);

	 }


      }

      /**
       * The <code>selectionSet</code> method decodes the 
       * <code>distr_map</code>, i.e. it returns the set of attribute names
       * that belong to '1' in the <code>pattern</code>.
       *
       */
      private TreeSet<String> selectionSet(
	 TreeMap<Integer, String> distr_map,  String pattern )
      {
	 TreeSet<String> result = new TreeSet<String>();
	 for( int index = 0; index < pattern.length(); ++index )
	    if( pattern.charAt(index) == '1' )
	       result.add(distr_map.get(index));
	 return result;
      }


      /**
       * It returns the best score of an attribute of type nominal.
       *
       * @param distr_lists the class distribution of each attribute value
       * @param attr_name the name of attributes.
       */
      private void getBestScoreNominal (
	 TreeMap<Object, TreeMap<String, Integer>> distr_lists,
	 String attr_name) 
      {
	 int patternint, maxpatternint = Mathi.pow(2,distr_lists.size());
	 String pattern;
	 TreeMap<String, Integer> left_class_distr = 
	    new TreeMap<String, Integer>(), 
	    right_class_distr = new TreeMap<String, Integer>();
	 double temp_score;
	 TreeMap<Integer, String> name_map = new TreeMap<Integer, String>();
	 TreeMap<Integer, TreeMap<String, Integer>> distr_map = 
	    new TreeMap<Integer, TreeMap<String, Integer>>();
	 buildMaps(distr_lists, name_map, distr_map);

	 for( patternint = 1; patternint < maxpatternint; ++patternint )
	 {
	    pattern = Integer.toBinaryString(patternint);
	    for( int  index = pattern.length(); index < distr_lists.size(); 
		 index++)
	       pattern = "0" + pattern;
	    buildClassDistr( distr_map, left_class_distr,  
			     right_class_distr, pattern );
	    if( Algorithms.sum(left_class_distr.values()) >= leaf_minimum_point&&
		Algorithms.sum(right_class_distr.values()) >= leaf_minimum_point )
	    {
	       temp_score = getScore( left_class_distr,  right_class_distr );
	       if( temp_score < min_score)
	       {
		  min_score = temp_score;
		  TreeSet<String> best_cond_set = selectionSet( name_map, 
								pattern );
		  condition = new ConditionNominal( attr_name, best_cond_set );
	       }
	    }

	 }
      }

      /**
       * It returns the best score of an attribute of type numeric.
       *
       * @param distr_lists the class distribution of each attribute value
       * @param attr_name the name of attributes.
       */

      private void getBestScoreNumeric( 
	 TreeMap<Object, TreeMap<String, Integer>> distr_lists,
	 String attr_name)
      {
	 TreeMap<String, Integer> left_class_distr = 
	    new TreeMap<String, Integer>(), 
	    right_class_distr = 
	    new TreeMap<String, Integer>(class_distribution);
	 Iterator<Map.Entry<Object, TreeMap<String, Integer>>> entry_iter = 
	    distr_lists.entrySet().iterator();
	 Map.Entry<Object, TreeMap<String, Integer>> an_entry;
	 double temp_score;
	 while(entry_iter.hasNext())
	 {
	    an_entry = entry_iter.next();
	    add_removeClassDistr(left_class_distr, an_entry.getValue(), true);
	    add_removeClassDistr(right_class_distr, an_entry.getValue(), false);
	    if( Algorithms.sum(left_class_distr.values()) >= leaf_minimum_point&&
		Algorithms.sum(right_class_distr.values()) >= leaf_minimum_point )
	    {
	       temp_score = getScore( left_class_distr,  right_class_distr );
	       if( temp_score < min_score)
	       {
		  min_score = temp_score;
		  condition = new ConditionOrdered(
		     attr_name, (Comparable) an_entry.getKey());
	       }
	    }
	 }
      }

      /**
       * This method evaluates all <em>A<c</em> condition, where <em>A</em> 
       * is a given attribute
       *
       * @param best_attr_index an <code>int</code> value
       */
      private void divideTrainingPoints( 
	 ArrayList<Pair<String,ArrayList<Object>>> training_points, 
	 ArrayList<Pair<String,ArrayList<Object>>> left_training_points, 
	 ArrayList<Pair<String,ArrayList<Object>>> right_training_points, 
	 int best_attr_index )
      {
	 Pair<String,ArrayList<Object>> a_training_point;
	 for( Iterator<Pair<String,ArrayList<Object>>> tp_iter = 
		 training_points.iterator(); 
	      tp_iter.hasNext(); )
	 {
	    a_training_point = tp_iter.next();
	    if( condition.meetsCondition(
		   a_training_point.second.get(best_attr_index)) )
	       left_training_points.add(a_training_point);
	    else right_training_points.add(a_training_point);
	 }
      }

      /**
       * The string representation of the root. If the root is a leaf, then
       * the decision, confidence and support is returned, otherwise
       * the condition.
       */
      public String toString()
      {
	 if( !isLeaf() )
	    return condition.toString();
	 else
	 {
	    NumberFormat pform = NumberFormat.getPercentInstance(),
	       pform2 = NumberFormat.getNumberInstance();
	    pform2.setMaximumFractionDigits(2);
	    return decision + ", support: " + pform2.format(weight) + 
	       ", confidence: " + pform.format(confidence) +
	       ", chi value: " + pform2.format(chi_value);

	 }
      }

      /**
       * The <code>buildJavaTree</code> recursive method builds up 
       * a <code>DefaultMutableTreeNode</code> that will be suitable
       * to create a <code>Jtree</code>.
       *
       * @param top the node the new nodes have to be added to.
       */
      public void buildJavaTree(DefaultMutableTreeNode top)
      {
	 if( children != null )
	 {
	    DefaultMutableTreeNode 
	       children1 = new DefaultMutableTreeNode(children[0]),
	       children2 = new DefaultMutableTreeNode(children[1]);
	    top.add(children1);
	    children[0].buildJavaTree(children1);
	    top.add(children2);
	    children[1].buildJavaTree(children2);
	 }
      }


      /**
       * At each leaf node this method updates the confusion matrix.
       *
       * @param training_points the list of the training points. 
       * @param confusion_matrix a TreeMap that stores the confusion matrix.
       */
      private void updateConfusionMatrix(
	 ArrayList<Pair<String,ArrayList<Object>>> training_points, 
	 TreeMap<String,TreeMap<String, Integer>> confusion_matrix )
      {
	 String a_class;
	 TreeMap<String, Integer> a_row;
	 Integer an_int;
	 for( Pair<String,ArrayList<Object>> a_training_point : training_points )
	 {
	    a_class = a_training_point.first;
	    a_row = confusion_matrix.get(a_class);
	    if( a_row == null )
	    {
	       a_row = new TreeMap<String, Integer>();
	       a_row.put(decision, 1);
	    }
	    else
	    {
	       an_int = a_row.get(decision);
	       if( an_int == null )
		  a_row.put(decision, 1);
	       else
		  a_row.put(decision, an_int + 1);
	    }
	    confusion_matrix.put(a_class, a_row);
	 }
      }

      /**
       * The <code>isLeaf</code> method returns if the root of the
       * (sub)tree is a leaf or not
       *
       * @return a <code>boolean</code> value that is <code>true</code> if
       * the root is a leaf, otherwise <code>false</code>.
       */
      public boolean isLeaf()
      {
	 if( children == null )
	    return true;
	 else
	    return false;
      }

      /**
       * If the root is not a leaf, then this method returns the name
       * of the attribute that resulted the best split.
       */
      public String getConditionAttrName()
      {
	 if( condition != null )
	    return condition.getAttributeName();
	 else
	    return null;
      }

      /**
       * It returns the child that has to be folloed based on the 
       * given attrbute value.
       */
      public DecisionTree properSubtree(Object attribute_value)
      {

	 if( condition != null )
	 {
	    if( condition.meetsCondition(attribute_value) )
	       return children[0];
	    else
	       return children[1];
	 }
	 else
	    return null;
      }
}
