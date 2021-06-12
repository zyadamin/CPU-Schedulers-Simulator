
package os3;
import java.util.ArrayList;
/*
4
1
0
p1
1
6
p2
1
8
p3
2
7
p4
3
3

*/
// processes :      p1  p2  p3  p4 
// burst time :     6   8   7   3   
// waiting time:    3   16  8   0
// Turnaround time: 9   24  15  3
public class SRTF {
    // Method to find the waiting time for all processes 
  
    static void findWaitingTime(ArrayList<process>processes, int n, 
                                     int waiting_time[],int contextSwitch) 
    { 
        int remaining_time[] = new int[n]; 
           
        // Copy the burst time into rt[] 
        for (int i = 0; i < n; i++) 
            remaining_time[i] = processes.get(i).burstTime; 
       
        int complete = 0, currentTime = 0;
        int minimum = Integer.MAX_VALUE;  // a big number = 2^31-1 = 2147483647    _ minimum Remaining time
        int shortest = 0;                 // index of least remaining time
        int oldShortest = 0;              // index of prev least remaining time
        int finish_time;                 // time at witch the process will finish
        boolean check = false; 
       
        while (complete != n) { 
       
            // Find process with minimum remaining time among the processes that arrives till the current time` 
            for (int j = 0; j < n; j++)  
            { 
                if ((processes.get(j).arrivalTime<= currentTime) && (remaining_time[j] < minimum) && remaining_time[j] > 0) { 
                    minimum = remaining_time[j]; 
                    shortest = j; 
                    check = true; 
                } 
            } 
            if (oldShortest != shortest) {// context switch Time
                processes.get(shortest).incContextSwitchNumber();
            }
            oldShortest = shortest;
            System.out.print("(");
            System.out.print(processes.get(shortest).name);
            System.out.print(")");
            if (!(complete == n - 1 && remaining_time[shortest] == 1)) {
                System.out.print("-->");
            }

       
            if (check == false) { 
                currentTime++; 
               continue; 
            } 
       
            // Reduce remaining time by one 
            remaining_time[shortest]--; 
       
            // Update minimum 
            minimum = remaining_time[shortest];
            // if minimum Remaining Time is 0 we need to make it a big number so the next least
            // number get executed
            if (minimum == 0) 
                minimum = Integer.MAX_VALUE; 
               
            // If a process gets completely executed 
            if (remaining_time[shortest] == 0) { 
       
                // Increment complete 
                complete++; 
                check = false; 
       
                // Find finish time of current process 
                finish_time = currentTime + 1; 
       
                // Calculate waiting time
                // waitingTime = finish - burstTime - arrivalTime - context switch time
                waiting_time[shortest] = finish_time - processes.get(shortest).burstTime 
                        - processes.get(shortest).arrivalTime + (processes.get(shortest).contextSwitch * contextSwitch)     ; 
                
                // if waiting time < 0 make it 0     move the process from waiting  to ready queue
                if (waiting_time[shortest] < 0) 
                    waiting_time[shortest] = 0; 
            } 
            // Increment time 
            currentTime++; 
        } 
        System.out.println("");
    }
         // Method to calculate turn around time 
    static void findTurnAroundTime(ArrayList<process>processes, int n, 
                            int waiting_time[], int tat[]) 
    { 
        // calculating turnaround time by adding burst_time[i] + waiting_time[i] 
        for (int i = 0; i < n; i++) 
            tat[i] = processes.get(i).burstTime + waiting_time[i]; 
    } 
       
    // Method to calculate average time 
    static void findavgTime(ArrayList<process>processes, int n,int contextSwitch) 
    { 
        int waiting_time[] = new int[n];
                int tat[] = new int[n]; // Turnaround Time
        int  total_wt = 0, total_tat = 0; 
       
        // Function to find waiting time of all processes 
        findWaitingTime(processes, n, waiting_time ,contextSwitch); 
       
        // Function to find turn around time for all processes 
        findTurnAroundTime(processes, n, waiting_time, tat); 
       
        // Display processes along with all details 
        System.out.println("processes " + 
                           " Burst time " + 
                           " Waiting time " + 
                           " Turn around time"); 
       
        // Calculate total waiting time and 
        // total turnaround time 
        for (int i = 0; i < n; i++) { 
            total_wt = total_wt + waiting_time[i]; 
            total_tat = total_tat + tat[i]; 
            System.out.println(" " + processes.get(i).name + "\t\t"
                             + processes.get(i).burstTime + "\t\t " + waiting_time[i] 
                             + "\t\t" + tat[i]); 
        } 
       
        System.out.println("Average waiting time = " + 
                          (float)total_wt / (float)n); 
        System.out.println("Average turn around time = " + 
                           (float)total_tat / (float)n); 
    }
    public SRTF(ArrayList<process> processes,int n ,int contextSwitch) {
        findavgTime(processes,n, contextSwitch);
    }

    
}