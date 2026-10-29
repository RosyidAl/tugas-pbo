package id.rosyidalansorri.akses.luar;

import id.rosyidalansorri.akses.toko.Kasir;
import id.rosyidalansorri.akses.toko.Produk;

/** Class biasa di package berbeda, bukan subclass. */
public class Main {
    public static void main(String[] args) {
        Produk p = new Produk();

        System.out.println("1. Dari dalam class Produk (semua level):");
        p.semuaDariDalam();

        System.out.println("\n2. Dari Kasir (package sama):");
        new Kasir().cek(p);

        System.out.println("\n3. Dari ProdukDiskon (subclass, package berbeda):");
        new ProdukDiskon().cek();

        System.out.println("\n4. Dari Main (bukan subclass, package berbeda):");
        System.out.println("  nama (public)  : " + p.nama);
        System.out.println("  infoPublic()   : " + p.infoPublic());
        // System.out.println(p.pemasok);      // error: protected
        // System.out.println(p.kodeRak);      // error: default
        // System.out.println(p.hargaModal);   // error: private
    }
}
