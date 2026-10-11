# Setup Instructions

## JDK Version Used

- **JDK:** OpenJDK 25.0.2
- **Vendor:** Oracle Corporation
- **Architecture:** arm64 (macOS)
- **JAVA_HOME:** `/Users/enculture_suman/Library/Java/JavaVirtualMachines/openjdk-25.0.2/Contents/Home`

Verify installation:

```bash
java -version
javac -version
```

Expected output (example):

```text
openjdk version "25.0.2" 2026-01-20
OpenJDK Runtime Environment (build 25.0.2+10-69)
OpenJDK 64-Bit Server VM (build 25.0.2+10-69, mixed mode, sharing)
```

## Hello World Program Run

Create a simple file `HelloWorld.java`:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

Compile and run from the terminal:

```bash
javac HelloWorld.java
java HelloWorld
```

Output:

```text
Hello World
```

This confirms that the JDK (`javac`) and JRE/JVM (`java`) are installed and working correctly.
