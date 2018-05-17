package SlagalicaKviz;

import java.util.Timer;
import java.util.TimerTask;

public class TimerApp{
    boolean running = false;



public static void timerStart() {

        //timer
        if(running == false)
        {

        TimerTask task = new TimerTask()
        {


public void run()
        {
        //what to do at each excecution
        seconds++;
        lbl.setText(Short.toString(seconds));
        }
        };

        timer.scheduleAtFixedRate(task,1000,1000);
        }
        running = true;
        }




