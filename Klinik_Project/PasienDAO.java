package Klinik_Project;

import java.sql.PreparedStatement;

public class PasienDAO {

    public void simpan(Pasien pasien) {

        try {

            String sql =
                    "INSERT INTO pasien VALUES(?,?,?,?,?)";

            PreparedStatement pst =
                    Koneksi.getConnection()
                            .prepareStatement(sql);

            pst.setString(1, pasien.getNoRM());
            pst.setString(2, pasien.getNama());
            pst.setInt(3, pasien.getUmur());
            pst.setString(4, pasien.getKeluhan());
            pst.setString(5, pasien.getDokter());

            pst.executeUpdate();

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }
}