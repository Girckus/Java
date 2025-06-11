# Java Reflection

This is a sample project demonstrating the use of the Java Reflection API, based on the Alura courses:  
- *Java Reflection Part 1: Understanding Metaprogramming*  
- *Java Reflection Part 2: Annotations and Dependency Injection*

## Overview

The project showcases how to use Reflection to build an application that processes requests in the format `/controller/method` with optional parameters, enabling dynamic method invocation based on the URL.


## How to Use

1. Download the two projects: **alurator** and **estoque-api**.

2. Add the **alurator** project to the classpath of **estoque-api** (via IDE or build configuration).

3. Run the `Main` class inside the **estoque-api** project.

4. In the console, enter requests following the formats below to invoke the desired methods:

```
/controller/method
/controller/method?param1=value1&param2=value2
```

---

## Usage Examples

```plaintext
/produto/lista
/produto/filtra?nome=produto
/produto/filtra?nome=produto&marca=marca 1
/produto/filtra?marca=marca 1&nome=produto
```

---

## Additional Details

- The URL structure corresponds to:  
  - `controller` — the controller name (class that manages a functionality)  
  - `method` — the public method of the controller to be called via Reflection  
  - `parameters` — optional parameters passed to the method

- The project uses Reflection to dynamically identify and invoke methods based on the request, demonstrating metaprogramming concepts in Java.
