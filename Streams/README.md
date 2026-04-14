# Java - Streams

This repository contains a **comprehensive and practical collection of examples for the Java Stream API**, covering **stream creation, intermediate and terminal operations, collectors, parallel streams, and functional programming concepts** available up to **Java 23**.

The goal is to serve as a **study guide, quick reference, and long-term knowledge base** for Java developers at any level.

Each file is **self-contained**, includes an executable `main` method, and demonstrates **specific concepts** of the API.

## Project Goals

- Provide a **complete guide to the Java Stream API**
- Help developers **write more declarative and functional-style code**
- Demonstrate **best practices when working with streams**
- Avoid **common pitfalls (e.g., misuse of parallel streams, side effects)**
- Serve as a reference for **technical interviews**
- Act as a **long-term personal knowledge base**

## Topics Covered

- Stream creation (`Stream.of`, `Collection.stream`, `Arrays.stream`)
- Intermediate operations (`map`, `filter`, `flatMap`, `distinct`, `sorted`, `peek`, `limit`, `skip`)
- Terminal operations (`forEach`, `collect`, `reduce`, `count`, `anyMatch`, `allMatch`, `findFirst`)
- Primitive streams (`IntStream`, `LongStream`, `DoubleStream`)
- Collectors (`Collectors.toList`, `groupingBy`, `partitioningBy`, `joining`, `mapping`)
- Optional usage (`Optional`, `orElse`, `ifPresent`, `map`)
- Parallel streams and performance considerations
- Lazy evaluation and pipeline behavior

## Requirements
- **Java 17+** (recommended **Java 21 or 23**)
- No external libraries required

## How to Compile and Run

Open a terminal and navigate to any subfolder with `.java` files:

```bash
javac FileName.java
java FileName
