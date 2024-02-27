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

![img.png](images/img.png)

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