package com.zwtech.mvpkotlin.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;


/**
 * Created by Martin on 2017/8/2.
 */

public class XBindingFragment<V extends IView> extends RxFragment implements IPresent<IView> {

    private PDelegate pDelegate;
    private V v;
    private  Context context;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = null;

        context = getActivity();

        if (rootView == null) {
            if (getV().getLayoutId() > 0) {
                rootView = inflater.inflate(getV().getLayoutId(), null);
                getV().bindUI(rootView);
            }

        } else {
            ViewGroup viewGroup = (ViewGroup) rootView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(rootView);
            }
        }

        initData(savedInstanceState);
        return rootView;
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
    public void onDestroy() {
        super.onDestroy();
        v = null;
        getpDelegate().destory();
        pDelegate = null;
    }

    @Override
    public void onPause() {
        super.onPause();
        getpDelegate().puase();
    }

    public XBindingFragment() {
        super();
    }

    @Override
    public void onResume() {
        super.onResume();
        getpDelegate().resume();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }




    @Override
    public V newV() {
        return null;
    }

    @Override
    public Context getRootContext() {
        return null;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }
}
