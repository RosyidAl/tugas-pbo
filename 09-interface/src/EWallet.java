public class EWallet implements Pembayaran {
    private double saldo;

    public EWallet(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean bayar(double jumlah) {
        double total = jumlah + hitungBiayaAdmin(jumlah);
        if (!Pembayaran.jumlahValid(jumlah) || total > saldo) {
            return false;
        }
        saldo -= total;
        return true;
    }

    @Override
    public double hitungBiayaAdmin(double jumlah) {
        return jumlah * 0.007;   // 0,7% dari jumlah
    }

    // Default method di-override agar format ringkasan berbeda.
    @Override
    public String ringkasan(double jumlah) {
        return "E-Wallet: " + Pembayaran.super.ringkasan(jumlah) + ", sisa saldo "
                + String.format("%,.0f", saldo);
    }
}
