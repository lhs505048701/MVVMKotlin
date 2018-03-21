package com.zwtech.mvpkotlin.mvp;

import android.content.DialogInterface;
import android.databinding.ViewDataBinding;
import android.os.Bundle;



/**
 * Created by Martin on 2017/8/2.
 */

public class VBaseF<A extends BaseBindingFragment, B extends ViewDataBinding> extends XBindingView<A, B> {


    @Override
    public void initData(Bundle savedInstanceState) {

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
    public void initUI() {

    }

    @Override
    public void showToastOnCenter(String msg) {

    }

    @Override
    public void showToastOnCenter(String msg, DialogInterface.OnDismissListener listener) {

    }

    @Override
    public boolean isLogin() {
        return false;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showLoading(DialogInterface.OnDismissListener listener) {

    }

    @Override
    public void closeLoading() {

    }

    @Override
    public void showLoadingWithMessage(String msg, DialogInterface.OnCancelListener listener) {

    }

    @Override
    public void showLoadingWithMessage(String msg) {

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

    }
}
