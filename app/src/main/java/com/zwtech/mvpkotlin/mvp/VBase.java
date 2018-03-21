package com.zwtech.mvpkotlin.mvp;

import android.content.DialogInterface;
import android.databinding.ViewDataBinding;
import android.os.Bundle;



/**
 * Created by Linn on 16/12/28.
 */

public class VBase<A extends BaseBindingActivity, B extends ViewDataBinding> extends XBindingView<A, B> {



    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initUI() {

    }

    @Override
    public int getLayoutId() {
        return 0;
    }



    @Override
    public A newP() {
        return null;
    }

    @Override
    public void showToastOnCenter(String msg) {
        showToastOnCenter(msg, null);
    }

    @Override
    public void showToastOnCenter(String msg, DialogInterface.OnDismissListener listener) {
        if (!getP().isFinishing()) {
           // ToastUtil.getInstance().showToastOnCenter(getP().getActivity(), msg, listener);
        }
    }

    @Override
    public boolean isLogin() {
        return false;
    }

    @Override
    public void showLoading() {
        showLoading(null);
    }

    @Override
    public void showLoading(DialogInterface.OnDismissListener onDismissListener) {
        if (!getP().isFinishing()){

        }
           // ToastUtil.getInstance().showProgress(getP().getActivity(), onDismissListener);
    }

    @Override
    public void closeLoading() {
        if (!getP().isFinishing()){

        }
          //  ToastUtil.getInstance().closeProgress(getP().getActivity());
    }

    @Override
    public void showLoadingWithMessage(String msg, DialogInterface.OnCancelListener listener) {

    }



    @Override
    public void showLoadingWithMessage(String message) {
        if (!getP().isFinishing()){

        }
           // ToastUtil.getInstance().showProgressWithMessage(getP().getActivity(), message, null);
    }

    @Override
    public void showCancleLableProcessWithMessage(String msg) {

    }

    @Override
    public void showCancelLableProcessWithMessage(String msg, DialogInterface.OnCancelListener listener) {

    }





    @Override
    public boolean checkLogin() {
        return false;
    }

    @Override
    public boolean checkNet() {
        return false;
    }

    @Override
    public void exit() {
        getP().exit();
    }
}
