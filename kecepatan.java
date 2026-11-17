package Modifikasi;

import javax.swing.*;
import java.awt.event.*;

public class kecepatan {

    public static void main(String[] args) {
        new KalkulatorMotor().setVisible(true);
    }

    public static class KalkulatorMotor extends JFrame {

        private JTextField txtCC;
        private JTextField txtKecepatan;
        private JLabel lblHasil;

        public KalkulatorMotor() {
            setTitle("Kalkulator Performa Motor");
            setSize(400, 250);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(null);

            JLabel lblCC = new JLabel("CC Motor:");
            lblCC.setBounds(20, 20, 100, 25);
            add(lblCC);

            txtCC = new JTextField();
            txtCC.setBounds(140, 20, 180, 25);
            add(txtCC);

            JLabel lblKecepatan = new JLabel("Kecepatan (km/jam):");
            lblKecepatan.setBounds(20, 60, 120, 25);
            add(lblKecepatan);

            txtKecepatan = new JTextField();
            txtKecepatan.setBounds(140, 60, 180, 25);
            add(txtKecepatan);

            JButton btnHitung = new JButton("Hitung");
            btnHitung.setBounds(140, 100, 100, 30);
            add(btnHitung);

            lblHasil = new JLabel("Hasil:");
            lblHasil.setBounds(20, 150, 350, 25);
            add(lblHasil);

            btnHitung.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int cc = Integer.parseInt(txtCC.getText());
                        double kecepatan = Double.parseDouble(txtKecepatan.getText());

                        double rasio = kecepatan / cc;

                        String kategori;

                        if (cc <= 125) {
                            kategori = "Motor Harian";
                        } else if (cc <= 250) {
                            kategori = "Motor Sport Ringan";
                        } else if (cc <= 500) {
                            kategori = "Motor Sport Menengah";
                        } else {
                            kategori = "Motor Moge";
                        }

                        lblHasil.setText(
                                String.format(
                                        "Rasio = %.2f km/jam per cc | Kategori: %s",
                                        rasio,
                                        kategori));

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
    }
}
