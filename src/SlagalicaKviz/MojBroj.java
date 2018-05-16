package SlagalicaKviz;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MojBroj{
    private int result;
    private int enteredResult;
    private ArrayList<Const> nizOdabranih;

    private static int[] set1 = {10, 15, 20, 25};
    private static int[] set2 = {25, 50, 75, 100};
    private Random rand;

    public MojBroj(){
        rand = new Random();
        nizOdabranih = new ArrayList<Const>();
        for(int i = 0; i <= 3; i++) {
            nizOdabranih.add(new Const(rand.nextInt(8) + 1));
        }

        int s_1 = rand.nextInt(3);
        nizOdabranih.add(new Const(set1[s_1]));
        int s_2 = rand.nextInt(3);
        nizOdabranih.add(new Const(set2[s_2]));

        result = rand.nextInt(1000) + 1;
    }

    public void show() {
        for(int i = 0; i <= 3; i++)
        System.out.print((nizOdabranih.get(i)).calculate() + " ");
        System.out.println("  " + nizOdabranih.get(4).calculate() + "  " + nizOdabranih.get(5).calculate());
        System.out.println("Trazi se broj: " +  result);
        System.out.print("Unesite vase resenje: ");
    }

    public int getNumber(int index) { return nizOdabranih.get(index).calculate(); }

    public void obradaUnosa(String input) throws MyException {
        Unos unos = new Unos(input);
        unos.check(nizOdabranih);

        Operacija root = (Operacija)(makeATree(unos.getList()));
        enteredResult = root.calculate();
    }

    public int getResult() {return result;}
    public int getEnteredResult() {return enteredResult;}

    public Node makeATree(ArrayList<Node> lista){
        Operacija root = null;
        Operacija lastOp = null;
        Operacija rootBracket = null;
        int ind = -1;

        Const sonLastOp;

        for(int i = 0; i < lista.size(); i++) {

            //prvi put ulazimo u izraz, a on pocinje konstantom
            if(root == null && lista.get(i) instanceof Const){
                root = (Operacija) lista.get(i+1);
                lastOp = root;
                root.setLeftNode(lista.get(i));
                i = i+1;
                continue;
            }

            //nailazimo na konstantu
            if (lista.get(i) instanceof Const)
                lastOp.setRightNode(lista.get(i));

            if (lista.get(i) instanceof Operacija) {

                //nailazimo na * ili /
                //((5+4)*2)
                if (((((Operacija) lista.get(i)).getOp() == '*') || (((Operacija) lista.get(i)).getOp() == '/'))
                        && !(lista.get(i-1) instanceof Zagrada)) {
                    sonLastOp = (Const) lastOp.getRightNode();
                    lastOp.setRightNode(lista.get(i));
                    ((Operacija) lista.get(i)).setLeftNode(sonLastOp);
                }

                if(((((Operacija) lista.get(i)).getOp() == '*') || (((Operacija) lista.get(i)).getOp() == '/'))
                        && (lista.get(i-1) instanceof Zagrada)){

                    if(ind == 1) {
                        ((Operacija) lista.get(i)).setLeftNode(rootBracket);
                        root = (Operacija)lista.get(i);
                    }
                    else{
                        ((Operacija) lista.get(i)).setLeftNode(rootBracket);
                        root.setRightNode((Operacija) lista.get(i));
                    }
                }


                //nailazimo na + ili -
                if ((((Operacija) lista.get(i)).getOp() == '+') || (((Operacija) lista.get(i)).getOp() == '-')) {

                    ((Operacija) lista.get(i)).setLeftNode(root);
                    root = (Operacija) lista.get(i);
                }
                lastOp = (Operacija) lista.get(i);
            }

            //nailazimo na otvorenu zagradu
            if (lista.get(i) instanceof Zagrada && ((Zagrada) lista.get(i)).getZagrada() == '('){
                int k = i + 1;
                int j = 1;
                while(j != 0 && k < lista.size()) {
                    if (lista.get(k) instanceof Zagrada && ((Zagrada)lista.get(k)).getZagrada() == ')')
                        j = j - 1;
                    if (lista.get(k) instanceof Zagrada && ((Zagrada)lista.get(k)).getZagrada() == '(')
                        j = j + 1;
                    k = k + 1;
                }

                //slucaj ((...))
                //              if((lista.subList(i+1, k-1)).size() == 1)

                rootBracket = (Operacija)makeATree(new ArrayList<Node>(lista.subList(i+1, k - 1)));

                //slucaj da je zagrada prvo cime smo poceli izraz
                if(lastOp == null && root == null) {
                    lastOp = rootBracket;
                    root = lastOp;
                    ind = 1;
                }
                else
                    lastOp.setRightNode(rootBracket);

                i = k - 1;
            }

        }
        return root;



    }
}
