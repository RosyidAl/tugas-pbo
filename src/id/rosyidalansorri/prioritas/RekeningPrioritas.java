package id.rosyidalansorri.prioritas;

import id.rosyidalansorri.Rekening;

/**
 * Class RekeningPrioritas berada di dalam package yang BERBEDA (id.rosyidalansorri.prioritas)
 * dan merupakan SUBCLASS (turunan) dari class Rekening.
 * 
 * Class ini mendemonstrasikan:
 * 1. PROTECTED: Subclass dapat mengakses method/atribut protected dari superclass
 *    (terapkanBunga() dan infoInternalRekening()), meskipun berada di package berbeda.
 * 2. DEFAULT: Subclass TIDAK DAPAT mengakses atribut default (kodeCabang) superclass
 *    karena berada di package berbeda.
 * 3. PRIVATE: Subclass TIDAK DAPAT mengakses atribut private (saldo, namaPemilik).
 * 
 * @author Rosyid Al Ansorri (NIM: L0125065)
 */
public class RekeningPrioritas extends Rekening {
    private String levelPrioritas; // Contoh: "Gold", "Platinum", "Diamond"
    private double fasilitasOverdraft;

    /**
     * Constructor RekeningPrioritas memanggil superconstructor dari class Rekening.
     */
    public RekeningPrioritas(String namaPemilik, double saldoAwal, String kodeCabang, String levelPrioritas, double fasilitasOverdraft) {
        super(namaPemilik, saldoAwal, kodeCabang);
        this.levelPrioritas = levelPrioritas;
        this.fasilitasOverdraft = fasilitasOverdraft;
    }

    public String getLevelPrioritas() {
        return levelPrioritas;
    }

    public double getFasilitasOverdraft() {
        return fasilitasOverdraft;
    }

    /**
     * Mendemonstrasikan pemanggilan method PROTECTED dari superclass di package berbeda.
     * Method terapkanBunga() berstatus protected di class Rekening.
     * Sebagai subclass, RekeningPrioritas BERHAK memanggil method ini.
     * 
     * @param persenPersentase Bunga eksklusif nasabah prioritas
     */
    public void berikanBungaPrioritas(double persenPersentase) {
        System.out.println("\n--- [DEMO PROTECTED MODIFIER - SUBCLASS BEDA PACKAGE] ---");
        System.out.printf("Nasabah Prioritas (%s) menerima bunga bulanan spesial...%n", this.levelPrioritas);

        // AKSES DIIZINKAN: Memanggil method protected dari superclass
        super.terapkanBunga(persenPersentase);
    }

    /**
     * Mendemonstrasikan pemanggilan method PROTECTED infoInternalRekening() dari superclass.
     */
    public void tampilkanProfilPrioritas() {
        System.out.println("\n--- [DEMO PROTECTED METHOD - INFO INTERNAL] ---");
        System.out.println("Memanggil super.infoInternalRekening() dari subclass:");
        // AKSES DIIZINKAN: Subclass dapat memanggil method protected superclass
        super.infoInternalRekening();
        System.out.printf("Tingkat Layanan: %s Priority | Batas Overdraft: Rp%,.2f%n",
                this.levelPrioritas, this.fasilitasOverdraft);
    }

    /**
     * Catatan demonstrasi batasan hak akses:
     * 
     * 1. Mencoba mengakses atribut DEFAULT (kodeCabang) dari subclass di luar package:
     *    this.kodeCabang = "CBG-099"; 
     *    // ERROR COMPILE: kodeCabang is not public in Rekening; cannot be accessed from outside package
     * 
     * 2. Mencoba mengakses atribut PRIVATE (saldo) langsung:
     *    this.saldo += 1000000;
     *    // ERROR COMPILE: saldo has private access in Rekening
     */
    public void demonstrasiBatasanSubclass() {
        // String cbg = this.kodeCabang; // COMPILE ERROR: atribut default tidak diwariskan lintas package!
        // double s = this.saldo;        // COMPILE ERROR: atribut private tidak bisa diakses!
    }
}
