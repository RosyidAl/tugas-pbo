package id.rosyidalansorri.akses.toko;

/** Class lain dalam package yang sama dengan Produk. */
public class Kasir {
    public void cek(Produk p) {
        System.out.println("  kodeRak   (default)  : " + p.kodeRak);
        System.out.println("  pemasok   (protected): " + p.pemasok);
        System.out.println("  nama      (public)   : " + p.nama);
        System.out.println("  infoDefault()        : " + p.infoDefault());
        // System.out.println(p.hargaModal);  // error: hargaModal has private access in Produk
    }
}
