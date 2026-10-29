# 01 - Class dan Objek

## Konsep
- **Class** adalah cetak biru yang mendefinisikan atribut (data) dan method (perilaku).
- **Objek** adalah instans dari class, dibuat dengan keyword `new`. Setiap objek menyimpan nilai atributnya sendiri.
- Variabel bertipe class menyimpan **referensi** ke objek. Menyalin variabel menyalin referensinya, bukan objeknya.

## Struktur folder
```
01-class-dan-objek/
├── README.md
└── src/
    ├── Mahasiswa.java   # class dengan atribut nama, nim, ipk dan dua method
    └── Main.java        # membuat objek, memakai method, menunjukkan referensi dan null
```

## Cara menjalankan
```bash
cd 01-class-dan-objek
javac -d bin src/*.java
java -cp bin Main
```

## Contoh keluaran
```
Halo, saya Rosyid (NIM L0125065)
Halo, saya Budi (NIM L0125001)
Rosyid lulus syarat beasiswa? true
Budi lulus syarat beasiswa? false
mhs1.nama setelah mhs3.nama diubah: Rosyid Al Ansorri
mhs1 == mhs3 (referensi sama)? true
mhs1 == mhs2 (referensi sama)? false
kosong == null? true
```

## Poin yang ditunjukkan
| Bagian kode | Penjelasan |
| :--- | :--- |
| `new Mahasiswa()` dua kali | Dua objek terpisah dari satu class, masing-masing punya `nama`, `nim`, `ipk` sendiri. |
| `mhs3 = mhs1` | `mhs3` dan `mhs1` menunjuk objek yang sama. Mengubah `mhs3.nama` ikut mengubah `mhs1.nama`. |
| `mhs1 == mhs2` | `==` pada objek membandingkan referensi, bukan isi. Hasilnya `false` walaupun tipenya sama. |
| `Mahasiswa kosong = null` | Variabel referensi yang belum menunjuk objek bernilai `null`. Memanggil method lewat `null` menghasilkan `NullPointerException`. |

## Catatan
Atribut pada contoh ini tidak diberi access modifier agar kodenya singkat. Cara melindungi atribut dibahas di folder `03-enkapsulasi`.
