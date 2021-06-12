/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os3;

import java.util.ArrayList;

/**
 *
 * @author Manaz
 */
public class multiLevel {

   
   
 

   
    public static void run( ArrayList<process>pro,int quant) {
        
        
         ArrayList<process>queue1=new ArrayList<>();
         ArrayList<process>queue2=new ArrayList<>();
        int time=0;
   
            
            for(int i=0;i<pro.size();i++){
            
            if(pro.get(i).getQueueNum()==1){
            queue1.add(pro.get(i));
            
            }
            else{
                queue2.add(pro.get(i));
            
            }
            }
            
      
             while (true) {
                   boolean flag=false;
                 for(int i=0;i<queue1.size();i++){
                 
                 if(queue1.get(i).getArrivalTime()<=time){
              flag=true;
              int done=time;
           
              int y= queue1.get(i).getBurstTime();
              int j=0;
              for(;j<quant;j++){
              if(y>0){
                    y--;
              }
              else{break;}
              }
              queue1.get(i).setBurstTime(y);
                 time+=j;
                  System.out.println(queue1.get(i).getName()+"  "+done+"   "+time);
                 if(queue1.get(i).getBurstTime()==0){
                  queue1.get(i).setCompletionTime(time);
                  queue1.remove(i);
                
                }
                 
               
                 }
                 
            
                 
                 }
                 
               if(!flag){
               
               
                        
                   
                   int done=time;
                for(int i=0;i<queue2.size();i++){
                if(queue2.get(i).getArrivalTime()<=time){
                    flag=true;
              
                int t=queue2.get(i).getBurstTime();
                queue2.get(i).setBurstTime(t-1);
             
                    time++;
                 System.out.println(queue2.get(i).getName()+"  "+done+"   "+time);
                if(queue2.get(i).getBurstTime()==0){
               queue2.get(i).setCompletionTime(time);
                queue2.remove(i);
                
                }
            
                break;
                    }
                
                }
          
                   
               }  
                if(!flag) {time++;}
           
            if(queue1.size()==0&&queue2.size()==0){
            break;
            }
            
        }
         for(int i=0;i<pro.size();i++){
    pro.get(i).setTurnAroundTime(pro.get(i).getCompletionTime()-pro.get(i).getArrivalTime());
    pro.get(i).setWaitingTime(pro.get(i).getTurnAroundTime()-pro.get(i).getFixedBrust());
    }
   
        
        
        
    }
    
}
