/**
 * Enkapsulasi: atribut dibuat private, akses lewat method public
 * sehingga class dapat memeriksa nilai sebelum disimpan.
 */
public class Mahasiswa {
    private final String nim;   // hanya baca: tidak ada setter
    private String nama;
    private double ipk;

    public Mahasiswa(String nim, String nama, double ipk) {
        this.nim = nim;
        setNama(nama);
        setIpk(ipk);
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("  [DITOLAK] Nama tidak boleh kosong.");
            return;
        }
        this.nama = nama.trim();
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        if (ipk < 0.0 || ipk > 4.0) {
            System.out.println("  [DITOLAK] IPK " + ipk + " di luar rentang 0.0 sampai 4.0.");
            return;
        }
        this.ipk = ipk;
    }

    // Nilai turunan dihitung dari data private, tidak disimpan sebagai atribut.
    public String getPredikat() {
        if (ipk >= 3.5) {
            return "Cum Laude";
        } else if (ipk >= 3.0) {
            return "Sangat Memuaskan";
        }
        return "Memuaskan";
    }
}
