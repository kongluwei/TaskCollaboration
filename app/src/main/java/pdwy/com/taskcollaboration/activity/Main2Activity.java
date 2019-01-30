package pdwy.com.taskcollaboration.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import pdwy.com.taskcollaboration.R;
import pdwy.com.taskcollaboration.adapter.Main2FragmentAdapter;
import pdwy.com.taskcollaboration.core.BaseActivity;
import pdwy.com.taskcollaboration.utils.CustomScrollViewPager;
import pdwy.com.taskcollaboration.utils.SharePreferencesUtils;

public class Main2Activity extends BaseActivity {

    @BindView(R.id.ll_head_return)
    LinearLayout ll_head_return;
    @BindView(R.id.tv_head_title)
    TextView tv_head_title;
    @BindView(R.id.tv_main_renwu)
     LinearLayout tv_main_renwu;
    @BindView(R.id.tv_main_fankui)
     LinearLayout tv_main_fankui;
    @BindView(R.id.tv_main_tongzhi)
     LinearLayout tv_main_tongzhi;
    @BindView(R.id.ll_head_personalcenter)
    LinearLayout ll_head_personalcenter;


    @BindView(R.id.ll_head_personalcenter_1)
    LinearLayout ll_head_personalcenter_1;
    @BindView(R.id.vp_main2)
    CustomScrollViewPager vp_main2;
    private List<Fragment> list;

    LinearLayout ll_p;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void onCreateAfter() {
        ll_head_return.setVisibility(View.VISIBLE);
        ll_head_personalcenter.setVisibility(View.INVISIBLE);
        tv_head_title.setVisibility(View.VISIBLE);;

        initData();
         setTitle();

    }

    @OnClick({R.id.tv_main_renwu,R.id.tv_main_fankui,
            R.id.tv_main_tongzhi,R.id.ll_head_personalcenter_1})
    public void voidOnViewClock(View v){

        switch (v.getId()) {
            case R.id.tv_main_renwu:
                if("".equals(SharePreferencesUtils.getString(getString(R.string.user_identity),""))){
                    Toast.makeText(this,"请先登录",Toast.LENGTH_SHORT).show();
                    return;
                }

                tv_head_title.setText("任务提醒");
                vp_main2.setCurrentItem(0);

                break;
            case R.id.tv_main_fankui:
                if("".equals(SharePreferencesUtils.getString(getString(R.string.user_identity),""))){
                    Toast.makeText(this,"请先登录",Toast.LENGTH_SHORT).show();
                    return;
                }
                tv_head_title.setText("反馈信息");
                vp_main2.setCurrentItem(1);
                break;
            case R.id.tv_main_tongzhi:
                tv_head_title.setText("通知公告");
                vp_main2.setCurrentItem(2);
                break;

            case R.id.ll_head_personalcenter_1:
                tv_head_title.setText("个人中心");
                vp_main2.setCurrentItem(3);
                break;

        }
        setLk((LinearLayout) v);
    }
    private void setTitle() {
            switch (getIntent().getStringExtra("label")) {


                case "任务提醒":


                    tv_head_title.setText("任务提醒");
                    vp_main2.setCurrentItem(0);
                    ll_p = tv_main_renwu;
                    break;
                case "反馈信息":
                    tv_head_title.setText("反馈信息");
                    vp_main2.setCurrentItem(1);
                    ll_p = tv_main_fankui;
                    break;
                case "通知公告":
                    tv_head_title.setText("通知公告");
                    vp_main2.setCurrentItem(2);
                    ll_p = tv_main_tongzhi;
                    break;
                case "个人中心":
                    tv_head_title.setText("个人中心");
                    vp_main2.setCurrentItem(3);
                    ll_p = ll_head_personalcenter_1;
                    break;

            }
        setXz(ll_p);
    }

    //初始选择器
    private void setXz(LinearLayout ll) {
        TextView tvxz= (TextView) ll.getChildAt(1);
        tvxz.setTextColor(Color.parseColor("#424242"));
        TextView tvxz0= (TextView) ll.getChildAt(0);
        switch (getIntent().getStringExtra("label")) {


            case "任务提醒":
                tvxz0.setBackgroundDrawable(getDrawableMipmap(R.mipmap.foot_icon1_on));
                break;
            case "反馈信息":
                tvxz0.setBackgroundDrawable(getDrawableMipmap(R.mipmap.foot_icon2_on));
                break;
            case "通知公告":
                tvxz0.setBackgroundDrawable(getDrawableMipmap(R.mipmap.foot_icon3_on));
                break;
            case "个人中心":
                tvxz0.setBackgroundDrawable(getDrawableMipmap(R.mipmap.foot_icon5_on));
                break;

        }

    }
    //选择器切换
    private void setLk(LinearLayout ll) {
        if (ll.equals(ll_p))
            return;
        TextView tvxz= (TextView) ll_p.getChildAt(1);
        tvxz.setTextColor(Color.parseColor("#C6C6C6"));
        TextView tvlx= (TextView) ll.getChildAt(1);
        tvlx.setTextColor(Color.parseColor("#424242"));
        TextView tvxz0= (TextView) ll_p.getChildAt(0);
        TextView tvlx0= (TextView) ll.getChildAt(0);

        switch (tvlx.getText().toString()) {


            case "任务提醒":
                tvlx0.setBackgroundDrawable(getDrawableMipmap(R.mipmap.foot_icon1_on));
                break;
            case "反馈信息":
                tvlx0.setBackgroundDrawable(getDrawableMipmap(R.mipmap.foot_icon2_on));
                break;
            case "通知公告":
                tvlx0.setBackgroundDrawable(getDrawableMipmap(R.mipmap.foot_icon3_on));
                break;
            case "个人中心":
                tvlx0.setBackgroundDrawable(getDrawableMipmap(R.mipmap.foot_icon5_on));
                break;

        }
        switch (tvxz.getText().toString()) {


            case "任务提醒":
                tvxz0.setBackgroundDrawable(getDrawableMipmap(R.mipmap.foot_icon1));
                break;
            case "反馈信息":
                tvxz0.setBackgroundDrawable(getDrawableMipmap(R.mipmap.foot_icon2));
                break;
            case "通知公告":
                tvxz0.setBackgroundDrawable(getDrawableMipmap(R.mipmap.foot_icon3));
                break;
            case "个人中心":
                tvxz0.setBackgroundDrawable(getDrawableMipmap(R.mipmap.foot_icon5));
                break;

        }
        ll_p=ll;
    }
    //初始化
    private void initData() {
        list=new ArrayList<>();
        switch (SharePreferencesUtils.getString( getString(R.string.user_identity),"")){

            case "处长":
                list.add(new RemindCzActivity());
                break;
            case "审查员":
                list.add(new RemindScyActivity());
                break;
            case "分中心主任":
                list.add(new RemindFzxzrActivity());
                break;
            case "测试员":
                list.add(new RemindCsyActivity());
                break;
            case "分中心保藏员":
                list.add(new RemindFzxbcyActivity());
                break;
                //未登录时必须默认添加一个
            case "":
                list.add(new RemindCsyActivity());
                break;
        }

        //反馈
        list.add(new FeedbackActivity());
        //通知
        list.add(new NoticeActivity());
        //个人中心
        list.add(new PersonalCenterActivity());
        //初始化adapter
        Main2FragmentAdapter adapter = new Main2FragmentAdapter(getSupportFragmentManager(), list);
        //将适配器和ViewPager结合
        vp_main2.setAdapter(adapter);
        vp_main2.setScrollable(false);
    }

    @Override
    protected void removeALLActivity() {
        super.removeALLActivity();
    }

}
