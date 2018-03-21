package com.zwtech.mvpkotlin.mvp;

import android.content.DialogInterface;

/**
 * Created by Luther on 2017/4/8.
 */
public interface XView<P extends IPresent> extends IView<P> {
    /**
     * 通用方法
     */
    void initUI();

    void showToastOnCenter(String msg);

    void showToastOnCenter(String msg, DialogInterface.OnDismissListener listener);

    boolean isLogin();

    void showLoading();

    void showLoading(DialogInterface.OnDismissListener listener);

    void closeLoading();

    void showLoadingWithMessage(String msg, DialogInterface.OnCancelListener listener);

    void showLoadingWithMessage(String msg);

    void showCancleLableProcessWithMessage(String msg);

    void showCancelLableProcessWithMessage(String msg, DialogInterface.OnCancelListener listener);

    boolean checkLogin();

    boolean checkNet();

    void exit();
}
