package com.zwtech.mvpkotlin.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;



/**
 * Created by Luther on 2017/4/8.
 */

public class XBindingActivity<V extends IView> extends RxAppCompatActivity implements IPresent<IView> {

    private PDelegate pDelegate;
    private V v;
    private  Context context;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        if(getV().getLayoutId() > 0){
            setContentView(getV().getLayoutId());
            getV().bindUI(null);

        }

        initData(savedInstanceState);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    protected PDelegate getpDelegate(){
        if(pDelegate == null){
                pDelegate = PDelegateBase.Companion.create(context);
        }
        return pDelegate;
    }

    protected V getV(){
        if(v == null){
            v = newV();
            v.attachP(this);
        }
        return v;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        v = null;
        getpDelegate().destory();
        pDelegate = null;
    }

    @Override
    protected void onPause() {
        super.onPause();
        getpDelegate().puase();
    }

    public XBindingActivity() {
        super();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getpDelegate().resume();
    }


    @Override
    public V newV() {
        return v;
    }

    @Override
    public Context getRootContext() {
        return context;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }
}
