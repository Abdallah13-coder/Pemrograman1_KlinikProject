package Project_Klinik;

public class Model_Pasien {

    private String noRM;
    private String nama;
    private int umur;
    private String keluhan;
    private String dokter;

    public Model_Pasien(String noRM, String nama, int umur, String keluhan, String dokter) {
        this.noRM = noRM;
        this.nama = nama;
        this.umur = umur;
        this.keluhan = keluhan;
        this.dokter = dokter;
    }

    public String getNoRM() {
        return noRM;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public String getDokter() {
        return dokter;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public void setDokter(String dokter) {
        this.dokter = dokter;
    }
}