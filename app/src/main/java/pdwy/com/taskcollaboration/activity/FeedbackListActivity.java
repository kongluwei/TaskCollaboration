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
import pdwy.com.taskcollaboration.adapter.FeedbackAdapter;
import pdwy.com.taskcollaboration.core.BaseActivity;
import pdwy.com.taskcollaboration.model.bean.FanKui;

public class FeedbackListActivity extends BaseActivity {
    @BindView(R.id.ll_head_return)
    LinearLayout ll_head_return;
    @BindView(R.id.tv_head_title)
    TextView tv_head_title;

    @BindView(R.id.ll_head_personalcenter)
    LinearLayout ll_head_personalcenter;
    @BindView(R.id.lv_fk)
    ListView lv_fk;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_feedback_list;
    }

    @Override
    protected void onCreateAfter() {
        ll_head_return.setVisibility(View.VISIBLE);
        ll_head_personalcenter.setVisibility(View.INVISIBLE);
        tv_head_title.setVisibility(View.VISIBLE);
        tv_head_title.setText("反馈列表");

        List<FanKui>list=new ArrayList<>();

        FeedbackAdapter feedbackAdapter=new FeedbackAdapter(this,list);

        lv_fk.setAdapter(feedbackAdapter);
        FanKui fanKui=new FanKui();
        fanKui.fkzt="反馈主题";
        fanKui.fkr="反馈人";
        fanKui.fkrq="反馈日期";
        list.add(fanKui);
        FanKui fanKui0=new FanKui();
        fanKui0.fkzt="201807253的繁材未收到";
        fanKui0.fkr="周海涛";
        fanKui0.fkrq="2018-07-25";
        list.add(fanKui0);
        FanKui fanKui1=new FanKui();
        fanKui1.fkzt="201805833的任务未收到";
        fanKui1.fkr="张晗";
        fanKui1.fkrq="2018-07-23";
        list.add(fanKui1);
        feedbackAdapter.update(list);
    }


}
