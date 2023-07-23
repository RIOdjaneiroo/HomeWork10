package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUserToJson {
    private String filePathIn;
    private String filePathOut;

    public FileUserToJson(String filePathIn, String filePathOut) {     // Конструктор
        this.filePathIn = filePathIn;
        this.filePathOut = filePathOut;
        copyUserToJson();
    }
public void copyUserToJson(){
    File file = new File(filePathIn); //створюємо обєкт типу файл для представлення вхідного файлу
    String jsonFilePath =filePathOut; // рядок шлях до файлу що створиться на основі вхідного файлу

    List<User> users = readUsersFromFile(file); // викликаємо метод зчитування користувачів з параметром
    writeUsersToJson(users, jsonFilePath);      // викликаэмо метод запису обєктів у файл
        System.out.println("Copy Ok");
}
    public static List<User> readUsersFromFile(File file) {  // цей метод зчитує користувачів (виводить ліст) з файлу йому передається файл
        List<User> users = new ArrayList<>();             //Створюється порожній список юзерів
        try (Scanner scanner = new Scanner(file)) {        // для зчитування використовуємо сканер в Траї щоб не закривати
            String[] headWord = scanner.nextLine().split("\\s+"); // зчитуємо заголовок та розділяємо його на колонки
            while (scanner.hasNextLine()) {                            // цикл поки є наступний рябок у файлі
                String[] usera = scanner.nextLine().split("\\s+"); // зчитуємо наступній рядлк даних розбиваємо регулярним виразом на слова
                String name = usera[0];               // зчитуємо перше слово з масиву (імя)
                int age = Integer.parseInt(usera[1]);  // зчитуємо парсимо з строки в число вік користувача 2 стово
                User user = new User(name, age); // створюємо обєкт юзер з імям та віком
                users.add(user);                   // додаємо юзера до списка
            }
        } catch (IOException e) {        // перехоплюємо помилку якщо немає файлу
            e.printStackTrace();
        }
        return users;         //повертаємо список юзерів
    }
    public static void writeUsersToJson(List<User> users, String jsonFilePath) { // метод що записує ліст юзерів в строку
        List<Object> listUserObjects = new ArrayList<>();  //ствоюємо список масивів обєктів
        for (User user : users) {    //цикл що обробляє ліст юзерів даних на початку
            listUserObjects.add(new User(user.name, user.age)); // додаємо обєкт юзера(імя,вік) в список
        }

        try (FileWriter file = new FileWriter(jsonFilePath)) {    // откриваєм файлВрайтер для запису файлу якщо дописати (jsonFilePath, true) будуть щоразу добавлятися юзера
            Gson gson = new GsonBuilder().setPrettyPrinting().create(); //створюється джейсон обєкт білдер для друку
            gson.toJson(listUserObjects, file); // створений білдер заповнюється(метод що перетворює ліст в файл юзер.жейсон задопомогою обєкта джейсон
        } catch (IOException e) {
            e.printStackTrace(); // вийнятки файлврайтера
        }
    }
}


