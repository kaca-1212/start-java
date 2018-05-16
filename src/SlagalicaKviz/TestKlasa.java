package SlagalicaKviz;

public class TestKlasa {

    String u1 = "2 + 3 / 3";
    String u2 = "(2 + 7)* 3";
    String u3 = "(1 + 1)/ 2";
    String u4 = "(2 * (6 - 7))";
    String u5 = "((5 * 2) - (9 + 2))";

    public TestKlasa(){

    }

    public void testiraj(){
        int ind = 1;
        MojBroj mb = new MojBroj();
        if(((Operacija) mb.makeATree((new Unos(u1).tokenize()))).calculate() != 3) {
            System.out.println("Prvi izraz ne prolazi.");
            ind = -1;
        }
        if(((Operacija) mb.makeATree((new Unos(u2).tokenize()))).calculate() != 27){
            System.out.println("Drugi izraz ne prolazi.");
            ind = -1;
        }
        if(((Operacija) mb.makeATree((new Unos(u3).tokenize()))).calculate() != 1){
            System.out.println("Treci izraz ne prolazi.");
            ind = -1;
        }
        if(((Operacija) mb.makeATree((new Unos(u4).tokenize()))).calculate() != -2){
            System.out.println("Cetvrti izraz ne prolazi.");
            ind = -1;
        }
        if(((Operacija) mb.makeATree((new Unos(u5).tokenize()))).calculate() != -1){
            System.out.println("Peti izraz ne prolazi.");
            ind = -1;
        }

        if (ind == 1)
            System.out.println("Sve je ok!");

    }




}
