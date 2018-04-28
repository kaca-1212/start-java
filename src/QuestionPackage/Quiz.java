package QuestionPackage;

import QuestionPackage.Answer;
import QuestionPackage.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Quiz {

    private int numberOfQuestions;
    private List<Question> ListOfQuestions;
    int sum;

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public Quiz(int numberOfQuestions) {
        String mainPath = new String("/home/stefan/pitanja/");
        ListOfQuestions = new ArrayList<Question>();


        this.numberOfQuestions = numberOfQuestions;
        this.sum = 0;

        try {
            FileReader fileReader = new FileReader(mainPath + "broj_pitanja.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            char c = bufferedReader.readLine().charAt(0);
            int maxQuestionNumber = Character.getNumericValue(c);

            bufferedReader.close();

            int i = 0;
            Random rand = new Random();
            while (i < numberOfQuestions) {
                int k = rand.nextInt(maxQuestionNumber) + 1;

                ListOfQuestions.add(new Question(mainPath + k + ".txt"));

                i++;
            }
        } catch (IOException ex) {
            System.out.println("Unable to open file '" + mainPath + "broj_pitanja.txt'");
        }

    }


    public int getCorrectAnswers(){
        return sum;
    }


    public void start() {

            sum = 0;

            for(Question q : ListOfQuestions){
                System.out.println(q);
                Scanner reader = new Scanner(System.in);
                System.out.println("Unesite tacan odgovor: ");
                String Ans = reader.next();

                if (q.check(Ans))
                    sum = sum + 1;

            }
    }
}
