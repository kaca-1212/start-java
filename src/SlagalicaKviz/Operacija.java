package SlagalicaKviz;

public class Operacija extends Node {

    private Node leftNode = null;
    private Node rightNode = null;
    private char op;



    public Operacija(char op){
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
        if(op == '+') return leftNode.calculate() + rightNode.calculate();
        else if(op == '-') return  leftNode.calculate() - rightNode.calculate();
        else if(op == '*') return leftNode.calculate() * rightNode.calculate();
        else if(op == '/') return leftNode.calculate() / rightNode.calculate();

        return 0;
    }

    public void toString2(){
        System.out.println(op);
    }
}
