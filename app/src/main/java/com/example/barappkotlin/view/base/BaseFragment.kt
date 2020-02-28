package com.example.barappkotlin.view.base

import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.barappkotlin.model.BarModel

abstract class BaseFragment : Fragment() {

    protected var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(getLayoutRes(), container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onFragmentViewCreated(view, savedInstanceState)
    }

    abstract fun getLayoutRes(): Int

    protected abstract fun onFragmentViewCreated(
        view: View?,
        savedInstanceState: Bundle?
    ): View?

    protected fun getLayoutView(): View? {
        return rootView
    }

    abstract fun onUserLocationChanged(
        location: Location?,
        bars: List<BarModel?>?
    )
}
