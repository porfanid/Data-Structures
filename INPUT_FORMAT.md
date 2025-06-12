# Input Format Documentation

## Graph Input Format

The program expects graph data in a specific text format through standard input (stdin).

### Format Structure

```
N           # Number of vertices (integer)
K           # Number of edges (integer)
v1 w1       # Edge 1: vertex v1 connected to vertex w1
v2 w2       # Edge 2: vertex v2 connected to vertex w2
...         # Additional edges
vK wK       # Edge K: last edge
```

### Format Rules

1. **Vertices are numbered from 0 to N-1**
2. **Each edge is represented by two integers separated by a space**
3. **The graph is treated as undirected** (each edge connects both ways)
4. **No duplicate edges are checked** (implementation allows duplicates)
5. **Self-loops are allowed** (vertex connected to itself)

### Example: Small Graph (`exampleGraph`)

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

**Explanation:**
- 10 vertices (numbered 0-9)
- 12 edges
- Vertex 0 connects to vertex 9
- Vertex 1 connects to vertices 3 and 2
- And so on...

### Example: Large Graph (`Roma`)

```
3353
8870
2958 2959
1494 1573
1590 1603
2634 2635
...
(8870 total edges)
```

**Explanation:**
- 3,353 vertices (numbered 0-3352)
- 8,870 edges
- Appears to represent a real-world network (possibly Rome city network)

## Providing Input to the Program

### Method 1: File Redirection (Recommended)
```bash
java -cp bin Graph < src/exampleGraph
```

### Method 2: Manual Console Input
```bash
java -cp bin Graph
# Then type each line manually:
10
12
0 9
1 3
1 2
...
```

### Method 3: Pipe from echo/cat
```bash
echo -e "3\n2\n0 1\n1 2" | java -cp bin Graph
```

## Graph Representation in Memory

Once loaded, the graph is stored as:

- **Adjacency Lists**: Each vertex maintains a list of its neighbors
- **Undirected**: If edge (u,v) exists, both u→v and v→u are stored

### Internal Storage Example

For the input:
```
4
3
0 1
1 2
2 3
```

The internal adjacency lists become:
```
0: [1]
1: [0, 2]
2: [1, 3]
3: [2]
```

## Input Validation

⚠️ **Note**: The current implementation has minimal input validation:

- **No bounds checking**: Vertex numbers outside 0 to N-1 may cause errors
- **No format validation**: Non-integer input will cause exceptions
- **No negative number handling**: Negative vertex numbers not checked

### Valid Input Examples

**Minimal graph (single vertex, no edges):**
```
1
0
```

**Triangle (3 vertices, fully connected):**
```
3
3
0 1
1 2
2 0
```

**Disconnected components:**
```
5
3
0 1
1 2
3 4
```

### Invalid Input Examples

❌ **Vertex out of range:**
```
3
2
0 1
1 5    # Vertex 5 doesn't exist (only 0-2 valid)
```

❌ **Wrong edge count:**
```
3
5      # Claims 5 edges
0 1
1 2    # Only provides 2 edges
```

❌ **Non-integer input:**
```
3
2
0 a    # 'a' is not a valid vertex number
1 2
```

## File Encoding

- **Expected encoding**: UTF-8 or ASCII
- **Line endings**: Unix (LF) or Windows (CRLF) both work
- **Whitespace**: Single spaces between numbers, no tabs

### Roma Dataset Specifics

The Roma file contains:
- European characters that require proper encoding
- Large vertex numbers (up to 3352)
- Dense connectivity (average degree ≈ 5.3)

## Performance Considerations

| Graph Size | Vertices | Edges | Load Time | Memory Usage |
|------------|----------|--------|-----------|--------------|
| Small      | 10       | 12     | < 1ms     | < 1KB        |
| Medium     | 100      | 200    | < 10ms    | < 10KB       |
| Large (Roma)| 3,353   | 8,870  | ~2ms      | ~500KB       |

## Creating Your Own Input Files

To create a custom graph file:

1. **Count your vertices** (starting from 0)
2. **List all edges** (each pair of connected vertices)
3. **Format as shown above**

### Example: Simple Path Graph
```
# Path: 0-1-2-3-4
5
4
0 1
1 2
2 3
3 4
```

### Example: Star Graph
```
# Star: center vertex 0 connected to all others
5
4
0 1
0 2
0 3
0 4
```

## Input Processing Class

The input is processed by the `In.java` class which provides:
- `In.init()`: Initialize input reading
- `In.getInt()`: Read next integer
- `In.empty()`: Check if input is exhausted

This class handles whitespace and converts strings to integers automatically.