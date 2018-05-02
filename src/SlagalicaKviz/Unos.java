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
        int size = lista.size();

        if(lista.get(0) instanceof Operacija) return false;
        if(lista.get(size - 1) instanceof Operacija) return false;

        for(int i = 1; i < size - 2; i++) {

            if (lista.get(i) instanceof Const) {
                if (lista.get(i - 1) instanceof Const)
                    return false;
                if (lista.get(i-1) instanceof Zagrada && ((Zagrada) lista.get(i - 1)).getZagrada() == ')')
                    return false;
                if (lista.get(i + 1) instanceof Const)
                    return false;
                if(lista.get(i+1) instanceof Zagrada && ((Zagrada) lista.get(i + 1)).getZagrada() == '(')
                    return false;
            }
            if (lista.get(i) instanceof Operacija) {
                if (lista.get(i - 1) instanceof Operacija)
                    return false;
                if(lista.get(i-1) instanceof Zagrada && ((Zagrada) lista.get(i - 1)).getZagrada() == '(')
                    return false;
                if (lista.get(i + 1) instanceof Operacija)
                    return false;
                if(lista.get(i+1) instanceof Zagrada && ((Zagrada) lista.get(i + 1)).getZagrada() == ')')
                    return false;
            }
            if (lista.get(i) instanceof Zagrada) {
                if (((Zagrada) lista.get(i)).getZagrada() == '(') {
                    if (lista.get(i - 1) instanceof Const)
                        return false;
                    if (lista.get(i - 1) instanceof Zagrada && ((Zagrada) lista.get(i - 1)).getZagrada() == ')')
                        return false;
                    if (lista.get(i + 1) instanceof Operacija)
                        return false;
                    if (lista.get(i + 1) instanceof Zagrada && ((Zagrada) lista.get(i + 1)).getZagrada() == ')')
                        return false;

                }
                if (((Zagrada) lista.get(i)).getZagrada() == ')') {
                    if (lista.get(i - 1) instanceof Operacija)
                        return false;
                    if (lista.get(i - 1) instanceof Zagrada && ((Zagrada) lista.get(i - 1)).getZagrada() == '(')
                        return false;
                    if (lista.get(i - 1) instanceof Operacija)
                        return false;
                    if (lista.get(i - 1) instanceof Zagrada && ((Zagrada) lista.get(i - 1)).getZagrada() == '(')
                        return false;
                }
            }
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




