
public class GraphLibrary<T> {
	
//	private Undirectedunweighted<T> UUGraph;
	private UndirectedWeightedGraph<T> UWGraph;
//	private WeightedGragh<T> DWGraph;
//	private DirectedUnweightedgraph<T> DUGraph;

	public GraphLibrary(String str) {
//		if(str.toString().equals("undirected unweighted"))
//			 this.UUGraph=new Undirectedunweighted<T>();
		if(str.toString().equals("undirected weighted"))
			 this.UWGraph=new UndirectedWeightedGraph<T>();
//		if(str.toString().equals("directed weighted"))
//			 this.DWGraph=new WeightedGragh<T>();
//		if(str.toString().equals("directed unweighted"))
//			 this.DUGraph=new DirectedUnweightedgraph<T>();
//			
	}

//	public Undirectedunweighted<T> getUUGraph() {
//		return UUGraph;
//	}

	public UndirectedWeightedGraph<T> getUWGraph() {
		return UWGraph;
	}

//	public WeightedGragh<T> getDWGraph() {
//		return DWGraph;
//	}
//
//	public DirectedUnweightedgraph<T> getDUGraph() {
//		return DUGraph;
//	}

}
