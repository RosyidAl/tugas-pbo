# 03 - Enkapsulasi

## Konsep
Enkapsulasi menyembunyikan data di dalam class dan hanya membuka akses lewat method. Caranya:
1. Atribut dideklarasikan `private`.
2. Akses baca lewat *getter*, akses tulis lewat *setter*.
3. Setter memeriksa nilai sebelum menyimpan, sehingga objek tidak masuk ke keadaan yang tidak valid.

Manfaat yang konkret pada contoh ini: IPK tidak bisa diisi di luar rentang 0,0 sampai 4,0, dan NIM tidak bisa diubah setelah objek dibuat.

## Struktur folder
```
03-enkapsulasi/
├── README.md
└── src/
    ├── Mahasiswa.java   # atribut private, getter/setter dengan validasi
    └── Main.java        # memakai nilai valid dan tidak valid
```

## Cara menjalankan
```bash
cd 03-enkapsulasi
javac -d bin src/*.java
java -cp bin Main
```

## Contoh keluaran
```
L0125065 | Rosyid | 3.6 | Cum Laude

Setter dengan nilai valid:
  IPK sekarang 3.2, predikat Sangat Memuaskan

Setter dengan nilai tidak valid:
  [DITOLAK] IPK 5.0 di luar rentang 0.0 sampai 4.0.
  [DITOLAK] Nama tidak boleh kosong.
  IPK tetap 3.2, nama tetap Rosyid
```

## Poin yang ditunjukkan
| Elemen | Cara enkapsulasi |
| :--- | :--- |
| `nim` | `private final`, hanya ada getter. Nilainya tetap sejak constructor. |
| `nama` | `setNama` menolak string kosong dan membuang spasi di tepi. |
| `ipk` | `setIpk` menolak nilai di luar 0,0 sampai 4,0. |
| `getPredikat()` | Nilai turunan dihitung dari `ipk`, tidak disimpan sebagai atribut sehingga tidak bisa tidak sinkron. |

Constructor memanggil setter (`setNama`, `setIpk`) supaya validasi yang sama berlaku saat objek dibuat. Bila nilai awal ditolak, atribut tetap pada nilai bawaan (`null` untuk `nama`, `0.0` untuk `ipk`). Pada contoh ini tidak ada pengecualian yang dilempar, hanya pesan ke konsol.

Akses langsung seperti `mhs.ipk = 9.9;` gagal kompilasi dengan pesan `ipk has private access in Mahasiswa`.
