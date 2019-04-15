package com.it520.contextleak;

import android.content.Context;
import android.widget.Toast;

/**
 * @author 小码哥Android学院(520it.com)
 * @time 2016/10/22  11:06
 * @desc ${TODD}  管理Toast的Manager管理类,做成单例
 */
public class ToastManager {

    private Context mContext;
    private ToastManager(Context context){
        this.mContext = context;
    }

    private static ToastManager mManager = null;

    //懒汉式 单例
    public static ToastManager getInstance(Context context){
        if(mManager==null){
            synchronized (ToastManager.class){
                if(mManager==null){
                    mManager = new ToastManager(context);
                }
            }
        }
        return mManager;
    }

    public  void showToast(String text){
//        startAciti
//        getR
        Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
    }
}
