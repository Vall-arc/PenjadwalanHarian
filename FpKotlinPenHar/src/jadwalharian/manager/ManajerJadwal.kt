package jadwalharian.manager

import jadwalharian.model.Kegiatan

/**
 * Kelas ini bertanggung jawab untuk mengelola semua logika jadwal.
 */
class ManajerJadwal {
    private val daftarKegiatan = mutableListOf<Kegiatan>()

    fun tambahKegiatan() {
        println("\n-- Tambah Kegiatan Baru --")
        val nama = mintaInput("Nama Kegiatan: ")
        val deskripsi = mintaInput("Deskripsi Singkat: ")
        val waktu = mintaInput("Waktu Kegiatan : ")
        val kegiatanBaru = Kegiatan(nama, deskripsi, waktu)
        daftarKegiatan.add(kegiatanBaru)

        println("\n>> SUKSES! Kegiatan '${kegiatanBaru.nama}' telah ditambahkan ke jadwal Anda.")
    }

    fun lihatJadwal() {
        println("\n📅 --- JADWAL HARIAN ANDA --- 📅")
        if (daftarKegiatan.isEmpty()) {
            println("Jadwal Anda masih kosong. Silakan tambah kegiatan baru.")
        } else {
            val jadwalTerurut = daftarKegiatan.sortedBy { it.waktu }

            jadwalTerurut.forEachIndexed { index, kegiatan ->
                println("------------------------------------")
                println("No. ${index + 1}")
                println(kegiatan)
            }
            println("------------------------------------")
        }
    }

    fun ubahKegiatan() {
        if (daftarKegiatan.isEmpty()) {
            println("\nTidak ada kegiatan yang bisa diubah.")
            return
        }

        lihatJadwal()
        print("\nPilih nomor kegiatan yang akan diubah: ")
        val pilihan = readLine()?.toIntOrNull()
        val index = if (pilihan != null) pilihan - 1 else -1

        if (index in daftarKegiatan.indices) {
            val kegiatanUntukDiedit = daftarKegiatan[index]
            println("\n--- Mengubah Kegiatan: '${kegiatanUntukDiedit.nama}' ---")
            println("(Tekan Enter untuk melewati jika tidak ada perubahan)")

            val namaBaru = mintaInput("Nama Baru (${kegiatanUntukDiedit.nama}): ", kosongDiizinkan = true)
            if (namaBaru.isNotBlank()) kegiatanUntukDiedit.nama = namaBaru

            val deskripsiBaru = mintaInput("Deskripsi Baru (${kegiatanUntukDiedit.deskripsi}): ", kosongDiizinkan = true)
            if (deskripsiBaru.isNotBlank()) kegiatanUntukDiedit.deskripsi = deskripsiBaru

            val waktuBaru = mintaInput("Waktu Kegiatan Baru (${kegiatanUntukDiedit.waktu}): ", kosongDiizinkan = true)
            if (waktuBaru.isNotBlank()) kegiatanUntukDiedit.waktu = waktuBaru

            println("\n>> SUKSES! Kegiatan telah diperbarui.")
        } else {
            println("Nomor yang Anda masukkan tidak valid !!")
        }
    }

    fun hapusKegiatan() {
        if (daftarKegiatan.isEmpty()) {
            println("\nTidak ada kegiatan yang bisa dihapus.")
            return
        }

        lihatJadwal()
        print("\nPilih nomor kegiatan yang akan dihapus: ")
        val pilihan = readLine()?.toIntOrNull()

        if (pilihan != null && pilihan > 0) {
            val jadwalTerurut = daftarKegiatan.sortedBy { it.waktu }
            val indexPilihan = pilihan - 1

            if (indexPilihan in jadwalTerurut.indices) {
                val kegiatanUntukDihapus = jadwalTerurut[indexPilihan]
                daftarKegiatan.remove(kegiatanUntukDihapus)
                println("\n>> SUKSES! Kegiatan '${kegiatanUntukDihapus.nama}' telah dihapus.")
            } else {
                println("Nomor yang Anda masukkan tidak valid !!")
            }
        } else {
            println("Input tidak valid. Harap masukkan nomor yang benar.")
        }
    }

    private fun mintaInput(pesan: String, kosongDiizinkan: Boolean = false): String {
        while (true) {
            print(pesan)
            val input = readLine()
            if (input != null && (input.isNotBlank() || kosongDiizinkan)) {
                return input
            }
            println("Input tidak boleh kosong. Silakan coba lagi !!")
        }
    }
}