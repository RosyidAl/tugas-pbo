# 04 - Package

## Konsep
Package mengelompokkan class terkait dan memberi ruang nama (*namespace*). Dua class boleh bernama sama selama berada di package berbeda.

- Deklarasi: `package id.rosyidalansorri.gudang;` di baris pertama berkas.
- Struktur direktori harus mengikuti nama package: `id/rosyidalansorri/gudang/Barang.java`.
- Penamaan memakai domain terbalik (`id.` + nama), huruf kecil semua, mengikuti konvensi penamaan package Java.
- Class di package lain dipakai lewat `import` atau nama lengkap (*fully qualified name*).

## Struktur folder
```
04-package/
├── README.md
├── PANDUAN-COMPILE.md            # cara compile, jalankan, JAR, dan daftar error
└── src/id/rosyidalansorri/
    ├── gudang/Barang.java        # Barang versi gudang (stok)
    ├── toko/Barang.java          # Barang versi toko (harga), nama class sama
    ├── util/FormatRupiah.java    # class utilitas dengan method static
    └── app/Main.java             # entry point, memakai ketiganya
```

## Cara menjalankan
Linux atau macOS:
```bash
cd 04-package
javac -d bin $(find src -name "*.java")
java -cp bin id.rosyidalansorri.app.Main
```
Windows (Command Prompt):
```bat
cd 04-package
dir /s /b src\*.java > sources.txt
javac -d bin @sources.txt
java -cp bin id.rosyidalansorri.app.Main
```
Class yang berada dalam package dijalankan dengan nama lengkapnya.

Penjelasan opsi `-d` dan `-cp`, compile bertahap, `-sourcepath`, pembuatan JAR, pemakaian package dari program lain, dan daftar error umum ada di [PANDUAN-COMPILE.md](PANDUAN-COMPILE.md).

## Contoh keluaran
```
[gudang] Keyboard, stok 40
[toko] Keyboard, harga Rp350,000
Harga lewat static import: Rp1,250,000
Package gudang.Barang : id.rosyidalansorri.gudang
Package toko.Barang   : id.rosyidalansorri.toko
Nama lengkap class    : id.rosyidalansorri.toko.Barang
```

## Poin yang ditunjukkan
| Cara | Contoh di kode | Keterangan |
| :--- | :--- | :--- |
| Import satu class | `import id.rosyidalansorri.gudang.Barang;` | Setelah itu cukup menulis `Barang`. |
| Nama lengkap | `id.rosyidalansorri.toko.Barang` | Dipakai ketika nama sederhana sudah terpakai oleh import lain. Mengimpor kedua class bernama `Barang` sekaligus ditolak compiler. |
| Static import | `import static ...FormatRupiah.format;` | Method static dipanggil sebagai `format(...)` tanpa nama class. |
| Import wildcard | `import id.rosyidalansorri.util.*;` (tidak dipakai di contoh) | Mengimpor semua class di package, tidak termasuk subpackage. |

`FormatRupiah` memakai constructor `private` agar tidak dibuat objeknya, karena seluruh membernya `static`.

Class yang tidak punya deklarasi `package` berada di *default package* dan tidak dapat di-import dari package bernama.
