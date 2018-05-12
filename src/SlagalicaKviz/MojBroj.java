package SlagalicaKviz;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MojBroj{


    private int result;
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
        show();
        ObradaUnosa();
    }

    public void show() {
        for(int i = 0; i <= 3; i++)
        System.out.print((nizOdabranih.get(i)).calculate() + " ");
        System.out.println("  " + nizOdabranih.get(4).calculate() + "  " + nizOdabranih.get(5).calculate());
        System.out.println("Trazi se broj: " +  result);
        System.out.print("Unesite vase resenje: ");
    }

    private void ObradaUnosa(){
        Scanner sc = new Scanner(System.in);
        Unos unos = new Unos(sc.nextLine());

        unos.check();

        ArrayList<Node> lista = unos.tokenize();
        ArrayList<Node> listacpy = new ArrayList<Node>(lista);

        for (Node node : listacpy){
            if(node instanceof Const){
                if (!( nizOdabranih.contains((Const) node))){
                    System.out.println("Niste koristili samo ponudjene brojeve!");
                    System.exit(1);
                }
                else
                    nizOdabranih.remove((Const) node);
            }
            else
                continue;

        }


        OurTree drvo = new OurTree();
        Operacija root = (Operacija)(drvo.makeATree(lista));
        System.out.println("");
        System.out.println("Vas rezultat je: " + Integer.toString(root.calculate()) + ", a razlika izmedju vaseg rezultata i tacnog resenja je: " +
                Math.abs(root.calculate() - result));



    }
}