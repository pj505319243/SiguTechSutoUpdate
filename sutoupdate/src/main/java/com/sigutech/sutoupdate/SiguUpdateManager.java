package com.sigutech.sutoupdate;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class SiguUpdateManager {

    public void register(Context mContext){
        Config.mContext = mContext;
        int versionCode = getVersion();
        int lineVersionCode = getLineVersion();

        //if (lineVersionCode > versionCode) {
            //去弹窗提示用户
            showDialog();
        //}
    }

    public int getVersion(){
        int versionCode = 0;
        if(Config.mContext==null){
            return versionCode;
        }
        PackageInfo pkg;
        try {
            pkg = Config.mContext.getPackageManager().getPackageInfo(Config.mContext.getPackageName(), 0);
            versionCode = pkg.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    public int getLineVersion(){
        int versionCode = 0;

        return versionCode;
    }

    private void showDialog(){
        AlertDialog dialog = new AlertDialog.Builder(Config.mContext).setTitle
                ("Tips").setMessage("Have new version,please update!")
                .setNeutralButton("Cancel", new DialogInterface
                        .OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNegativeButton("Update", new DialogInterface
                        .OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //下载
                    }
                }).show();
        //dialog.setCanceledOnTouchOutside(false);//可选,点击dialog其它地方dismiss无效
        //dialog.setCancelable(false);//可选,点击返回键无效
    }

}
