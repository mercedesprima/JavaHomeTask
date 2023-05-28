package HomeWork6;

import java.util.*;

//Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
//Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру.
// Критерии фильтрации можно хранить в Map. Например:
//“Введите цифру, соответствующую необходимому критерию:
//        1 - ОЗУ
//        2 - Объём ЖД
//        3 - Операционная система
//        4 - Цвет …
//Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
//Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
public class HomeTask6 {

    public static void main(String[] args) {
        HashSet<Notebook> catalog = (HashSet<Notebook>) createNotebook();
        System.out.println(catalog);
        Scanner sc = new Scanner(System.in);
        Map<String, Object> targetNotebook = findNotebook(sc);
        HashSet<Notebook> queryNotes = querySet(catalog, targetNotebook);
        System.out.println(queryNotes);
    }

    public static Object createNotebook() {
        HashSet<Notebook> notebooks = new HashSet<>();
        notebooks.add(Notebook.createNotebook("Asus", 8, 512, "Windows", "серый", 64999));
        notebooks.add(Notebook.createNotebook("Huawei", 8, 512, "Windows", "серебристый", 52999));
        notebooks.add(Notebook.createNotebook("HP", 4, 1024, "отсутствует", "черный", 19999));
        notebooks.add(Notebook.createNotebook("Lenovo", 8, 256, "Windows", "черный", 37999));
        notebooks.add(Notebook.createNotebook("Acer", 8, 256, "отсутствует", "черный", 29999));
        notebooks.add(Notebook.createNotebook("Acer", 8, 256, "Windows", "серебристый", 44999));
        notebooks.add(Notebook.createNotebook("Apple", 16, 512, "MacOs", "серый", 259999));
        notebooks.add(Notebook.createNotebook("Apple", 8, 256, "MacOs", "золотой", 97999));
        notebooks.add(Notebook.createNotebook("Apple", 8, 256, "MacOs", "черный", 134990));
        notebooks.add(Notebook.createNotebook("Tecno", 12, 256, "Linux", "серый", 33999));
        notebooks.add(Notebook.createNotebook("Irbis", 4, 64, "Windows", "серый", 15999));
        notebooks.add(Notebook.createNotebook("Lenovo", 4, 1024, "отсутствует", "черный", 19_999));
        notebooks.add(Notebook.createNotebook("Lenovo", 8, 256, "Windows", "черный", 36_999));
        notebooks.add(Notebook.createNotebook("Samsung", 4, 500, "Windows", "белый", 20_990));
        notebooks.add(Notebook.createNotebook("Samsung", 6, 1024, "Windows", "черный", 34_990));
        return notebooks;
    }

    public static Map<String, Object> findNotebook(Scanner s) {

        System.out.println("\nВведите цифру, соответствующую необходимому критерию: ");
        System.out.println("1. Бренд");
        System.out.println("2. ОЗУ");
        System.out.println("3. Объём ЖД");
        System.out.println("4. Операционная система");
        System.out.println("5. Цвет");
        System.out.println("6. Стоимость");
        System.out.println(" ");

        int query = s.nextInt();
        s.nextLine();
        Map<String, Object> targetNotebook = new HashMap<>();

        if (query == 1) {
            System.out.println("Введите название бренда: ");
            String temp = s.nextLine();
            targetNotebook.put("Бренд", temp);
        }
        if (query == 2) {
            System.out.println("Введите минимальный объем оперативной памяти: ");
            int temp = s.nextInt();
            s.nextLine();
            targetNotebook.put("ОЗУ", temp);
        }
        if (query == 3) {
            System.out.println("Введите минимальный объем жесткого диска в Гб: ");
            int temp = s.nextInt();
            s.nextLine();
            targetNotebook.put("Объём ЖД", temp);
        }
        if (query == 4) {
            System.out.println("Введите название операционной системы: ");
            String temp = s.nextLine();
            targetNotebook.put("Операционная система", temp);
        }
        if (query == 5) {
            System.out.println("Введите цвет: ");
            String temp = s.nextLine();
            targetNotebook.put("Цвет", temp);
        }
        if (query == 6) {
            System.out.println("Введите стоимость: ");
            int temp = s.nextInt();
            s.nextLine();
            targetNotebook.put("Стоимость", temp);
        }
        return targetNotebook;
    }
    public static HashSet<Notebook> querySet(HashSet<Notebook> nbSelected, Map<String, Object> targetNb) {
        HashSet<Notebook> filtered = new HashSet<>();

        Iterator<Notebook> iterator = nbSelected.iterator();

        for (Map.Entry<String, Object> entry : targetNb.entrySet()) {
            if (entry.getKey().equals("Бренд")) {
                while (iterator.hasNext()) {
                    Notebook note = iterator.next();
                    if (note.brand.equals(entry.getValue())) {
                        filtered.add(note);
                    }
                }
            }
            if (entry.getKey().equals("ОЗУ")) {
                while (iterator.hasNext()) {
                    Notebook note = iterator.next();
                    if (note.RAM >= (Integer) entry.getValue()) {
                        filtered.add(note);
                    }
                }
            }
            if (entry.getKey().equals("Объём ЖД")) {
                while (iterator.hasNext()) {
                    Notebook note = iterator.next();
                    if (note.HDD >= (Integer) entry.getValue()) {
                        filtered.add(note);
                    }
                }
            }
            if (entry.getKey().equals("Операционная система")) {
                while (iterator.hasNext()) {
                    Notebook note = iterator.next();
                    if (note.OS.equals(entry.getValue())) {
                        filtered.add(note);
                    }
                }
            }
            if (entry.getKey().equals("Цвет")) {
                while (iterator.hasNext()) {
                    Notebook note = iterator.next();
                    if (note.color.equals(entry.getValue())) {
                        filtered.add(note);
                    }
                }
            }
            if (entry.getKey().equals("Стоимость")) {
                while (iterator.hasNext()) {
                    Notebook note = iterator.next();
                    if (note.price >= (Integer) entry.getValue()) {
                        filtered.add(note);
                    }
                }
            }
        }
        return filtered;
    }
}


