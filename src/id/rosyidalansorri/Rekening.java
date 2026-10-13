package id.rosyidalansorri;

/**
 * Class Rekening merepresentasikan akun perbankan dasar.
 * Class ini mendemonstrasikan konsep enkapsulasi dan penggunaan berbagai access modifier:
 * - private: untuk atribut namaPemilik dan saldo (data sensitif)
 * - default (package-private): untuk atribut kodeCabang
 * - protected: untuk method terapkanBunga() dan infoInternalRekening()
 * - public: untuk constructor, getter, dan method operasional setor() serta tarik()
 * 
 * @author Rosyid Al Ansorri (NIM: L0125065)
 */
public class Rekening {
    // 1. PRIVATE: Hanya bisa diakses di dalam class Rekening ini saja.
    // Atribut saldo tidak boleh diubah secara langsung dari luar untuk menjaga integritas data.
    private String namaPemilik;
    private double saldo;

    // 2. DEFAULT (Package-Private): Tidak ada keyword modifier.
    // Hanya bisa diakses oleh class-class yang berada dalam package yang sama (id.rosyidalansorri).
    String kodeCabang;

    /**
     * Constructor public agar objek Rekening dapat diinstansiasi dari package manapun.
     * 
     * @param namaPemilik Nama pemilik rekening
     * @param saldoAwal Saldo pembukaan awal rekening
     * @param kodeCabang Kode kantor cabang pendaftaran rekening
     */
    public Rekening(String namaPemilik, double saldoAwal, String kodeCabang) {
        this.namaPemilik = namaPemilik;
        if (saldoAwal >= 0) {
            this.saldo = saldoAwal;
        } else {
            System.out.println("[PERINGATAN] Saldo awal tidak boleh negatif. Saldo disetel ke Rp0.");
            this.saldo = 0;
        }
        this.kodeCabang = kodeCabang;
    }

    // ================= PUBLIC GETTER & OPERATIONAL METHODS =================

    /**
     * Getter public untuk mengakses namaPemilik dari luar class.
     */
    public String getNamaPemilik() {
        return namaPemilik;
    }

    /**
     * Getter public untuk memeriksa saldo dari luar class.
     * Nilai saldo hanya bisa dibaca, tidak dapat diubah secara langsung.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Getter public untuk membaca kode cabang.
     */
    public String getKodeCabang() {
        return kodeCabang;
    }

    /**
     * Method public untuk menyetor uang ke rekening.
     * Saldo hanya boleh bertambah melalui method ini.
     * 
     * @param jumlah Nominal yang ingin disetor
     */
    public void setor(double jumlah) {
        if (jumlah > 0) {
            this.saldo += jumlah;
            System.out.printf("[SETOR BERHASIL] Rekening %s (+Rp%,.2f) -> Saldo Sekarang: Rp%,.2f%n",
                    this.namaPemilik, jumlah, this.saldo);
        } else {
            System.out.println("[SETOR GAGAL] Jumlah setoran harus lebih besar dari 0.");
        }
    }

    /**
     * Method public untuk menarik uang dari rekening.
     * Saldo hanya boleh berkurang melalui method ini dengan validasi saldo mencukupi.
     * 
     * @param jumlah Nominal yang ingin ditarik
     * @return boolean Status keberhasilan penarikan
     */
    public boolean tarik(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("[TARIK GAGAL] Nominal penarikan harus lebih besar dari 0.");
            return false;
        }
        if (jumlah > this.saldo) {
            System.out.printf("[TARIK DITOLAK] Saldo tidak mencukupi! Saldo saat ini: Rp%,.2f, Permintaan: Rp%,.2f%n",
                    this.saldo, jumlah);
            return false;
        }

        this.saldo -= jumlah;
        System.out.printf("[TARIK BERHASIL] Rekening %s (-Rp%,.2f) -> Sisa Saldo: Rp%,.2f%n",
                this.namaPemilik, jumlah, this.saldo);
        return true;
    }

    // ================= PROTECTED METHODS =================

    /**
     * Method protected: Hanya dapat diakses oleh class dalam package yang sama (id.rosyidalansorri)
     * dan oleh subclass (turunan) di package manapun (misal: RekeningPrioritas di package prioritas).
     * 
     * @param persen Persentase bunga yang akan ditambahkan ke saldo
     */
    protected void terapkanBunga(double persen) {
        if (persen > 0) {
            double nominalBunga = this.saldo * (persen / 100.0);
            this.saldo += nominalBunga;
            System.out.printf("[PROTECTED - BUNGA] Menerapkan bunga %.2f%% (+Rp%,.2f) ke rekening %s -> Saldo Baru: Rp%,.2f%n",
                    persen, nominalBunga, this.namaPemilik, this.saldo);
        } else {
            System.out.println("[PROTECTED - BUNGA] Persentase bunga harus positif.");
        }
    }

    /**
     * Method protected: Memberikan akses informasi internal rekening bagi subclass atau class se-package.
     */
    protected void infoInternalRekening() {
        System.out.printf("[PROTECTED - INFO INTERNAL] Pemilik: %s | Saldo: Rp%,.2f | Cabang: %s%n",
                this.namaPemilik, this.saldo, this.kodeCabang);
    }
}
