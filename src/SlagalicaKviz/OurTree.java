package SlagalicaKviz;

import java.util.ArrayList;

public class OurTree {

    public OurTree(){

    }

    public static Node makeATree(ArrayList<Node> lista){
        int ind = -1;
        Node root = null;
        Operacija node1 = new Operacija('-');
        for(Node node : lista){
            if (node instanceof Const) {
                if (node1.getLeftNode() instanceof Const)
                    node1.setRightNode((Const) node);
                else
                    node1.setLeftNode((Const) node);
            }

             if (node instanceof Operacija){
                    node1 = (Operacija)node;
                    root = node1;

             }


        }
        root.toString2();
        return root;
    }


}
