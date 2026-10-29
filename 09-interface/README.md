# 09 - Interface

## Konsep
Interface adalah kontrak berisi daftar method yang harus dimiliki class pelaksananya. Class memakainya dengan `implements`, dan satu class boleh mengimplementasikan lebih dari satu interface.

Isi interface (Java 8 ke atas):
| Elemen | Keterangan |
| :--- | :--- |
| Konstanta | Atribut otomatis `public static final`. |
| Method abstract | Otomatis `public abstract`. Wajib diimplementasikan. |
| `default` method | Punya badan, boleh di-override. Menambah method ke interface tanpa merusak class lama. |
| `static` method | Dipanggil lewat nama interface, tidak diwariskan ke class pelaksana. |

Interface tidak dapat diinstansiasi dan tidak punya constructor atau atribut instans.

## Struktur folder
```
09-interface/
├── README.md
└── src/
    ├── Pembayaran.java     # interface: abstract, default, static, konstanta
    ├── DapatDicetak.java   # interface kedua
    ├── TransferBank.java   # implements Pembayaran, DapatDicetak
    ├── EWallet.java        # implements Pembayaran, meng-override default method
    └── Main.java
```

## Cara menjalankan
```bash
cd 09-interface
javac -d bin src/*.java
java -cp bin Main
```

## Contoh keluaran
```
1. Transfer bank (Pembayaran + DapatDicetak)
  Total 256,500 (termasuk admin 6,500)
  Hasil: berhasil
  STRUK TRANSFER ke BNI: Rp250,000

2. E-wallet (hanya Pembayaran), saldo cukup
  E-Wallet: Total 100,700 (termasuk admin 700), sisa saldo 500,000
  Hasil: berhasil

3. E-wallet, saldo tidak cukup
  E-Wallet: Total 100,700 (termasuk admin 700), sisa saldo 50,000
  Hasil: gagal

4. Static method dan konstanta interface
  Pembayaran.jumlahValid(-5)    = false
  Pembayaran.BIAYA_ADMIN_MINIMAL = 0.0
```

## Poin yang ditunjukkan
- `prosesPembayaran(Pembayaran metode, ...)` menerima `TransferBank` maupun `EWallet`. Method ini hanya bergantung pada kontrak, bukan pada class tertentu.
- `TransferBank` mengimplementasikan dua interface sekaligus. Hal yang sama tidak mungkin dengan `extends` pada class.
- `EWallet` meng-override `ringkasan()` dan memanggil versi default lewat `Pembayaran.super.ringkasan(jumlah)`.
- `Pembayaran.jumlahValid(...)` dipanggil dari nama interface. `BIAYA_ADMIN_MINIMAL` dibaca sebagai konstanta.
- Pada langkah 2 dan 3, `ringkasan()` dicetak sebelum `bayar()` dijalankan, sehingga saldo yang tampil adalah saldo sebelum pembayaran.
- `new Pembayaran()` ditolak compiler: `Pembayaran is abstract; cannot be instantiated`.
