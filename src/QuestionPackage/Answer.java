package QuestionPackage;

public class Answer {

    public String answer;
    public boolean correct;

    public Answer(String answer, boolean correct){
        this.answer = answer;
        this.correct = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return this.correct;
    }
}