package com.cfuv.crypto.lab.Hill;

public class Main_2 {
    public static void main(String[] args) {
        // моя матрица
        int[][] keyMatrix = { {7, 11}, {4, 9} };

        // обратная матрица вручную заранее
        int[][] invKeyMatrix = { {21, 9}, {8, 25} };

        // Текст
        String text = "This is an example text for testing the implementation of the Hill cipher in Java. I study business informatics and explore cryptographic methods.";


        System.out.println("Оригинал:");
        System.out.println(text);
        System.out.println();

        // Шифрование
        String encrypted = Hill.encrypt(text, keyMatrix);
        System.out.println("Зашифрованный:");
        System.out.println(encrypted);
        System.out.println();

        // Расшифрование
        String decrypted = Hill.decrypt(encrypted, invKeyMatrix);
        System.out.println("Расшифрованный:");
        System.out.println(decrypted);
    }
}

