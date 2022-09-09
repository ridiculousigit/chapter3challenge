package binar.academy.chapter3challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HurufAdapter(private val listHuruf : ArrayList<ListHuruf>, private val layoutManager : GridLayoutManager) : RecyclerView.Adapter<HurufAdapter.HurufViewHolder>() {
    private val layoutGrid = 1
    private val layoutList = 2
    class HurufViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun listBind(hurufParam : ListHuruf) {
            val btnHuruf = itemView.findViewById<Button>(R.id.btnHuruf)
            btnHuruf.text = hurufParam.huruf
            btnHuruf.setOnClickListener {
                val activity : AppCompatActivity = itemView.context as AppCompatActivity
                val fragmentKalimat = FragmentKalimat(btnHuruf.text.toString())
                activity.supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,fragmentKalimat).addToBackStack("fragment").commit()
            }
        }

        fun gridBind(hurufParam : ListHuruf) {
            val btnHuruf = itemView.findViewById<Button>(R.id.btnHuruf)
            btnHuruf.text = hurufParam.huruf
            btnHuruf.setOnClickListener {
                val activity : AppCompatActivity = itemView.context as AppCompatActivity
                val fragmentKalimat = FragmentKalimat(btnHuruf.text.toString())
                activity.supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,fragmentKalimat).addToBackStack("fragment").commit()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HurufViewHolder {
        val view : View = if(viewType == layoutGrid) {
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_huruf, parent, false)
        }else{
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_kalimat, parent, false)
        }
        return HurufViewHolder(view)
    }

    override fun onBindViewHolder(holder: HurufViewHolder, position: Int) {
        if(layoutManager.spanCount == 1) {
            holder.gridBind(listHuruf[position])
        } else {
            holder.listBind(listHuruf[position])
        }
    }

    override fun getItemCount(): Int {
        return listHuruf.size
    }

    override fun getItemViewType(position: Int): Int {
        val layoutBeing = layoutManager.spanCount
        return if (layoutBeing == 3) {
            layoutGrid
        } else {
            layoutList
        }
    }
}