import java.util.Random;

/**
 * Класс, представляющий набор домино.
 */
public class DominoSet {
    private DominoNode[] tiles; // массив костей домино

    /**
     * Конструктор класса, который создает новый набор домино.
     */
    public DominoSet() {
        // создаем массив костей домино
        tiles = new DominoNode[28];

        // заполняем массив костей домино
        int index = 0;
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                // i * 10 для правильного представления домино в формате левая часть десятки, правая часть единицы
                tiles[index] = new DominoNode(i * 10 + j);
                index++;
            }
        }
    }

    /**
     * Метод, перемешивающий кости домино в наборе.
     */
    public void shuffle() {
        // используем алгоритм Фишера-Йетса для перемешивания массива
        Random random = new Random();
        for (int i = tiles.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            DominoNode temp = tiles[i];
            tiles[i] = tiles[j];
            tiles[j] = temp;
        }
    }

    /**
     * Метод, возвращающий кость домино по индексу в наборе.
     *
     * @param index индекс кости домино в наборе
     * @return кость домино
     */
    public DominoNode getTile(int index) {
        return tiles[index];
    }

    /**
     * Метод, возвращающий массив костей домино.
     *
     * @return массив костей домино
     */
    public DominoNode[] getTiles() { return tiles; }

    /**
     * Метод, возвращающий количество костей в наборе.
     *
     * @return количество костей в наборе
     */
    public int getSize() {
        return tiles.length;
    }
}