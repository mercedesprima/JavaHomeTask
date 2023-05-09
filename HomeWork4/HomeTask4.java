package HomeWork4;

import java.util.*;

public class HomeTask4 {
    public static void main(String[] args) {
        ex1();
        ex2();
    }

    public static void ex1() {
//Реализовать консольное приложение, которое:
//Принимает от пользователя и “запоминает” строки.
//Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//Если введено revert, удаляет предыдущую введенную строку из памяти.
        Scanner s = new Scanner(System.in);
        Stack inputArr = new Stack<>();
        while (true) {
            System.out.println("Введите строку: ");
            String input = s.nextLine();
            if (input.equals("print")) {
                while (!inputArr.isEmpty()) {
                    System.out.println(inputArr.pop());
                }
            } else if (input.equals("revert")) {
                if (!inputArr.isEmpty()) {
                    inputArr.pop();
                    System.out.println("Последняя введенная строка удалена, чтобы увидеть получившийся список, введите 'print'");
                }
            } else if (input.equals("stop")) { // добавляем условие для остановки цикла
                break;
            } else {
                inputArr.push(input);
            }
        }
        System.out.println("Программа остановлена");
    }

    public static void ex2() {
//Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Apple", "2", "парад", "сын", "Москва", "15", "гном"));
        System.out.print("Первоначальный список: " + list);
        Collections.reverse(list);
        System.out.print("\nСписок в обратном порядке: " + list);
    }
}