package com.zwtech.mvpkotlin

import android.os.Bundle
import com.zwtech.mvpkotlin.mvp.BaseBindingActivity

class MainActivity : BaseBindingActivity<VMain>() {

    override fun newV(): VMain {
        return VMain()
    }

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        v.initUI()
    }
}
