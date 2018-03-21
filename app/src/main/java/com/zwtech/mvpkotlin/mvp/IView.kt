package com.zwtech.mvpkotlin.mvp

import android.os.Bundle
import android.view.View

/**
 * Created by wanglei on 2016/12/29.
 */

interface IView<P> {


    val layoutId: Int


    val rootView: View
    fun bindUI(rootView: View)


    fun initData(savedInstanceState: Bundle)


    fun newP(): P

    fun attachP(present: P)

    fun detach()

}
