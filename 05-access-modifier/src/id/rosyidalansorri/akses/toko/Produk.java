package id.rosyidalansorri.akses.toko;

/** Empat level akses pada satu class. */
public class Produk {
    private String hargaModal = "Rp70.000";     // hanya di class Produk
    String kodeRak = "RAK-A1";                  // default: se-package
    protected String pemasok = "PT Sumber Jaya"; // se-package dan subclass
    public String nama = "Mouse";               // dari mana saja

    private String infoPrivate() {
        return "method private";
    }

    String infoDefault() {
        return "method default";
    }

    protected String infoProtected() {
        return "method protected";
    }

    public String infoPublic() {
        return "method public";
    }

    // Di dalam class yang sama, semua member terlihat.
    public void semuaDariDalam() {
        System.out.println("  hargaModal=" + hargaModal + ", kodeRak=" + kodeRak
                + ", pemasok=" + pemasok + ", nama=" + nama);
        System.out.println("  " + infoPrivate() + ", " + infoDefault() + ", "
                + infoProtected() + ", " + infoPublic());
    }
}
