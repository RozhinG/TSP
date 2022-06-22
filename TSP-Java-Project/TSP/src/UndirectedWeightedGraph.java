import java.util.ArrayList;
import java.util.LinkedList;

public class UndirectedWeightedGraph<T> {
	
	private ArrayList<T> vertexList;
	private int NumOfVertex;
	
	
	public ArrayList<T> getVertexList() {
		return vertexList;
	}
	public int getNumOfVertex() {
		return NumOfVertex;
	}

	LinkedList<GenericEdge<T>> [] AdjLst;

	public UndirectedWeightedGraph() {
		this.NumOfVertex=0;
		this.vertexList= (ArrayList<T>) new ArrayList<T>();	
		this.AdjLst=new LinkedList[100];
		
	}
	public UndirectedWeightedGraph(int size) {
		this.NumOfVertex=size;
		this.vertexList=(ArrayList<T>) new ArrayList<T>();
		this.AdjLst=new LinkedList[100];
		for(int i=0;i<this.NumOfVertex;i++)
		this.AdjLst[i]=new LinkedList<GenericEdge<T>>();
	}
	
	public final LinkedList<GenericEdge<T>> getUnvistedEdges(T vertex)
	{
		int index=this.vertexList.indexOf(vertex);
		LinkedList<GenericEdge<T>> unVistedLists=new LinkedList<GenericEdge<T>>();
		for(GenericEdge<T> edge:this.AdjLst[index])
			if(!edge.isVisted())
				unVistedLists.add(edge);
		return unVistedLists;
	}
	
	public void addVertex(T token)
	{
		if(!this.vertexList.contains(token))///if v is not in the vertexlist
		{
			try {
				
			this.vertexList.add(token);
			this.NumOfVertex++;
			int i=this.vertexList.indexOf(token);
			this.AdjLst[i]=new LinkedList<GenericEdge<T>>();
			}
			catch(Exception ex)
			{
				
			}
		}
		else 
			return;
	}
	public void printEdgesOfVertex(T vertex)
	{
		int index=this.vertexList.indexOf(vertex);
		 System.out.print("[");
         for(GenericEdge<T> e: this.AdjLst[index]){ 
             System.out.print("("+e.getTo()+","+e.getCost() +") ,"); 
         } 
         System.out.print("]");
		
	}
	
	public LinkedList<GenericEdge<T>> getEdges(T vertex)
	{
		int index=this.vertexList.indexOf(vertex);
		return this.AdjLst[index];
	}
	
    public void addEdge(T source,T destination,int weight) 
    {
		
		this.addVertex(source);///if from is not in the vertexlist
		
		this.addVertex(destination);///if to is not in the vertexlist
		
		int indexFrom=this.vertexList.indexOf(source);
		GenericEdge<T> e=new GenericEdge<T>(source,destination, weight,false);
		if(!this.AdjLst[indexFrom].contains(destination))
		 this.AdjLst[indexFrom].add( e); //adding the new edge to the end of list
		
		int indexTo=this.vertexList.indexOf(destination);
		GenericEdge<T> ed=new GenericEdge<T>(destination,source, weight,false);
		if(!this.AdjLst[indexTo].contains(source))
		   this.AdjLst[indexTo].add( ed); //add new edge to both lists
					
		
	}
	

	public void getVertices() {
		if(this.NumOfVertex==0)
			System.out.print("This Graph doesn't have any vertex yet."+"\n");
		else {
			System.out.print("Vertices List"+"\n");
		for(int i=0;i<this.NumOfVertex;i++)
			System.out.println(this.vertexList.get(i));
			System.out.print("\n");
		}
	}
	
	public void printGraph() 
    {  
		if(this.NumOfVertex==0)
			System.out.print("Graph is empty"+"\n");
        for(int v = 0; v < this.NumOfVertex; v++) 
        { 
            System.out.println("Adjacency list of vertex "+  this.vertexList.get(v)); 
            System.out.print("head"); 
            System.out.print("[");
            for(GenericEdge<T> edge: this.AdjLst[v]){ 
                System.out.print("("+edge.getFrom()+","+ edge.getTo()+","+edge.getCost()+","+edge.isVisted()+ ") ,"); 
            } 
            System.out.print("]");
            System.out.println("\n"); 
        } 
    } 
}
