package by.Zolokinos.quizer.exceptions;

public class QuizNotFinishedException extends Exception {
    public QuizNotFinishedException(String text) {
        super(text);
    }

    public QuizNotFinishedException() {
        super();
    }
}
