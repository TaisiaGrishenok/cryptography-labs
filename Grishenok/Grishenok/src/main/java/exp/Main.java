package com.cfuv.crypto.lab.caesar;

import com.cfuv.crypto.lab.caesar.Caesar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ШИФР ЦЕЗАРЯ ===");
        System.out.print("Введите ваш номер в группе: ");
        int number = scanner.nextInt();

        int shift = Caesar.getShift(number);
        System.out.println("Смещение для шифра: " + shift);
        System.out.println();

        // Текст для шифрования (более 100 символов)
        String text = "Я студентка четвертого курса бизнес-информатики. " +
                "Изучаю программирование на Java и криптографию. " +
                "Это очень интересно и полезно для будущей карьеры в IT. " +
                "Каждый день узнаю что-то новое и развиваю свои навыки программирования.";

        System.out.println("Исходный текст:");
        System.out.println(text);
        System.out.println("Длина текста: " + text.length() + " символов");
        System.out.println();

        // Шифруем
        String encrypted = Caesar.encrypt(text, shift);
        System.out.println("Зашифрованный текст:");
        System.out.println(encrypted);
        System.out.println();

        // Расшифровываем
        String decrypted = Caesar.decrypt(encrypted, shift);
        System.out.println("Расшифрованный текст:");
        System.out.println(decrypted);
        System.out.println();

        // Проверяем
        if (text.equals(decrypted)) {
            System.out.println("Правильно");
        } else {
            System.out.println("Ошибка ");
        }

        scanner.close();
    }
}