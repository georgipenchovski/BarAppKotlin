package com.example.barappkotlin.view.base

import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.barappkotlin.model.BarModel

abstract class BaseFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      var view = inflater.inflate(getLayoutRes(), container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onFragmentViewCreated(view, savedInstanceState)
    }

    protected abstract fun getLayoutRes(): Int

    protected abstract fun onFragmentViewCreated(
        view: View?,
        savedInstanceState: Bundle?
    ): View?

    protected fun getLayoutView(): View? {
        return view
    }

    abstract fun onUserLocationChanged(
        location: Location?,
        bars: List<BarModel?>?
    )
}
