package SlagalicaKviz;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args){

        Random rand = new Random();
        int[] set1 = {10, 15, 20, 25};
        int[] set2 = {25, 50, 75, 100};
        int[] nizJednocifrenih = {0, 0, 0, 0};

        for(int i = 0; i <= 3; i++) {
            nizJednocifrenih[i] = rand.nextInt(8) + 1;
            System.out.print(nizJednocifrenih[i] + " ");
        }

        System.out.print("   ");
        int s_1 = rand.nextInt(3);
        System.out.print(set1[s_1]);
        System.out.print("   ");
        int s_2 = rand.nextInt(3);
        System.out.println(set2[s_2]);


        int s_3 = rand.nextInt(1000) + 1;
        System.out.println("Trazi se broj: " +  s_3);
        System.out.print("Unesite vase resenje: ");

        Scanner sc = new Scanner(System.in);
        Unos unos = new Unos(sc.nextLine());

        unos.check();

        ArrayList<Node> lista = unos.tokenize();
        OurTree drvo = new OurTree();
        Operacija root = (Operacija)(drvo.makeATree(lista));
        root.toString2();
        System.out.println("");
        System.out.println("Rezultat je: " + Integer.toString(root.calculate()));



    }
}
