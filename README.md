# Kuis-1-PBO 👨‍💻

Repository ini berisi program aplikasi java sederhana dengan tema Perpustakaan. Aplikasi ini ditujukan untuk pemenuhan tugas matkul Pemrograman Berorientasi Objek.

Nama: Muhammad Wafa
<br>
NPM: 2015061057

## Table of Contents 
- [Fitur Program](#fitur-program)
- [Alur Program](#alur-program)
  * [Sebagai user Admin](#sebagai-user-admin)
  * [Sebagai user Anggota Perpustakaan](#sebagai-user-anggota-perpustakaan)
- [Penjelasan singkat kode](#penjelasan-singkat-kode)

<br>

## Fitur Program
- 2 user: Admin, Anggota Perpustakaan
- Login Manager: untuk login, signup dan logout
- Fitur admin: tambah buku, update data buku, lihat transaksi yang dilakukan anggota perpustakaan
- Fitur anggota: meminjam buku, mengembalikan buku, lihat riwayat peminjaman, lihat daftar buku baik keseluruhan / berdasarkan abjad

<br>

## Alur Program
Note: 
- Sample Admin: username = admin, password admin1234
- Sample Anggota: username = wafa01, password = 12345678 


### Sebagai user Admin
1. login, menginput input username dan password
2. Untuk admin tidak bisa sign up, jika signup maka akan otomatis menjadi user kategori anggota perpustakaan
3. Pada menu admin terdapat 5 pilihan yaitu:
    - Tambah Buku
    - Update Informasi Buku
    - Tampilkan Daftar Buku
    - Tampilkan Daftar Transaksi
    - Logout 
5. Jika memilih 1 (Tambah Buku) maka admin akan menginput data buku baru, mulai dari judul, kategori, penulis dan Tahun Rilis
6. Jika memilih 2 (Update Informasi Buku) maka 
    - Admin perlu memilih terlebih dahulu buku yang ingin di update
    - Buku dapat ditampilkan secara seluruh / berdasarkan abjad saja
    - Setelah memilih, maka admin perlu menginput ulang data buku
    - Jika tidak ingin merubah salah satu atribut buku, maka dapat menginput "-" (strip)
7. Pilihan 3 untuk menampilkan seluruh daftar buku
8. Pilihan 4 untuk menampilkan seluruh transaksi baik peminjaman / pengembalian yang dilakukan oleh user bertipe Anggota Perpustakaan
9. Logout untuk keluar dari menu admin dan kembali ke menu Login / Signup


### Sebagai user Anggota Perpustakaan
1. login, menginput input username dan password
2. Signup jika tidak punya akun, kemudian login kembali
3. Pada menu Anggota Perpustakaan terdapat 5 pilihan yaitu
    - Melihat daftar buku
    - Meminjam Buku
    - Mengembalikan Buku
    - Melihat Riwayat Peminjaman
    - Logout
4. Pilihan 1 untuk menampilkan seluruh daftar buku
5. Jika user memilih 2, maka akan diarahkan ke menu peminjaman
    - Pertama user memilih buku
    - Buku dapat ditampilkan secara seluruh / berdasarkan abjad saja
    - Jika telah memilih dan telah meng-konfirmasi pilihan, maka user telah tercata meminjam buku
    - User tidak dapat meminjam buku lagi, jika buku belum dikembalikan
6. Pilihan 3 untuk mengembalikan buku
7. Pilihan 4 untuk melihat riwayat buku yang pernah dipinjam
8. Logout untuk keluar dari menu dan kembali ke menu login / signup

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
