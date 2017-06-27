package com.example.chzuschool.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by XC on 2017/6/27.
 */

public class MyNetworkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //**判断当前的网络连接状态是否可用*/
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if ( info != null && info.isAvailable()){
            //当前网络状态可用
            Toast.makeText(context, "网络连接已恢复", Toast.LENGTH_SHORT).show();
        }else {
            //当前网络不可用
            Toast.makeText(context, "无网络连接,请打开WIFI或移动数据", Toast.LENGTH_SHORT).show();
        }
    }
}