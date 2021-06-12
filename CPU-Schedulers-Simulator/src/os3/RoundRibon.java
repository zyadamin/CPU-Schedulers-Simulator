/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author zezo
 */
public class RoundRibon {
    //ArrayList<process>procopy=new ArrayList<process>(10);
    process Process;
    int starttime=0;
    int endtime=0;
    Set<process> procopy = new HashSet<process>();
    public  void RR(ArrayList<process>pro,int Quantum,int contextswitch)
    {

        pro.sort(Comparator.comparing(process::getArrivalTime));

        endtime=pro.get(0).getArrivalTime();
        System.out.println("the excution order");

        while(pro.size()!=0)
        {
            Process=pro.get(0);
            pro.remove(0);

            if(Process.getFixedBrust()>Quantum)
            {
                endtime=starttime+Quantum;
                Process.setStarttime(starttime);
                Process.setEndtime(endtime);
                System.out.println(Process.getName()+"  "+Process.getStarttime()+" "+Process.getEndtime()+"\n");
                Process.setWaitingTime(Process.getEndtime()-Process.getBurstTime());
                Process.setFixedBrust(Process.getFixedBrust()-Quantum);
                Process.setTurnAroundTime(Process.getWaitingTime()+Process.getFixedBrust());
                starttime=endtime+contextswitch;
                pro.add(Process);
                procopy.add(Process);

            }
            else if(Process.getFixedBrust()<=Quantum)
            {

                endtime=starttime+Process.getFixedBrust()+contextswitch;
                Process.setStarttime(starttime);
                Process.setEndtime(endtime);
                System.out.println(Process.getName()+"  "+Process.getStarttime()+" "+Process.getEndtime()+"\n");
                Process.setWaitingTime(Process.getEndtime()-Process.getBurstTime());
                Process.setTurnAroundTime(Process.getWaitingTime()+Process.getBurstTime());
                starttime=endtime+contextswitch;
                Process.setBurstTime(0);
                procopy.add(Process);

            }


        }

    }
    public void timewaiting()
    {
        timewaiting(procopy);
    }

    public void timewaiting(Set<process> pro)
    {

        double time=0.0;
        for(process value:pro)
        {

            System.out.println(value.getName()+" "+value.getWaitingTime());
            time=time+value.getWaitingTime();
        }
        double timeavr=  (time / pro.size());

        System.out.println("the waiting time is ="+time+"\n");
        System.out.println("the AVRwaiting time is ="+timeavr+"\n");

    }
    public void timeturnround()
    {
        timeturnround(procopy);
    }
    public void timeturnround(Set<process>pro)
    {
        double time=0.0;

        for(process value:pro)
        {
            value.setTurnAroundTime(value.getTurnAroundTime());
            System.out.println(value.getName()+" "+value.getTurnAroundTime());
            time=time+(value.getTurnAroundTime());

        }
        double  timeavr=time/pro.size();
        System.out.println("the turnround time is ="+time+"\n");

        System.out.println("the AVRturnround time is ="+timeavr+"\n");


    }
}