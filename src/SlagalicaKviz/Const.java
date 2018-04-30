package SlagalicaKviz;


public class Const extends Node {

    private String value;

    public Const(String value) {
        this.value = value;
    }

    public int calculate() {
        return Integer.parseInt(value);
    }

}

