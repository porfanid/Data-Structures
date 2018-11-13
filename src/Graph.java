import java.io.*;

public class Graph {

    private final int N;                // number of vertices
    private int M;                      // number of edges
    private Collection<Integer>[] adj;  // adjacency lists
    private static boolean[] marked;
	private int []parent;

    public Graph(int N) {
        this.N = N;
        this.M = 0;
        
        marked=new boolean[N];
        parent=new int[N];
        
        adj = (Collection<Integer>[]) new Collection[N];  // array of references to collections
        for (int i = 0; i < N; i++) {
            adj[i] = new Collection<Integer>();  // initialize collections to be empty
        }
    }
    
    
    private static void printArray(boolean[] array)
    {
    	for(boolean element:array)
    	{
    		System.out.println(element);
    	}
    }
    
    
    public void addEdge(int v, int w) {
        adj[v].insert(w);
        adj[w].insert(v);
        M++;
    }

    // list of neighbors 
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    // print adjacency lists
    public void printGraph() {
        System.out.println("adjacency lists");
        for (int v = 0; v < N; v++) {
            System.out.print(v + " : ");
            for (int w : adj(v)) {
                System.out.print(w + " ");
            }
            System.out.println("");
        }
    }

    /* breadth-first search starting from node s */
    Queue<Integer> bfs(int s)
    {	
         /* enter your code! */
        int k=-1;
		Queue<Integer> Q = new Queue<Integer>();
		System.out.print("hello World 1");
		marked[s] = true;
		Q.put(s);
		//Q.trimToSize();
		int i=0;
		while (i<N)
		{
			System.out.print("hello World 2");
			try {
				k = Q.get();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.print("hello World 3");
			for ( int v : adj(k) ) {		
				if (!marked[v]) {
					marked[v] = true;
					parent[v] = k;
					Q.put(v);
				}
			}
			i++;
		}
		System.out.print("hello World 4");
		return Q;
    }
    
    /* compute distance (minimun number of edges) from v to w */
    int distance(int v, int w)
    {
    	
    	Queue<Integer> result = bfs(v);
    	
    	Integer[] list=result.getList();
    	
    	int listLength=list.length;
    	for(int i=0;i<listLength;i++)
    	{
    		System.out.print(result.List[i]);
    	}

        return -1; // return -1 if w is not reachable from v
    }
    
    /* find and print shortest path from v to w */
    void shortestPath(int v, int w)
    {
        /* enter your code! */    
    }
    
    /* compute graph diameter */
   int diameter()
   {
        int diam = N-1; /* initialization */
        
        /* enter your code! */
        
        return diam;
    }
    
    

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
        //G.printGraph();
        
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
