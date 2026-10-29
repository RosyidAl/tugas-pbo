# 05 - Access Modifier

## Konsep
Access modifier menentukan dari mana sebuah atribut, method, atau constructor dapat diakses.

| Modifier | Class sama | Package sama | Subclass beda package | Package lain |
| :--- | :---: | :---: | :---: | :---: |
| `private` | Ya | Tidak | Tidak | Tidak |
| *(default)* | Ya | Ya | Tidak | Tidak |
| `protected` | Ya | Ya | Ya | Tidak |
| `public` | Ya | Ya | Ya | Ya |

Folder ini memakai domain barang toko. Contoh lain dengan domain rekening bank ada di `src/` pada root repo.

## Struktur folder
```
05-access-modifier/
├── README.md
└── src/id/rosyidalansorri/akses/
    ├── toko/
    │   ├── Produk.java         # satu atribut dan satu method untuk tiap level akses
    │   └── Kasir.java          # class lain, package sama dengan Produk
    └── luar/
        ├── ProdukDiskon.java   # subclass Produk di package berbeda
        └── Main.java           # class biasa di package berbeda, entry point
```

## Cara menjalankan
Linux atau macOS:
```bash
cd 05-access-modifier
javac -d bin $(find src -name "*.java")
java -cp bin id.rosyidalansorri.akses.luar.Main
```
Windows (Command Prompt):
```bat
cd 05-access-modifier
dir /s /b src\*.java > sources.txt
javac -d bin @sources.txt
java -cp bin id.rosyidalansorri.akses.luar.Main
```

## Contoh keluaran
```
1. Dari dalam class Produk (semua level):
  hargaModal=Rp70.000, kodeRak=RAK-A1, pemasok=PT Sumber Jaya, nama=Mouse
  method private, method default, method protected, method public

2. Dari Kasir (package sama):
  kodeRak   (default)  : RAK-A1
  pemasok   (protected): PT Sumber Jaya
  nama      (public)   : Mouse
  infoDefault()        : method default

3. Dari ProdukDiskon (subclass, package berbeda):
  pemasok   (protected): PT Sumber Jaya
  nama      (public)   : Mouse
  infoProtected()      : method protected

4. Dari Main (bukan subclass, package berbeda):
  nama (public)  : Mouse
  infoPublic()   : method public
```

## Akses yang ditolak compiler
Baris berikut ada di kode sebagai komentar. Jika komentarnya dibuka, kompilasi gagal dengan pesan yang tertulis (pesan diambil dari `javac` 25).

| Dari | Baris | Pesan |
| :--- | :--- | :--- |
| `Kasir` (package sama) | `p.hargaModal` | `hargaModal has private access in Produk` |
| `ProdukDiskon` (subclass) | `kodeRak` | `kodeRak is not public in Produk; cannot be accessed from outside package` |
| `ProdukDiskon` (subclass) | `hargaModal` | `hargaModal has private access in Produk` |
| `Main` (bukan subclass) | `p.pemasok` | `pemasok has protected access in Produk` |
| `Main` (bukan subclass) | `p.kodeRak` | `kodeRak is not public in Produk; cannot be accessed from outside package` |

## Catatan tentang `protected`
Di package lain, subclass mengakses member `protected` lewat `this` (atau objek bertipe subclass itu sendiri), bukan lewat objek `Produk` biasa. Karena itu `p.pemasok` dari dalam `ProdukDiskon` dengan `p` bertipe `Produk` tetap ditolak. Contohnya ada sebagai komentar di `ProdukDiskon.java`.
