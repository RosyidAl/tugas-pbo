public class Segitiga extends Bentuk {
    private double alas;
    private double tinggi;

    public Segitiga(double alas, double tinggi) {
        super("Segitiga");
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public double luas() {
        return 0.5 * alas * tinggi;
    }

    // gambar() sengaja tidak di-override: Segitiga memakai versi Bentuk.
}
