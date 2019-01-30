package pdwy.com.taskcollaboration.core;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;


import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import pdwy.com.taskcollaboration.App;
import pdwy.com.taskcollaboration.R;
import pdwy.com.taskcollaboration.activity.PersonalCenterActivity;
import pdwy.com.taskcollaboration.activity.ScanningActivity;
import pdwy.com.taskcollaboration.utils.InputMethodUtils;
import pdwy.com.taskcollaboration.utils.StatusBarUtil;
import pdwy.com.taskcollaboration.utils.SystemBarTintManager;
import pdwy.com.taskcollaboration.utils.helper.DebugHelper;


/**
 * BaseActivity 封装
 * Author： by MR on 2017/3/15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected BaseActivity mContext;
    private boolean onDestroy;
    private App application;
    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onDestroy = false;
        mContext = this;
        if (application == null) {
            // 得到Application对象
            application = (App) getApplication();
        }

        addActivity();// 调用添加方法
        //设置为横屏
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            setTranslucentStatus(true);
//            SystemBarTintManager tintManager = new SystemBarTintManager(this);
//            tintManager.setStatusBarTintEnabled(true);
//            tintManager.setStatusBarTintResource(R.color.theme_color);// 通知栏所需颜色
//        }
        onCreateBefore(savedInstanceState);

        if (getLayoutId() != 0) {// 设置布局,如果子类有返回布局的话
            setContentView(getLayoutId());
            ButterKnife.bind(this);
        } else {
            //没有提供ViewId
            DebugHelper.throwIllegalState("没有提供正确的LayoutId");
            return;
        }

        initBase(savedInstanceState);
        //留给子类重写
        onCreateAfter();


    }

    /**
     * setContentView之前调用
     *
     * @param savedInstanceState
     */
    protected void onCreateBefore(Bundle savedInstanceState) {

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * setContentView之后调用
     *
     *
     */
    protected abstract void onCreateAfter();

    @Override
    protected void onResume() {
        super.onResume();
        //页面统计
//        Tracker.onResume(this);

//        Resources resource = getResources();
//        Configuration configuration = resource.getConfiguration();
//        configuration.fontScale = 1.0f;// 设置字体的缩放比例
//        resource.updateConfiguration(configuration, resource.getDisplayMetrics());
    }

    @Override
    protected void onPause() {
        super.onPause();
        //页面统计
//        Tracker.onPause(this);
        dismissLoadingDialog();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestroy = true;
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        inputMethodHide(this);
    }

    /**
     * 关闭Activity
     */
    protected void finishActivity() {
        finish();
    }

    /**
     * 重写返回键
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishActivity();
        Log.i(getClass().getCanonicalName(), "onBackPressed");
    }

    /**
     * 隐藏输入法
     */
    protected void inputMethodHide(Context context) {
        InputMethodUtils.hide(context);
    }




    protected void initBase(Bundle savedInstanceState) {
        //初始化EventBus
        if (userEventBus()) {
            EventBus.getDefault().register(this);
        }

        //初始化其他,后续按需求来
    }

    //如果要使用Eventbus,则重写返回true
    protected boolean userEventBus() {
        return false;
    }


    //兼容低版本的 判断Activity是否已经被关闭了
    public boolean isDestroyed() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                return super.isDestroyed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return onDestroy;
    }



    /**
     * 加载动画ImageView
     */
    private Dialog waitDialog;


    /**
     * 取消Loading动画
     */
    public void dismissLoadingDialog() {
        if (waitDialog != null && !isDestroyed() && waitDialog.isShowing()) {
            waitDialog.dismiss();
        }
    }

    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = 0x04000000;//WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
    public void headOnClick(View v){
             switch (v.getId()){
                 case R.id.ll_head_return:
                     finish();
                     break;
                 //个人中心
                 case R.id.ll_head_personalcenter:
                     startActivity(PersonalCenterActivity.class,false);
                     break;
                 case R.id.tv_main_saoma:
                     startActivity(ScanningActivity.class,false);
//                intent.putExtra("label","扫描查询");
//                startActivity(intent);
                     break;
             }
    }
    // 添加Activity方法
    protected void addActivity() {
        application.addActivity_(mContext);// 调用myApplication的添加Activity方法
    }
    //销毁当个Activity方法
    protected void removeActivity() {
        application.removeActivity_(mContext);// 调用myApplication的销毁单个Activity方法
    }
    //销毁所有Activity方法
    protected void removeALLActivity() {
        application.removeALLActivity_();// 调用myApplication的销毁所有Activity方法
    }
//设置背景图片
protected Drawable getDrawableMipmap(int mipmap){

        Resources resources = getResources();
        Drawable btnDrawable;
        btnDrawable = resources.getDrawable(mipmap);

        return btnDrawable;
    }
    //页面跳转
    protected void startActivity(Class activity,boolean close){
     this.startActivity(new Intent(this,activity));
       if(close)
           this.finish();
    }
}
