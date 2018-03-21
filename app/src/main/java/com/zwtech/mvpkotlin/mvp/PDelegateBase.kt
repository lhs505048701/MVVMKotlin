package com.zwtech.mvpkotlin.mvp

import android.content.Context

/**
 * Created by Luther on 2017/4/8.
 */

class PDelegateBase private constructor(private val context: Context) : PDelegate {

    override fun resume() {

    }

    override fun puase() {

    }

    override fun destory() {

    }

    companion object {

        fun create(context: Context): PDelegateBase {
            return PDelegateBase(context)
        }
    }
}
