package part_03.prakticheskoe_zadanie_1;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Урок 1. Обобщения. Java Core. Профессиональный уровень. Практическое задание 1.");
        System.out.println("1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);");
        Integer[] intArray = new Integer[5];
        intArray[0] = 1;
        intArray[1] = 2;
        intArray[4] = 200;
        System.out.println("Входной массив Integer: " + Arrays.deepToString(intArray));
        changePosition(intArray, 0, 4);
        System.out.println("Поменяли местами элементы 0 и 4: " + Arrays.deepToString(intArray));

        String[] stringArray = new String[7];
        stringArray[0] = "Понедельник";
        stringArray[1] = "Вторник";
        stringArray[6] = "Воскресенье";
        System.out.println("Входной массив String: " + Arrays.deepToString(stringArray));
        changePosition(stringArray, 0, 6);
        System.out.println("Поменяли местами элементы 0 и 6: " + Arrays.deepToString(stringArray));

        System.out.println("2. Написать метод, который преобразует массив в ArrayList;");
        System.out.println("Массив Integer: " + Arrays.deepToString(intArray));
        ArrayList<Integer> arrayListI = arrayToArrayList(intArray);//преобразуем массив в ArrayList
        System.out.println("Элементы ArrayList Integer: " + arrayListI.toString());
        System.out.println("Массив String: " + Arrays.deepToString(stringArray));
        ArrayList<String> arrayListS = arrayToArrayList(stringArray);//преобразуем массив в ArrayList
        System.out.println("Элементы ArrayList String:");
        for (String s : arrayListS) {
            System.out.println(s);
        }

        System.out.println("3. Задача;");
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        Box<Apple> box1 = new Box<Apple>(apple1, apple2, apple3);
        System.out.println("Вес коробки 1(Три яблока): " + box1.getWeight());
        Box<Orange> box2 = new Box<Orange>(orange1, orange2);
        System.out.println("Вес коробки 2(Два апельсина): " + box2.getWeight());
        System.out.println("Сравниваем коробку 1 и коробку 2: " + box1.compare(box2));
        box2.add(orange3);
        System.out.println("Добавили в коробку 2 ещё один апельсин, теперь её вес: " + box2.getWeight());
        System.out.println("Сравниваем коробку 1(" + box1.getWeight() + ") и коробку 2(" + box2.getWeight() + "): " + box1.compare(box2));

        Box<Orange> box3 = new Box<Orange>();//Создадим ещё одну коробку с апельсинами
        System.out.println("Вес коробки 2: " + box2.getWeight() + ", вес коробки 3: " + box3.getWeight());
        box2.transfer(box3);//Пересыпим апельсины из Коробки 2 в Корорбку 3
        System.out.println("Пересыпали фрукты из коробки 2 в 3. Вес коробки 2: " + box2.getWeight() + ", вес коробки 3: " + box3.getWeight());
//        box1.transfer(box3);//Если попробовать пересыпать Коробку 1, в которой яблоки в коробку с апельсинами, то Идея подсвечивает ошибку. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
    }

    //1. Метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    //array - массив - может быть любого ссылочного типа, т.к. Object
    //arrayItemNumber1 - номер первого элемента массива
    //arrayItemNumber2 - номер второго элемента массива
    public static void changePosition(Object[] array, int arrayItemNumber1, int arrayItemNumber2) {
        Object arr = array[arrayItemNumber1];//создаём временный массив
        array[arrayItemNumber1] = array[arrayItemNumber2];
        array[arrayItemNumber2] = arr;
    }

    //2. Метод, который преобразует массив в ArrayList;
    public static <U> ArrayList<U> arrayToArrayList(U[] array) {
        return new ArrayList<U>(Arrays.asList(array));
    }
/*    //метод, который принимает на вход U и его же и возвращает
    public <U> U getSomething(U arg) {
        return arg;
    }*/
}
