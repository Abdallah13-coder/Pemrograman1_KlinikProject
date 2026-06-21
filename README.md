# 🏥 Klinik_Project

## Deskripsi Project

Klinik_Project adalah aplikasi desktop sederhana berbasis Java Swing yang digunakan untuk mengelola data pasien pada sebuah klinik. Aplikasi ini memungkinkan pengguna untuk memasukkan data pasien seperti nomor rekam medis, nama pasien, umur, keluhan, dan dokter yang menangani, kemudian menyimpannya ke database MySQL.

Project ini dibuat sebagai implementasi mata kuliah Pemrograman Java Desktop menggunakan NetBeans dan MySQL.

## Fitur Aplikasi

* Input Data Pasien
* Penyimpanan Data ke Database MySQL
* Validasi Input Data
* Pemilihan Dokter melalui ComboBox
* Koneksi Database menggunakan JDBC
* Antarmuka GUI menggunakan Java Swing

## Struktur Project

```text
Klinik_Project
│
├── Koneksi.java
├── Pasien.java
├── PasienDAO.java
├── FormPasien.java
└── Main.java

### Penjelasan File

| File            | Fungsi                                          |
| --------------- | ----------------------------------------------- |
| Koneksi.java    | Menghubungkan aplikasi dengan database MySQL    |
| Pasien.java     | Menyimpan atribut data pasien                   |
| PasienDAO.java  | Menjalankan proses penyimpanan data ke database |
| FormPasien.java | Tampilan GUI aplikasi                           |
| Main.java       | Menjalankan aplikasi                            |

## Database

Nama Database:

```sql
db_klinik
```

Tabel Pasien:

```sql
CREATE TABLE pasien (
    no_rm VARCHAR(10) PRIMARY KEY,
    nama VARCHAR(100),
    umur INT,
    keluhan VARCHAR(255),
    dokter VARCHAR(100)
);
```

## Materi yang Digunakan

### 1. Pemrograman Berorientasi Objek (OOP)

Konsep yang digunakan:

* Class
* Object
* Encapsulation
* Constructor
* Method

Contoh:

```java
Pasien pasien = new Pasien();
```

### 2. Java Swing

Komponen GUI yang digunakan:

* JFrame
* JLabel
* JTextField
* JComboBox
* JButton
* JOptionPane

Contoh:

```java
JButton btnSimpan = new JButton("Simpan");
```

### 3. Event Handling

Digunakan untuk menangani aksi saat tombol ditekan.

Contoh:

```java
btnSimpan.addActionListener(e -> {
    // proses simpan data
});
```

### 4. JDBC (Java Database Connectivity)

Digunakan untuk menghubungkan aplikasi Java dengan database MySQL.

Contoh:

```java
Connection conn =
DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/db_klinik",
    "root",
    ""
);
```

### 5. MySQL Database

Digunakan sebagai media penyimpanan data pasien.

Operasi yang digunakan:

* CREATE DATABASE
* CREATE TABLE
* INSERT INTO


### 6. XAMPP

Digunakan untuk menjalankan layanan:

* Apache
* MySQL

Sebagai server database lokal.


### 7. NetBeans IDE 25

Digunakan sebagai IDE untuk:

* Menulis kode program
* Mendesain GUI
* Menjalankan aplikasi Java


## Software yang Digunakan

* Java JDK 25
* Apache NetBeans 25
* XAMPP
* MySQL Connector/J
* GitHub


## Cara Menjalankan Program

1. Jalankan Apache dan MySQL pada XAMPP.
2. Buat database `db_klinik`.
3. Import tabel `pasien`.
4. Tambahkan MySQL Connector/J ke Libraries NetBeans.
5. Jalankan file `Main.java`.


## Data Dokter

* dr. Fahrezi
* dr. Fanrehalt
* dr. Anggara


## Author

Abdallah Najwan Muharidien A.K.A SigmaaWann

Program Studi Teknik Informatika

Project Akhir Pemrograman Java Desktop
