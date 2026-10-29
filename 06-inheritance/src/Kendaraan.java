/** Superclass: atribut dan perilaku yang dimiliki semua kendaraan. */
public class Kendaraan {
    protected String merek;
    protected int tahun;

    public Kendaraan(String merek, int tahun) {
        this.merek = merek;
        this.tahun = tahun;
        System.out.println("  [Kendaraan] constructor: " + merek);
    }

    public void nyalakan() {
        System.out.println("  " + merek + " menyala.");
    }

    public String info() {
        return merek + " (" + tahun + ")";
    }

    // final: tidak boleh di-override subclass.
    public final String jenisInduk() {
        return "Kendaraan";
    }
}
