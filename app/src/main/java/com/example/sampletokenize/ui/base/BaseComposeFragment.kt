package com.example.sampletokenize.ui.base

abstract class BaseComposeFragment <VM : BaseViewModel> : BaseFragment<VM>() {

    override fun getLayoutId(): Int = 0
}
