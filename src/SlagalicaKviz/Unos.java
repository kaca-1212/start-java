package SlagalicaKviz;

import java.util.ArrayList;
import java.util.Arrays;

public class Unos {
    private String unos;

    public Unos(String unos){
        this.unos = unos;
    }


    public ArrayList<Node> tokenize(){
        char[] nizKaraktera = unos.toCharArray();
        ArrayList<Node> listOfNodes = new ArrayList<Node>();
        int num = 0;
        boolean ind = false;
        for(int i = 0; i < nizKaraktera.length; i++){
            if(Character.isDigit(nizKaraktera[i])){
                num = (nizKaraktera[i] - '0') + 10 * num;
                ind = true;
            }
            else if (ind) {
                listOfNodes.add(new Const(num));
                ind = false;
                num = 0;
            }
            if(nizKaraktera[i] == '+' || nizKaraktera[i] == '-' ||
                    nizKaraktera[i] == '*' || nizKaraktera[i] == '/')
                listOfNodes.add(new Operacija(nizKaraktera[i]));

            if(nizKaraktera[i] == ')' || nizKaraktera[i] == '(')
                listOfNodes.add(new Zagrada(nizKaraktera[i]));

        }

        if(ind) {
            listOfNodes.add(new Const(num));
        }

        return listOfNodes;

    }



    }




