package SlagalicaKviz;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        MojBroj igra = new MojBroj();
        igra.show();
        Scanner sc = new Scanner(System.in);
        try {
            igra.obradaUnosa(sc.nextLine());

            System.out.println("");
            System.out.println("Vas rezultat je: " + igra.getEnteredResult() + ", a razlika izmedju vaseg rezultata i tacnog resenja je: " +
                    Math.abs(igra.getEnteredResult() - igra.getResult()));


        }
        catch (MyException e) {
            System.out.println(e.getMessage());
        }

        // TestKlasa test = new TestKlasa();
        // test.testiraj();

    }
}
