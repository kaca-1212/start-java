package SlagalicaKviz;

import QuestionPackage.Question;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ProveraSrpski implements IProvera {

    public ProveraSrpski() {
    }


    private boolean proveriSlova(String rec, ArrayList<String> slova) {

        String[] nizSlova = podeliRecNaSlova(rec);
        for (String slo : nizSlova)
            if (slova.contains(slo))
                slova.remove(slo);
            else
                return false;

        return true;
    }

    private boolean check(String izabranaRec) {
        String filePath = new String("/home/tjitji/pitanja/rechnik.txt");
        String line;
        boolean ind = false;

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null)
                if(line.equals(izabranaRec))
                    ind = true;


            bufferedReader.close();

        } catch (IOException ex) {
            System.out.println("Unable to open file '" + filePath);
        }

        return ind;
    }

    //Ovo je dobro urađeno, tj. radiće
    // Međutim bilo bi lepo da se izbegne scanner.
    // Scanner se izbegava zbog velikog overheada, tj. nepotrebnih operacija
    // koje teze da uspore kod. Ali za tvoj nivo je ovo resenje super.
    // Ono što je diskutabilno je dal ovo treba da bude public.
    private String[] podeliRecNaSlova (String rec) {

        String[] niz = rec.split("(?!^)");
        for(int i = 0; i < niz.length; i++)
            switch (niz[i]) {

                case "d" : if(niz[i + 1].equals("ž")) {
                                niz[i] = "dž";
                                niz[i + 1] = "*";
                }
                case "l" : if(niz[i + 1].equals("j")) {
                    niz[i] = "lj";
                    niz[i + 1] = "*";
                }
                case "n" : if(niz[i + 1].equals("j")) {
                    niz[i] = "nj";
                    niz[i + 1] = "*";
                }

            }
        ArrayList<String> lista_slova = new ArrayList<>(Arrays.asList(niz));
        lista_slova.remove("*");

        return lista_slova.toArray(new String[lista_slova.size()]);


    }

    @Override
    public boolean check(String izabranaRec, ArrayList<String> slova) {
        return (proveriSlova(izabranaRec, slova) && check(izabranaRec));
    }
}