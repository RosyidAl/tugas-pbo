package id.rosyidalansorri;

/**
 * Class PetugasBank berada di dalam package yang sama dengan Rekening (id.rosyidalansorri).
 * Class ini mendemonstrasikan hak akses DEFAULT (Package-Private):
 * - Atribut kodeCabang pada Rekening berstatus DEFAULT, sehingga PetugasBank DAPAT
 *   mengakses dan memodifikasinya secara langsung tanpa perlu getter/setter.
 * - Atribut saldo dan namaPemilik pada Rekening berstatus PRIVATE, sehingga PetugasBank
 *   TIDAK BISA mengaksesnya secara langsung.
 * - Method berstatus PROTECTED pada Rekening juga DAPAT diakses karena masih satu package.
 * 
 * @author Rosyid Al Ansorri (NIM: L0125065)
 */
public class PetugasBank {
    private String idPetugas;
    private String namaPetugas;

    public PetugasBank(String idPetugas, String namaPetugas) {
        this.idPetugas = idPetugas;
        this.namaPetugas = namaPetugas;
    }

    public String getIdPetugas() {
        return idPetugas;
    }

    public String getNamaPetugas() {
        return namaPetugas;
    }

    /**
     * Mendemonstrasikan akses langsung ke atribut DEFAULT (kodeCabang) pada objek Rekening.
     * Karena berada dalam satu package (id.rosyidalansorri), atribut default dapat dibaca dan diubah.
     * 
     * @param rek Objek Rekening yang ingin diubah cabangnya
     * @param kodeCabangBaru Kode cabang tujuan mutasi administrasi
     */
    public void ubahKodeCabang(Rekening rek, String kodeCabangBaru) {
        System.out.println("\n--- [DEMO DEFAULT MODIFIER - DALAM SATU PACKAGE] ---");
        System.out.printf("Petugas %s (%s) sedang memperbarui kode cabang nasabah %s...%n",
                this.namaPetugas, this.idPetugas, rek.getNamaPemilik());

        // AKSES DIIZINKAN: Membaca atribut default kodeCabang langsung
        String cabangLama = rek.kodeCabang;

        // AKSES DIIZINKAN: Mengubah atribut default kodeCabang langsung tanpa setter
        rek.kodeCabang = kodeCabangBaru;

        System.out.printf("[SUKSES] Akses atribut default 'kodeCabang' berhasil: %s -> %s%n",
                cabangLama, rek.kodeCabang);
    }

    /**
     * Demonstrasi bahwa PetugasBank juga dapat memanggil method PROTECTED
     * karena berada dalam package yang sama.
     */
    public void inspeksiRekening(Rekening rek) {
        System.out.println("\n--- [DEMO PROTECTED MODIFIER - DALAM SATU PACKAGE] ---");
        System.out.printf("Petugas %s memanggil method internal (protected) rekening:%n", this.namaPetugas);
        // AKSES DIIZINKAN: method protected dapat dipanggil dalam satu package
        rek.infoInternalRekening();
    }

    /**
     * Catatan demonstrasi akses atribut PRIVATE:
     * Jika kode di bawah ini diaktifkan (uncomment), compiler Java akan menolak dengan error:
     * "saldo has private access in id.rosyidalansorri.Rekening"
     */
    public void cobaAksesAtributPrivate(Rekening rek) {
        // rek.saldo = 100_000_000; // COMPILE ERROR: saldo private!
        // String nama = rek.namaPemilik; // COMPILE ERROR: namaPemilik private!
    }
}
