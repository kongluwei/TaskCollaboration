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
import pdwy.com.taskcollaboration.adapter.RemindRwCsyAdapter;
import pdwy.com.taskcollaboration.core.BaseActivity;
import pdwy.com.taskcollaboration.model.bean.RenWuCsy;

public class RemindRwCsyActivity extends BaseActivity {
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
        return R.layout.activity_remind_rw_csy;
    }

    @Override
    protected void onCreateAfter() {
        ll_head_return.setVisibility(View.VISIBLE);
        ll_head_personalcenter.setVisibility(View.INVISIBLE);
        tv_head_title.setVisibility(View.VISIBLE);
        tv_head_title.setText("待接收的新任务");

        List<RenWuCsy> list=new ArrayList<>();
        RemindRwCsyAdapter remindRwCsyAdapter=new RemindRwCsyAdapter(this,list);
        lv_cz.setAdapter(remindRwCsyAdapter);
        RenWuCsy renWuCsy=new RenWuCsy();
        renWuCsy.csbh="测试编号";
        renWuCsy.sz="属种";
        renWuCsy.scy="审查员";
        renWuCsy.zq="周期";
        list.add(renWuCsy);
        RenWuCsy renWuCsy0=new RenWuCsy();
        renWuCsy0.csbh="2017013245";
        renWuCsy0.sz="水稻";
        renWuCsy0.scy="杨旭红";
        renWuCsy0.zq="1";
        list.add(renWuCsy0);
        RenWuCsy renWuCsy1=new RenWuCsy();
        renWuCsy1.csbh="2017013248";
        renWuCsy1.sz="玉米";
        renWuCsy1.scy="杨旭红";
        renWuCsy1.zq="2";
        list.add(renWuCsy1);
        remindRwCsyAdapter.update(list);

    }
}
