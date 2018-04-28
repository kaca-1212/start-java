package Vezbice;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
     /*   B b = new B();
        A c = new B();
        ITest t = new B();

        t.vrati1();

        System.out.println("----------------------------");
        b.hello();
        System.out.println("----------------------------");
        c.hello();
        System.out.println("----------------------------");



        b.testA();
        */

     Scanner sc = new Scanner("1,2,3,4,5,6").useDelimiter(",");

     while(sc.hasNextInt()){
         int broj = sc.nextInt();
         if(broj % 2 == 0)
             System.out.println(broj);
     }

     int[] niz = new int[50];
     double prosek = 0.0;
     for (double element: niz)
         prosek += element;


     prosek = prosek/niz.length;
     System.out.println(prosek);
    }
}


