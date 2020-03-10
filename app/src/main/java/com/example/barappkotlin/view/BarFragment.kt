package com.example.barappkotlin.view


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.barappkotlin.R
import com.example.barappkotlin.adapters.RecyclerViewAdapter
import com.example.barappkotlin.model.BarItem
import com.example.barappkotlin.view.base.BaseFragment
import com.example.barappkotlin.viewmodel.BarViewModel
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.item_bar.*

class BarFragment : BaseFragment(), RecyclerViewAdapter.ItemClickListener {


    private lateinit var viewModel: BarViewModel
    private lateinit var adapter: RecyclerViewAdapter
    private var isUiInitiated = false

    override fun getLayoutRes(): Int {
        return R.layout.fragment_bar
    }

    override fun onFragmentViewCreated(view: View?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(BarViewModel::class.java)
        viewModel.onBarsLoadedEvent.observe(viewLifecycleOwner, Observer {
            adapter.setBars(it)
        })
        bindElements()
        return view
    }

    private fun bindElements() {
        val myRecyclerView: RecyclerView? = view?.findViewById(R.id.recycler_view)
        if (myRecyclerView != null) {
            adapter = context?.let { RecyclerViewAdapter(it) }!!
            myRecyclerView.layoutManager = LinearLayoutManager(activity)
            myRecyclerView.adapter = adapter
            adapter.setClickListener(this)
            isUiInitiated = true


            val latitude = 42.6679
            val longitude = 23.2917
            val homeLatLng = LatLng(latitude, longitude)
            viewModel.loadBars(latitude, longitude)
        }

    }

    override fun onItemClick(bar: BarItem?) {
        bar?.let { openGoogleMap(it) }
    }

    private fun openGoogleMap(bar: BarItem) {
//        val gmmIntentUri = Uri.parse(
//            "geo:" +
//                    bar.location.latitude.toString() + "," +
//                    bar.location.longitude.toString() + "?q=" +
//                    bar.location.latitude.toString() + "," +
//                    bar.location.longitude
//        )
        val mapIntent = Intent(Intent.ACTION_VIEW)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}
