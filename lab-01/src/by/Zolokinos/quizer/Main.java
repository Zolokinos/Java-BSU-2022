package by.Zolokinos.quizer;

import java.util.Map;
import java.util.Scanner;

public class Main {
    /**
     * @return тесты в {@link Map}, где
     * ключ     - название теста {@link String}
     * значение - сам тест       {@link Quiz}
     */
//    static Map<String, Quiz> getQuizMap() {
//         ...
//    }
    public static void main(String[] args) {
        Map<String, Quiz> quizMap = null;
//        quizMap = getQuizMap();
        System.out.println("Введите название теста...");
        Quiz quiz;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (!scanner.hasNextLine()) {
                System.out.println("Неправильный ввод: повторите попытку");
                continue;
            }
            quiz = quizMap.get(scanner.nextLine());
            if (quiz == null) {
                System.out.println("Неправильный ввод: повторите попытку");
                continue;
            }
            break;
        }

        while (!quiz.isFinished()) {
            Task task = quiz.nextTask();
            while (true) {
                System.out.println(task.getText());
                if (!scanner.hasNextLine()) {
                    System.out.println("Ничего не введено, введите ответ");
                    continue;
                }
                Result result = quiz.provideAnswer(scanner.nextLine());
                if (result == Result.INCORRECT_INPUT) {
                    System.out.println("Некорректный ввод, попробуйте снова");
                    continue;
                }
                break;
            }
        }
    }
}