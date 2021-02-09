package part_03.prakticheskoe_zadanie_1;

import java.util.*;

//2. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
public class Box<T extends Fruit> {
    private ArrayList<T> items;//3. Для хранения фруктов внутри коробки можно использовать ArrayList;

    public Box(T... items) {
        this.items = new ArrayList<T>(Arrays.asList(items));
    }
    //7. Не забываем про метод добавления фрукта в коробку.
    public void add(T... items) {
        this.items.addAll(Arrays.asList(items));
    }

    public void remove(T... items) {
        for (T item : items) this.items.remove(item);
    }

    public ArrayList<T> getItems() {
        return new ArrayList<T>(items);
    }

    public void clear() {
        items.clear();
    }

    //4. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
    public float getWeight() {
        if (items.size() == 0) return 0;
        float weight = 0;
        for (T item : items) weight += item.getWeight();
        return weight;
    }

    //5. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void transfer(Box<? super T> box) {
        box.items.addAll(this.items);
        clear();
    }
}
