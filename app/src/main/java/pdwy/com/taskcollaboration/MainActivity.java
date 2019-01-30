package pdwy.com.taskcollaboration;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import pdwy.com.taskcollaboration.activity.Main2Activity;
import pdwy.com.taskcollaboration.activity.NoticeGgXqActivity;
import pdwy.com.taskcollaboration.activity.ScanningActivity;
import pdwy.com.taskcollaboration.core.BaseActivity;
import pdwy.com.taskcollaboration.utils.SharePreferencesUtils;

public class MainActivity extends BaseActivity implements OnBannerListener {
    @BindView(R.id.et_search)
    EditText mEtSearch;
    @BindView(R.id.layout_default)
    LinearLayout mLayoutDefaultText;
    @BindView(R.id.ll_main_x)
    LinearLayout ll_main_x;
    @BindView(R.id.tv_main_renwu)
    LinearLayout tv_main_renwu;
    @BindView(R.id.tv_main_fankui)
    LinearLayout tv_main_fankui;
    @BindView(R.id.tv_main_tongzhi)
    LinearLayout tv_main_tongzhi;
    @BindView(R.id.tv_main_saoma)
    LinearLayout tv_main_saoma;
    @BindView(R.id.tv_login)
    TextView tv_login;
    private Banner mBanner;
    private MyImageLoader mMyImageLoader;
    private ArrayList<Integer> imagePath;
    private ArrayList<String> imagePath1;
    private ArrayList<String> imageTitle;
    private Intent intent;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreateAfter() {
//        if("".equals(SharePreferencesUtils.getString(getString(R.string.user_id),""))){
//            startActivity(new Intent(this,LoginActivity.class));
//            finish();
//            return;
//        }
        if(!"".equals(SharePreferencesUtils.getString(getString(R.string.user_identity),""))){
            tv_login.setVisibility(View.GONE);
        }
//检查当前权限（若没有该权限，值为-1；若有该权限，值为0）
        int hasReadExternalStoragePermission = ContextCompat.checkSelfPermission(getApplication(), Manifest.permission.CAMERA);
        Log.e("PERMISION_CODE",hasReadExternalStoragePermission+"***");
        if(hasReadExternalStoragePermission== PackageManager.PERMISSION_GRANTED){

        }else{
            //若没有授权，会弹出一个对话框（这个对话框是系统的，开发者不能自己定制），用户选择是否授权应用使用系统权限
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},1);
        }

//取消严格模式  FileProvider
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }

        initData();
        initView();
    }

    @OnClick({R.id.tv_main_renwu,R.id.tv_main_renwu_1,R.id.tv_main_fankui,R.id.tv_main_fankui_1,
            R.id.tv_main_tongzhi,R.id.tv_main_tongzhi_1,R.id.tv_main_saoma_1,R.id.ll_head_personalcenter,R.id.tv_login})
    public void voidOnViewClock(View v){

        switch (v.getId()){
            case R.id.tv_login:

                startActivity(LoginActivity.class,true);
                break;
            //任务提醒（分权限）
            case  R.id.tv_main_renwu_1:
            case R.id.tv_main_renwu:
                if("".equals(SharePreferencesUtils.getString(getString(R.string.user_identity),""))){
                Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
                return;
            }
                intent.putExtra("label","任务提醒");
                startActivity(intent);
                mEtSearch.clearFocus();
            break;
//反馈信息
            case  R.id.tv_main_fankui_1:
            case R.id.tv_main_fankui:
                if("".equals(SharePreferencesUtils.getString(getString(R.string.user_identity),""))){
                    Toast.makeText(this,"请先登录",Toast.LENGTH_SHORT).show();
                    return;
            }

//                startActivity(FeedbackActivity.class,false);
                intent.putExtra("label","反馈信息");
                startActivity(intent);
                mEtSearch.clearFocus();
                break;
                //通知公告
            case  R.id.tv_main_tongzhi_1:
            case R.id.tv_main_tongzhi:

//                startActivity(NoticeActivity.class,false);
                intent.putExtra("label","通知公告");
                 startActivity(intent);
                mEtSearch.clearFocus();
                break;
                //扫描查询
            case  R.id.tv_main_saoma_1:
                startActivity(ScanningActivity.class,false);
//                intent.putExtra("label","扫描查询");
//                startActivity(intent);
                mEtSearch.clearFocus();
                break;
                //个人中心
            case  R.id.ll_head_personalcenter:
//                startActivity(PersonalCenterActivity.class,false);
                intent.putExtra("label","个人中心");
                System.err.println("s");
                startActivity(intent);
                mEtSearch.clearFocus();
                break;

        }

    }

    private void initData() {
        imagePath = new ArrayList<>();
        imageTitle = new ArrayList<>();
        imagePath1= new ArrayList<>();
        imagePath.add(R.mipmap.lb0);
        imagePath.add(R.mipmap.shamo);
        imagePath.add(R.mipmap.juhua);
        imagePath1.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533566443368&di=b056ce1f74ee9a2d4fd910866c21de39&imgtype=0&src=http://p5.pccoo.cn/news/20160720/2016072010271681587483.png");
        imagePath1.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533566443368&di=b056ce1f74ee9a2d4fd910866c21de39&imgtype=0&src=http://p5.pccoo.cn/news/20160720/2016072010271681587483.png");
        imagePath1.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533566443368&di=b056ce1f74ee9a2d4fd910866c21de39&imgtype=0&src=http://p5.pccoo.cn/news/20160720/2016072010271681587483.png");
        imageTitle.add("关于确定2018-2020年中山市政策性农业保险承办机构的通知");

        imageTitle.add("沙漠");
        imageTitle.add("菊花");

        intent = new Intent(this, Main2Activity.class);
    }

    private void initView() {

        mEtSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                // hasFocus 为false时表示点击了别的控件，离开当前editText控件
                if (!hasFocus) {
                    if ("".equals(mEtSearch.getText().toString())) {
                        mLayoutDefaultText.setVisibility(View.VISIBLE);
                    }
                }
                else {
                    mLayoutDefaultText.setVisibility(View.GONE);
                }
            }
        });

        mMyImageLoader = new MyImageLoader();
        mBanner = findViewById(R.id.banner);
        //设置样式，里面有很多种样式可以自己都看看效果
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        mBanner.setImageLoader(mMyImageLoader);
        //设置轮播的动画效果,里面有很多种特效,可以都看看效果。
        mBanner.setBannerAnimation(Transformer.ZoomOutSlide);
        //轮播图片的文字
        mBanner.setBannerTitles(imageTitle);
        //设置轮播间隔时间
        mBanner.setDelayTime(5000);
        //设置是否为自动轮播，默认是true
        mBanner.isAutoPlay(true);
        //设置指示器的位置，小点点，居中显示
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        //设置图片加载地址
        mBanner.setImages(imagePath)
                //轮播图的监听
                .setOnBannerListener(this)
                //开始调用的方法，启动轮播图。；
                .start();

    }

    /**
     * 轮播图的监听
     *
     * @param position
     */
    @Override
    public void OnBannerClick(int position) {

        Intent intentClick=new Intent(this,NoticeGgXqActivity.class);
        intentClick.putExtra("bt",imageTitle.get(position));
        startActivity(intentClick);
        mEtSearch.clearFocus();
    }




    /**
     * 图片加载类
     */
    private class MyImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load(path)
                    .into(imageView);
        }
    }

}
