/**
* Класс, содержащий метод main(), который создает набор домино, перемешивает его,
* создает последовательность, задает целое значение и выполняет последовательное исключение костей из последовательности,
* с выводом костей и последовательности на экран.
 */
public class Main {
    public static void main(String[] args) {
        // создаем набор домино
        DominoSet set = new DominoSet();

        // выводим набор домино на экран
        System.out.println("Набор домино до смешивания:");
        for (int i = 0; i < set.getSize(); i++) {
            System.out.print(set.getTile(i) + " ");
        }
        System.out.println();

        // перемешиваем набор домино
        set.shuffle();

        // выводим набор домино на экран
        System.out.println("Набор домино после смешивания:");
        for (int i = 0; i < set.getSize(); i++) {
            System.out.print(set.getTile(i) + " ");
        }
        System.out.println();

        // создаем последовательность домино на основе набора домино
        DominoSequence sequence = new DominoSequence(set);

        System.out.println();;
        for (int i = 28; i > 0; --i) {
            sequence.removeAfter(3);
        }
        for (int i = 0; i < set.getSize(); i++) {
            System.out.print(set.getTile(i).getNext() + " ");
        }
        System.out.println();
    }
}