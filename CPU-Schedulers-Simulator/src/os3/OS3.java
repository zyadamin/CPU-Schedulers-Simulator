/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zezo
 */
public class OS3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


       
        ArrayList<process>processes=new ArrayList<>();
        
    String name;
    int priority=0;
    int arrivalTime;
    int burstTime;
    int queueNum=0;
    
    
        Scanner input = new Scanner(System.in);
                int number;
                int choose;        
              int ContextSwitch = 0;
              int Quantum = 0;
       System.out.println("what is number of process?");   
        number = input.nextInt();         
                
               
        System.out.println("what is the type ?\n"
                +   "1-Shortest Job First \n" +
                    "2-Round Robin \n" +
                    "3-Priority\n" +
                    "4-Multi level\n");     
        
        choose=input.nextInt();
        
         if(choose==2||choose==4){
       System.out.println("Quantum ?"); 
              Quantum= input.nextInt();          
       }

        if(choose==1||choose==2){
        
      System.out.println("ContextSwitch ?");
        ContextSwitch= input.nextInt();
        }

        
        for(int i=0;i<number;i++){
            
           System.out.println("name ?"); 
            name=input.next();

           System.out.println("arrivalTime ?");  
            arrivalTime = input.nextInt();

           System.out.println("burstTime ?");   
            burstTime  =  input.nextInt();   
            
           if(choose==3){
          System.out.println("Priority ?");
            priority = input.nextInt();   
           }
  
           
         if(choose==4){
       System.out.println("queue number ?"); 
         queueNum=input.nextInt();
                 
         }  
           
        process newOne= new process(name,priority,arrivalTime,burstTime,ContextSwitch);
        newOne.setQueueNum(queueNum);
        processes.add(newOne);
        }
        

     if(choose==1){
     
        SRTF object = new SRTF(processes,number,ContextSwitch);

     }   
        
       if(choose==2){ 
       RoundRibon Round= new RoundRibon();
       Round.RR(processes,Quantum,ContextSwitch);
       Round.timewaiting();
       Round.timeturnround();
       }
       
       
       if(choose==3){
        Priority.run(processes);

       }
       
       if(choose==4){
        
       multiLevel.run(processes,Quantum);
       }
       
      if(choose==4||choose==3){ 
       double avWating=0,avT=0;   

       
System.out.println("Name        Waiting Time          Turnaround  Time" );

for(int i=0;i<processes.size();i++){
System.out.println(processes.get(i).getName()+"               "+processes.get(i).getWaitingTime()+"                     "+processes.get(i).getTurnAroundTime());
avWating+=processes.get(i).getWaitingTime();
avT+=processes.get(i).getTurnAroundTime();
}


        System.out.println("Average Waiting Time  "+(avWating/processes.size()));
        System.out.println("Average Turnaround  Time   "+(avT/processes.size()));
        
      }
    }
    
}
// priorty
/*
4
3
p1
0
2
5
p2
1
3
10
p3
3
2
4
p4
5
2
12
*/



//maltilevel
/*
4
4
2
p1
0
4
1
p2
0
3
1
p3
0
8
2
p4
10
5
1

*/

// priorty

/*
7
3
p1
0
1
2
p2
1	
7
6
p3	
2	
3
3
p4	
3
6
5
p5		
4	
5
4
p6		
5	
15
10
p7	
6
8
9
*/


