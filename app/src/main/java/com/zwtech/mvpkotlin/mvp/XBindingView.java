package com.zwtech.mvpkotlin.mvp;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;



/**
 * Created by Luther on 2017/4/8.
 */

public abstract class XBindingView<P extends IPresent,D extends ViewDataBinding> implements XView<P> {
    private VDelegate vDelegate;
    private  P present;
    private D binding;
    private View rootView;

    @Override
    public void bindUI(View rootView) {
        if(rootView == null){
            binding = DataBindingUtil.setContentView(getP().getActivity(),getLayoutId());

        }else{
            binding = DataBindingUtil.bind(rootView);
        }
        this.rootView = rootView;
    }

    protected VDelegate getvDelegate(){
        if(vDelegate == null
                && getP() != null
                && getP().getRootContext() != null){
            vDelegate = VDelegateBase.create(getP().getRootContext());
        }
        return vDelegate;
    }

    public D getBinding(){
        return binding;
    }

    @Override
    public void attachP(P present) {
        this.present = present;
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public void detach() {

    }


    protected  P  getP(){
        return  present;
    }


}
