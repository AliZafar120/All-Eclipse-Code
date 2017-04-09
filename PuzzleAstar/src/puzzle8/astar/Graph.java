package puzzle8.astar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

	// correlating a node with a number of edges
	private Map<NodeStruct, LinkedList<Edge>> graph = new HashMap<NodeStruct, LinkedList<Edge>>();
	private NodeStruct initial;
	private Object[] goal;
	// the open set which holds states of the graph not yet investigated

	private final int MISPLACED = 0;
	private final int MANHATTAN = 1;
	private final int EUCLIDEAN = 2;
	private final int LINEAR_CONFLICT = 3;
	private final int OUT_OF_ROW_COL = 4;
	private int ev_len;
	private int heuristic;
	private String goal_state;
	// the close set which holds states of the graph which are already
	// investigated
	private Map<String, NodeStruct> close = new HashMap<String, NodeStruct>();
	private Map<String, Integer> state_cost = new HashMap<String, Integer>();
	private List<Map<Integer, Integer>> coor = new ArrayList<Map<Integer, Integer>>();
	private Set<String> all_states = new HashSet<String>();
	private boolean puzzle8;
	private int moves_req;
	private NodeStruct solution;

	public int getMoves() {
		NodeStruct curr = solution;
		while (curr.getFather() != null) {
			curr = curr.getFather();
			++moves_req;
		}
		return moves_req;
	}

	public Graph(Object[] num, Object[] final_state, int evretiko,
			boolean type, int one_dim) {
		puzzle8 = type;
		ev_len = one_dim;
		heuristic = evretiko;
		goal = final_state;
		initial = putNode(num, 0, 0);
		// initializing coor list

		// inserting dummy values to extend my list
		for (int dum = 0; dum < 22; ++dum)
			coor.add(null);

		int line = 0, col = 0;
		for (int i = 0; i < goal.length; ++i) {

			if (i % ev_len == 0 && i != 0) {
				++line;
				col = 0;
			}
			Map<Integer, Integer> coordinate = new HashMap<Integer, Integer>();
			coordinate.put(line, col);
			if (goal[i].toString().equals(" "))
				coor.set(20, coordinate);
			else
				coor.set(new Integer(goal[i].toString()).intValue(), coordinate);

			++col;
		}
		goal_state = getStringState(goal);

	}

	public String getStringState(Object[] x) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < x.length; ++i) {
			sb.append(x[i]);
		}
		return sb.toString();
	}

	// this method add a node in the graph without edges
	public NodeStruct putNode(Object[] num, int level, int path_dis) {
		NodeStruct nd = new NodeStruct(num, level, path_dis, null);
		graph.put(nd, null);
		all_states.add(nd.getId());
		return nd;
	}

	public NodeStruct getInitial() {
		return initial;
	}

	public void createChild(Object[] temp, NodeStruct father) {
		LinkedList<Edge> edges = graph.get(father);
		NodeStruct nd;
		// if it is the initial state ,,and it has no children at all
		// then clear the graph
		if ((father.getLevel() == 0) && (edges == null)) {
			// if it is the initial state
			graph.clear();
		}
		// creating the child
		nd = new NodeStruct(temp, father.getLevel() + 1, father.getLevel() + 1
				+ heuristic(heuristic, temp), father);
		Integer the_cost = state_cost.get(nd.getId());
		// if the state is not already in the graph
		if (!all_states.contains(nd.getId())
		// or the cost of this newly allocated state
		// is smaller than the node that already exists
				|| (the_cost != null && nd.getCost() < the_cost)) {

			Edge ed = new Edge(father, nd);
			if (edges == null) {// putting the first child for this father
				// no mapping for this node yet
				edges = new LinkedList<Edge>();
				edges.offer(ed);
				graph.put(father, edges);
			} else {// edges for this node exist
					// adding one more for this child
				edges.offer(ed);
				graph.put(father, edges);
			}
			all_states.add(nd.getId());
			state_cost.put(nd.getId(), nd.getCost());
		}
	}

	public void deriveChilds15(Object[] num, NodeStruct father) {
		Object[] temp = new Object[num.length];
		Object[] table;
		int k;
		// duplicating the values of num using the temp array
		for (int i = 0; i < num.length; ++i)
			temp[i] = new String(num[i].toString());
		for (k = 0; k < num.length; ++k)
			// checking to see where is the blank string
			if (num[k].toString().equals(" "))
				break;

		switch (k) {
		case 0:

			// case one
			table = swap2(0, 1, temp);
			createChild(table, father);
			// case two
			table = swap2(0, 4, temp);
			createChild(table, father);
			break;
		case 1:

			// case one
			table = swap2(1, 0, temp);
			createChild(table, father);
			// case two
			table = swap2(2, 1, temp);
			createChild(table, father);
			// case three
			table = swap2(5, 1, temp);
			createChild(table, father);
			break;
		case 2:
			// case one
			table = swap2(1, 2, temp);
			createChild(table, father);
			// case two
			table = swap2(2, 3, temp);
			createChild(table, father);
			// case three
			table = swap2(2, 6, temp);
			createChild(table, father);
			break;
		case 3:
			// case one
			table = swap2(3, 2, temp);
			createChild(table, father);
			// case two
			table = swap2(7, 3, temp);
			createChild(table, father);
			break;
		case 4:
			// case one
			table = swap2(0, 4, temp);
			createChild(table, father);
			// case two
			table = swap2(5, 4, temp);
			createChild(table, father);
			// case three
			table = swap2(4, 8, temp);
			createChild(table, father);
			break;
		case 5:
			// case one
			table = swap2(1, 5, temp);
			createChild(table, father);
			// case two
			table = swap2(5, 4, temp);
			createChild(table, father);
			// case three
			table = swap2(6, 5, temp);
			createChild(table, father);
			// case three
			table = swap2(9, 5, temp);
			createChild(table, father);
			break;
		case 6:
			// case one
			table = swap2(2, 6, temp);
			createChild(table, father);
			// case two
			table = swap2(5, 6, temp);
			createChild(table, father);
			table = swap2(7, 6, temp);
			createChild(table, father);
			table = swap2(10, 6, temp);
			createChild(table, father);
			break;
		case 7:
			// case one
			table = swap2(7, 3, temp);
			createChild(table, father);
			// case two
			table = swap2(6, 7, temp);
			createChild(table, father);
			// case three
			table = swap2(11, 7, temp);
			createChild(table, father);
			break;
		case 8:
			// case one
			table = swap2(4, 8, temp);
			createChild(table, father);
			// case two
			table = swap2(9, 8, temp);
			createChild(table, father);
			table = swap2(12, 8, temp);
			createChild(table, father);
			break;
		case 9:
			// case one
			table = swap2(9, 5, temp);
			createChild(table, father);
			// case two
			table = swap2(9, 8, temp);
			createChild(table, father);
			table = swap2(9, 10, temp);
			createChild(table, father);
			table = swap2(9, 13, temp);
			createChild(table, father);
			break;
		case 10:
			// case one
			table = swap2(10, 9, temp);
			createChild(table, father);
			// case two
			table = swap2(10, 6, temp);
			createChild(table, father);
			table = swap2(11, 10, temp);
			createChild(table, father);
			table = swap2(14, 10, temp);
			createChild(table, father);
			break;
		case 11:
			// case one
			table = swap2(11, 7, temp);
			createChild(table, father);
			// case two
			table = swap2(10, 11, temp);
			createChild(table, father);
			table = swap2(15, 11, temp);
			createChild(table, father);
			break;
		case 12:
			// case one
			table = swap2(12, 8, temp);
			createChild(table, father);
			// case two
			table = swap2(12, 13, temp);
			createChild(table, father);
			break;
		case 13:
			// case one
			table = swap2(13, 9, temp);
			createChild(table, father);
			// case two
			table = swap2(12, 13, temp);
			createChild(table, father);
			table = swap2(13, 14, temp);
			createChild(table, father);
			break;
		case 14:
			// case one
			table = swap2(14, 10, temp);
			createChild(table, father);
			// case two
			table = swap2(13, 14, temp);
			createChild(table, father);
			table = swap2(14, 15, temp);
			createChild(table, father);
			break;
		case 15:
			// case one
			table = swap2(15, 11, temp);
			createChild(table, father);
			// case two
			table = swap2(14, 15, temp);
			createChild(table, father);
			break;

		}

	}

	public void deriveChilds8(Object[] num, NodeStruct father) {
		Object[] temp = new Object[num.length];
		Object[] table;
		int k;
		// duplicating the values of num using the temp array
		for (int i = 0; i < num.length; ++i)
			temp[i] = new String(num[i].toString());
		for (k = 0; k < num.length; ++k)
			// checking to see where is the blank string
			if (num[k].toString().equals(" "))
				break;

		switch (k) {
		case 0:
			table = swap2(0, 1, temp);
			createChild(table, father);
			// case two
			table = swap2(0, 3, temp);
			createChild(table, father);
			break;
		case 1:
			table = swap2(1, 0, temp);
			createChild(table, father);

			// case two
			table = swap2(2, 1, temp);

			createChild(table, father);

			// case three
			table = swap2(4, 1, temp);

			createChild(table, father);
			break;
		case 2:
			// case one
			table = swap2(1, 2, temp);

			createChild(table, father);

			// case two
			table = swap2(2, 5, temp);

			createChild(table, father);
			break;
		case 3:

			// case one
			table = swap2(3, 0, temp);

			createChild(table, father);

			// case two
			table = swap2(6, 3, temp);

			createChild(table, father);

			// case three
			table = swap2(4, 3, temp);

			createChild(table, father);
			break;
		case 4:
			// case one
			table = swap2(1, 4, temp);

			createChild(table, father);

			// case two
			table = swap2(3, 4, temp);

			createChild(table, father);

			// case three
			table = swap2(4, 7, temp);

			createChild(table, father);

			// case four
			table = swap2(4, 5, temp);

			createChild(table, father);
			break;
		case 5:
			// case one
			table = swap2(2, 5, temp);

			createChild(table, father);

			// case two
			table = swap2(5, 4, temp);

			createChild(table, father);

			// case three
			table = swap2(8, 5, temp);

			createChild(table, father);
			break;
		case 6:
			// case one
			table = swap2(3, 6, temp);

			createChild(table, father);

			// case two
			table = swap2(7, 6, temp);

			createChild(table, father);
			break;
		case 7:
			// case one
			table = swap2(7, 4, temp);

			createChild(table, father);

			// case two
			table = swap2(6, 7, temp);

			createChild(table, father);

			// case three
			table = swap2(8, 7, temp);

			createChild(table, father);
			break;
		case 8:
			// case one
			table = swap2(5, 8, temp);

			createChild(table, father);

			// case two
			table = swap2(7, 8, temp);

			createChild(table, father);
			break;

		}

	}

	public Object[] swap2(int x, int y, Object[] arr) {
		Object[] n_array = new Object[arr.length];
		for (int i = 0; i < n_array.length; ++i) {
			if (i == x)
				n_array[i] = arr[y];
			else if (i == y)
				n_array[i] = arr[x];
			else
				n_array[i] = arr[i];
		}
		return n_array;
	}

	public int out_of_order(Object[] x) {
		int sum = 0;
		for (int i = 0; i < x.length; ++i) {
			if (!x[i].toString().equals(" "))
				if (!x[i].toString().equals(goal[i].toString()))
					++sum;
		}
		return sum;
	}

	public int out_of_row_col(Object[] x) {
		int distance = 0;
		Map<Integer, Integer> tmp = null;
		Integer coor_x, coor_y;
		int row, col;
		for (int i = 0; i < x.length; ++i) {
			Object value = x[i];
			if (!value.toString().equals(" ")) {
				// coordinates of the current state
				row = i / ev_len;
				col = i % ev_len;
				tmp = coor.get(new Integer(value.toString()));
				// coordinates of the goal state
				coor_x = tmp.keySet().iterator().next();
				coor_y = tmp.get(coor_x);
				if (row != coor_x.intValue())
					++distance;
				if (col != coor_y.intValue())
					++distance;
			}

		}
		return distance;
	}

	public int linearConflict(Object[] x) {
		int lin_distance = 0;
		boolean plustwo = false;
		Map<Integer, Integer> tmp = null;
		Integer coor_x, coor_y, o_cor_x, o_cor_y;
		int row;

		for (int i = 0; i < x.length; ++i) {
			Object value = x[i];
			if (!value.toString().equals(" ")) {
				// coordinates of the current state
				row = i / ev_len;

				tmp = coor.get(new Integer(value.toString()));
				// coordinates of the goal state
				coor_x = tmp.keySet().iterator().next();
				coor_y = tmp.get(coor_x);

				// looking for tj's
				for (int j = i + 1; j < ev_len; ++j) {
					if (!x[j].toString().equals(" ")) {
						int o_row = i / ev_len;
						tmp = coor.get(new Integer(x[j].toString()));
						o_cor_x = tmp.keySet().iterator().next();
						o_cor_y = tmp.get(coor_x);
						if (o_row == row)
							if (coor_x.intValue() == o_cor_x.intValue())
								if (o_cor_y.intValue() < coor_y.intValue())
									plustwo = true;
					}
				}
				if (plustwo)
					lin_distance += manhattan(x) + 2;
				else
					lin_distance += manhattan(x);
				plustwo = false;
			}

		}
		return lin_distance;
	}

	public int manhattan(Object[] x) {
		int man_distance = 0;
		Map<Integer, Integer> tmp = null;
		Integer coor_x, coor_y;
		int dif_x, dif_y, row, col;

		for (int i = 0; i < x.length; ++i) {
			Object value = x[i];
			if (!value.toString().equals(" ")) {
				// coordinates of the current state
				row = i / ev_len;
				col = i % ev_len;
				tmp = coor.get(new Integer(value.toString()));
				// coordinates of the goal state
				coor_x = tmp.keySet().iterator().next();
				coor_y = tmp.get(coor_x);
				dif_x = coor_x - row;
				dif_y = coor_y - col;
				man_distance += Math.abs(dif_x) + Math.abs(dif_y);
			}

		}
		return man_distance;
	}

	public int euclidean(Object[] x) {
		int euc_distance = 0;
		Map<Integer, Integer> tmp = null;
		Integer coor_x, coor_y;
		int dif_x, dif_y, row, col;
		for (int i = 0; i < x.length; ++i) {
			Object value = x[i];
			if (!value.toString().equals(" ")) {
				// coordinates of the current state
				row = i / ev_len;
				col = i % ev_len;
				tmp = coor.get(new Integer(value.toString()));
				// coordinates of the goal state
				coor_x = tmp.keySet().iterator().next();
				coor_y = tmp.get(coor_x);
				dif_x = coor_x - row;
				dif_y = coor_y - col;
				euc_distance += Math.sqrt((Math.pow(dif_x, 2) + Math.pow(dif_y,
						2)));
			}

		}
		return euc_distance;
	}

	public int heuristic(int what, Object[] x) {
		int heur = 0;
		switch (what) {
		case MISPLACED:
			heur = out_of_order(x);
			break;
		case MANHATTAN:
			heur = manhattan(x);
			break;
		case EUCLIDEAN:
			heur = euclidean(x);
			break;
		case LINEAR_CONFLICT:
			heur = linearConflict(x);
			break;
		case OUT_OF_ROW_COL:
			heur = out_of_row_col(x);
			break;
		}
		return heur;
	}

	public NodeStruct aStar() {

		int f_value, h_value, g_value;
		Object[] arr;
		// boolean values indicating whether or not a node-state
		// is in the open or the close set of states
		boolean in_open = false, in_close = false, found = false, out_of_mem = false;
		LinkedList<Edge> children;// edges leading to the children
		SelectNode open = new SelectNode();
		NodeStruct child, father;
		SelectNode.SelNode min_node;

		open.add(initial.getCost(), initial.getLevel(), initial,
				initial.getId());

		while (!open.isEmpty()) {
			try {
				min_node = open.remove();

				father = min_node.getNode();
				// adding the state just taken from open to the close set
				close.put(father.getId(), father);

				if (father.getId().equalsIgnoreCase(goal_state)) {
					// comparing this state with the goal state
					found = true;
					solution = father;
					break;

				} else {
					if (puzzle8)
						deriveChilds8(father.getArray(), father);
					else
						deriveChilds15(father.getArray(), father);

					// getting the edges which connect the father
					children = graph.get(father);// to their children
					if (children == null)
						continue;

					for (int p = 0; p < children.size(); ++p) {
						/* getting the edge p from the linked list */
						child = children.get(p).getSon();
						arr = child.getArray();

						if (child.getId().equalsIgnoreCase(goal_state)) {
							solution = child;
							found = true;
							break;
						}

						g_value = father.getLevel() + 1;
						h_value = heuristic(heuristic, arr);
						// calculating the f value
						f_value = g_value + h_value;

						in_open = false;
						in_close = false;

						in_open = open.contains(child.getId());
						in_close = close.containsKey(child.getId());

						if (in_open && (f_value >= child.getCost()))
							continue;
						if (in_close && (f_value >= child.getCost()))
							continue;

						if (in_open)
							open.remove(child.getId());
						if (in_close)
							close.remove(child.getId());

						open.add(child.getCost(), child.getLevel(), child,
								child.getId());

					}
					if (found)
						break;

				}
			} catch (OutOfMemoryError e) {
				// out of memory exception
				out_of_mem = true;
				close.clear();
				graph.clear();
				open.clear();
				PuzzleDialog.main(5);
			}
		}
		/*
		 * returning a dummy node to avoid the msg "No solution for this conf."
		 */
		if (out_of_mem)
			return new NodeStruct();
									
		else
			return solution;
	}

	public Map<NodeStruct, LinkedList<Edge>> getGraph() {
		return graph;
	}

}
