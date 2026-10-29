/**
 * Abstract class: tidak dapat diinstansiasi. Berisi method abstract
 * (wajib diimplementasikan subclass) dan method biasa (dipakai bersama).
 */
public abstract class Karyawan {
    private final String nama;
    private final String id;

    protected Karyawan(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    // Method abstract: hanya tanda tangan, tanpa badan.
    public abstract double hitungGaji();

    public abstract String getJabatan();

    // Method biasa: logika yang sama untuk semua subclass.
    public void cetakSlip() {
        System.out.println("  ID      : " + id);
        System.out.println("  Nama    : " + nama);
        System.out.println("  Jabatan : " + getJabatan());
        System.out.printf("  Gaji    : Rp%,.0f%n", hitungGaji());
    }

    public String getNama() {
        return nama;
    }
}
