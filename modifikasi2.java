package Modifikasi;

import javax.swing.JOptionPane;

public class modifikasi2 {
    public static void main(String[] args) {
        String beratInput = JOptionPane.showInputDialog("Masukkan berat badan (kg):");
        String tinggiInput = JOptionPane.showInputDialog("Masukkan tinggi badan (meter):");

        if (beratInput == null || tinggiInput == null
                || beratInput.trim().isEmpty() || tinggiInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Input tidak boleh kosong!");
            return;
        }

        try {
            double berat = Double.parseDouble(beratInput.trim());
            double tinggi = Double.parseDouble(tinggiInput.trim());
            if (berat <= 0 || tinggi <= 0) {
                JOptionPane.showMessageDialog(null, "Berat dan tinggi harus lebih besar dari 0!");
                return;
            }

            double bmi = berat / (tinggi * tinggi);
            JOptionPane.showMessageDialog(null, String.format("BMI Anda = %.2f", bmi));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input harus berupa angka!");
        }
    }
}