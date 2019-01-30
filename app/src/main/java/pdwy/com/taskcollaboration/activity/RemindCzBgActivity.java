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
import pdwy.com.taskcollaboration.adapter.RemindCzBgAdapter;
import pdwy.com.taskcollaboration.core.BaseActivity;
import pdwy.com.taskcollaboration.model.bean.BaoGaoCz;

public class RemindCzBgActivity extends BaseActivity {
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
        return R.layout.activity_remind_cz_bg;
    }

    @Override
    protected void onCreateAfter() {
        ll_head_return.setVisibility(View.VISIBLE);
        ll_head_personalcenter.setVisibility(View.INVISIBLE);
        tv_head_title.setVisibility(View.VISIBLE);
        tv_head_title.setText("待批准的报告");
        List<BaoGaoCz> list=new ArrayList<>();

        RemindCzBgAdapter remindCzBgAdapter=new RemindCzBgAdapter(this,list);
        lv_cz.setAdapter(remindCzBgAdapter);
            BaoGaoCz gaoCz=new BaoGaoCz();
            gaoCz.csbh="测试编号";
          gaoCz.sz="属种";
        gaoCz.tjr="提交人";
        gaoCz.tjrq="提交日期";
        list.add(gaoCz);
        BaoGaoCz gaoCz0=new BaoGaoCz();
        gaoCz0.csbh="2017013245";
        gaoCz0.sz="水稻";
        gaoCz0.tjr="杨旭红";
        gaoCz0.tjrq="2018-07-25";
        list.add(gaoCz0);
        BaoGaoCz gaoCz1=new BaoGaoCz();
        gaoCz1.csbh="2017013248";
        gaoCz1.sz="玉米";
        gaoCz1.tjr="邓超";
        gaoCz1.tjrq="2018-07-25";
        list.add(gaoCz1);
        remindCzBgAdapter.update(list);
    }
}
