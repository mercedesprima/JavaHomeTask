package HomeWork5;
import java.util.*;
public class HomeTask5 {
    public static void main(String[] args) {
        ex1_2();
    }
    public static void ex1_2() {
// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин,
// Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова,
// Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов
//  Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
//  Отсортировать по убыванию популярности.

        String[] employees = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Петр Лыков", "Мария Герасимова", "Павел Чернов", "Петр Чернышов",
                "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова",
                "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов", "Павел Савелов"};

        Map<String, List<String>> phonebook = new HashMap<>();

        Random random = new Random();
        for (String employee : employees) {
            List<String> phones = new ArrayList<>();
            int phoneCount = random.nextInt(2) + 1;
            for (int i = 0; i < phoneCount; i++) {
                String phone = "+7(9" + String.format("%02d", random.nextInt(100)) + ") "
                        + String.format("%03d", random.nextInt(1000)) + "-"
                        + String.format("%02d", random.nextInt(100)) + "-"
                        + String.format("%02d", random.nextInt(100));
                phones.add(phone);
            }
            phonebook.put(employee, phones);
        }
        System.out.println(phonebook);

        Map<String, Integer> nameCounts = new HashMap<>();
        for (String employee : phonebook.keySet()) {
            String[] names = employee.split(" ");
            String firstName = names[0];
            if (nameCounts.containsKey(firstName)) {
                nameCounts.put(firstName, nameCounts.get(firstName) + 1);
            } else {
                nameCounts.put(firstName, 1);
            }
        }
        List<Map.Entry<String, Integer>> sortedNameCounts = new ArrayList<>(nameCounts.entrySet());
        sortedNameCounts.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        System.out.println("Повторяющиеся имена:");
        for (Map.Entry<String, Integer> entry : sortedNameCounts) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " раз(а)");
            }
        }
    }
}
