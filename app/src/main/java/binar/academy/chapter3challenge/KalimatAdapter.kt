package binar.academy.chapter3challenge

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class KalimatAdapter(private val listKalimat : ArrayList<ListKalimat>) : RecyclerView.Adapter<KalimatAdapter.KalimatViewHolder>() {
    class KalimatViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        fun viewBind(kalimat : ListKalimat) {
            val btnKalimat = view.findViewById<Button>(R.id.btnKalimat)
            btnKalimat.text = kalimat.kalimat
            btnKalimat.setOnClickListener {
                Toast.makeText(view.context, kalimat.kalimat, Toast.LENGTH_SHORT).show()
                val activity = view.context as MainActivity
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.google.com/search?q=${kalimat.kalimat}")
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KalimatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_kalimat, parent, false)
        return KalimatViewHolder(view)
    }

    override fun onBindViewHolder(holder: KalimatViewHolder, position: Int) {
        holder.viewBind(listKalimat[position])
    }

    override fun getItemCount(): Int {
        return listKalimat.size
    }
}