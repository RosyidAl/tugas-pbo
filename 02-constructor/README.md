# 02 - Constructor

## Konsep
Constructor adalah method khusus yang dipanggil saat objek dibuat dengan `new`. Namanya sama dengan nama class dan tidak punya tipe kembalian.

Jenis yang dicontohkan:
1. **Constructor tanpa parameter** (`Buku()`): mengisi nilai bawaan.
2. **Constructor berparameter** (`Buku(judul, penulis, tahunTerbit, harga)`): mengisi atribut dari argumen.
3. **Overloading constructor**: beberapa constructor dengan daftar parameter berbeda dalam satu class.
4. **Constructor chaining** dengan `this(...)`: satu constructor memanggil constructor lain di class yang sama. Pemanggilan `this(...)` harus menjadi baris pertama.
5. **Copy constructor** (`Buku(Buku asal)`): membuat objek baru dari nilai objek lain, sehingga perubahan pada salinan tidak memengaruhi objek asli.

Bila sebuah class tidak mendefinisikan constructor sama sekali, compiler menyediakan constructor tanpa parameter. Begitu ada satu constructor yang ditulis sendiri, constructor bawaan itu tidak dibuat lagi.

## Struktur folder
```
02-constructor/
├── README.md
└── src/
    ├── Buku.java    # empat constructor, saling memanggil dengan this(...)
    └── Main.java    # memanggil tiap constructor
```

## Cara menjalankan
```bash
cd 02-constructor
javac -d bin src/*.java
java -cp bin Main
```

## Contoh keluaran
```
1. Constructor tanpa parameter
  [Buku(judul, penulis, tahunTerbit, harga)] dipanggil
  [Buku()] dipanggil
  "Tanpa Judul" oleh Anonim (2000), Rp0

2. Constructor dua parameter (chaining ke constructor lengkap)
  [Buku(judul, penulis, tahunTerbit, harga)] dipanggil
  [Buku(judul, penulis)] dipanggil
  "Pemrograman Java" oleh Rosyid (2024), Rp50,000

3. Constructor lengkap
  [Buku(judul, penulis, tahunTerbit, harga)] dipanggil
  "Struktur Data" oleh Budi (2021), Rp85,000

4. Copy constructor
  [Buku(judul, penulis, tahunTerbit, harga)] dipanggil
  [Buku(Buku)] dipanggil
  asli   :  "Struktur Data" oleh Budi (2021), Rp85,000
  salinan:  "Struktur Data (Salinan)" oleh Budi (2021), Rp85,000
```
Format angka (`50,000` atau `50.000`) mengikuti locale sistem.

## Poin yang ditunjukkan
- Pada `new Buku()`, pesan constructor lengkap muncul lebih dulu daripada `[Buku()]`. Sebab `this(...)` dijalankan sebelum sisa badan constructor.
- Semua pengisian atribut berada di satu constructor (yang lengkap). Constructor lain hanya menyiapkan argumen, sehingga aturan inisialisasi tidak tersebar.
- Pada copy constructor, mengubah judul `salinan` tidak mengubah judul `c`.
