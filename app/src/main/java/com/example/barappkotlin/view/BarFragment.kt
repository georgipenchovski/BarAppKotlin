package com.example.barappkotlin.view


import android.location.Location
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.barappkotlin.BarViewModel
import com.example.barappkotlin.R
import com.example.barappkotlin.adapters.RecyclerViewAdapter
import com.example.barappkotlin.model.BarItem
import com.example.barappkotlin.model.BarModel
import com.example.barappkotlin.view.base.BaseFragment

class BarFragment : BaseFragment(), RecyclerViewAdapter.ItemClickListener {


    private lateinit var viewModel: BarViewModel
    private lateinit var adapter: RecyclerViewAdapter
    private var isUiInitiated = false
    private val userLocation: Location? = null
    private val bars: List<BarModel>? = null

    override fun getLayoutRes(): Int {
        return R.layout.fragment_bar
    }

    override fun onFragmentViewCreated(view: View?, savedInstanceState: Bundle?): View? {
        bindElements()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BarViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onUserLocationChanged(location: Location?, bars: List<BarModel?>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun bindElements() {
        val myRecyclerView: RecyclerView = getLayoutView()!!.findViewById(R.id.recycler_view)
        adapter = context?.let { RecyclerViewAdapter(it) }!!
        myRecyclerView.layoutManager = LinearLayoutManager(activity)
        myRecyclerView.adapter = adapter
        adapter!!.setClickListener(this)
        isUiInitiated = true
//        onUserLocationChanged(userLocation, bars)
    }

    override fun onItemClick(bar: BarItem?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
