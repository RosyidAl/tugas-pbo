public class Main {
    public static void main(String[] args) {
        // Karyawan k = new Karyawan("X", "Y");
        // error: Karyawan is abstract; cannot be instantiated

        Karyawan[] daftar = {
            new KaryawanTetap("K-001", "Rosyid", 6_000_000, 1_000_000),
            new KaryawanKontrak("K-002", "Budi", 40_000, 120),
            new Magang("K-003", "Sari")
        };

        double total = 0;
        for (Karyawan k : daftar) {
            k.cetakSlip();    // cetakSlip() ada di abstract class, hitungGaji() di subclass
            System.out.println();
            total += k.hitungGaji();
        }
        System.out.printf("Total pengeluaran gaji: Rp%,.0f%n", total);
    }
}
