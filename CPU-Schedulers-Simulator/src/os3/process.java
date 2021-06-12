package os3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zezo
 */
public class process {
    
    String name;
    int Priority;
    int arrivalTime;
    int burstTime;
    int completionTime;
    int turnAroundTime;
    int waitingTime;
    boolean complete=false;
    int fixedBrust;
    int queueNum;
    int starttime;
    int endtime;
    int contextSwitch ;

     public process() {
    }

        public void incContextSwitchNumber() {
        this.contextSwitch++;
    }
     
     
    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    
    

    public process(String name, int Priority, int arrivalTime, int burstTime,int contextSwitch) {
        this.name = name;
        this.Priority = Priority;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.fixedBrust=burstTime;
        this.contextSwitch=contextSwitch;

    }

    public void setQueueNum(int queueNum) {
        this.queueNum = queueNum;
    }

    public int getQueueNum() {
        return queueNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int Priority) {
        this.Priority = Priority;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getFixedBrust() {
        return fixedBrust;
    }

    public void setFixedBrust(int fixedBrust) {
        this.fixedBrust = fixedBrust;
    }
    

    public int getStarttime() {
        return starttime;
    }

    public void setStarttime(int starttime) {
        this.starttime = starttime;
    }

    public int getEndtime() {
        return endtime;
    }

    public void setEndtime(int endtime) {
        this.endtime = endtime;
    }
    
    
    
    
    
    
}
