package jadwalharian.app

import jadwalharian.manager.ManajerJadwal

fun main() {
    val manajer = ManajerJadwal()

    println("====================================================")
    println("      SELAMAT DATANG DI APLIKASI JADWAL HARIAN      ")
    println("====================================================")

    while (true) {
        tampilkanMenu()
        print("Masukkan pilihan Anda (1-5) : ")
        val pilihan = readLine()

        var butuhJeda = true

        when (pilihan) {
            "1" -> manajer.tambahKegiatan()
            "2" -> manajer.lihatJadwal()
            "3" -> manajer.ubahKegiatan()
            "4" -> manajer.hapusKegiatan()
            "5" -> {
                println("\nTerima kasih telah menggunakan aplikasi ini")
                return
            }
            else -> {
                println("\nPilihan tidak valid. Silahkan pilih dari nomor 1 sampai 5.")
                butuhJeda = false
            }
        }

        if (butuhJeda) {
            println("\nTekan Enter untuk kembali ke menu utama ...")
            readLine()
        }
    }
}

fun tampilkanMenu() {
    println("\n======== MENU UTAMA ========")
    println("1. Tambah Kegiatan Baru")
    println("2. Lihat Seluruh Jadwal")
    println("3. Ubah Kegiatan")
    println("4. Hapus Kegiatan")
    println("5. Keluar")
    println("============================")
}