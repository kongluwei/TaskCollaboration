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
import pdwy.com.taskcollaboration.adapter.RemindBgCsyAdapter;
import pdwy.com.taskcollaboration.core.BaseActivity;
import pdwy.com.taskcollaboration.model.bean.BaoGaoCsy;

public class RemindBgCsyActivity extends BaseActivity {
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
        return R.layout.activity_remind_bg_csy;
    }

    @Override
    protected void onCreateAfter() {
        ll_head_return.setVisibility(View.VISIBLE);
        ll_head_personalcenter.setVisibility(View.INVISIBLE);
        tv_head_title.setVisibility(View.VISIBLE);
        tv_head_title.setText("退回的报告");

        List<BaoGaoCsy>list=new ArrayList<>();
        RemindBgCsyAdapter remindBgCsyAdapter=new RemindBgCsyAdapter(this,list);
        lv_cz.setAdapter(remindBgCsyAdapter);

        BaoGaoCsy baoGaoCsy=new BaoGaoCsy();
        baoGaoCsy.csbh="测试编号";
        baoGaoCsy.sz="属种";
        baoGaoCsy.thsj="退回时间";
        list.add(baoGaoCsy);
        BaoGaoCsy baoGaoCsy0=new BaoGaoCsy();
        baoGaoCsy0.csbh="2016013248";
        baoGaoCsy0.sz="玉米";
        baoGaoCsy0.thsj="2018-07-25";
        list.add(baoGaoCsy0);
        BaoGaoCsy baoGaoCsy1=new BaoGaoCsy();
        baoGaoCsy1.csbh="2016023568";
        baoGaoCsy1.sz="玉米";
        baoGaoCsy1.thsj="2018-07-25";
        list.add(baoGaoCsy1);
        remindBgCsyAdapter.update(list);
    }
}
