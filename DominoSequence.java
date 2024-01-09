/**
 Класс, представляющий последовательность домино.
 */
 public class DominoSequence {
//    private final DominoSet tiles; // массив костей домино в последовательности, с изначально заданным размером в 28 костяшек
    private DominoNode[] arr;
    /**
     * Указатель на начальный элемент последовательности
     */
    private int current = 0;

    /**
     * Конструктор класса, который создает новую последовательность домино на основе заданного набора домино.
     * Последовательность соответсвует изначальному порядку
     * @param set набор домино
     */
    public DominoSequence(DominoSet set) {
        arr = set.getTiles();
        for (int i = 0; i < arr.length; ++i) {
            if (i == arr.length - 1) {
                addDomino(arr[i], i, 0);
                arr[i].setNext(0);
                break;
            }
            arr[i].setNext(i + 1);
            addDomino(arr[i], i, i + 1);
        }
    }

    /**
     * Добавление элемента в последовательность
     * @param node домино
     * @param index индекс в изначальном массиве
     * @param next следующий элемент
     */
    public void addDomino(DominoNode node, int index, int next) {
        arr[index] = node;
        arr[index].setNext(next);
    }


    /**
     * Удаление домино из последовательности
     * @param value значение домино в формате int (11, 1, 66)
     */


    public DominoNode deleteDomino(int value) {
        int temp = current, prev = -1;

        if (temp != -1 && arr[temp].getValue() == value) {
            current = arr[temp].getNext();
            arr[temp].setNext(-1);
            return arr[temp];
        }

        while (temp != -1 && arr[temp].getValue() != value) {
            prev = temp;
            temp = arr[temp].getNext();
        }
        //  и наверное не очень везде вызывать getTiles делать
        arr[prev].setNext(arr[temp].getNext());
        current = arr[temp].getNext();
        arr[temp].setNext(-1);
        return arr[temp];
    }

    /**
     * Удаляем элемент из последовательности с шагом number от current
     */
    public DominoNode removeAfter(int number) {
        int targetValue;
        int index = current;

        for (int i = 0; i <= number; ++i) {
            if (i == number) {
                targetValue = arr[index].getValue();
                return deleteDomino(targetValue);
            }
        }
        return arr[0];
    }
}