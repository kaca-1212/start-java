package SlagalicaKviz;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class KorakPoKorak {
    static int interval;
    static Timer timer;

    public static void main(String[] args) {

        String secs = "25";
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = Integer.parseInt(secs);
        System.out.print("\r" + secs);

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.print("\r" + setInterval());

            }
        }, delay, period);
    }

    private static final int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }
}