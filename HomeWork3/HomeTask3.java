package HomeWork3;

import java.util.*;

public class HomeTask3 {
    public static void main(String[] args) {
//        ex1();
//        ex2();
        ex3();
    }

    //1.
    public static void ex1() {
//Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа.
//Пройти по списку, найти и удалить целые числа.
//Пример: {"Яблоко", "11", "13", "Апельсин", "Дыня", "17"} -> {"Яблоко", "Апельсин", "Дыня"}
        List<String> list = new ArrayList<>(Arrays.asList("Яблоко", "115", "14", "75", "82", "Малина", "-18", "Апельсин", "Ежевика", "2", "25", "Дыня", "17"));
        System.out.println(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            String element = list.get(i);
            if (element.matches("\\d+||-?\\d+")) {
                list.remove(i);
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
    public static void ex2() {
//Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так, что на 0й позиции
// каждого внутреннего списка содержится название жанра, а на остальных позициях - названия книг.
// Напишите метод для заполнения данной структуры(можно через консоль).
//    Пример:
// "Классика", "Преступление и наказание", "Война и мир", "Анна Каренина".
//"Научная фантастика", "Солярис", "Ночной дозор", "Братья Стругацкие".
//"Детектив", "Десять негритят".
//"Фантастика", "Хроники Нарнии", "Гарри Поттер и философский камень", "Грозовой перевал".
        Scanner s = new Scanner(System.in);
        List<List<String>> catalog = new ArrayList<>();
        boolean moreGenres = true;
        while (moreGenres) {
            System.out.print("Введите жанр книги или нажмите '0' для окончания ввода: ");
            String genre = s.nextLine();
            if (genre.equalsIgnoreCase("0")) {
                moreGenres = false;
            } else {
                List<String> books = new ArrayList<>();
                catalog.add(books);
                books.add(genre);
                System.out.print("Введите название книги или нажмите '0' для окончания ввода: ");
                String book = s.nextLine();
                while (!book.equalsIgnoreCase("0")) {
                    books.add(book);
                    book = s.nextLine();
                }
            }
        }

        for (List<String> category : catalog) {
            System.out.print(category.get(0) + ": ");
            for (int i = 1; i < category.size(); i++) {
                System.out.print("\"" + category.get(i) + "\"");
                if (i < category.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    private static void ex3() {
//    Пройти по списку из предыдущего задания и удалить повторяющиеся элементы
//                                                  1 вариант
//        String[] planetsNamesStringArray = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Neptune", "Uranus", "Pluto"};
//        List<String> list = new ArrayList<>();
//        Random random = new Random();
//        for (int i = 0; i < 100; i++) {
//            list.add(planetsNamesStringArray[random.nextInt(planetsNamesStringArray.length)]);
//        }
//        list.sort(Comparator.naturalOrder());
//        System.out.println(list);
//        for (int i = 0; i < list.size() - 1; i++) {
//            String first = list.get(i);
//            String second = list.get(i + 1);
//            if (second.equals(first)) {
//                list.remove(i);
//                i--;
//            } else {
//                first = list.get(i + 1);
//            }
//        }
//        System.out.println(list);

        String[] planetsNamesStringArray = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Neptune", "Uranus", "Pluto"};
        List<String> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            list.add(planetsNamesStringArray[random.nextInt(planetsNamesStringArray.length)]);
        }
        System.out.println(list);
        Set planetSet = new HashSet<>(list);
        System.out.println(planetSet);
    }
}
