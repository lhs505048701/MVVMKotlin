package com.zwtech.mvpkotlin.mvp;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Linn on 16/12/28.
 */

public abstract class BaseBindingActivity<V extends VBase> extends XBindingActivity<V> {
    /**
     * 是否沉浸状态栏
     **/
    private boolean isSetStatusBar = true;
    /**
     * 是否允许全屏
     **/
    private boolean isAllowFullScreen = false;

    private boolean isKB = false;

    /**
     * 是否允许旋转屏幕
     **/
    private boolean isAllowScreenRoate = false;
    /**
     * 是否需要全局下沉
     */
    private boolean isNeedFullDown = true;
    /**
     * 是否需要屏幕常亮
     */
    private boolean needWake = false;
    /**
     * 输出log的tag
     */
    protected final String TAG = this.getClass().getSimpleName();
    /**
     * 是否需要白底黑字状态栏
     */
    private boolean dark = true;

    public boolean isDark() {
        return dark;
    }

    public void setDark(boolean dark) {
        this.dark = dark;
    }
    public void setisSetStatusBar(boolean isSetStatusBar) {
        this.isSetStatusBar = isSetStatusBar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }


    public boolean isKB() {
        return isKB;
    }

    public void setKB(boolean KB) {
        isKB = KB;
    }




    @Override
    protected void onStop() {
        super.onStop();

    }

    /**
     * 程序是否在前台运行
     *
     * @return
     */
    public boolean isAppOnForeground() {
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = getApplicationContext().getPackageName();

        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null)
            return false;

        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }

        return false;
    }

    /**
     * 是否全屏
     *
     * @param allowFullScreen
     */
    public void setAllowFullScreen(boolean allowFullScreen) {
        isAllowFullScreen = allowFullScreen;
    }

    /**
     * 是否允许旋转
     *
     * @param allowScreenRoate
     */
    public void setAllowScreenRoate(boolean allowScreenRoate) {
        isAllowScreenRoate = allowScreenRoate;
    }



    /**
     * 是否需要全局沉浸
     *
     * @param is
     */
    public void setNeedFullDown(boolean is) {
        this.isNeedFullDown = is;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
    }

    public boolean checkNet() {
       // boolean result = NetUtils.isNetworkAvailable(getActivity());
      //  if (!result)
      //      getV().showToastOnCenter("网络错误");
        return false;
    }

    /**
     * 设置状态栏字体图标为深色，需要MIUIV6以上
     *
     * @param window 需要设置的窗口
     * @param dark   是否把状态栏字体及图标颜色设置为深色
     * @return boolean 成功执行返回true
     */
    public static boolean MIUISetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            Class clazz = window.getClass();
            try {
                int darkModeFlag = 0;
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if (dark) {
                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag);//状态栏透明且黑色字体
                } else {
                    extraFlagField.invoke(window, 0, darkModeFlag);//清除黑色字体
                }
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }





    private View downView;

    public View getDownView() {
        return downView;
    }

    /**
     * 此方法应在needFullDown为false时在initTitle中调用
     * 设置padding
     *
     * @param downView
     */
    public void setDownView(View downView) {
        this.downView = downView;
    }



    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    protected void initBundle(Bundle bundle) {

    }



    public void exit() {
        finish();
    }

    /**
     * 返回当前Activity实例
     *
     * @return
     */
    public BaseBindingActivity getActivity() {
        return this;
    }




    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
