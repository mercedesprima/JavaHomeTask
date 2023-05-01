package HomeWork2;

import java.io.File;

public class HomeTask2 {
    public static void main(String[] args) {
        System.out.print(ex1("Petrov", null, "Moscow", null));
        ex2("/Users/ekaterinaposkrobko/Desktop/Учеба/Java/HTjava/Extentions");
    }

    private static String ex1(String name, String country, String city, String age) {
//    1. Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//            Если значение null, то параметр не должен попадать в запрос.
//    Пример 1:
//    Параметры для фильтрации: {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"}
//    Результат: SELECT * FROM USER WHERE name = 'Ivanov' and country = 'Russia' and city = 'Moscow';
//    Пример 2:
//    Параметры для фильтрации: {"name:null", "country:null", "city:null", "age:null"}
//    Результат: SELECT * FROM USER;

        StringBuilder where = new StringBuilder("SELECT * FROM USER WHERE");

        if (name != null) {
            where.append(" name = '").append(name).append("' and");
        }
        if (country != null) {
            where.append(" country = '").append(country).append("' and");
        }
        if (city != null) {
            where.append(" city = '").append(city).append("' and");
        }
        if (age != null) {
            where.append(" age = '").append(age).append("' and");
        }
        where.delete(where.length() - 5, where.length());
        String sqlQuery = where.toString();
        return sqlQuery;
    }

    private static void ex2(String nameFileString) {
        File filefolder = new File(nameFileString);
        File[] files = filefolder.listFiles();
        int count = 0;
        assert files != null;
        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                int dotIndex = fileName.lastIndexOf('.');
                if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
                    String extension = fileName.substring(dotIndex + 1);
                    System.out.println(++count + " Расширение файла: " + extension);
                } else {
                    System.out.println(++count + " Расширение файла:");
                }
            }
        }
    }
}