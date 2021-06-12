package os3;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zezo
 */
public class Priority {
 //arival      // 0   1  2   2   4
 //periorety   // 5   3  1   2   9
 //burst time  // 1   5  3   4   1
     public static void run(ArrayList<process> x){
        
         boolean in=true;
    ArrayList<process> waiting= new ArrayList<>();
         process  select = null;  
         int time=0;
         while(in){
         int maxInWating=0;
         int maxPer=0;
         
           for(int j=0;j<waiting.size();j++){
               
              if(waiting.get(j).getWaitingTime()>2){
              int per=waiting.get(j).getPriority();
              waiting.get(j).setPriority(per+1);
              
              }

             if(waiting.get(j).getPriority()>maxPer){
             maxPer=waiting.get(j).getPriority();
             maxInWating=j;
             }
         }
                 
         for(int i=0;i<x.size();i++){
         if(x.get(i).getArrivalTime()== time &&!x.get(i).isComplete()){
            if(select==null){
             select=x.get(i);
             
             }
             else{
                
              if(x.get(i).getPriority()>select.getPriority()){
                  waiting.add(select);
                  select=x.get(i);
                  }
              
              else{
              
              waiting.add(x.get(i));
              
              }
                  
      
              }
             }
             }

         if(waiting.size()>0){
         if(select==null){
         select=waiting.get(maxInWating);
         }
         else{
             
         if(select.getPriority()<waiting.get(maxInWating).getPriority()){
         
             waiting.add(select);
             select=waiting.get(maxInWating);
         }
         
         
         }
         }
         

        if(select!=null){
         System.out.println(select.getName());
         int mins=select.getBurstTime();
         select.setBurstTime(mins-1);
         
         if(select.getBurstTime()==0){
             if(waiting.size()>0){
          if(select==waiting.get(maxInWating)){
              waiting.remove(maxInWating);
             }
             }
         select.setCompletionTime(time+1);
         select.setComplete(true);
            select=null;   
         }
         
        }
    
        for(int i=0;i<waiting.size();i++){
        
       if(waiting.get(i)!=select){
       int wait= waiting.get(i).getWaitingTime();
       waiting.get(i).setWaitingTime(wait+1);
       }       
        }
      
          time++;
         int count=0;
         for(int i=0;i<x.size();i++){             
         if(x.get(i).isComplete()==true){count++;}
         }
         
         if(count==x.size()){in=false;}
         
         }
       
         
    for(int i=0;i<x.size();i++){
    x.get(i).setTurnAroundTime(x.get(i).getCompletionTime()-x.get(i).getArrivalTime());
    //x.get(i).setWaitingTime(x.get(i).getTurnAroundTime()-x.get(i).getFixedBrust());
    }

    
    
    }
    
    
    
    
    
}
