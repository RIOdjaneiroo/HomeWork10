package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPhon {

    public static void validatorNumber(File file) {   // метод івиводу алідних номерів
        try (Scanner scanner = new Scanner(file)) {                // створюємо сканер в блоці трай щоб не закривати і подбати про вийнятки
            Pattern pattern = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}");// створюємо патерн для валідації
            while (scanner.hasNextLine()) {          // цикл   поки є строки у файлі
                String line = scanner.nextLine();      // зчитуємо строку
                Matcher matcher = pattern.matcher(line); // створюємо матчер і передаєм в нього строку для перевірки
                if (matcher.matches()) {                 // якщо строка відповідає патерну
                    System.out.println(line);             // виводимо строку в консоль
                }                                         // якщо ні то йдемо далі
            }
        } catch (FileNotFoundException e) {               // виключення якщо на місці ненемає файлу
            System.err.println("не знайдено файл " + e.getMessage());
        }
    }
}
