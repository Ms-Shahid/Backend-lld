# Concurrency 

## Introduction to process & Threads

### Important concepts

- Process is program in execution( running program)
- Speed of CPU >>> Speed of Hard-disk
- RAM size <<< HDD/SSD size
- Perform depends on RAM & no. of CPU core

### Internal working

- when we load/launch the application, os allocates this application into RAM
- once this application is running in RAM it becomes process (running state)
- Then CPU executes this process
- The Process contains multiple threads along with application code, resources & other files related to application
  - Example: lets say we have launched Microsoft word application, first OS loads the application into RAM, then this becomes a process
  - Inside this process, there are multiple other small processes are running in parallel such as
    - spell checker
    - auto suggestion 
    - Grammar check
  - This internally processes which are running in parallel within process is called _Thread_
- Thread is a light weight process which runs/executes inside a process along with other application resources
- In general, thread is a unit of CPU execution


### Structure of Process (Process Control Block)

![img.png](img.png)

- The Process consists of 
  - application code
  - application data
  - resources
  - program counter(PC)
  - stack
  - Thread
- There can be multiple threads within a single process; each thread has their own PC, stack, data
- Whereas the application code is commonly used.

### Process Vs Threads

| Process                                   |  | Thread                                  |
|-------------------------------------------|----------|-----------------------------------------|
| Processes may not share data between them |    | All Threads can share common data       |
| Process takes more memory & speed is less |    | Thread takes less memory & speed is fast |


### Concurrency Vs Parallelism
| Concurrency                                                  |  | Parallelism                                                                                       |
|--------------------------------------------------------------|----------|---------------------------------------------------------------------------------------------------|
| At a given point of time, only one thread is making progress |    | Multiple threads running in parallel, concecurrey + Multiple threads making progress at same time |


## How Production services handle threads

- In real production thread is handled by service called Executors service
- A service that helps to manage threads in code more efficiently
- Efficiently manages multiple threads
- Executors use _Thread pool_ to handle threads & also destroy them if not utilized through garbage collector
- We can also reuse same threads again after its done with execution so that we don't end up creating N no.of threads
- Through the concept of Thread-Pool, executors service runs the certain no. of thread parallelly & remaining are waited in waiting queue, as soon as one of the running thread is done with execution the next thread from waiting queue is processed


## Understanding Executor service

- Executor service consists of 
  - work queue : the size of work queue describes how many are in waiting state
  - Workers : No. of tasks
- lets take an example, say we have 100 tasks & created a thread pool size of 10 threads
- At a time 10 threads are available for completing 100 tasks
- say at time = 95, then 94 tasks are totally in execution, out of which 10 threads ( size of pool ) will be assigned
- The Remaining 84 tasks are in work-queue
- At the end, make sure you shutdown executor service


## Callable Interface

- Similar to Runnable interface, however, the only difference is has a return type
- It can return any data-type
- Used when we have to implement task & return some data

## Problem of synchronization

- When more than one thread works on a shared variables at the same time, it can lead to potentially wrong results.
- Ref => 
- To handle this there is a concept of **critical section(CS)** which is applicable whenever there is a shared data among different threads
- Race Condition(RC) : When multiple threads are trying to access the shared resources (within CS) at the same time.
- Preemption : A program which is in its critical-Section is preempted(halt | stop | abort) by CPU can lead to syn problem.

- In Summary 
- Critical-Section is a section where multiple threads are executing
- Race Condition is a condition where multiple threads trying to enter CS
- Preemption is a program within CS is preempted due to some other high priority task.

## Properties of Synchronization problem

- Ideally there must be only one thread present in CS at a time
1) Mutual Exclusion 
   - only one thread should be present inside the CS at any point of time
2) Progress
    - Overall, the system should keep making progress, all the threads should get a chance to entire into CS 
3) Bounded Waiting
    - No thread should have to wait infinitely, avg waiting time should be same or similar
4) No Busy waiting
    - Instead of continuously checking the critical section again & again whether it's free, its better to notify thread once the critical section is free
    - Ideally there should not be busy waiting in code, it will lead to wastage of resources.

## Solution of Synchronization problem
1) Lock Class
   - The solution to sync problem is _**MUTEX**_, which is _Mutually Exclusion_
   - We have a Lock class in Java to use MUTEX
   - Along with shared data, there is also Lock object, 
   - At a given point of time only one thread can acquire the lock, & once the lock is acquired other thread can't enter CS , Unless release of lock is done.
   - Ref => 

2) Synchronized keyword
   - In jave every object has implict lock
   - Instead of creating a lock & releasing a lock manually we can simply use **synchronized** keyword
   - Its similar to lock provided by Java internally
   - You have to specify on which object you have to acquire lock, the rest part is handled by _Synchronized keyword_
   - `lock.lock();
     count.value += i;
     lock.unlock();`
   - Instead of the above we can simply use 
   - `synchronized(object) { //operations }`
   - Note : Synchronized can be used when we want to acquire lock only on one object passed as parameter
   - In case of multiple _Lock_ would be preferred way

3) Synchronized Method
    - once we make a method synchronized, only one thread can call this synchronized object at any given point of time.
    - similar to synchronized keyword, now its applicable at method level
    - can be used when we want to access/update count in multithreading env
   
## Thread class Methods

- **.join()** : join() waits for thread to die before proceeding for next execution
 - An invocation of this method behaves in exactly the same way as the invocation
   - join(0)
   - Throws:
   - InterruptedException – if any thread has interrupted the current thread. The interrupted status of the current thread is cleared when this exception is thrown.
   - Ref => https://www.geeksforgeeks.org/joining-threads-in-java/