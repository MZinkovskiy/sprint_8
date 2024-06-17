package ru.yandex.praktikum;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        if (name.length() < 3) {
            return false;
        }
        if (name.length() > 19) {
            return false;
        }
         if (name.indexOf(" ") == -1) {
            return false;
        }
        if (name.indexOf(" ") == 0) {
            return false;
        }
        if (name.indexOf(" ") == name.length()-1) {
            return false;
        }
        if (name.indexOf(" ", name.indexOf(" ")+1) > 0) {
            return false;
        }
        return true;
    }

}