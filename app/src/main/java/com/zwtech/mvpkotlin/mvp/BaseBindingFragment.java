package com.zwtech.mvpkotlin.mvp;


import android.os.Bundle;
import android.support.annotation.Nullable;





/**
 * Created by Martin on 2017/8/2.
 */

public abstract class BaseBindingFragment<V extends VBaseF>  extends XBindingFragment<V>{


    public BaseBindingFragment getFragment() {
        return this;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }






    public  void UpdateData(String ciryId, String zoomId,String propertyId){
    }

    public  void NewUpdateData(String district_id){
    }




}
