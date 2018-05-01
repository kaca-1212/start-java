package SlagalicaKviz;


public class Const extends Node {

    private int value;

    public Const(int value) {
        this.value = value;
    }

    public int calculate() {
        return value;
    }

}

