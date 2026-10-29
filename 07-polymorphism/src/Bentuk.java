/** Superclass untuk demonstrasi runtime polymorphism. */
public class Bentuk {
    protected String nama;

    public Bentuk(String nama) {
        this.nama = nama;
    }

    public double luas() {
        return 0.0;
    }

    public void gambar() {
        System.out.println("  Menggambar bentuk umum");
    }

    public String getNama() {
        return nama;
    }
}
