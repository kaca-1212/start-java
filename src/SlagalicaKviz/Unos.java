package SlagalicaKviz;

import java.util.ArrayList;


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

    private boolean checkBrackets(){
        ArrayList<Node> lista = tokenize();
        int i = 0;
        for(Node node : lista) {
            if (node instanceof Zagrada && ((Zagrada) node).getZagrada() == '(')
                i++;
            if (node instanceof Zagrada && ((Zagrada) node).getZagrada() == ')')
                i--;
            if(i < 0)
                return false;
        }
        if(i == 0) return true;
        else return false;
    }

    private boolean checkOrder() {
        ArrayList<Node> lista = tokenize();
        Node[] arrayOfNodes = new Node[lista.size()];
        int i = 0;
        for (Node node : lista) {
            arrayOfNodes[i] = node;
            i++;
        }
        if(arrayOfNodes[0] instanceof Operacija) {System.out.println(1); return false;}
        if(arrayOfNodes[i - 1] instanceof Operacija) {System.out.println(2); return false;}


        for (int j = 0; j < (i - 1); j++) {
            if (arrayOfNodes[j] instanceof Const) {
                if(arrayOfNodes[j + 1] instanceof Operacija || ((Zagrada) arrayOfNodes[j + 1]).getZagrada() == ')')
                        {System.out.println(3); return false; }  }
            else if (arrayOfNodes[j + 1] instanceof Operacija) {
                if(arrayOfNodes[j] instanceof Const ||
                    ((Zagrada) arrayOfNodes[j]).getZagrada() == ')')
                {System.out.println(4); return false;}   }
            else if (arrayOfNodes[j] instanceof Operacija)  {
                if (arrayOfNodes[j + 1] instanceof Const ||
                    ((Zagrada) arrayOfNodes[j + 1]).getZagrada() == '(')
                {System.out.println(5); return false;}  }
            else if (arrayOfNodes[j + 1] instanceof Const){
                if (arrayOfNodes[j] instanceof Operacija ||
                    ((Zagrada) arrayOfNodes[j]).getZagrada() == '(')
                {System.out.println(6); return false;}        }
            else if (((Zagrada) arrayOfNodes[j]).getZagrada() == ')'){
                if (arrayOfNodes[j + 1] instanceof Operacija ||
                        ((Zagrada) arrayOfNodes[j + 1]).getZagrada() == ')')
                {System.out.println(7); return false;} }
            else if (((Zagrada) arrayOfNodes[j + 1]).getZagrada() == ')'){
                if (arrayOfNodes[j] instanceof Const ||
                    ((Zagrada) arrayOfNodes[j]).getZagrada() == ')')
                {System.out.println(8); return false;}  }
            else if (((Zagrada) arrayOfNodes[j]).getZagrada() == '('){
                if(arrayOfNodes[j + 1] instanceof Const ||
                        ((Zagrada) arrayOfNodes[j + 1]).getZagrada() == '(')
                {System.out.println(9); return false;}  }
            else if (((Zagrada) arrayOfNodes[j + 1]).getZagrada() == '('){
                if (arrayOfNodes[j] instanceof Operacija ||
                    ((Zagrada) arrayOfNodes[j + 1]).getZagrada() == '(')
                {System.out.println(10); return false;}    }
        }
        return true;
    }

    public void check(){
        if (!(checkBrackets() && checkOrder())){
            System.out.println("Niste lepo uneli resenje!");
            System.exit(1);
        }
    }



    }




