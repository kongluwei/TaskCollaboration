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
import pdwy.com.taskcollaboration.adapter.RemindRwFzxzrAdapter;
import pdwy.com.taskcollaboration.core.BaseActivity;
import pdwy.com.taskcollaboration.model.bean.RenWuFzxzr;

public class RemindRwFzxzrActivity extends BaseActivity {

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
        return R.layout.activity_remind_rw_fzxzr;
    }

    @Override
    protected void onCreateAfter() {
        ll_head_return.setVisibility(View.VISIBLE);
        ll_head_personalcenter.setVisibility(View.INVISIBLE);
        tv_head_title.setVisibility(View.VISIBLE);
        tv_head_title.setText("新接收的任务");
        List<RenWuFzxzr> list=new ArrayList<>();
        RemindRwFzxzrAdapter remindRwFzxzrAdapter=new RemindRwFzxzrAdapter(this,list);
        lv_cz.setAdapter(remindRwFzxzrAdapter);
        RenWuFzxzr renWuFzxzr=new RenWuFzxzr();
        renWuFzxzr.csbh="测试编号";
        renWuFzxzr.sz="属种";
        renWuFzxzr.xdr="下达人";
        renWuFzxzr.xdrq="下达日期";
        list.add(renWuFzxzr);
        RenWuFzxzr renWuFzxzr0=new RenWuFzxzr();
        renWuFzxzr0.csbh="2017013245";
        renWuFzxzr0.sz="水稻";
        renWuFzxzr0.xdr="杨旭红";
        renWuFzxzr0.xdrq="2018-07-25";
        list.add(renWuFzxzr0);
        RenWuFzxzr renWuFzxzr1=new RenWuFzxzr();
        renWuFzxzr1.csbh="2017013248";
        renWuFzxzr1.sz="玉米";
        renWuFzxzr1.xdr="韩瑞玺";
        renWuFzxzr1.xdrq="2018-07-25";
        list.add(renWuFzxzr1);
        remindRwFzxzrAdapter.update(list);

    }
}
