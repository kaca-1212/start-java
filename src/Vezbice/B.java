package Vezbice;

public class B extends A implements ITest{
    public B() {
        super();
    }


    public void hello() {
        super.hello();
        System.out.println("Hello from B!");
    }

    public void testB() {
        System.out.println("Hello test B!!");
    }

    public void ttt() {

    }

    public int vrati1() {
        return 1;
    }
}
