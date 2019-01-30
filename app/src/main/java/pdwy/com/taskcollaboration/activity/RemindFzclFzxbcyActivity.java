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
import pdwy.com.taskcollaboration.adapter.RemindFzclFzxbcyAdapter;
import pdwy.com.taskcollaboration.core.BaseActivity;

public class RemindFzclFzxbcyActivity extends BaseActivity {
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
        return R.layout.activity_remind_fzcl_fzxbcy;
    }

    @Override
    protected void onCreateAfter() {
        ll_head_return.setVisibility(View.VISIBLE);
        ll_head_personalcenter.setVisibility(View.INVISIBLE);
        tv_head_title.setVisibility(View.VISIBLE);
        tv_head_title.setText("待入库的繁材");
        List<FanzclFzxbcy>list=new ArrayList<>();
        RemindFzclFzxbcyAdapter remindFzclFzxbcyAdapter=new RemindFzclFzxbcyAdapter(this,list);
        lv_cz.setAdapter(remindFzclFzxbcyAdapter);
        FanzclFzxbcy fanzclFzxbcy=new FanzclFzxbcy();
        fanzclFzxbcy.dh="单号";
        fanzclFzxbcy.yjr="邮寄人";
        fanzclFzxbcy.yjrq="邮寄日期";
        list.add(fanzclFzxbcy);
        FanzclFzxbcy fanzclFzxbcy0=new FanzclFzxbcy();
        fanzclFzxbcy0.dh="FCLQ-3701-01-20180725";
        fanzclFzxbcy0.yjr="品种保护";
        fanzclFzxbcy0.yjrq="2018-07-25";
        list.add(fanzclFzxbcy0);
        FanzclFzxbcy fanzclFzxbcy1=new FanzclFzxbcy();
        fanzclFzxbcy1.dh="FCLQ-3701-02-20180724";
        fanzclFzxbcy1.yjr="品种保护";
        fanzclFzxbcy1.yjrq="2018-07-25";
        list.add(fanzclFzxbcy1);
        remindFzclFzxbcyAdapter.update(list);


    }
}
