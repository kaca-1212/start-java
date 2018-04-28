package SlagalicaKviz;

import java.util.ArrayList;
import java.util.Random;

public class SrpskaSlova implements ISlova {

    private ArrayList<String> samoglasnici;
    private ArrayList<String> suglasnici;
    private Random rand;
    private int brojSlova;
    private int brojacSamoglasnika;
    private int brojSamoglasnika;


    public SrpskaSlova(int brojSlova) {
        initSlova();
        rand = new Random(1);
        this.brojSlova = brojSlova;
        this.brojacSamoglasnika = 0;
        this.brojSamoglasnika = rand.nextInt(brojSlova/4) + brojSlova/2;
    }


    private void initSlova() {
        samoglasnici = new ArrayList<String>();
        suglasnici = new ArrayList<String>();
        samoglasnici.add(new String("a"));
        suglasnici.add(new String("b"));
        suglasnici.add(new String("v"));
        suglasnici.add(new String("g"));
        suglasnici.add(new String("d"));
        suglasnici.add(new String("đ"));
        samoglasnici.add(new String("e"));
        suglasnici.add(new String("ž"));
        suglasnici.add(new String("z"));
        samoglasnici.add(new String("i"));
        suglasnici.add(new String("j"));
        suglasnici.add(new String("k"));
        suglasnici.add(new String("l"));
        suglasnici.add(new String("lj"));
        suglasnici.add(new String("m"));
        suglasnici.add(new String("n"));
        suglasnici.add(new String("nj"));
        samoglasnici.add(new String("o"));
        suglasnici.add(new String("p"));
        suglasnici.add(new String("r"));
        suglasnici.add(new String("s"));
        suglasnici.add(new String("t"));
        suglasnici.add(new String("ć"));
        samoglasnici.add(new String("u"));
        suglasnici.add(new String("f"));
        suglasnici.add(new String("h"));
        suglasnici.add(new String("c"));
        suglasnici.add(new String("č"));
        suglasnici.add(new String("dž"));
        suglasnici.add(new String("š"));

    }

    public void reset() {
        brojacSamoglasnika = 0;
    }

    public String getNext() {
        if(brojacSamoglasnika < brojSamoglasnika){
            brojacSamoglasnika++;
            return samoglasnici.get(rand.nextInt(samoglasnici.size()));
        }

            return suglasnici.get(rand.nextInt(suglasnici.size()));
        }



  /*
    public boolean brojSamoglasnika(ArrayList<String> izabrana, int brIzabranih) {

        int counter = 0;
        for(String s : izabrana){
            if((s.equals("a")) || (s.equals("e")) || (s.equals("i")) || (s.equals("o")) || (s.equals("u")))
                    counter++;
        }
        return counter >= (brIzabranih/3) && counter <= (brIzabranih*2/3);
    }

*/
}
