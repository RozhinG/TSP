import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static GraphLibrary<String> GraphReader(String fileName,BufferedReader br)
	{
		 String[] token=new String[6];
		try {
			
			GraphLibrary< String> GR=new GraphLibrary<String>(fileName);
			GraphLibrary<Integer> GR2=new GraphLibrary<Integer>(fileName);
    		
       if(fileName.equals("undirected weighted"))
        {
      //  	UndirectedWeightedGraph<String> UW=new UndirectedWeightedGraph<String>();
        	
        	
  		  while ((fileName = br.readLine()) != null) 
  		  {
  			 token=fileName.split("=");
  			 String from=token[0];
  			String to=token[1];
  			Integer cost=Integer.parseInt(token[2]);
  			GR.getUWGraph().addEdge(from,to, cost);
  		  }
  		GR.getUWGraph().printGraph();
  		return GR;
  		
  		//	GR.getUWGraph().getVertices();
  		//	GR.getUWGraph().getEdges("A");
        }
		}
		catch(Exception ex) {
			ex.getMessage();
			
		}
		return null;
	}
	public static void main(String[] args) {
		
		System.out.print("Please enter the full path with the file name : Example:"+"E:\\gl_Files\\t7.gl");
		Scanner sc=new Scanner(System.in);
		String path=sc.next();
		  File file = new File(path); 
		  
		  BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String st; 
			st = br.readLine();
			GraphLibrary<String> G=GraphReader(st, br);
			
			TSP t1=new TSP(G);
			t1.getPath(G);
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		  
		  
		
	}

}
