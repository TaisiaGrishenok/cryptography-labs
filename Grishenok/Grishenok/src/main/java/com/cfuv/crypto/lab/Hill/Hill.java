package com.cfuv.crypto.lab.Hill;
public class Hill {
    private static final int MOD = 26; // Все операции делаем по модулю 26

    // Превращаем букву в число
    private static int charToInt(char c) {
        return c - 'A';
    }

    // Превращаем число обратно в букву
    private static char intToChar(int i) {
        return (char) ('A' + i);
    }

    // Умножение матрицы на вектор
    // matrix: n x n
    // vector: длина n
    // result: длина n
    private static int[] multiplyMatrixVector(int[][] matrix, int[] vector) {
        int n = matrix.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j] * vector[j]; // Внутри двух циклов мы делаем строка на столбец
            }
            // Берём результат по модулю 26, чтобы было в диапазоне 0-25
            result[i] = ((sum % MOD) + MOD) % MOD;
        }
        return result;
    }

    // Убираем все не буквы и приводим к верхнему регистру
    private static String preprocess(String text) {
        return text.replaceAll("[^A-Za-z]", "").toUpperCase();
    }

    // Дополним текст X, чтобы длина делилась на размер блока
    private static String padToBlock(String text, int blockSize) {
        StringBuilder sb = new StringBuilder(text);
        while (sb.length() % blockSize != 0) {
            sb.append('X'); // добавляем букву X
        }
        return sb.toString();
    }

    // Шифрование текста
    public static String encrypt(String plain, int[][] keyMatrix) {
        // 1. Преобразуем текст: только буквы, верхний регистр
        String text = preprocess(plain);

        int n = keyMatrix.length; // размер матрицы
        text = padToBlock(text, n); // дополняем до кратного n

        StringBuilder cipher = new StringBuilder();

        // Шифруем блоки
        for (int i = 0; i < text.length(); i += n) {
            int[] vector = new int[n];
            for (int j = 0; j < n; j++) {
                vector[j] = charToInt(text.charAt(i + j)); // буквы -> числа
            }
            int[] enc = multiplyMatrixVector(keyMatrix, vector); // умножаем на матрицу
            for (int v : enc) cipher.append(intToChar(v)); // числа -> буквы
        }
        return cipher.toString();
    }

    // Расшифровка текста
    public static String decrypt(String cipher, int[][] invKeyMatrix) {
        int n = invKeyMatrix.length;
        StringBuilder plain = new StringBuilder();

        for (int i = 0; i < cipher.length(); i += n) {
            int[] vector = new int[n];
            for (int j = 0; j < n; j++) {
                vector[j] = charToInt(cipher.charAt(i + j));
            }
            int[] dec = multiplyMatrixVector(invKeyMatrix, vector); // умножаем на обратную матрицу
            for (int v : dec) plain.append(intToChar(v));
        }
        return plain.toString();
    }
}
