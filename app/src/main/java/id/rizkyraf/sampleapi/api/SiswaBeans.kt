package id.rizkyraf.sampleapi.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class SiswaBeans : Serializable {
    @SerializedName("idSiswa")
    @Expose
    var idSiswa: String? = null
    @SerializedName("nama")
    @Expose
    var nama: String? = null
    @SerializedName("jenisKelamin")
    @Expose
    var jenisKelamin: String? = null
    @SerializedName("tanggalLahir")
    @Expose
    var tanggalLahir: String? = null
    @SerializedName("alamat")
    @Expose
    var alamat: String? = null
    @SerializedName("tahunMasuk")
    @Expose
    var tahunMasuk: String? = null
}