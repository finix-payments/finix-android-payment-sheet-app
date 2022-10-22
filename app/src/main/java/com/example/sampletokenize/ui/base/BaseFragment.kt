package com.example.sampletokenize.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment<VM : BaseViewModel> : Fragment(), PageDestination {

    /**
     * setView
     *
     * set the content view based on layoutId()
     */
    open fun setView(inflater: LayoutInflater, container: ViewGroup?): View? =
        inflater.inflate(getLayoutId(), container, false)

    /**
     * getLayoutId
     *
     * Override to set layout resource
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int
}
