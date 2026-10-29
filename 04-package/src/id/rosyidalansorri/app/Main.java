package id.rosyidalansorri.app;

// 1. Import satu class tertentu.
import id.rosyidalansorri.gudang.Barang;
// 2. Import static: memanggil method static tanpa nama class.
import static id.rosyidalansorri.util.FormatRupiah.format;

public class Main {
    public static void main(String[] args) {
        // Barang di sini adalah id.rosyidalansorri.gudang.Barang (sesuai import).
        Barang dariGudang = new Barang("Keyboard", 40);
        System.out.println(dariGudang.ringkasan());

        // Class lain bernama sama dari package berbeda dipakai dengan nama lengkap
        // (fully qualified name), karena nama sederhana "Barang" sudah dipakai import.
        id.rosyidalansorri.toko.Barang dariToko =
                new id.rosyidalansorri.toko.Barang("Keyboard", 350_000);
        System.out.println(dariToko.ringkasan());

        System.out.println("Harga lewat static import: " + format(1_250_000));

        // Informasi package diperoleh lewat reflection.
        System.out.println("Package gudang.Barang : " + dariGudang.getClass().getPackageName());
        System.out.println("Package toko.Barang   : " + dariToko.getClass().getPackageName());
        System.out.println("Nama lengkap class    : " + dariToko.getClass().getName());
    }
}
