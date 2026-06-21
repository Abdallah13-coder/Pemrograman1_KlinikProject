package Klinik_Project;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    private static Connection conn;

    public static Connection getConnection() {

        try {

            if (conn == null) {

                String url =
                        "jdbc:mysql://localhost:3306/db_klinik";

                String user = "root";
                String password = "";

                conn = DriverManager.getConnection(
                        url,
                        user,
                        password
                );

                System.out.println("Koneksi Berhasil");
            }

        } catch (Exception e) {

            System.out.println(
                    "Koneksi Gagal : "
                    + e.getMessage()
            );
        }

        return conn;
    }
}