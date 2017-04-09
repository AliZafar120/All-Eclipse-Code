package puzzle8.astar;
public class NodeStruct {
	//level is the depth of the node
	private int level;
	//sp_to_this_node is the shortest path to this node until now
	private int sp_to_this_node;
	private Object []numb;
	private StringBuilder identity;
	private String id;
	private NodeStruct father;
	
	public String getId(){
		return id;
	}
	public NodeStruct(){
		
	}
	public boolean isNull(){
		if(level==0 && sp_to_this_node==0 && numb==null && identity==null && id==null && father==null )
			return true;
		return false;
	}
	public NodeStruct(Object []num,int lev,int path_dis,NodeStruct fath) {
		father=fath;
		level=lev;
		sp_to_this_node=path_dis;
		//allocating memory to store node's state
		numb=new Object[num.length];
		identity=new StringBuilder();
		for(int i=0;i<num.length;++i)
		{
			numb[i]=num[i];
			identity.append(numb[i]);
		}
		id=identity.toString();
	}
	public NodeStruct getFather(){
		return father;
	}
	
	public String printNode(int one_dim){
		StringBuilder sol_sb=new StringBuilder();
		for(int i=0;i<numb.length;++i)
		{
			
			if(i%one_dim==0 && i!=0)
				sol_sb.append("\n");
			if(!numb[i].toString().equals(" "))
			sol_sb.append("|"+numb[i]);
			else
				sol_sb.append("|  ");
			if(one_dim==4){
				if(!numb[i].toString().equals(" ")){
				Integer x=new Integer(numb[i].toString());
				if(x<10)
				sol_sb.append("  ");
			
				}
			}
			
		}
		sol_sb.append("\n");
		sol_sb.append("\n");
	return sol_sb.toString();
	}
	public int getCost(){
		return sp_to_this_node;
	}
	
	public int getLevel(){
		return level;
	}
	
	public  Object[] getArray(){
		return numb;
	}
	

}
