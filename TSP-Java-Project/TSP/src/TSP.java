import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;

public class TSP {

//	private  HashMap<Integer,ArrayList<ArrayList<String>>> path;
	private int minPathCost;
	private ArrayList<String> minPath;
//	private static int pathNum;
	int index=0;
	public class TSPhelper{
		public int minPathCost;
	    public  ArrayList<String> minPath;
		public TSPhelper() {
			// TODO Auto-generated constructor stub
			this.minPath=new ArrayList<String>();
			this.minPathCost=0;
		}
		
	}
	private TSPhelper [] allPaths;
	
	public TSP(GraphLibrary<String> G) {
		// TODO Auto-generated constructor stub
		this.minPath=new ArrayList<String>();
//		for(int i=0;i<G.getUWGraph().getNumOfVertex();i++)
//		this.PathList[i]=new <ArrayList<String>();
	//	this.path=new HashMap<Integer,ArrayList<ArrayList<String>>>();
		this.minPathCost=Integer.MAX_VALUE;
	this.allPaths=new TSPhelper[1000];
	for(int i=0;i<1000;i++)
	{
		TSPhelper obj=new TSPhelper();
		this.allPaths[i]=obj;
	}
	}
	
	
	public void computePath( GraphLibrary<String> G,String currentVertice,ArrayList<String> currentpath,Integer pathCost,HashMap<String,LinkedList<GenericEdge<String>>> remainedLists)
	{
		//if all vertices are visited return 

		if(currentpath.containsAll(G.getUWGraph().getVertexList()) )
		{
			
			//adding the cost of final edge to form the circle
			for(GenericEdge<String> edge: remainedLists.get(currentVertice) )
			{
				if(edge.getTo().equals(currentpath.toArray()[0]))
				{
		           	pathCost=pathCost+edge.getCost();
		           	break;
				}
			}
			//add edge cost which completes the cycle by searching through all the edge lists of current vertex

	                	if(pathCost<this.minPathCost)
	                	{
	                		this.minPathCost=pathCost;	 
	                		for(String e:currentpath)
	                		allPaths[index].minPath.add(e);
	                		allPaths[index].minPath.add(currentpath.get(0));
	                		allPaths[index].minPathCost=pathCost;
	                		index++;
	                		printTSP(currentpath);	 
	                		System.out.println("--------------\n"); 
	                	}
	                			   		 
		}
			
		else{
		//	 per each unvisited edges in adjancy lists of current vertice 
			 for(GenericEdge<String> edge: remainedLists.get(currentVertice) ){ 
				
			 if(!currentpath.contains(edge.getTo() )&& !edge.isVisted() )
				 {
					 if(currentpath.isEmpty())
					 {
						 currentpath.add(edge.getFrom());
					 }
						 currentpath.add(edge.to);	
						
						int index= remainedLists.get(currentVertice).indexOf(edge);					
						remainedLists.get(currentVertice).get(index).setVisted(true);
						 computePath(G, edge.getTo(), currentpath, pathCost+edge.getCost(),remainedLists);
						 currentpath.remove(edge.getTo());
						 remainedLists.get(currentVertice).get(index).setVisted(false);
				 }
			 }
		 }
			 
	}
	
	

public void getPath(GraphLibrary<String> G){
	
	LinkedList<GenericEdge<String>> adjList=new LinkedList<GenericEdge<String>>();
	ArrayList<String> Currentpath;
	HashMap<String,LinkedList<GenericEdge<String>>> RemainedLists=new HashMap<>();
	Integer minCost=Integer.MAX_VALUE;
	int pathCost=0;

	for(String v:G.getUWGraph().getVertexList())
	{
		for(String v1:G.getUWGraph().getVertexList())
		{
		adjList=G.getUWGraph().getEdges(v1);
		RemainedLists.put(v1, adjList);
		}
		pathCost=0;
		Currentpath=new ArrayList();
	 computePath(G, v, Currentpath, pathCost, RemainedLists);
	 System.out.println("*****************************\n"); 
	 System.out.println("Minimum path starting from vertex "+v+"\n"); 
	 System.out.println("*****************************\n"); 
	 if(minCost>this.minPathCost)
	 {
		 minCost=this.minPathCost;
	 }
	this.minPathCost=Integer.MAX_VALUE;
		
	}
	try {
		writeToFile(this.allPaths, minCost);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void printTSP(ArrayList<String> Currentpath)
{
	//   System.out.print("[");
       for(String edge: Currentpath){ 
           System.out.print(edge+"--"); 
       } 
       System.out.println(Currentpath.get(0));
       System.out.println("\n"); 
       System.out.print("Path cost: "+this.minPathCost);
       System.out.println("\n"); 
  
	
}
public void printMinimumPath( TSPhelper [] All, Integer minCost)
{
	//   System.out.print("[");
	for(int i=0;i<All.length;i++){
		if(All[i].minPathCost==minCost)
		{
		 System.out.print("Alternative min path number "+i+"\n" );
		 for(String s: All[i].minPath)
		 {
		 System.out.print(s+"--"); 
		  
		 }
		 System.out.println("\tPathCost:"+All[i].minPathCost+"\n");
		 System.out.println("\n"); 
		
		}
	
	}
       
         
	
}

public static void writeToFile(TSPhelper [] All, Integer minCost) throws IOException
{
	try{
	 String filename = "TSP_Paths.txt";
	  String workingDirectory = System.getProperty("user.dir");
	  String absoluteFilePath = "";
		
		//absoluteFilePath = workingDirectory + System.getProperty("file.separator") + filename;
		absoluteFilePath = workingDirectory + File.separator + filename;

		System.out.println("\n"+"File has been saved to : " + absoluteFilePath);
			
		//****************//
			
	//	File file = new File(absoluteFilePath);
   FileWriter fileWriter = new FileWriter(absoluteFilePath);
   
   for(int i=0;i<All.length;i++){
		if(All[i].minPathCost==minCost)
		{
		 fileWriter.write("Alternative min path starting from vertex "+All[i].minPath.get(0)+"\n" );
		 for(String s: All[i].minPath)
		 {
			 fileWriter.write(s+"->-"); 
		  
		 }
		fileWriter.write(">> PathCost:"+All[i].minPathCost+"\n");
		 fileWriter.write("\n"); 
		
		}
	
	}
   fileWriter.close();
	}
	catch(Exception e)
	{
		e.getMessage();
		
	}
   
}


}