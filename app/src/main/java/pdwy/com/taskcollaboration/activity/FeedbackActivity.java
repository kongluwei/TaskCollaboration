package pdwy.com.taskcollaboration.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.OnClick;
import pdwy.com.taskcollaboration.R;
import pdwy.com.taskcollaboration.core.BaseActivity;

public class FeedbackActivity extends Fragment {
    TextView tv_cz_0_0;
    TextView tv_cz_0_1;
    TextView tv_hongdian;
    LinearLayout ll_cz_0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_feedback,null);
        onCreateAfter(view);

        return view;
    }

    protected int getLayoutId() {
        return R.layout.activity_feedback;
    }

    protected void onCreateAfter(View view1) {
        LinearLayout ll_sc= view1.findViewById(R.id.ll_sc);
        RefreshLayout refreshLayout = (RefreshLayout)view1.findViewById(R.id.refreshLayout);
        //设置 Header 为 贝塞尔雷达 样式
        refreshLayout.setRefreshHeader(new MaterialHeader(getContext()));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {

                new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(5000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        refreshLayout.finishRefresh();
                    }
                }.start();

            }
        });
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_fankui, null);

        tv_cz_0_0=view.findViewById(R.id.tv_cz_0_1);
        tv_cz_0_1=view.findViewById(R.id.tv_cz_0_0);
        tv_hongdian=view.findViewById(R.id.tv_hongdian);
        ll_cz_0=view.findViewById(R.id.ll_cz_0);

        tv_cz_0_0.setText("2018-10-20");
        tv_cz_0_1.setText("您有新的反馈");
        tv_hongdian.setText("0");
        ll_cz_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),FeedbackListActivity.class));
            }
        });
        ll_sc.addView(view);
    }
    @OnClick({R.id.ll_cz_0})
    public void OnButterknifeClick(View v){

//        startActivity(FeedbackListActivity.class,false);

    }
}
