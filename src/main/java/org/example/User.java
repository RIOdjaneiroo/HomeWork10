package org.example;

import java.io.Serializable;

class User implements Serializable {
    long serialVersionUID = -5771428736158032631L; //спробую прокоментувати пізніше навіщо це потрібно) в цій задачі можливо і ні
    String name;
    int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

