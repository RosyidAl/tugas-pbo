public class KaryawanTetap extends Karyawan {
    private final double gajiPokok;
    private final double tunjangan;

    public KaryawanTetap(String id, String nama, double gajiPokok, double tunjangan) {
        super(id, nama);
        this.gajiPokok = gajiPokok;
        this.tunjangan = tunjangan;
    }

    @Override
    public double hitungGaji() {
        return gajiPokok + tunjangan;
    }

    @Override
    public String getJabatan() {
        return "Karyawan Tetap";
    }
}
