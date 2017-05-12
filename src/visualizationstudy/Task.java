/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizationstudy;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author Katka
 */
public class Task extends TimerTask {
  
    int time = 0;
    JLabel timerLabel;
    Timer timer;
    boolean isRunning;
    long startTime;
    long completeTime;

    public Task(JLabel timerLabel, Timer timer, long completeTime) {
        this.timerLabel = timerLabel;
        this.timer = timer;
        this.completeTime = completeTime;
        this.time = (int)(completeTime/1000);
        startTime = System.currentTimeMillis();
        isRunning = true;
    }

    @Override
    public void run() {
        time++;
        timerLabel.setText("Time: " + Integer.toString(time));
    }

    public boolean isRunning(){
        return isRunning;
    }
    
    public void stop(){
        timer.cancel();
        isRunning = false;
        completeTime += System.currentTimeMillis() - startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getCompleteTime() {
        return completeTime;
    }
  
    

}
