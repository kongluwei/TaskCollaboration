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
import pdwy.com.taskcollaboration.adapter.RemindRwScyAdapter;
import pdwy.com.taskcollaboration.core.BaseActivity;
import pdwy.com.taskcollaboration.model.bean.RenWuScy;

public class RemindRwScyActivity extends BaseActivity {

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
        return R.layout.activity_remind_rw_scy;
    }

    @Override
    protected void onCreateAfter() {
        ll_head_return.setVisibility(View.VISIBLE);
        ll_head_personalcenter.setVisibility(View.INVISIBLE);
        tv_head_title.setVisibility(View.VISIBLE);
        tv_head_title.setText("新接收的任务");
        List<RenWuScy> list=new ArrayList<>();
        RemindRwScyAdapter remindRwScyAdapter=new RemindRwScyAdapter(this,list);
        lv_cz.setAdapter(remindRwScyAdapter);
        RenWuScy renWuScy=new RenWuScy();
        renWuScy.csbh="测试编号";
        renWuScy.sqh="申请号";
        renWuScy.pzmc="品种名称";
        renWuScy.sz="属种";
        list.add(renWuScy);
        RenWuScy renWuScy0=new RenWuScy();
        renWuScy0.csbh="2017013245";
        renWuScy0.sqh="20170122.5";
        renWuScy0.pzmc="稻种022";
        renWuScy0.sz="水稻";
        list.add(renWuScy0);
        RenWuScy renWuScy1=new RenWuScy();
        renWuScy1.csbh="2017013248";
        renWuScy1.sqh="20170322.7";
        renWuScy1.pzmc="玉京311";
        renWuScy1.sz="玉米";
        list.add(renWuScy1);
        remindRwScyAdapter.update(list);
    }
}
