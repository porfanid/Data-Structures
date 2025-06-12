# Build Instructions

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- A Java IDE (Eclipse recommended, project files included) or command line tools

## Command Line Build

### 1. Compile the Project

From the project root directory:

```bash
# Create bin directory if it doesn't exist
mkdir -p bin

# Compile all Java files
javac -d bin src/*.java
```

### 2. Run the Program

#### With the sample graph:
```bash
java -cp bin Graph < src/exampleGraph
```

#### With the Roma dataset:
```bash
java -cp bin Graph < src/Roma
```

#### Interactive input:
```bash
java -cp bin Graph
# Then manually enter:
# 10
# 12
# 0 9
# 1 3
# ... (continue with edges)
```

## Eclipse IDE Build

### 1. Import Project

1. Open Eclipse
2. File → Import → General → Existing Projects into Workspace
3. Select the project root directory
4. Click Finish

### 2. Run Configuration

1. Right-click on `Graph.java` in Package Explorer
2. Run As → Java Application
3. The program will start and wait for input

### 3. Provide Input

**Option A: Console Input**
- Enter the graph data manually in the console

**Option B: File Redirection (Advanced)**
1. Right-click on `Graph.java` → Run As → Run Configurations
2. Go to "Arguments" tab
3. In "Program arguments", you can't directly redirect files, but you can:
   - Copy the content of `exampleGraph` or `Roma`
   - Paste it into the console when the program runs

## Alternative Build Methods

### Using a Simple Script

Create a file called `build.sh` (Linux/Mac) or `build.bat` (Windows):

**build.sh:**
```bash
#!/bin/bash
echo "Compiling Java files..."
mkdir -p bin
javac -d bin src/*.java

if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo "Run with: java -cp bin Graph < src/exampleGraph"
else
    echo "Compilation failed!"
fi
```

**build.bat:**
```batch
@echo off
echo Compiling Java files...
if not exist bin mkdir bin
javac -d bin src/*.java

if %errorlevel% == 0 (
    echo Compilation successful!
    echo Run with: java -cp bin Graph ^< src/exampleGraph
) else (
    echo Compilation failed!
)
```

### Using Maven (if you want to modernize)

If you decide to add Maven support, create a `pom.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <groupId>university.lab</groupId>
    <artifactId>graph-algorithms</artifactId>
    <version>1.0.0</version>
    
    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>
    
    <build>
        <sourceDirectory>src</sourceDirectory>
        <plugins>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>3.1.0</version>
                <configuration>
                    <mainClass>Graph</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

Then build with:
```bash
mvn compile exec:java < src/exampleGraph
```

## Troubleshooting

### Common Issues

**"Class not found" error:**
- Make sure you're in the correct directory
- Verify the classpath: use `-cp bin` not `-cp src`

**"javac not found":**
- Install JDK (not just JRE)
- Add Java to your system PATH

**Input file not found:**
- Use relative paths from project root: `src/exampleGraph`
- Or use absolute paths to the files

**Eclipse compilation errors:**
- Right-click project → Refresh
- Project → Clean → Select your project

### File Encoding Issues

If you encounter encoding issues with the Roma dataset:
```bash
# Check file encoding
file -bi src/Roma

# If needed, convert encoding
iconv -f ISO-8859-1 -t UTF-8 src/Roma > src/Roma_utf8
```

## Performance Notes

- The Roma dataset (3353 vertices, 8870 edges) may take a few seconds to process
- Expected output for exampleGraph should appear almost instantly
- BFS traversal time scales as O(V + E)

## Output Files

The program outputs to console only. If you want to save results:

```bash
java -cp bin Graph < src/exampleGraph > results.txt
```

This will save all output (including timing information) to `results.txt`.