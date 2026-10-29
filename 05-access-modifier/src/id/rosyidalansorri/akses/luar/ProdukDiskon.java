package id.rosyidalansorri.akses.luar;

import id.rosyidalansorri.akses.toko.Produk;

/** Subclass di package berbeda. */
public class ProdukDiskon extends Produk {
    public void cek() {
        // protected dan public terlihat lewat pewarisan.
        System.out.println("  pemasok   (protected): " + pemasok);
        System.out.println("  nama      (public)   : " + nama);
        System.out.println("  infoProtected()      : " + infoProtected());
        // System.out.println(kodeRak);        // error: kodeRak is not public in Produk; cannot be accessed from outside package
        // System.out.println(hargaModal);     // error: hargaModal has private access in Produk
    }

    // Akses protected lewat objek Produk biasa (bukan this) ditolak di package lain:
    // public void cobaLewatObjekLain(Produk p) {
    //     System.out.println(p.pemasok);      // error: pemasok has protected access in Produk
    // }
}
