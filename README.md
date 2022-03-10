# Kuis-1-PBO 👨‍💻

Repository ini berisi program aplikasi java sederhana dengan tema Perpustakaan. Aplikasi ini ditujukan untuk pemenuhan tugas matkul Pemrograman Berorientasi Objek.

Nama: Muhammad Wafa
<br>
NPM: 2015061057

<br>

## Penjelasan singkat kode 
Pada projek java ini terdapat 9 Class yang dikelompokkan sesuai kegunaan dalam package berikut:

Package main:

- Main.java -> tempat dimana main method berada untuk menjalankan program

Package user:

- User.java -> sebagai parent class untuk Admin.java dan LibraryMember
- Admin.java -> kelas admin yang memiliki method untuk tambah buku baru dan merubah data buku
- LibraryMember.java -> kelas member biasa yang dapat meminjam dan mengembalikan buku


Package library:

- Library.java -> kelas yang berisi keseluruhan sistem perpustakaan
- Book.java -> kelas yang merepresentasikan objek dari buku yang ada pada perpustakaan dan dapat dipinjam oleh user bertipe member
- Transaction.java -> kelas untuk menampung transaksi dari member baik peminjaman ataupun pengembalian.
- LoginManager.java -> static kelas untuk menangani login dan signup user. User akan diarahkan ke method adminMenu() atau memberMenu() pada kelas Library.java jika berhasil login.

Package dummy:

- DummyData.java -> static class untuk generate data list buku perpustakaan. Dibuat terpisah agar tidak terlalu banyak kode pada kelas Library.java
