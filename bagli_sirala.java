

package com.mycompany.programlama_odev2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class NumberWithIndex {
    int number;
    int index;

    NumberWithIndex(int number, int index) {
        this.number = number;
        this.index = index;
    }
}

public class bagli_sirala {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Dosya adı eksik.");
            return;
        }

        String fileName = args[0];
        ArrayList<NumberWithIndex> numbers = readNumbersFromFile(fileName);
        if (numbers == null) {
            System.out.println("Dosya okunamadı veya dosya boş.");
            return;
        }

        System.out.println("Giriş dizisi:");
        for (NumberWithIndex num : numbers) {
            System.out.println(num.number + " " + num.index);
        }

        // Sıralama
        sortNumbers(numbers);

        System.out.println("Sıralanmış dizi:");
        for (NumberWithIndex num : numbers) {
            System.out.println(num.number + " " + num.index);
        }
    }

    private static ArrayList<NumberWithIndex> readNumbersFromFile(String fileName) {
        ArrayList<NumberWithIndex> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                numbers.add(new NumberWithIndex(number, index));
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return numbers;
    }

    private static void sortNumbers(ArrayList<NumberWithIndex> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = 0; j < numbers.size() - i - 1; j++) {
                if (numbers.get(j).number > numbers.get(j + 1).number) {
                    // Swap
                    NumberWithIndex temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
    }
}
