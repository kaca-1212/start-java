package SlagalicaKviz;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Slagalica {

    private ArrayList<String> izabranaSlova;
    private ISlova slova;
    private int brojIzabranih;
    private IProvera provera;


    public Slagalica(int brojIzabranih){
        this.brojIzabranih = brojIzabranih;
        slova = new SrpskaSlova(brojIzabranih);
        birajSlova();
        provera = new ProveraSrpski();
    }


    private void birajSlova() {

        izabranaSlova = new ArrayList<String>();
        for (int i = 0; i < brojIzabranih; i++) {
            izabranaSlova.add(slova.getNext());
        }
        Collections.shuffle(izabranaSlova);

    }

    public void print(){
        for(String slovo : izabranaSlova){
            System.out.print(slovo + " ");
        }
    }

    public boolean check(String rec){
        return provera.check(rec, izabranaSlova);
    }



     public static void main(String[] args){

        System.out.print("Unesi broj slova od kojih pravimo rec: ");
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String a = sc.next();
        Slagalica s = new Slagalica(Integer.parseInt(a));
        s.print();

        System.out.print("Unesi najduzu rec: ");
        String izabranaRec = sc.next();

        if(s.check(izabranaRec))
            System.out.println("Dobra vam je rec");


     }
}
