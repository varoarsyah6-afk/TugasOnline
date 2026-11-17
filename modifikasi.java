package Modifikasi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modifikasi extends JFrame {

    private JTextField txtBerat, txtTinggi;
    private JLabel lblHasil;

    public modifikasi() {
        setTitle("Kalkulator BMI");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblBerat = new JLabel("Berat (kg):");
        lblBerat.setBounds(20, 20, 100, 25);
        add(lblBerat);

        txtBerat = new JTextField();
        txtBerat.setBounds(120, 20, 150, 25);
        add(txtBerat);

        JLabel lblTinggi = new JLabel("Tinggi (cm):");
        lblTinggi.setBounds(20, 60, 100, 25);
        add(lblTinggi);

        txtTinggi = new JTextField();
        txtTinggi.setBounds(120, 60, 150, 25);
        add(txtTinggi);

        JButton btnHitung = new JButton("Hitung BMI");
        btnHitung.setBounds(100, 100, 120, 30);
        add(btnHitung);

        lblHasil = new JLabel("Hasil BMI:");
        lblHasil.setBounds(20, 145, 300, 25);
        add(lblHasil);

        btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double berat = Double.parseDouble(txtBerat.getText());
                    double tinggiCm = Double.parseDouble(txtTinggi.getText());

                    double tinggiM = tinggiCm / 100.0;
                    double bmi = berat / (tinggiM * tinggiM);

                    String kategori;

                    if (bmi < 18.5) {
                        kategori = "Kurus";
                    } else if (bmi < 25) {
                        kategori = "Normal";
                    } else if (bmi < 30) {
                        kategori = "Gemuk";
                    } else {
                        kategori = "Obesitas";
                    }

                    lblHasil.setText(String.format("BMI = %.2f (%s)", bmi, kategori));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Masukkan angka yang valid!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new modifikasi().setVisible(true));
    }
}
