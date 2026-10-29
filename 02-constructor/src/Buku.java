/**
 * Class Buku mendemonstrasikan jenis-jenis constructor:
 * default, berparameter, overloading, constructor chaining (this), dan copy constructor.
 */
public class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private double harga;

    // 1. Constructor tanpa parameter: mengisi nilai bawaan.
    public Buku() {
        this("Tanpa Judul", "Anonim", 2000, 0.0);
        System.out.println("  [Buku()] dipanggil");
    }

    // 2. Constructor dengan dua parameter: meneruskan ke constructor lengkap.
    public Buku(String judul, String penulis) {
        this(judul, penulis, 2024, 50_000.0);
        System.out.println("  [Buku(judul, penulis)] dipanggil");
    }

    // 3. Constructor lengkap: tempat semua inisialisasi sebenarnya.
    public Buku(String judul, String penulis, int tahunTerbit, double harga) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.harga = harga;
        System.out.println("  [Buku(judul, penulis, tahunTerbit, harga)] dipanggil");
    }

    // 4. Copy constructor: membuat objek baru dari nilai objek lain.
    public Buku(Buku asal) {
        this(asal.judul, asal.penulis, asal.tahunTerbit, asal.harga);
        System.out.println("  [Buku(Buku)] dipanggil");
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void tampilkan() {
        System.out.printf("  \"%s\" oleh %s (%d), Rp%,.0f%n", judul, penulis, tahunTerbit, harga);
    }
}
