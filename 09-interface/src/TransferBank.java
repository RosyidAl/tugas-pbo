/** Satu class mengimplementasikan dua interface sekaligus. */
public class TransferBank implements Pembayaran, DapatDicetak {
    private final String bankTujuan;
    private double terakhir;

    public TransferBank(String bankTujuan) {
        this.bankTujuan = bankTujuan;
    }

    @Override
    public boolean bayar(double jumlah) {
        if (!Pembayaran.jumlahValid(jumlah)) {
            return false;
        }
        terakhir = jumlah;
        return true;
    }

    @Override
    public double hitungBiayaAdmin(double jumlah) {
        return 6_500;   // tarif tetap
    }

    @Override
    public void cetakStruk() {
        System.out.println("  STRUK TRANSFER ke " + bankTujuan + ": Rp" + String.format("%,.0f", terakhir));
    }
}
