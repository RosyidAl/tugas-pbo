public class Main {
    // Parameter bertipe interface: menerima implementasi apa pun.
    static void prosesPembayaran(Pembayaran metode, double jumlah) {
        System.out.println("  " + metode.ringkasan(jumlah));
        boolean ok = metode.bayar(jumlah);
        System.out.println("  Hasil: " + (ok ? "berhasil" : "gagal"));
        // Pemeriksaan tipe untuk interface lain yang mungkin juga diimplementasikan.
        if (ok && metode instanceof DapatDicetak) {
            ((DapatDicetak) metode).cetakStruk();
        }
    }

    public static void main(String[] args) {
        System.out.println("1. Transfer bank (Pembayaran + DapatDicetak)");
        prosesPembayaran(new TransferBank("BNI"), 250_000);

        System.out.println("\n2. E-wallet (hanya Pembayaran), saldo cukup");
        prosesPembayaran(new EWallet(500_000), 100_000);

        System.out.println("\n3. E-wallet, saldo tidak cukup");
        prosesPembayaran(new EWallet(50_000), 100_000);

        System.out.println("\n4. Static method dan konstanta interface");
        System.out.println("  Pembayaran.jumlahValid(-5)    = " + Pembayaran.jumlahValid(-5));
        System.out.println("  Pembayaran.BIAYA_ADMIN_MINIMAL = " + Pembayaran.BIAYA_ADMIN_MINIMAL);

        // Pembayaran p = new Pembayaran();   // error: Pembayaran is abstract; cannot be instantiated
    }
}
