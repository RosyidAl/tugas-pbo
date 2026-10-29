package id.rosyidalansorri.gudang;

/** Barang dari sudut pandang gudang: yang dicatat adalah stok. */
public class Barang {
    private final String nama;
    private int stok;

    public Barang(String nama, int stok) {
        this.nama = nama;
        this.stok = stok;
    }

    public String ringkasan() {
        return "[gudang] " + nama + ", stok " + stok;
    }
}
