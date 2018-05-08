package SlagalicaKviz;


public class Const extends Node {

    private int value;

    public Const(int value) {
        this.value = value;
    }

    public int calculate() {
        return value;
    }

    @Override
    public void toString2() {
        System.out.print(Integer.toString(value));
    }

}

