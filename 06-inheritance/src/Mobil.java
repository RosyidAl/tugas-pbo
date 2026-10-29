/** Subclass tingkat 1: Mobil extends Kendaraan. */
public class Mobil extends Kendaraan {
    protected int jumlahPintu;

    public Mobil(String merek, int tahun, int jumlahPintu) {
        super(merek, tahun);   // wajib dipanggil pertama untuk menginisialisasi superclass
        this.jumlahPintu = jumlahPintu;
        System.out.println("  [Mobil] constructor");
    }

    // Override: mengganti implementasi dari superclass.
    @Override
    public String info() {
        return super.info() + ", " + jumlahPintu + " pintu";
    }

    public void bukaBagasi() {
        System.out.println("  Bagasi " + merek + " terbuka.");
    }
}
