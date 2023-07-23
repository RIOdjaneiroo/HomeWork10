package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCounter {
    private String fileN;                      //="./files/words.txt";

    public WordCounter(String fileN) {          // конструктор
        this.fileN = fileN;
        doCountWordPrintSort(fileN);             // можливо так робити і не можна , принаймні я спробував
    }
    public void doCountWordPrintSort(String fileN){        // це по суті обєднаний метод що визивається під час створення обєкту в конструкторі
        //String filename = fileN;   // вказуэмо шлях до файлу
        Map<String, Integer> wordMap = getWordMap(); //отримуємо мапу з методу що створили передавши в нього файл
        printWordSort(wordMap);             // роздруковуємо отриману мапу
    }
    public Map<String, Integer> getWordMap() {   // метод що створює мапу частоти вживання слів у файлі
        Map<String, Integer> wordMap = new HashMap<>();     // створюємо мапу слово - це ключ а частота значення
        try (BufferedReader br = new BufferedReader(new FileReader(fileN))) { // створюємобуферрідер в блоці щоб не закривати та подбати про виключення предаємо йому файл рідер з файлом
            String line;   // оголошуємо строкову змінну
            while ((line = br.readLine()) != null) {   // цикл що буде читати рядки поки наступний буде 0
                String[] words = line.split("\\s+"); //масив слів отримуємо розбивши строку пробілом або пробілами
                for (String word : words) {   //цикл форІч перебирає масив
                    wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);// пут - кладе слово до мапи або +1 до частоти якщо такий ключ вже є
                }
            }
        } catch (IOException e) {
            e.printStackTrace();  // виключення при помилкі читання
        }
        return wordMap;      // виводимо результат
    }
    public static void printWordSort(Map<String, Integer> wordMap) { // метод що буде друкувати та сортувати мапу
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordMap.entrySet()); //тут створюється список з мапи wordMap.entrySet() - виводить усі елементи мапи
        entries.sort(Map.Entry.<String, Integer>comparingByValue().reversed());// елементи сортуються в зворотньому порядку значень частоти

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());   //друкуємо
        }
    }
}

