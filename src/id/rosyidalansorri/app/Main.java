package id.rosyidalansorri.app;

import id.rosyidalansorri.Rekening;
import id.rosyidalansorri.PetugasBank;
import id.rosyidalansorri.prioritas.RekeningPrioritas;

/**
 * Class Main bertindak sebagai entry point aplikasi.
 * Terletak pada package id.rosyidalansorri.app.
 * 
 * Class ini mendemonstrasikan secara komprehensif 4 jenis access modifier di Java:
 * 1. PUBLIC    : Dapat diakses dari package manapun (antar-package).
 * 2. DEFAULT   : Hanya dapat diakses dari class dalam package yang sama.
 * 3. PROTECTED : Dapat diakses dalam package yang sama dan oleh subclass di package berbeda.
 * 4. PRIVATE   : Hanya dapat diakses dari dalam class pemiliknya sendiri.
 * 
 * @author Rosyid Al Ansorri (NIM: L0125065)
 */
public class Main {

    public static void main(String[] args) {
        cetakHeaderIdentitas();

        // =========================================================================
        // 1. DEMONSTRASI ACCESS MODIFIER: PUBLIC
        // =========================================================================
        System.out.println("================================================================================");
        System.out.println("1. DEMONSTRASI ACCESS MODIFIER: PUBLIC");
        System.out.println("================================================================================");
        System.out.println("Keterangan: Elemen public dapat diakses bebas dari package manapun.");
        System.out.println("Di sini, class Main (package .app) mengakses class Rekening (package dasar).\n");

        // [Akses Diizinkan] Constructor Rekening bersifat public
        Rekening rekReguler = new Rekening("Rosyid Al Ansorri", 1_500_000.0, "CABANG-SOLO-01");
        System.out.println("[SUKSES] Objek Rekening berhasil dibuat melalui public constructor:");
        
        // [Akses Diizinkan] Method getter berstatus public
        System.out.printf("  - Nama Pemilik (public getter) : %s%n", rekReguler.getNamaPemilik());
        System.out.printf("  - Saldo Awal   (public getter) : Rp%,.2f%n", rekReguler.getSaldo());
        System.out.printf("  - Kode Cabang  (public getter) : %s%n%n", rekReguler.getKodeCabang());

        // [Akses Diizinkan] Method setor() dan tarik() bersifat public
        System.out.println("Menguji transaksi rekening via public method setor() dan tarik():");
        rekReguler.setor(500_000.0);
        rekReguler.tarik(250_000.0);
        System.out.printf("Saldo akhir setelah transaksi : Rp%,.2f%n", rekReguler.getSaldo());


        // =========================================================================
        // 2. DEMONSTRASI ACCESS MODIFIER: DEFAULT (PACKAGE-PRIVATE)
        // =========================================================================
        System.out.println("\n================================================================================");
        System.out.println("2. DEMONSTRASI ACCESS MODIFIER: DEFAULT (PACKAGE-PRIVATE)");
        System.out.println("================================================================================");
        System.out.println("Keterangan: Atribut 'kodeCabang' pada class Rekening tidak memiliki modifier (default).");
        System.out.println("- Class PetugasBank (satu package id.rosyidalansorri) DAPAT mengaksesnya langsung.");
        System.out.println("- Class Main (package id.rosyidalansorri.app) TIDAK DAPAT mengaksesnya langsung.\n");

        // Membuat objek PetugasBank (satu package dengan Rekening)
        PetugasBank teller = new PetugasBank("PETUGAS-007", "Ahmad Fauzi");
        System.out.printf("Petugas terdaftar: %s (%s)%n", teller.getNamaPetugas(), teller.getIdPetugas());

        // PetugasBank mengubah kodeCabang secara langsung tanpa setter
        teller.ubahKodeCabang(rekReguler, "CABANG-SOLO-VIP");
        System.out.printf("Verifikasi dari Main via getter: Kode Cabang sekarang = %s%n", rekReguler.getKodeCabang());

        System.out.println("\n[PEMBUKTIAN AKSES DITOLAK PADA DEFAULT]:");
        System.out.println("Jika Main mencoba membaca/menulis atribut default 'kodeCabang' secara langsung:");
        System.out.println("  -> rekReguler.kodeCabang = \"CABANG-BARU\";");
        System.out.println("  -> HASIL: COMPILE ERROR! \"kodeCabang is not public in id.rosyidalansorri.Rekening; cannot be accessed from outside package\"");


        // =========================================================================
        // 3. DEMONSTRASI ACCESS MODIFIER: PROTECTED
        // =========================================================================
        System.out.println("\n================================================================================");
        System.out.println("3. DEMONSTRASI ACCESS MODIFIER: PROTECTED");
        System.out.println("================================================================================");
        System.out.println("Keterangan: Method 'terapkanBunga()' dan 'infoInternalRekening()' bersifat protected.");
        System.out.println("- Subclass RekeningPrioritas (di package .prioritas) BISA memanggilnya via super.");
        System.out.println("- Class Main (package .app, non-subclass) TIDAK BISA memanggilnya secara langsung.\n");

        // Membuat objek RekeningPrioritas (subclass di package id.rosyidalansorri.prioritas)
        RekeningPrioritas rekPrioritas = new RekeningPrioritas(
                "Siti Nurhaliza",
                10_000_000.0,
                "CABANG-SOLO-VIP",
                "Platinum",
                25_000_000.0
        );

        // RekeningPrioritas memanggil method protected superclass dari dalam method-nya sendiri
        rekPrioritas.tampilkanProfilPrioritas();
        rekPrioritas.berikanBungaPrioritas(3.5); // Memberikan bunga 3.5%

        System.out.println("\n[PEMBUKTIAN AKSES DITOLAK PADA PROTECTED]:");
        System.out.println("Jika class Main memanggil method protected secara langsung pada objek rekening:");
        System.out.println("  -> rekReguler.terapkanBunga(5.0);");
        System.out.println("  -> rekPrioritas.terapkanBunga(5.0);");
        System.out.println("  -> HASIL: COMPILE ERROR! \"terapkanBunga(double) has protected access in id.rosyidalansorri.Rekening\"");


        // =========================================================================
        // 4. DEMONSTRASI ACCESS MODIFIER: PRIVATE
        // =========================================================================
        System.out.println("\n================================================================================");
        System.out.println("4. DEMONSTRASI ACCESS MODIFIER: PRIVATE & ENKAPSULASI");
        System.out.println("================================================================================");
        System.out.println("Keterangan: Atribut 'saldo' dan 'namaPemilik' bersifat private di Rekening.");
        System.out.println("Tidak ada class lain (Main, PetugasBank, RekeningPrioritas) yang bisa mengaksesnya langsung.\n");

        System.out.println("[UJI VALIDASI ENKAPSULASI]:");
        System.out.println("Mencoba melakukan penarikan ilegal (melebihi saldo yang ada):");
        boolean hasilTarik = rekReguler.tarik(50_000_000.0);
        System.out.printf("Status transaksi tarik ilegal: %s (Saldo tetap aman: Rp%,.2f)%n",
                (hasilTarik ? "Berhasil" : "Ditolak"), rekReguler.getSaldo());

        System.out.println("\n[PEMBUKTIAN AKSES DITOLAK PADA PRIVATE]:");
        System.out.println("Jika class Main mencoba memanipulasi saldo secara langsung:");
        System.out.println("  -> rekReguler.saldo = 999_999_999.0;");
        System.out.println("  -> rekReguler.namaPemilik = \"Hacker\";");
        System.out.println("  -> HASIL: COMPILE ERROR! \"saldo has private access in id.rosyidalansorri.Rekening\"");
        System.out.println("Saldo hanya dapat diubah melalui validasi method setor() dan tarik().");


        // =========================================================================
        // 5. DEMONSTRASI PENGUJIAN ERROR SECARA FAKTUAL (KODE KOMENTAR DI BAWAH)
        // =========================================================================
        cobaSimulasiCompileError();

        // =========================================================================
        // 6. RINGKASAN MATRIKS HAK AKSES JAVA
        // =========================================================================
        cetakMatriksHakAkses();
    }

    /**
     * Method untuk mendokumentasikan baris-baris kode yang sengaja ditolak oleh compiler.
     * Baris kode sengaja dikomentari agar project dapat dikompilasi secara normal.
     */
    private static void cobaSimulasiCompileError() {
        System.out.println("\n================================================================================");
        System.out.println("5. DOKUMENTASI BARIS KODE ILEGAL (COMPILATION ERROR AUDIT)");
        System.out.println("================================================================================");
        
        Rekening tesRekening = new Rekening("Nasabah Uji", 100_000, "CBG-001");
        
        // --- 1. ERROR PRIVATE ---
        // tesRekening.saldo = 500000;
        // Penjelasan: Error: saldo has private access in id.rosyidalansorri.Rekening
        
        // tesRekening.namaPemilik = "Nama Baru";
        // Penjelasan: Error: namaPemilik has private access in id.rosyidalansorri.Rekening
        
        // --- 2. ERROR DEFAULT ---
        // tesRekening.kodeCabang = "CBG-999";
        // Penjelasan: Error: kodeCabang is not public in id.rosyidalansorri.Rekening; cannot be accessed from outside package
        
        // --- 3. ERROR PROTECTED ---
        // tesRekening.terapkanBunga(10.0);
        // Penjelasan: Error: terapkanBunga(double) has protected access in id.rosyidalansorri.Rekening
        
        // tesRekening.infoInternalRekening();
        // Penjelasan: Error: infoInternalRekening() has protected access in id.rosyidalansorri.Rekening

        System.out.println("[STATUS] Seluruh baris ilegal telah dipetakan dan diverifikasi sesuai aturan JLS (Java Language Specification).");
    }

    private static void cetakHeaderIdentitas() {
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║            PRAKTIKUM PEMROGRAMAN BERORIENTASI OBJEK (PBO)                    ║");
        System.out.println("║                DEMONSTRASI JAVA ACCESS MODIFIER                              ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Nama  : Rosyid Al Ansorri                                                    ║");
        System.out.println("║ NIM   : L0125065                                                             ║");
        System.out.println("║ Topik : Access Modifier (public, protected, default, private)                ║");
        System.out.println("║ Paket : id.rosyidalansorri, .prioritas, .app                                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝\n");
    }

    private static void cetakMatriksHakAkses() {
        System.out.println("\n================================================================================");
        System.out.println("6. RINGKASAN MATRIKS HAK AKSES ACCESS MODIFIER JAVA");
        System.out.println("================================================================================");
        System.out.println("+-------------+---------------+---------------+--------------------+---------------+");
        System.out.println("| Modifier    | Same Class    | Same Package  | Subclass (Diff Pkg)| World/Anywhere|");
        System.out.println("+-------------+---------------+---------------+--------------------+---------------+");
        System.out.println("| public      |      YA       |      YA       |         YA         |      YA       |");
        System.out.println("| protected   |      YA       |      YA       |         YA         |     TIDAK     |");
        System.out.println("| default     |      YA       |      YA       |        TIDAK       |     TIDAK     |");
        System.out.println("| private     |      YA       |     TIDAK     |        TIDAK       |     TIDAK     |");
        System.out.println("+-------------+---------------+---------------+--------------------+---------------+");
        System.out.println("[SELESAI] Demonstrasi seluruh Access Modifier berhasil dijalankan dengan sempurna.\n");
    }
}
