package id.rosyidalansorri.util;

/** Class utilitas: seluruh member static, tidak perlu dibuat objeknya. */
public class FormatRupiah {
    private FormatRupiah() {
        // Constructor private mencegah instansiasi.
    }

    public static String format(double nilai) {
        return String.format("Rp%,.0f", nilai);
    }
}
