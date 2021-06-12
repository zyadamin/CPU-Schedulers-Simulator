# CPU-Schedulers-Simulator

1.	preemptive Shortest- Job  First (SJF) Scheduling  with context switching 
2.	Round Robin (RR) with context switching
3.	preemptive  Priority Scheduling (Provide a solution to avoid starvation problem)
4.	Multi level Scheduling : 
      1.	The schedule consists of 2 queues
      2.	The first queue is Round Robin (Quantum will be input )
      3.	The second queue is FCFS (preemptive)
      4.	The first queue always has higher priority. So the second queue starts/resumes execution only if the first queue is empty
      5.	The process input is name, arrival, burst and the queue number that it will enter (1 or 2)
      6.	The process doesn’t change the queue that it enters
