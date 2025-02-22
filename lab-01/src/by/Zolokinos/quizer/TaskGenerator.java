package by.Zolokinos.quizer;

/**
 * Interface, который описывает один генератор заданий
 */
interface TaskGenerator {
    /**
     * Возвращает задание. При этом новый объект может не создаваться, если класс задания иммутабельный
     *
     * @return задание
     * @see    Task
     */
    Task generate();
}