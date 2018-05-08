package SlagalicaKviz;

import java.util.ArrayList;

public class OurTree {

    public OurTree(){

    }

    public static Node makeATree(ArrayList<Node> lista){
        Operacija root = (Operacija)lista.get(1);
        Operacija lastOp = root;
        Const sonLastOp;
        root.setLeftNode(lista.get(0));
        for(int i = 2; i < lista.size(); i++) {
            if (lista.get(i) instanceof Const)
                lastOp.setRightNode(lista.get(i));
            if (lista.get(i) instanceof Operacija) {

                if ((((Operacija) lista.get(i)).getOp() == '*') || (((Operacija) lista.get(i)).getOp() == '/')) {
                    sonLastOp = (Const) lastOp.getRightNode();
                    lastOp.setRightNode(lista.get(i));
                    ((Operacija) lista.get(i)).setLeftNode(sonLastOp);
                }

                if ((((Operacija) lista.get(i)).getOp() == '+') || (((Operacija) lista.get(i)).getOp() == '-')) {

                    ((Operacija) lista.get(i)).setLeftNode(root);
                    root = (Operacija) lista.get(i);
                }
                lastOp = (Operacija) lista.get(i);
            }

        }
        return root;



}
}