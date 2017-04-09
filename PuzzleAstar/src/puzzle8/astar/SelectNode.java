package puzzle8.astar;
import java.util.*;

@SuppressWarnings("serial")
class SelectNode extends PriorityQueue<SelectNode.SelNode> {
	private  Set<String> cont=new HashSet<String>();

	static class SelNode implements Comparable<SelNode> {

		private int child_cost;
		private int child_level;
		private String state;
		private NodeStruct node;
		
		public NodeStruct getNode(){
			return node;
		}
	
		public String toString(){
			return "cost: "+child_cost+" level: "+child_level+" ref: "+node;
		}
		
		public SelNode(int child_c, int child_l,NodeStruct nd,String str) {
			child_cost = child_c;
			child_level = child_l;
			node=nd;
			state=str;
		}

		public int compareTo(SelNode arg) {
			if (child_cost > arg.child_cost)
				return +1;
			if (child_cost == arg.child_cost)
				if (child_level > arg.child_level)
					return +1;
				else if (child_level == arg.child_level)
					return 0;
			return -1;
		
		}

	
	}
	
	public boolean remove(String x){
		Iterator<SelNode> it=super.iterator();
		SelNode kom;
		while(it.hasNext())
		{
			kom=it.next();
			if(kom.state.equalsIgnoreCase(x)){
				//if(super.remove(kom.node))
				it.remove();
				cont.remove(x);
				return true;
				
			}
		
		}
		return false;
		
	}
	public NodeStruct getNode(String id){
		Iterator<SelNode> it=super.iterator();
		SelNode kom;
		while(it.hasNext())
		{
			kom=it.next();
			if(kom.state.equalsIgnoreCase(id)){
				return kom.node;
			}
		}
		return null;
	}
	public boolean contains(String str){
		return cont.contains(str);
	}

	public void add(int co,int le,NodeStruct nd,String st) {
		cont.add(st);
		super.add(new SelNode( co,le,nd,st));
	}

	//public boolean

//	public static void main(String[] args) {
//		SelectNode list = new SelectNode();
//		
//		list.add(0,1, null,"a");
//		list.add(0,10, null,"b");
//		list.add(1,1, null,"c");
//		list.add(1,6, null,"d");
//		list.add(2,3, null,"e");
//		list.add(3,1, null,"f");
//		list.add(3,9, null,"g");
//		list.add(3,11, null,"h");
//		list.add(4,0, null,"f");
//		list.add(5,1, null,"a");
//		list.add(5,1, null,"a");
//		list.add(5,2, null,"a");
//		System.out.println("list contains:"+list.contains("a"));
//		System.out.println("list contains:"+list.contains("z"));
//		list.remove("b");
//		
//		
//		while (!list.isEmpty())
//			System.out.println(list.remove());
//	}
} 
