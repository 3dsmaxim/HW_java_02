import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class HW_java002 {
    public static String Filtr(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != '[' & text.charAt(i) != ']' & text.charAt(i) != '{' & text.charAt(i) != '}'
                    & text.charAt(i) != ':' & text.charAt(i) != ',' & text.charAt(i) != '"' & text.charAt(i) != ' ') {
                result.append(text.charAt(i));
            }

            if (text.charAt(i) == '}') {
                result.append("\n");
                i += 2;

            } else if (text.charAt(i) == ':') {
                result.append(" ");

            } else if (text.charAt(i) == ',') {
                result.append(" ");
            }

        }

        System.out.println(result.toString());
        System.out.println();
        text = result.toString();
        result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'ф' && text.charAt(i + 6) == 'я') {
                result.append("Студент");
                i += 7;
            }
            if (text.charAt(i) == 'о' && text.charAt(i + 5) == 'а') {
                result.append("получил");
                i += 6;
            }
            if (text.charAt(i) == 'п' && text.charAt(i + 6) == 'е') {
                result.append("по педмету");
                i += 7;
            }
            result.append(text.charAt(i));
        }
        return result.toString();

    }

    public static void ToFile(String text) {

        try (FileWriter fw = new FileWriter("Text.txt", false)) {
            fw.write(text);

        } catch (IOException e) {
            try {
                Logger logger = Logger.getLogger(HW_java002.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("log.txt", true);
                logger.addHandler(fh);
                SimpleFormatter sFormat = new SimpleFormatter();
                fh.setFormatter(sFormat);
                logger.log(Level.WARNING, "совсем не робит");

            } catch (Exception iException) {
                e.printStackTrace();

            }

        }
    }

    public static String RiaderText(String text) {
        try (BufferedReader br = new BufferedReader(new FileReader(text))) {
            text = br.readLine();

        } catch (IOException e) {

            try {
                Logger logger = Logger.getLogger(HW_java002.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("log.txt", true);
                logger.addHandler(fh);
                SimpleFormatter sFormat = new SimpleFormatter();
                fh.setFormatter(sFormat);
                logger.log(Level.WARNING, "совсем не робит");

            } catch (Exception iException) {
                e.printStackTrace();

            }

        }
        return text;

    }

    public static void main(String[] args) {

        // Дана json строка [{
        // "фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
        // Задача написать метод(ы), который распарсит строку и выдаст ответ вида:
        // Студент Иванов получил 5 по предмету Математика.
        // Студент Петрова получил 4 по предмету Информатика.
        // Студент Краснов получил 5 по предмету Физика.

        // Используйте StringBuilder для подготовки ответа

        // Исходная json строка это просто String !!! Для работы используйте методы
        // String, такие как replace, split, substring и т.д. по необходимости

        // Создать метод, который запишет результат работы в файл. Обработайте
        // исключения и запишите ошибки в лог файл.
        // 2. *Получить исходную json строку из файла, используя FileReader или Scanner
        // 3. *Реализуйте алгоритм сортировки пузырьком числового массива, результат
        // после каждой итерации запишите в лог-файл.

        String path = "qewrtyText.js";
        String textJS = RiaderText(path);// это чтобы избавиться от каскада log.txt, log1.txt, log2.txt

        System.out.println();
        System.out.println(Filtr(textJS));
        ToFile(Filtr(textJS));
    }

}
