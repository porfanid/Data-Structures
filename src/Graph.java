/**
 *Pavlos Orfanidis 4134
 *Pantelis Rempakos 4279
 *Giorgos Kamaridis 4264
 */
/**
 * creating a class to store the graph.
 * @author porfanid
 *
 */
public class Graph {

    private final int numberOfVertices;
    
    
    
    
    //private int numberOfEdges;
    
    
    
    
    
    
    private Collection<Integer>[] adjacencyLists;
    
    
    
    
    
    
    private static boolean[] marked;
	
    
    
    
    
    
    private int[] parent;
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Constructor
     * 
     * initializing the number of Vertices
     * 
     * initializing a boolean array named marked based on the number of vertices
     * 
     * initializing an int array named parent based on the number of vertices.
     * 
     * creating anew collection list based on the number of vertices
     * 
     * initializing all the tables in the array created in the previous step.
     * 
     * @param numberOfVertices
     */
    @SuppressWarnings("unchecked")
	public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        //numberOfEdges = 0;
        
        
        
        
        
        marked=new boolean[numberOfVertices];
        
        parent=new int[numberOfVertices];
        
        
        
        
        adjacencyLists = (Collection<Integer>[]) new Collection[numberOfVertices];  // array of references to collections
        
        
        
        for (int i = 0; i < numberOfVertices; i++) {
        	adjacencyLists[i] = new Collection<Integer>();  // initialize collections to be empty
        }
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    /**
     * adding an edge to the list.
     * 
     * getting the collection item that exists in the position v and adding the int w
     * also
     * getting the collection item that exists in the position w and adding the int v
     * 
     * this is done because the path leads from v to w and from w to v. So, it has to add both paths.
     * 
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
    	
    	
    	
    	adjacencyLists[v].insert(w);
    	adjacencyLists[w].insert(v);
        //numberOfEdges++;
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * getting a list with all the neighbors.
     * @param v, the node from which I will get the neighbors from.
     * @return a Collection Item the adjacency list of the current item.
     * Since Collection class implements the Iterable interface, I can call it with either type. Either as a Collection item, or as an Iterable item.
     */
    public Iterable<Integer> adj(int v) {
        return adjacencyLists[v];
    }
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    /**
     * print adjacency lists
     * 
     * for every vertex, it prints the number plus ":"
     * 
     * then it prints all its neighbors seperated with space
     * 
     * finally it is changing line, to print the next one.
     */
    public void printGraph() {
        
    	
    	System.out.println("adjacency lists");
        
        
        
        for (int v = 0; v < numberOfVertices; v++) {
        	
        	
            System.out.print(v + " : ");
            
            
            
            for (int w : adj(v)) {
                System.out.print(w + " ");
            }
            
            
            
            System.out.println("");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     *  breadth-first search starting from node s
     *  
     *  it gets a node.
     *  
     *  it places all the ones connected to him from the form of a diagram as a straight line.
     *  
     *  Procedure:
     *  
     *  i) creating a new Queue.
     *  
     *  ii) marking the position on the marked table of that node as true, to suggest that this node has been examined.
     *  
     *  iii) adding the s node to the queue we created
     *  
     *  iv) while the number of current node is smaller than the amount of nodes:
     *  
     *  		a) getting the value of the last added node.
     *  				catches exception because the number of element that he will want to get may be largetr than the amount of elements stored in the list.
     * 
     *  		b) for every neighbor (stored in the adjacency list), if the neighbor is not marked, it marks him and applyes the current node as its parent.
     *  
     *  		c) stores the neighbor to the queue.
     *  
     *  @param s
     *  
     *  @return the Q with all the elements starting from node s.
     */
    public Queue<Integer> bfs(int s)
    {	
         /* enter your code! */
        
        System.out.println("Creating BFS");
        
		Queue<Integer> Q = new Queue<Integer>();
		
		
		

		marked[s] = true;
		
		
		
		
		
		
		
		Q.put(s);
		
		
		
		
		
		
		
		
		
		
		int k=-1;
		int i=0;
		while (i<numberOfVertices)
		{
			
			try {
				k = Q.get();
				
			} catch (Exception e) {
				//System.out.println("My name is Paul "+e.getMessage()+"Hello There");
			}
			
			
			
			
			
			
			
			
			
			for ( int v : adj(k) ) {		
				if (!marked[v]) {
					marked[v] = true;
					parent[v] = k;
					Q.put(v);
				}
			}
			
			
			
			
			
			
			i++;
		}
		
		
		
		
		
		
		return Q;
    }
    
    
    
    
    
    
    
    
    
    /**
     * checks if the node we want to check has neighbors.
     * 
     * We know that the node has at least one connection. Otherwise we wouldn't bew able to get to it.
     * 
     * What we are interested in is if it has more than one connections.
     * 
     * @param currentNode
     * @return
     */
    public boolean hasNext(int currentNode)
    {
    	return adjacencyLists[currentNode].length>1;
    }
    
    
    
    
    
    
    
    
    
    /**
     * Checks if a node contains a neighbor.
     * @param startNode
     * @param desiredNeighbor
     * @return boolean whether the desiredNeighbor is connected to the startNode.
     */
    public boolean containsNeighbor(int startNode, int desiredNeighbor)
    {
    	
    	Iterable<Integer> allNeighbors=adj(startNode);
    	
    	
    	boolean response=false;
    	for(Integer neighbor:allNeighbors)
    	{
    		if(neighbor.equals(desiredNeighbor))
    		{
    			return true;
    		}
    		else
    		{
    			if(neighbor.equals(startNode))
    			{
    				continue;
    			}
    			
    			response=false;
    			//response=containsNeighbor(neighbor,desiredNeighbor);
    		}
    	}
    	
    	
    	return response;
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    /**
     * compute distance (minimum number of edges) from v to w
     * @param v
     * @param w
     * @return
     */
    int distance(int v, int w)
    {
    	
    	if(containsNeighbor(v,w))
    	{
    		return 1;
    	}
    	
    	Iterable<Integer> allNeighbors=adj(v);
    	for(Integer neighbor:allNeighbors)
    	{
    		if(neighbor.equals(v))
    		{
    			continue;
    		}
    		//return distance+distance(neighbor,w);
    	}
    	
    	
    	return - 1;
    }
    
    /* find and print shortest path from v to w */
    void shortestPath(int v, int w)
    {
        /* enter your code! */    
    }
    
    /* compute graph diameter */
   int diameter()
   {
        int diam = numberOfVertices-1; /* initialization */
        
        /* enter your code! */
        
        return diam;
    }
    
    
   
   
   
   
   /**
    * main method
    * 
    * getting the first int from the file.
    * 
    * recording the time that the program started the execution.
    * 
    * creating a new graph that will record the nodes.
    * 
    * reading an  int from the file.
    * 
    * for every number until the one read, it reads the next two and adds them as edges.
    * 
    * storing the current time.
    * 
    * printing the distance from certain numbers.
    * 
    * getting the shortest path from 0 to N-1
    * 
    * getting the diameter of the diagram.
    * 
    * recording the time the program ended its execution.
    * 
    * @param args
    */
    public static void main(String[] args) {
    	
    	
    	
        In.init();
        
        int N = In.getInt();
        
        long startTime = System.currentTimeMillis();
        
        Graph G = new Graph(N);
        
        
        
        int K = In.getInt();
        
        
        
        for (int i = 0; i < K; i++) {
            int v = In.getInt();
            int w = In.getInt();
            G.addEdge(v, w);
        }
        
        
        
        long constructTime = System.currentTimeMillis();
        
        
        
        System.out.println("Graph construction time = " + (constructTime - startTime));
        
        G.printGraph();
        
        int dist = G.distance(0,(N-1)/2);
        System.out.println("Distance from 0 to " + (N-1)/2 + " = " + dist);
        
        
        
        dist = G.distance((N-1)/2,N-1);
        System.out.println("Distance from " + (N-1)/2 + " to " + (N-1) + " = " + dist);

        
        
        dist = G.distance(0,N-1);
        System.out.println("Distance from 0 to " + (N-1) + " = " + dist);
        
        
        
        G.shortestPath(0,N-1);
       
        int diamG = G.diameter();
        System.out.println("Diameter = " + diamG);
        
        
        
        long endTime = System.currentTimeMillis();
        System.out.println("Computation time = " + (endTime - constructTime));
    }
}
