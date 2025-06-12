# Graph Algorithms and Data Structures - Java Lab Project

**Course**: Data Structures and Algorithms Lab  
**University**:University Of Ioannina
**Year**: 2017-2018  
**Team Members**: 
- Pavlos Orfanidis (4134)
- Pantelis Rempakos (4279) 
- Giorgos Kamaridis (4264)

## Overview

This project implements fundamental graph algorithms and data structures in Java. It was developed as part of a university laboratory assignment focusing on graph theory, traversal algorithms, and custom data structure implementations.

### Key Features

- **Custom Collection Class**: Generic linked list implementation with iterator support
- **Graph Representation**: Adjacency list-based graph structure
- **Graph Algorithms**: 
  - Breadth-First Search (BFS)
  - Shortest path computation
  - Graph diameter calculation
- **Supporting Data Structures**: Custom Queue implementation (FIFO)
- **Input Processing**: Custom input reading utilities

## Project Structure

```
src/
├── Collection.java    # Generic linked list with iterator
├── Graph.java         # Main graph class with algorithms
├── Queue.java         # FIFO queue implementation
├── In.java           # Input utility methods
├── exampleGraph      # Small sample graph (10 vertices, 12 edges)
├── Roma             # Large real-world graph dataset (3353 vertices)
└── lab3results.txt  # Sample output from bracket matching tests
```

## How to Compile and Run

### Prerequisites
- Java 8 or higher
- Any Java IDE (Eclipse project files included) or command line

### Command Line Instructions

1. **Compile the project:**
   ```bash
   javac -d bin src/*.java
   ```

2. **Run with sample graph:**
   ```bash
   java -cp bin Graph < src/exampleGraph
   ```

3. **Run with Roma dataset:**
   ```bash
   java -cp bin Graph < src/Roma
   ```

### Eclipse Instructions
1. Import the project into Eclipse
2. Right-click on `Graph.java` → Run As → Java Application
3. Provide input through console or redirect from files

## Input Format

The program expects graph input in the following format:

```
N          # Number of vertices (0 to N-1)
K          # Number of edges
v1 w1      # First edge (vertex v1 connected to vertex w1)
v2 w2      # Second edge
...        # Additional edges
vK wK      # Last edge
```

### Example Input (`exampleGraph`):
```
10
12
0 9
1 3
1 2
2 3
2 4
3 5
4 6
5 8
5 6
7 8
7 9
8 9
```

## Algorithms Implemented

### Breadth-First Search (BFS)
- **Method**: `bfs(int s)`
- **Purpose**: Traverses graph starting from vertex `s`
- **Returns**: Queue containing vertices in BFS order
- **Time Complexity**: O(V + E)

### Distance Calculation
- **Method**: `distance(int v, int w)`
- **Purpose**: Computes shortest path distance between vertices
- **Returns**: Minimum number of edges between `v` and `w`
- **Implementation**: Currently incomplete (returns -1)

### Graph Diameter
- **Method**: `diameter()`
- **Purpose**: Finds the longest shortest path in the graph
- **Implementation**: Work in progress

## Sample Output

The program outputs:
1. Graph construction time
2. Adjacency list representation
3. Distance calculations between specific vertex pairs
4. Graph diameter
5. Total computation time

Example:
```
Graph construction time = 2
adjacency lists
0 : 9 
1 : 3 2 
2 : 1 3 4 
...
Distance from 0 to 4 = -1
Distance from 4 to 9 = -1
Distance from 0 to 9 = -1
Diameter = 0
Computation time = 1
```

## Implementation Notes

### Collection Class
- Generic linked list implementation
- Supports iteration via `Iterable<Item>` interface
- Methods: `insert()`, `isEmpty()`, `toArray()`, `toString()`

### Graph Class
- Uses adjacency lists for efficient storage
- Undirected graph representation (edges added in both directions)
- Supports BFS traversal with parent tracking

### Queue Class
- FIFO (First In, First Out) implementation
- Built on top of the custom Collection class
- Used in BFS algorithm

## Known Limitations

- Distance calculation algorithm is incomplete
- Shortest path printing is not implemented
- Diameter calculation needs refinement
- Some methods return placeholder values

## Dataset Information

### Roma Dataset
- **Vertices**: 3,353
- **Edges**: 8,870
- **Description**: Appears to be a real-world network (possibly Rome road network or similar)
- **Format**: Same as example graph but much larger scale

## Future Improvements

If continuing this project, consider:
- Implementing complete shortest path algorithms (Dijkstra's, Floyd-Warshall)
- Adding graph connectivity checks
- Implementing cycle detection
- Adding weighted graph support
- Improving input validation and error handling

## Academic Context

This project demonstrates understanding of:
- Object-oriented programming in Java
- Generic programming and type safety
- Graph theory and algorithms
- Data structure implementation
- Algorithm complexity analysis
- Iterator pattern implementation

## License

This project is for educational purposes. See LICENSE file for details.

---

**Note**: This is an archived academic project from 2017-2018. Code is preserved for historical and portfolio purposes.
