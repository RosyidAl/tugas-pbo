/**
 * Interface mendefinisikan kontrak: apa yang harus bisa dilakukan,
 * tanpa menentukan bagaimana. Class yang mengimplementasikannya wajib
 * mengisi semua method abstract.
 */
public interface Pembayaran {
    // Atribut di interface otomatis public static final.
    double BIAYA_ADMIN_MINIMAL = 0;

    // Method abstract (otomatis public abstract).
    boolean bayar(double jumlah);

    double hitungBiayaAdmin(double jumlah);

    // Default method (Java 8): punya isi, boleh di-override.
    default String ringkasan(double jumlah) {
        return String.format("Total %,.0f (termasuk admin %,.0f)",
                jumlah + hitungBiayaAdmin(jumlah), hitungBiayaAdmin(jumlah));
    }

    // Static method (Java 8): dipanggil lewat nama interface.
    static boolean jumlahValid(double jumlah) {
        return jumlah > 0;
    }
}
