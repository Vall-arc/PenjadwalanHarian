package jadwalharian.model

data class Kegiatan(
    var nama: String,
    var deskripsi: String,
    var waktu: String
) {
    override fun toString(): String {
        return """
        |- Nama       : $nama
        |- Deskripsi  : $deskripsi
        |- Waktu      : $waktu
        """.trimMargin()
    }
}