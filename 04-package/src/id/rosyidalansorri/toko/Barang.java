package id.rosyidalansorri.toko;

/** Barang dari sudut pandang toko: yang dicatat adalah harga jual. */
public class Barang {
    private final String nama;
    private final double harga;

    public Barang(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String ringkasan() {
        return "[toko] " + nama + ", harga " + id.rosyidalansorri.util.FormatRupiah.format(harga);
    }
}
