## Readme Docs in [Master branch](https://github.com/Ms-Shahid/Backend-lld/tree/master)

## Concurrency-1 

* Problem-1
  - A class Client with a main method.
  - Client class shall take two numbers as input from the user.
  - Client class should create a new thread and invoke code in a class called Adder.
  - Client class shall pass two numbers (taken as input from the user) to the Adder class.
  - The Adder class should print the sum of two numbers passed to it.

* [Solution Code]( https://github.com/Ms-Shahid/Backend-lld/tree/assignments/src/main/java/concurrency1/problem1 )

<hr>

* Problem-2
  - A class Client with a main method.
  - Client class shall take a number n as input.
  - A class called TableCreator which prints the multiplication table from 1 to 10 for a given number x
    - x times 1 is x

      - ..
    - x times 10 is 10x
  - Client should create a thread for every number between 1 to n, n included and
  - Pass it to TableCreator to print a multiplication table for that number.
  - Print format = 2 times 6 is 12

* [Solution Code](https://github.com/Ms-Shahid/Backend-lld/tree/assignments/src/main/java/concurrency1/problem2)

<hr>

## Concurrency - 2 : Executors & Callables

* Problem-1
  - A class Node to represent the Node of a BinaryTree.
  - Node should have two properties - left and right of type Node.
  - Node should also have an integer property - data.
  - Create a class TreeSizeCalculator to calculate the size of a BinaryTree using multiple threads.
  - TreeSizeCalculator constructor will be passed the root of the tree and ExecutorService to make new threads.
  - TreeSizeCalculator should implement Callable<Integer> interface