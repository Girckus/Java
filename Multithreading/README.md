# Java - Multithreading

This project demonstrates different concepts and examples of multithreading in Java, including thread creation, synchronization, locking mechanisms, and parallel processing techniques.

## Features
- Basic thread creation and management
- Synchronization examples
- Usage of `ReentrantLock` and `ReadWriteLock`
- Thread-safe operations
- Examples of parallel execution

## Directory Structure

Each subfolder focuses on a specific concept:

- 'atomic/' contains examples of Atomic classe from the package java.concurrent.atomic.
- 'basic/' contains examples of basic concurrency in Java, like sychronized, volatile, wait and notify.
- 'forkjoin/' contains examples of the ForkJoin API.
- 'future/' contains examples of the Future API.
- 'lock/' contains examples of high-level lock classes from java.concurrent.locks.
- 'reactive/' contains examples of the Java 9 Reactive API.
- 'synchronizers/' contains examples of high-level synchronizes classes. 

## Requirements
- Java 17+ (Java 23 recommended to explore newer features like records and sealed classes)
- Terminal or IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code with Java support)

## How to Compile and Run

Open a terminal and navigate to any subfolder with `.java` files:

```bash
javac FileName.java
java FileName
```

Alternatively, use an IDE to open the folder and run the class with the `main` method.

---

> Developed as part of personal studies on Java concurrency and multithreading.

