package id.rizkyraf.sampleapi.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.rizkyraf.sampleapi.R
import id.rizkyraf.sampleapi.api.SiswaBeans

class SiswaAdapter(
    private val context: Context,
    private val list: ArrayList<SiswaBeans>?
) :
    androidx.recyclerview.widget.RecyclerView.Adapter<SiswaAdapter.ViewHolder>() {

    private var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int, SiswaBeans: SiswaBeans)
    }

    fun setListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    fun reCreate(list: List<SiswaBeans>) {
        this.list?.addAll(list)
        notifyDataSetChanged()
    }

    fun addItem(list: List<SiswaBeans>) {
        for (item in list) {
            this.list?.add(item)
        }
        notifyDataSetChanged()
    }

    fun getData(): ArrayList<SiswaBeans> {
        return list!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(context).inflate(R.layout.item_siswa, parent, false)
        return ViewHolder(
            itemView
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list!![position]

        holder.tvNamaSiswa.text = item.nama.toString()
        holder.tvAlamat.text = item.alamat
        holder.tvJenisKelamin.text = if (item.jenisKelamin == "L") "Laki-Laki" else "Perempuan"

        holder.itemView.setOnClickListener {
            listener?.onItemClick(it, position, item)
        }

    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    class ViewHolder(itemView: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

        internal var tvNamaSiswa: TextView = itemView.findViewById(R.id.tvNamaSiswa)
        internal var tvJenisKelamin: TextView = itemView.findViewById(R.id.tvJenisKelamin)
        internal var tvAlamat: TextView = itemView.findViewById(R.id.tvAlamat)

    }

}
