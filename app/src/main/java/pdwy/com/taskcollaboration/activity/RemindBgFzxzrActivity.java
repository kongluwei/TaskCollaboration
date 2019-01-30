package pdwy.com.taskcollaboration.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import pdwy.com.taskcollaboration.R;
import pdwy.com.taskcollaboration.adapter.RemindBgFzxzrAdapter;
import pdwy.com.taskcollaboration.core.BaseActivity;
import pdwy.com.taskcollaboration.model.bean.BaoGaoFzxzr;

public class RemindBgFzxzrActivity extends BaseActivity {
    @BindView(R.id.ll_head_return)
    LinearLayout ll_head_return;
    @BindView(R.id.tv_head_title)
    TextView tv_head_title;

    @BindView(R.id.ll_head_personalcenter)
    LinearLayout ll_head_personalcenter;
    @BindView(R.id.lv_cz)
    ListView lv_cz;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_remind_bg_fzxzr;
    }

    @Override
    protected void onCreateAfter() {
        ll_head_return.setVisibility(View.VISIBLE);
        ll_head_personalcenter.setVisibility(View.INVISIBLE);
        tv_head_title.setVisibility(View.VISIBLE);
        tv_head_title.setText("待批准的报告");

        List<BaoGaoFzxzr> list=new ArrayList<>();
        RemindBgFzxzrAdapter remindBgFzxzrAdapter=new RemindBgFzxzrAdapter(this,list);
        lv_cz.setAdapter(remindBgFzxzrAdapter);
        BaoGaoFzxzr baoGaoFzxzr=new BaoGaoFzxzr();
        baoGaoFzxzr.csbh="测试编号";
        baoGaoFzxzr.sz="属种";
        baoGaoFzxzr.csy="测试员";
        baoGaoFzxzr.rwlx="任务类型";
        baoGaoFzxzr.tjsj="提交时间";
        list.add(baoGaoFzxzr);
        BaoGaoFzxzr baoGaoFzxzr0=new BaoGaoFzxzr();
        baoGaoFzxzr0.csbh="2017013245";
        baoGaoFzxzr0.sz="水稻";
        baoGaoFzxzr0.csy="张晗";
        baoGaoFzxzr0.rwlx="委托";
        baoGaoFzxzr0.tjsj="2018-07-25";
        list.add(baoGaoFzxzr0);
        BaoGaoFzxzr baoGaoFzxzr1=new BaoGaoFzxzr();
        baoGaoFzxzr1.csbh="2016013248";
        baoGaoFzxzr1.sz="玉米";
        baoGaoFzxzr1.csy="王东健";
        baoGaoFzxzr1.rwlx="品种保护";
        baoGaoFzxzr1.tjsj="2018-07-25";
        list.add(baoGaoFzxzr1);
    }
}
