package SlagalicaKviz;

import java.util.ArrayList;


public class Unos {
    private String unos;
    private ArrayList<Node> lista;

    public Unos(String unos){
        this.unos = unos;
        lista = tokenize();
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

    private void checkBrackets() throws MyException{
        int i = 0;
        for(Node node : lista) {
            if (node instanceof Zagrada && ((Zagrada) node).getZagrada() == '(')
                i++;
            if (node instanceof Zagrada && ((Zagrada) node).getZagrada() == ')')
                i--;
            if(i < 0)
                throw new MyException("Zagrade nisu dobro uparene!");
        }
        if(i != 0)
            throw new MyException("Visak zagrada!");
    }

    private void checkOrder() throws MyException{
        int size = lista.size();

        if(lista.get(0) instanceof Operacija) throw new MyException("Nije dobar redosled operacija!");
        if(lista.get(size - 1) instanceof Operacija) throw new MyException("Nije dobar redosled operacija!");

        for(int i = 1; i < size - 2; i++) {

            if (lista.get(i) instanceof Const) {
                if (lista.get(i - 1) instanceof Const)
                    throw new MyException("Nije dobar redosled operacija!");
                if (lista.get(i-1) instanceof Zagrada && ((Zagrada) lista.get(i - 1)).getZagrada() == ')')
                    throw new MyException("Nije dobar redosled operacija!");
                if (lista.get(i + 1) instanceof Const)
                    throw new MyException("Nije dobar redosled operacija!");
                if(lista.get(i+1) instanceof Zagrada && ((Zagrada) lista.get(i + 1)).getZagrada() == '(')
                    throw new MyException("Nije dobar redosled operacija!");
            }
            if (lista.get(i) instanceof Operacija) {
                if (lista.get(i - 1) instanceof Operacija)
                    throw new MyException("Nije dobar redosled operacija!");
                if(lista.get(i-1) instanceof Zagrada && ((Zagrada) lista.get(i - 1)).getZagrada() == '(')
                    throw new MyException("Nije dobar redosled operacija!");
                if (lista.get(i + 1) instanceof Operacija)
                    throw new MyException("Nije dobar redosled operacija!");
                if(lista.get(i+1) instanceof Zagrada && ((Zagrada) lista.get(i + 1)).getZagrada() == ')')
                    throw new MyException("Nije dobar redosled operacija!");
            }
            if (lista.get(i) instanceof Zagrada) {
                if (((Zagrada) lista.get(i)).getZagrada() == '(') {
                    if (lista.get(i - 1) instanceof Const)
                        throw new MyException("Nije dobar redosled operacija!");
                    if (lista.get(i - 1) instanceof Zagrada && ((Zagrada) lista.get(i - 1)).getZagrada() == ')')
                        throw new MyException("Nije dobar redosled operacija!");
                    if (lista.get(i + 1) instanceof Operacija)
                        throw new MyException("Nije dobar redosled operacija!");
                    if (lista.get(i + 1) instanceof Zagrada && ((Zagrada) lista.get(i + 1)).getZagrada() == ')')
                        throw new MyException("Nije dobar redosled operacija!");

                }
                if (((Zagrada) lista.get(i)).getZagrada() == ')') {
                    if (lista.get(i - 1) instanceof Operacija)
                        throw new MyException("Nije dobar redosled operacija!");
                    if (lista.get(i - 1) instanceof Zagrada && ((Zagrada) lista.get(i - 1)).getZagrada() == '(')
                        throw new MyException("Nije dobar redosled operacija!");
                    if (lista.get(i - 1) instanceof Operacija)
                        throw new MyException("Nije dobar redosled operacija!");
                    if (lista.get(i - 1) instanceof Zagrada && ((Zagrada) lista.get(i - 1)).getZagrada() == '(')
                        throw new MyException("Nije dobar redosled operacija!");
                }
            }
        }
    }

    private void checkEntry(ArrayList<Const> nizOdabranih) throws MyException{
        ArrayList<Node> listacpy = new ArrayList<Node>(lista);

        for (Node node : listacpy){
            if(node instanceof Const){
                if (!( nizOdabranih.contains((Const) node))){
                    throw new MyException("Izabrali ste brojeve koji nisu ponudjeni!");
                }
                else
                    nizOdabranih.remove((Const) node);
            }
            else
                continue;

        }
    }

    public ArrayList<Node> getList() { return lista;}

    public void check(ArrayList<Const> nizOdabranih) throws MyException{
        checkBrackets();
        checkOrder();
        checkEntry(nizOdabranih);
    }

    }




