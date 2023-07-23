package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {

       // System.out.printf("Hello and welcome! \n");

        File file = new File("./files/file.txt");   //передаємо файл в змінну
        NumberPhon.validatorNumber(file);                   // виводимо валідні строки методом класу


        FileUserToJson fUTJ = new FileUserToJson("./files/fileUser.txt","./files/user.json"); // задача 2


        WordCounter wordCounter = new WordCounter("./files/words.txt");   // задача 3
    }
}