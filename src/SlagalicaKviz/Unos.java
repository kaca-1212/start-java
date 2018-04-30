package SlagalicaKviz;

import java.util.ArrayList;
import java.util.Arrays;

public class Unos {
    private String unos;

    public Unos(String unos){
        this.unos = unos;
    }


    private ArrayList<String> izdvajanjeKonstanti(){
        String[] nizKaraktera = unos.split("(?!^)");
        for(int i = 0; i < nizKaraktera.length; i++){
            if(nizKaraktera[i].equals("2") && nizKaraktera[i + 1].equals("0")) {
                nizKaraktera[i] = "20";
                nizKaraktera[i + 1] = "*";
            }

            if(nizKaraktera[i].equals("2") && nizKaraktera[i + 1].equals("5")){
                    nizKaraktera[i] = "25";
                    nizKaraktera[i + 1] = "*";
            }
            if(nizKaraktera[i].equals("1") && nizKaraktera[i + 1].equals("0")) {
                nizKaraktera[i] = "10";
                nizKaraktera[i + 1] = "*";
            }
            if(nizKaraktera[i].equals("1") && nizKaraktera[i + 1].equals("5")) {
                nizKaraktera[i] = "15";
                nizKaraktera[i + 1] = "*";
            }
            if(nizKaraktera[i].equals("5") && nizKaraktera[i + 1].equals("0")) {
                nizKaraktera[i] = "50";
                nizKaraktera[i + 1] = "*";
            }
            if(nizKaraktera[i].equals("7") && nizKaraktera[i + 1].equals("5")) {
                nizKaraktera[i] = "20";
                nizKaraktera[i + 1] = "*";
            }
            if(nizKaraktera[i].equals("1") && nizKaraktera[i + 1].equals("0") && nizKaraktera[i + 2].equals("0")) {
                nizKaraktera[i] = "100";
                nizKaraktera[i + 1] = "*";
                nizKaraktera[i + 2] = "*";
            }
            if(nizKaraktera[i].equals(" "))
                nizKaraktera[i] = "*";

        }
        ArrayList<String> lista = new ArrayList<String>(Arrays.asList(nizKaraktera));
        lista.remove("*");
        return lista;

    }



    private ArrayList<Node> tokenize() {
        ArrayList<String> listOfCharacters = izdvajanjeKonstanti();
        ArrayList<Node> listOfNodes = new ArrayList<Node>();
        for (String ch : listOfCharacters) {
            if (ch.equals("+")) listOfNodes.add(new Operacija("+"));
            else if (ch.equals("-")) listOfNodes.add(new Operacija("-"));
            else if (ch.equals("*")) listOfNodes.add(new Operacija("*"));
            else if (ch.equals("+")) listOfNodes.add(new Operacija("/"));
            else if (ch.equals("(")) listOfNodes.add(new Zagrada("("));
            else if (ch.equals(")")) listOfNodes.add(new Zagrada(")"));
            else listOfNodes.add(new Const(ch));
        }

            return listOfNodes;


    }

    }




