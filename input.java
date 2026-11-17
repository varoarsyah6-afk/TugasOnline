package Modifikasi;

import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan angka: ");
        String input = scanner.nextLine();

        if (input == null || input.trim().isEmpty()) {
            System.out.println("Input tidak boleh kosong!");
        } else {
            try {
                double number = Double.parseDouble(input);
                System.out.println("Angka yang dimasukkan: " + number);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }

        scanner.close();
    }
}