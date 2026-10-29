public class Main {
    public static void main(String[] args) {
        System.out.println("1. Overloading (dipilih saat kompilasi)");
        Kalkulator k = new Kalkulator();
        System.out.println(k.tambah(2, 3));
        System.out.println(k.tambah(2, 3, 4));
        System.out.println(k.tambah(2.5, 3.5));
        System.out.println(k.tambah("Poli", "morfisme"));

        System.out.println("\n2. Overriding (dipilih saat program berjalan)");
        // Satu tipe referensi (Bentuk), tiga objek berbeda.
        Bentuk[] daftar = {
            new Lingkaran(7),
            new Persegi(4),
            new Segitiga(6, 5)
        };
        double total = 0;
        for (Bentuk b : daftar) {
            b.gambar();   // versi yang dijalankan mengikuti tipe objek sebenarnya
            System.out.printf("  %s, luas = %.2f%n", b.getNama(), b.luas());
            total += b.luas();
        }
        System.out.printf("  Total luas = %.2f%n", total);

        System.out.println("\n3. Upcasting dan downcasting");
        Bentuk b = new Lingkaran(10);          // upcasting: otomatis
        System.out.println("  Tipe referensi: Bentuk, tipe objek: " + b.getClass().getSimpleName());
        // b.keliling();                       // error: keliling() tidak ada di Bentuk
        if (b instanceof Lingkaran) {
            Lingkaran l = (Lingkaran) b;       // downcasting: eksplisit, aman setelah instanceof
            System.out.printf("  keliling() setelah downcast = %.2f%n", l.keliling());
        }
        Bentuk p = new Persegi(2);
        try {
            Lingkaran salah = (Lingkaran) p;   // lolos kompilasi, gagal saat runtime
            System.out.println(salah);
        } catch (ClassCastException e) {
            System.out.println("  Downcast Persegi ke Lingkaran: ClassCastException");
        }
    }
}
