package QuestionPackage;

class Main {
    public static void main(String[] args) {

        Quiz quiz = new Quiz(4);
        quiz.start();

        System.out.println("You answered correct on " + quiz.getCorrectAnswers() + " out of " + quiz.getNumberOfQuestions());

    }
}