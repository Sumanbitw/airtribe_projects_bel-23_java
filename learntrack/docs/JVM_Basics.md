# JVM Basics

## What is JDK, JRE, and JVM?

**JDK (Java Development Kit)** is the full toolkit used to write and build Java programs. It includes the compiler (`javac`), tools, and also a JRE. Developers need the JDK to create `.class` files from `.java` source code.

**JRE (Java Runtime Environment)** is what you need to run already compiled Java programs. It contains the JVM and the core class libraries. End users who only run Java apps typically need a JRE (or a JDK, which includes one).

**JVM (Java Virtual Machine)** is the engine that actually executes Java bytecode. It loads `.class` files, verifies them, and runs the instructions on the host machine. Different operating systems have their own JVM implementations, but they all understand the same bytecode format.

## What is Bytecode?

Bytecode is the intermediate form produced when you compile a `.java` file with `javac`. Instead of compiling directly to machine code for one CPU/OS, Java produces platform-independent `.class` files. The JVM on each machine then interprets or JIT-compiles that bytecode into native instructions for that system.

## What Does “Write Once, Run Anywhere” Mean?

“Write once, run anywhere” means you can write Java source code once, compile it to bytecode, and then run that same bytecode on any system that has a compatible JVM. You do not need to rewrite or recompile the program for Windows, macOS, or Linux separately, as long as each platform provides a JVM that understands the bytecode.

In short: the JDK helps you create portable bytecode, and the JVM on each machine makes that bytecode run locally. That separation is what makes Java applications portable across platforms.
