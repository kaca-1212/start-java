package SlagalicaKviz;

import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args){

        Random rand = new Random();
        int[] set1 = {10, 15, 20, 25};
        int[] set2 = {25, 50, 75, 100};

        for(int i = 0; i <= 3; i++)
            System.out.print((rand.nextInt(8) + 1) + " ");

        System.out.print("   ");
        System.out.print(set1[rand.nextInt(3)]);
        System.out.print("   ");
        System.out.println(set2[rand.nextInt(3)]);

        System.out.println("Trazi se broj: " + rand.nextInt(100) + 1);
        System.out.print("Unesite vase resenje: ");

        Scanner sc = new Scanner(System.in);
        Unos unos = new Unos(sc.next());










    }
}
