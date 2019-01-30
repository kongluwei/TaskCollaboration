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
import pdwy.com.taskcollaboration.adapter.RemindFcScyAdapter;
import pdwy.com.taskcollaboration.core.BaseActivity;
import pdwy.com.taskcollaboration.model.bean.FanCaiScy;

public class RemindFcScyActivity extends BaseActivity {

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
        return R.layout.activity_remind_fc_scy;
    }

    @Override
    protected void onCreateAfter() {
        ll_head_return.setVisibility(View.VISIBLE);
        ll_head_personalcenter.setVisibility(View.INVISIBLE);
        tv_head_title.setVisibility(View.VISIBLE);
        tv_head_title.setText("已寄出的繁材");

        List<FanCaiScy> list=new ArrayList<>();
        RemindFcScyAdapter remindFcScyAdapter=new RemindFcScyAdapter(this,list);
        lv_cz.setAdapter(remindFcScyAdapter);
        FanCaiScy fanCaiScy=new FanCaiScy();
        fanCaiScy.dh="单号";
        fanCaiScy.jsr="接收人";
        fanCaiScy.sdrq="收到日期";
        list.add(fanCaiScy);
        FanCaiScy fanCaiScy0=new FanCaiScy();
        fanCaiScy0.dh="FCLQ-3701-01-20180515";
        fanCaiScy0.jsr="公主岭-周海涛";
        fanCaiScy0.sdrq="2018-08-07";
        list.add(fanCaiScy0);
        FanCaiScy fanCaiScy1=new FanCaiScy();
        fanCaiScy1.dh="FCLQ-3701-01-20180725";
        fanCaiScy1.jsr="济南-张晗";
        fanCaiScy1.sdrq="2018-08-07";
        list.add(fanCaiScy1);
        remindFcScyAdapter.update(list);
    }
}
