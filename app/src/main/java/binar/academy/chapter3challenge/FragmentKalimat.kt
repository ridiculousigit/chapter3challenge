package binar.academy.chapter3challenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentKalimat(private var hasilHuruf : String) : Fragment() {
    private lateinit var daftarKalimat : ArrayList<ListKalimat>
    private lateinit var kalimatAdapter : KalimatAdapter
    private lateinit var recyclerView : RecyclerView
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kalimat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInit(hasilHuruf)
        recyclerView = view.findViewById(R.id.rvKalimat)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        kalimatAdapter = KalimatAdapter(daftarKalimat)
        recyclerView.adapter = kalimatAdapter
    }

    private fun dataInit(data:String) {
        daftarKalimat = when(data){
            "A" -> arrayListOf(ListKalimat("Apel"),
                ListKalimat("Alpukat"),
                ListKalimat("Anggur"))
            "B" -> arrayListOf(ListKalimat("Badak"),
                ListKalimat("Bebek"),
                ListKalimat("Buaya"))
            "C" -> arrayListOf(ListKalimat("Chile"),
                ListKalimat("Cina"),
                ListKalimat("Costa"))
            "D" -> arrayListOf(ListKalimat("Desainer"),
                ListKalimat("Diplomat"),
                ListKalimat("Dokter"))
            "E" -> arrayListOf(ListKalimat("Ear"),
                ListKalimat("Elbow"),
                ListKalimat("Eye"))
            "F" -> arrayListOf(ListKalimat("Fiji"),
                ListKalimat("Finland"),
                ListKalimat("France"))
            "G" -> arrayListOf(ListKalimat("Gecko"),
                ListKalimat("Giraffe"),
                ListKalimat("Gorilla"))
            "H" -> arrayListOf(ListKalimat("Hamburger"),
                ListKalimat("Hash Brown"),
                ListKalimat("Hotdog"))
            "I" -> arrayListOf(ListKalimat("Iran"),
                ListKalimat("Iraq"),
                ListKalimat("Israel"))
            "J" -> arrayListOf(ListKalimat("Kelapa"),
                ListKalimat("Kelengkeng"),
                ListKalimat("Kesemek"))
            "K" -> arrayListOf(ListKalimat("Apel"),
                ListKalimat("Alpukat"),
                ListKalimat("Anggur"))
            "L" -> arrayListOf(ListKalimat("Apel"),
                ListKalimat("Alpukat"),
                ListKalimat("Anggur"))
            else -> {arrayListOf()}
        }
    }
}