package com.zwtech.mvpkotlin

import com.zwtech.mvpkotlin.databinding.ActivityMainBinding
import com.zwtech.mvpkotlin.mvp.VBase

/**
 * Created by Martin on 2018/3/21.
 */
class VMain : VBase<MainActivity,ActivityMainBinding>(){

    override fun initUI() {
        super.initUI()
    }

    override val layoutId: Int
        get() = R.layout.activity_main

}