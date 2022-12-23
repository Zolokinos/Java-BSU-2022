package by.Zolokinos.quizer;

import by.Zolokinos.quizer.exceptions.QuizNotFinishedException;

/**
 * Class, который описывает один тест
 */
class Quiz {
    private final int taskCount;
    private int correctAnswerNumber;
    private int wrongAnswerNumber;
    private int incorrectInputNumber;
    TaskGenerator taskGenerator;
    /**
     * @param generator генератор заданий
     * @param taskCount количество заданий в тесте
     */
    Quiz(TaskGenerator generator, int taskCount) {
        taskGenerator = generator;
        this.taskCount = taskCount;
    }

    /**
     * @return задание, повторный вызов вернет слелующее
     * @see Task
     */
    Task nextTask() {
        return taskGenerator.generate();
    }

    /**
     * Предоставить ответ ученика. Если результат {@link Result#INCORRECT_INPUT}, то счетчик неправильных
     * ответов не увеличивается, а {@link #nextTask()} в следующий раз вернет тот же самый объект {@link Task}.
     */
    Result provideAnswer(String answer) {
        
    }

    /**
     * @return завершен ли тест
     */
    boolean isFinished() {
        return (correctAnswerNumber + wrongAnswerNumber) == taskCount;
    }

    /**
     * @return количество правильных ответов
     */
    int getCorrectAnswerNumber() {
        return correctAnswerNumber;
    }

    /**
     * @return количество неправильных ответов
     */
    int getWrongAnswerNumber() {
        return wrongAnswerNumber;
    }

    /**
     * @return количество раз, когда был предоставлен неправильный ввод
     */
    int getIncorrectInputNumber() {
        return incorrectInputNumber;
    }

    /**
     * @return оценка, которая является отношением количества правильных ответов к количеству всех вопросов.
     *         Оценка выставляется только в конце!
     */
    double getMark() {
        if (!isFinished()) {
            throw new ArithmeticException();
        }
        return correctAnswerNumber / (double) (correctAnswerNumber + wrongAnswerNumber + incorrectInputNumber);
    }
}