package SlagalicaKviz;


import java.util.ArrayList;

public class KorakPoKorak {

    private ArrayList<String> hints;

    public KorakPoKorak() {
        hints = new ArrayList<String>();
        hints.add("Ima hromozome.");
        hints.add("Barak Obama");
        hints.add("jarac");

    }

    public void show() {
        TimerApp tim = new TimerApp();
        for (String s : hints) {
            System.out.println(s + "   ");
            tim.startTimer();
            tim.stopTimer();
        }

    }

}
