package pdwy.com.taskcollaboration.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    protected void onCreateAfter(View view) {

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
    }
    @OnClick({R.id.ll_cz_0})
    public void OnButterknifeClick(View v){

//        startActivity(FeedbackListActivity.class,false);

    }
}
