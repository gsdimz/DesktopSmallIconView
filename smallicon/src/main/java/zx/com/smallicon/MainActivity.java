package zx.com.smallicon;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import zx.com.smallicon.utils.AppShortCutUtil;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addNumShortCut(this, MainActivity.class, true, "8", true);
    }
    public static void addNumShortCut(Context context, Class<?> clazz, boolean isShowNum, String num, boolean isStroke) {
        Log.e("TAG", "manufacturer=" + Build.MANUFACTURER);
        if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            //小米
            AppShortCutUtil.xiaoMiShortCut(context, clazz, num);

        } else if (Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
            //三星
            AppShortCutUtil.samsungShortCut(context, num);

        } else {//其他原生系统手机
            AppShortCutUtil.installRawShortCut(context, MainActivity.class, isShowNum, num, isStroke);
        }

    }
}
