package Klinik_Project;

import javax.swing.*;

public class FormPasien extends JFrame {

    JTextField txtNoRM = new JTextField();
    JTextField txtNama = new JTextField();
    JTextField txtUmur = new JTextField();
    JTextField txtKeluhan = new JTextField();

    JComboBox<String> cmbDokter =
            new JComboBox<>(
                    new String[]{
                            "Dr. Anggara",
                            "Dr. Fanrehalt",
                            "Dr. Fahrezi"
                    });

    JButton btnSimpan =
            new JButton("Simpan");

    public FormPasien() {

        setTitle("Data Pasien Klinik");
        setSize(400,300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblNoRM =
                new JLabel("No RM");

        lblNoRM.setBounds(
                20,20,100,25);

        add(lblNoRM);

        txtNoRM.setBounds(
                120,20,200,25);

        add(txtNoRM);

        JLabel lblNama =
                new JLabel("Nama");

        lblNama.setBounds(
                20,60,100,25);

        add(lblNama);

        txtNama.setBounds(
                120,60,200,25);

        add(txtNama);

        JLabel lblUmur =
                new JLabel("Umur");

        lblUmur.setBounds(
                20,100,100,25);

        add(lblUmur);

        txtUmur.setBounds(
                120,100,200,25);

        add(txtUmur);

        JLabel lblKeluhan =
                new JLabel("Keluhan");

        lblKeluhan.setBounds(
                20,140,100,25);

        add(lblKeluhan);

        txtKeluhan.setBounds(
                120,140,200,25);

        add(txtKeluhan);

        JLabel lblDokter =
                new JLabel("Dokter");

        lblDokter.setBounds(
                20,180,100,25);

        add(lblDokter);

        cmbDokter.setBounds(
                120,180,200,25);

        add(cmbDokter);

        btnSimpan.setBounds(
                120,220,100,30);

        add(btnSimpan);

        btnSimpan.addActionListener(e -> {

            Pasien pasien =
                    new Pasien();

            pasien.setNoRM(
                    txtNoRM.getText());

            pasien.setNama(
                    txtNama.getText());

            pasien.setUmur(
                    Integer.parseInt(
                            txtUmur.getText()));

            pasien.setKeluhan(
                    txtKeluhan.getText());

            pasien.setDokter(
                    cmbDokter.getSelectedItem()
                            .toString());

            new PasienDAO()
                    .simpan(pasien);

            JOptionPane.showMessageDialog(
                    null,
                    "Data Berhasil Disimpan");

        });
    }
}