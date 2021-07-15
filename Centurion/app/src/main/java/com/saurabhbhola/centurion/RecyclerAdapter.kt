package com.saurabhbhola.centurion


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemKode: TextView
        var itemKategori: TextView
        var itemIsi: TextView

        init {
            itemKode = itemView.findViewById(R.id.kodePertanyaan)
            itemKategori = itemView.findViewById(R.id.kategori)
            itemIsi = itemView.findViewById(R.id.isiPertanyaan)

//            itemView.setOnClickListener {
//                val position: Int = getAbsoluteAdapterPosition()
//                val context = itemView.context
//                val intent = Intent(context, NewClass::class.java).apply {
//                    putExtra("NUMBER", position)
//                    putExtra("CODE", itemKode.text)
//                    putExtra("CATEGORY", itemKategori.text)
//                    putExtra("CONTENT", itemIsi.text)
//                }
//                context.startActivity(intent)
//            }
        }
    }

    private val kode = arrayOf("d116df5",
        "36ffc75", "f5cfe78", "5b87628",
        "db8d14e", "9913dc4", "e120f96",
        "466251b")

    private val kategori = arrayOf("Kekayaan", "Teknologi",
        "Keluarga", "Bisnis",
        "Keluarga", "Hutang",
        "Teknologi", "Pidana")

    private val isi = arrayOf("pertanyaan 9",
        "pertanyaan 11", "pertanyaan 17", "test forum",
        "pertanyaan 12", "pertanyaan 18", "pertanyaan 20",
        "pertanyaan 21")



    override fun getItemCount(): Int {

        return kode.size
    }





    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemKode.text = kode[position]
        holder.itemKategori.text=kategori[position]
        holder.itemIsi.text=isi[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.card, parent ,false)
        return ViewHolder(v)
    }
}