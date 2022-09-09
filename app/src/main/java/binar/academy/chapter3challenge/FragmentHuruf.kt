package binar.academy.chapter3challenge

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentHuruf : Fragment() {
    lateinit var listHuruf : ArrayList<ListHuruf>
    lateinit var hurufAdapter : HurufAdapter
    lateinit var recyclerView : RecyclerView
    lateinit var layoutManager: GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_huruf, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.setTitle("Huruf")
        dataInit()
        recyclerView = view.findViewById(R.id.rvHuruf)
        recyclerView.setHasFixedSize(true)
        layoutManager = GridLayoutManager(context, 3)
        recyclerView.layoutManager = layoutManager
        hurufAdapter = HurufAdapter(listHuruf, layoutManager)
        recyclerView.adapter = hurufAdapter
    }

    override fun onCreateOptionsMenu(menu : Menu, inflater : MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item : MenuItem) : Boolean {
        when (item.itemId) {
            R.id.btnRelayout -> {
                if (layoutManager.spanCount == 3) {
                    layoutManager.spanCount = 1
                    item.setIcon(R.drawable.ic_list).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
                } else{
                    layoutManager.spanCount = 3
                    item.setIcon(R.drawable.ic_grid).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
                }
                hurufAdapter.notifyItemRangeChanged(0,hurufAdapter.itemCount)
            } else -> return false
        }
        return true
    }

    private fun dataInit() {
        listHuruf = arrayListOf(
            ListHuruf("A"), ListHuruf("B"),ListHuruf("C"),
            ListHuruf("D"), ListHuruf("E"),ListHuruf("F"),
            ListHuruf("G"),ListHuruf("H"), ListHuruf("I"),
            ListHuruf("J"),ListHuruf("K"),ListHuruf("L"))
    }
}