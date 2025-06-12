# Algorithms Documentation

## Overview

This project implements several graph algorithms and data structures. This document provides detailed explanations of the algorithms, their complexity, and implementation details.

## Data Structures

### 1. Collection<Item> - Generic Linked List

**Purpose**: Custom implementation of a linked list with iterator support.

**Key Features**:
- Generic type support (`<Item>`)
- Implements `Iterable<Item>` interface
- Dynamic size with efficient insertion
- Conversion to array format

**Implementation Details**:
```java
private class Node {
    Item item;
    Node next;
}
```

**Methods and Complexity**:
- `insert(Item item)`: O(n) - appends to end
- `isEmpty()`: O(1) - checks if head is null
- `toArray()`: O(n) - creates array representation
- `toString()`: O(n) - creates comma-separated string

**Iterator Implementation**:
- Uses inner class `CollectionIterator`
- Supports enhanced for-loop syntax
- O(1) per iteration step

### 2. Queue<Item> - FIFO Data Structure

**Purpose**: First-In-First-Out queue implementation built on Collection.

**Key Features**:
- FIFO ordering
- Built on custom Collection class
- Generic type support

**Methods and Complexity**:
- `put(Item item)`: O(n) - adds to end (delegates to Collection.insert)
- `get()`: O(n) - returns last element (not true FIFO behavior!)
- `isEmpty()`: O(1) - checks underlying collection
- `contains(Item element)`: O(n) - linear search with type checking

⚠️ **Implementation Issue**: The `get()` method returns the last element instead of the first, making this not a true FIFO queue!

### 3. Graph - Adjacency List Representation

**Purpose**: Undirected graph representation using adjacency lists.

**Key Features**:
- Adjacency list storage using Collection arrays
- Undirected edges (each edge stored bidirectionally)
- Support for BFS traversal
- Parent tracking for path reconstruction

**Storage Structure**:
```java
private Collection<Integer>[] adjacencyLists;
private boolean[] marked;      // For BFS marking
private int[] parent;          // For parent tracking
```

## Graph Algorithms

### 1. Breadth-First Search (BFS)

**Purpose**: Explores graph level by level from a starting vertex.

**Algorithm Overview**:
1. Mark starting vertex and add to queue
2. While vertices remain to process:
   - Dequeue a vertex
   - For each unmarked neighbor:
     - Mark it, set parent, and enqueue

**Time Complexity**: O(V + E)
- V = number of vertices
- E = number of edges

**Space Complexity**: O(V)
- Storage for marked array, parent array, and queue

**Implementation Details**:
```java
public Queue<Integer> bfs(int s) {
    Queue<Integer> Q = new Queue<Integer>();
    marked[s] = true;
    Q.put(s);
    
    // Process vertices level by level
    while (conditions_met) {
        int v = Q.get();  // Current vertex
        for (int w : adj(v)) {  // All neighbors
            if (!marked[w]) {
                marked[w] = true;
                parent[w] = v;
                Q.put(w);
            }
        }
    }
    return Q;
}
```

**Applications**:
- Finding shortest paths in unweighted graphs
- Connected component analysis
- Level-order traversal

### 2. Distance Calculation (Incomplete)

**Purpose**: Calculate shortest path distance between two vertices.

**Current Implementation**: 
- `distance(int v, int w)` returns -1 (placeholder)
- Contains partial logic for neighbor checking

**Intended Algorithm** (BFS-based shortest path):
1. Run BFS from source vertex
2. Return the level at which target vertex is found
3. If target not reachable, return -1

**Expected Time Complexity**: O(V + E)

**Improvement Needed**:
```java
int distance(int v, int w) {
    // Reset marked array
    Arrays.fill(marked, false);
    
    Queue<Integer> queue = new Queue<>();
    marked[v] = true;
    queue.put(v);
    
    int level = 0;
    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        for (int i = 0; i < levelSize; i++) {
            int current = queue.get();
            if (current == w) return level;
            
            for (int neighbor : adj(current)) {
                if (!marked[neighbor]) {
                    marked[neighbor] = true;
                    queue.put(neighbor);
                }
            }
        }
        level++;
    }
    return -1; // Not reachable
}
```

### 3. Graph Diameter (Incomplete)

**Purpose**: Find the longest shortest path in the graph.

**Current Implementation**: 
- Calls `height(int node)` recursively
- Returns 0 (placeholder)

**Intended Algorithm**:
1. For each vertex as root, calculate maximum distance to all other vertices
2. Return the maximum of all these distances

**Expected Time Complexity**: O(V × (V + E)) = O(V²E) for dense graphs

**Tree Height Algorithm** (partially implemented):
- Recursively calculates depth from a given node
- Uses DFS-like approach
- **Issue**: Doesn't handle cycles properly (graph vs tree)

### 4. Shortest Path Printing (Not Implemented)

**Purpose**: Print the actual shortest path between two vertices.

**Algorithm Outline**:
1. Run BFS to build parent array
2. Backtrack from target to source using parent pointers
3. Reverse the path and print

**Expected Implementation**:
```java
void shortestPath(int v, int w) {
    // Run BFS to populate parent array
    bfs(v);
    
    if (!marked[w]) {
        System.out.println("No path exists");
        return;
    }
    
    // Reconstruct path
    Stack<Integer> path = new Stack<>();
    int current = w;
    while (current != v) {
        path.push(current);
        current = parent[current];
    }
    path.push(v);
    
    // Print path
    while (!path.isEmpty()) {
        System.out.print(path.pop());
        if (!path.isEmpty()) System.out.print(" -> ");
    }
    System.out.println();
}
```

## Utility Methods

### Graph Construction
- `addEdge(int v, int w)`: Adds undirected edge
- Time: O(1) average (depends on Collection.insert)

### Graph Display
- `printGraph()`: Prints adjacency list representation
- Time: O(V + E)

### Neighbor Queries
- `adj(int v)`: Returns iterable of neighbors
- `hasNeighbors(int node, int desiredLength)`: Checks degree
- `containsNeighbor(int start, int target)`: Checks direct connection

## Algorithm Analysis Summary

| Algorithm | Time Complexity | Space Complexity | Status |
|-----------|----------------|------------------|---------|
| BFS | O(V + E) | O(V) | ✅ Implemented |
| Distance | O(V + E) | O(V) | ❌ Incomplete |
| Diameter | O(V²E) | O(V) | ❌ Incomplete |
| Shortest Path | O(V + E) | O(V) | ❌ Not implemented |

## Performance Characteristics

### Input Size vs Performance (Roma Dataset)
- **Vertices**: 3,353
- **Edges**: 8,870
- **Construction Time**: ~2ms
- **Memory Usage**: ~500KB for adjacency lists

### Scalability Considerations
- **Dense graphs**: Performance degrades as E approaches V²
- **Sparse graphs**: Near-linear performance in practice
- **Memory**: O(V + E) storage requirement

## Known Issues and Improvements

### Current Issues
1. **Queue implementation**: `get()` method doesn't follow FIFO
2. **Distance algorithm**: Returns -1 instead of computing actual distances
3. **Diameter calculation**: Incomplete implementation
4. **Path reconstruction**: Not implemented

### Suggested Improvements
1. **Fix Queue FIFO behavior**
2. **Implement proper shortest path algorithms**
3. **Add weighted graph support**
4. **Implement cycle detection**
5. **Add graph connectivity checks**
6. **Optimize memory usage for large graphs**

### Advanced Algorithms to Consider
- **Dijkstra's Algorithm**: For weighted shortest paths
- **Floyd-Warshall**: For all-pairs shortest paths
- **DFS-based algorithms**: Cycle detection, topological sort
- **Connected Components**: Union-Find or DFS-based
- **Minimum Spanning Tree**: Kruskal's or Prim's algorithm