package SlagalicaKviz;

public class Operacija extends Node {

    private Node leftNode = null;
    private Node rightNode = null;
    private String op;



    public Operacija(String op){
        this.op = op;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }


    @Override
    public int calculate() {
        if(op.equals("+")) return leftNode.calculate() + rightNode.calculate();
        else if(op.equals("-")) return  leftNode.calculate() - rightNode.calculate();
        else if(op.equals("*")) return leftNode.calculate() * rightNode.calculate();
        else if(op.equals("/")) return leftNode.calculate() / rightNode.calculate();

        return 0;
    }
}
