package com.cfuv.crypto.lab.caesar;

public class Caesar {

    // Русский алфавит
    private static final String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    // Шифруем текст
    public static String encrypt(String text, int shift) {
        if (text == null) return ""; //Если передан null, метод возвращает пустую строку

        StringBuilder result = new StringBuilder(); //аккумулирует результат
// берём каждую букву текста и, если она большая русская, сдвигаем её в алфавите на н позиций,
// а потом добавляем в результат
        for (char c : text.toCharArray()) {
            // Для больших букв
            if (Character.isUpperCase(c)) {
                int index = ALPHABET.indexOf(c);
                if (index != -1) {
                    int newIndex = (index + shift) % 33; //возвращает остаток от деления на 33 и зацикливает счёт
                    if (newIndex < 0) newIndex += 33;
                    result.append(ALPHABET.charAt(newIndex));
                } else {
                    result.append(c);
                }
            }
            // Для маленьких букв
            else if (Character.isLowerCase(c)) {
                char upper = Character.toUpperCase(c);
                int index = ALPHABET.indexOf(upper);
                if (index != -1) {
                    int newIndex = (index + shift) % 33;
                    if (newIndex < 0) newIndex += 33;
                    result.append(Character.toLowerCase(ALPHABET.charAt(newIndex)));
                } else {
                    result.append(c);
                }
            }
            // Для всех остальных символов
            else {
                result.append(c);
            }
        }

        return result.toString();
    }

    // Расшифровываем текст
    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

    // Вычисляем смещение
    public static int getShift(int groupNumber) {
        return groupNumber + 2; // Смещение для шифра = номер группы + 2
    }
}