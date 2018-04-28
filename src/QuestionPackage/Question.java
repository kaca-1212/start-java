package QuestionPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {

    private String question;
    private List<Answer> answers;

    public Question(String filename) throws IOException {

        String line  = null;
        answers = new ArrayList<Answer>();

        try{
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int k = 0;
            while((line = bufferedReader.readLine()) != null){

                if(k == 0) question = line;

                else {
                    answers.add(new Answer(line, k == 1));
                }
                k = k + 1;

            }

            bufferedReader.close();
            // This is moved here because, you maybe in some point will need multiple print of question
            // or getting its own string representation so repeating shuffling will invalidate previous
            // version of question you sent somewhere or displayed.
            Collections.shuffle(answers);
        }
        catch(IOException ex) {
            throw ex;
        }
    }

    public boolean check(String a){
        return answers.get(a.charAt(0) - 'A').isCorrect();
    }


    @Override
    public String toString() {
        String ret = new String(question+"\n");
        char num = 'A';
        for(Answer answer : answers){
            ret += num + ") " + answer.getAnswer() + "\n";
            num++;
        }
        return ret;
    }

    public String getQuestionContent(){
        return question;
    }

    public String getAnswerContent(char in){
        return answers.get(in - 'A').getAnswer();
        }
    }

