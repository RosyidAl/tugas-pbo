public class KaryawanKontrak extends Karyawan {
    private final double upahPerJam;
    private final int jamKerja;

    public KaryawanKontrak(String id, String nama, double upahPerJam, int jamKerja) {
        super(id, nama);
        this.upahPerJam = upahPerJam;
        this.jamKerja = jamKerja;
    }

    @Override
    public double hitungGaji() {
        return upahPerJam * jamKerja;
    }

    @Override
    public String getJabatan() {
        return "Karyawan Kontrak (" + jamKerja + " jam)";
    }
}
