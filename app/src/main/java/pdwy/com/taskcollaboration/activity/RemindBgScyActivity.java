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
import pdwy.com.taskcollaboration.adapter.RemindBgScyAdapter;
import pdwy.com.taskcollaboration.core.BaseActivity;
import pdwy.com.taskcollaboration.model.bean.BaoGaoScy;

public class RemindBgScyActivity extends BaseActivity {

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
        return R.layout.activity_remind_bg_scy;
    }

    @Override
    protected void onCreateAfter() {
        ll_head_return.setVisibility(View.VISIBLE);
        ll_head_personalcenter.setVisibility(View.INVISIBLE);
        tv_head_title.setVisibility(View.VISIBLE);
        tv_head_title.setText("待审查报告");

        List<BaoGaoScy>list=new ArrayList<>();
        RemindBgScyAdapter remindBgScyAdapter=new RemindBgScyAdapter(this,list);
        lv_cz.setAdapter(remindBgScyAdapter);
        BaoGaoScy baoGaoScy=new BaoGaoScy();
        baoGaoScy.csbh="测试编号";
        baoGaoScy.sz="属种";
        baoGaoScy.csy="测试员";
        baoGaoScy.csdd="测试地点";
        baoGaoScy.zq="周期";
        list.add(baoGaoScy);
        BaoGaoScy baoGaoScy0=new BaoGaoScy();
        baoGaoScy0.csbh="2017013245";
        baoGaoScy0.sz="水稻";
        baoGaoScy0.csy="周海涛";
        baoGaoScy0.csdd="公主岭";
        baoGaoScy0.zq="2";
        list.add(baoGaoScy0);
        BaoGaoScy baoGaoScy1=new BaoGaoScy();
        baoGaoScy1.csbh="2016013248";
        baoGaoScy1.sz="玉米";
        baoGaoScy1.csy="张晗";
        baoGaoScy1.csdd="济南";
        baoGaoScy1.zq="2";
        list.add(baoGaoScy1);
        BaoGaoScy baoGaoScy2=new BaoGaoScy();
        baoGaoScy2.csbh="2017058963";
        baoGaoScy2.sz="百合属";
        baoGaoScy2.csy="刘艳芳";
        baoGaoScy2.csdd="昆明";
        baoGaoScy2.zq="1";
        list.add(baoGaoScy2);
        remindBgScyAdapter.update(list);

    }
}
