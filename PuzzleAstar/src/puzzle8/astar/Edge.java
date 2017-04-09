package puzzle8.astar;
public class Edge {
	//an edge has two nodes attached to it
	private NodeStruct from;
	private NodeStruct to;
	public Edge(NodeStruct fr,NodeStruct se){
		from=fr;
		to=se;
	}
	public NodeStruct getFather(){
		return from;
	}
	public NodeStruct getSon(){
		return to;
	}

}
