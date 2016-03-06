package com.fuxuemingzhu.threaduitest.activity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


/**
 * <p>
 * Title: BaseActivity
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author fuxuemingzhu
 * @email fuxuemingzhu@163.com
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 初始化视图 *
     */
    protected abstract void initViews();

    /**
     * 初始化事件 *
     */
    protected abstract void initEvents();


    protected void processHandler(Handler handler, int what) {
        Message msg = handler.obtainMessage();
        msg.what = what;
        handler.sendMessage(msg);
    }

    /**
     * Debug输出Log日志 *
     */
    protected void showLogDebug(String tag, String msg) {
        Log.d(tag, msg);
    }

    /**
     * Error输出Log日志 *
     */
    protected void showLogError(String tag, String msg) {
        Log.e(tag, msg);
    }


    /**
     * （非 Javadoc）
     * <p>
     * Title: getResources
     * </p>
     * <p>
     * Description:设置字体不随系统字体变化
     * </p>
     *
     * @return
     *
     * @see android.view.ContextThemeWrapper#getResources()
     */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }


    @Override
    public void finish() {
        super.finish();
    }

    /**
     * 默认退出 *
     */
    protected void defaultFinish() {
        super.finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
