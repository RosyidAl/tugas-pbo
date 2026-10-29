/**
 * Compile-time polymorphism (method overloading):
 * nama method sama, daftar parameter berbeda. Compiler memilih versi
 * yang dipanggil berdasarkan tipe dan jumlah argumen.
 */
public class Kalkulator {
    public int tambah(int a, int b) {
        System.out.print("  tambah(int, int)        -> ");
        return a + b;
    }

    public int tambah(int a, int b, int c) {
        System.out.print("  tambah(int, int, int)   -> ");
        return a + b + c;
    }

    public double tambah(double a, double b) {
        System.out.print("  tambah(double, double)  -> ");
        return a + b;
    }

    public String tambah(String a, String b) {
        System.out.print("  tambah(String, String)  -> ");
        return a + b;
    }
}
