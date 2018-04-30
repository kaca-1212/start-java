package SlagalicaKviz;

public class Main1 {

    public static void main(String[] args){

        Const a = new Const("5");
        Const b = new Const("3");
        Const c = new Const("2");

        Operacija op1 = new Operacija("+");
        Operacija op2 = new Operacija("-");

        op1.setLeftNode(a);
        op1.setRightNode(op2);
        op2.setLeftNode(b);
        op2.setRightNode(c);

        System.out.println("Rezultat je: " + op1.calculate());





    }
}
