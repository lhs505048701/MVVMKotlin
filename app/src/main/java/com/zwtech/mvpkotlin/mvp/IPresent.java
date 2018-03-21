package com.zwtech.mvpkotlin.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by wanglei on 2016/12/29.
 */

public interface IPresent<V> {



    V newV();

    Context getRootContext();

    Activity getActivity();

    void initData(Bundle savedInstanceState);
}
