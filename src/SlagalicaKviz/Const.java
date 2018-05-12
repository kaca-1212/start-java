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

    public boolean equals(Object object)
    {
        boolean sameSame = false;

        if (object != null && object instanceof Const)
        {
            sameSame = this.value == ((Const) object).value;
        }

        return sameSame;
    }
}

