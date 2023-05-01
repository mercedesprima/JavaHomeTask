import java.util.Scanner;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.util.Random;
public class HomeTask1 {
//1. Написать метод, принимающий на вход два аргумента: len и initialValue, и
// возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
        task4();
//        task5();
    }

    public static void task1() {
        //1. Написать метод, принимающий на вход два аргумента: len и initialValue,
        // и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
        Scanner s = new Scanner(System.in);
        System.out.println("Длина массива: ");
        int len = s.nextInt();
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            System.out.println("Элемент массива: ");
            int initialValue = s.nextInt();
            array[i] = initialValue;

        }
        System.out.println(Arrays.toString(array));
    }

    public static void task2() {
//2. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
        int[] array = {1, 7, 28, -4, 65, 2, 93, -10};
        Arrays.sort(array);

        System.out.println("Минимальный элемент:  " + array[0]);
        System.out.println("Максимальный элемент:  " + array[array.length - 1]);
    }

    public static void task3() {
//3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
//        заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
//        Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
//        то есть [0][0], [1][1], [2][2], …, [n][n];
//        int[] arr[] = new int [4][4];
        Scanner s = new Scanner(System.in);
        System.out.println("Введите размер массива:  ");
        int num = s.nextInt();
        int[][] array = new int[num][num];
        for (int i = 0; i <= num - 1; i++) {
            for (int j = 0; j <= num - 1; j++) {
                if (i == j) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
    public static void task4(){
        //4. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
//        "Доброе утро, <Имя>!", если время от 05:00 до 11:59
//        "Добрый день, <Имя>!", если время от 12:00 до 17:59;
//        "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//        "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
        Scanner s = new Scanner(System.in);
        System.out.println("Введите своё имя: ");
        String name = s.nextLine();

        LocalDateTime current = LocalDateTime.now();
        int time = current.getHour();
        if (time >= 5 && time < 12) {
            System.out.println("Доброе утро, " + name + "!");
        }
        if (time >= 12 && time < 18) {
            System.out.println("Добрый день, " + name + "!");
        }
        if (time >= 18 && time < 23) {
            System.out.println("Добрый вечер, " + name + "!");
        }
        if (time >= 23 && time < 5) {
            System.out.println("Доброй ночи, " + name + "!");
        }
    }
//    public static void task5(){
//
//// 5.** Написать метод, которому на вход подается одномерный массив и число n
//// (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
//// Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
//// Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
//// при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
//        Scanner s = new Scanner(System.in);
//        System.out.println("Введите количество элементов массива: ");
//        int len = s.nextInt();
//        Random random = new Random();
//        int[] array = random.ints(len, -5,5).toArray();
////        System.out.println("Введите  число: ");
////        int num = s.nextInt();
//        System.out.println(array);
//    }
}



