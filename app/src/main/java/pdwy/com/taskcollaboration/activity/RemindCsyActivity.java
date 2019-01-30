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

import butterknife.BindView;
import butterknife.OnClick;
import pdwy.com.taskcollaboration.R;
import pdwy.com.taskcollaboration.core.BaseActivity;

public class RemindCsyActivity extends Fragment implements View.OnClickListener{
    TextView tv_cz_0_0;
    TextView tv_cz_0_1;
    TextView tv_cz_1_0;
    TextView tv_cz_1_1;
    TextView tv_hongdian_0;
    TextView tv_hongdian_1;
    LinearLayout ll_cz_0;
    LinearLayout ll_cz_1;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_remind_csy,null);
        onCreateAfter(view);
        return view;
    }
    protected int getLayoutId() {
        return R.layout.activity_remind_csy;
    }

    protected void onCreateAfter(View view) {
        tv_cz_0_0=view.findViewById(R.id.tv_cz_0_1);
        tv_cz_0_1=view.findViewById(R.id.tv_cz_0_0);
        tv_cz_1_0=view.findViewById(R.id.tv_cz_1_1);
        tv_cz_1_1=view.findViewById(R.id.tv_cz_1_0);
        tv_hongdian_0=view.findViewById(R.id.tv_hongdian_0);
        tv_hongdian_1=view.findViewById(R.id.tv_hongdian_1);
        ll_cz_0=view.findViewById(R.id.ll_cz_0);
        ll_cz_1=view.findViewById(R.id.ll_cz_1);

        tv_cz_0_0.setText("2018-07-25");
        tv_cz_0_1.setText("您有2个待接收的新测试任务");
        tv_cz_1_0.setText("2018-07-25");
        tv_cz_1_1.setText("您有新的被退回的报告");
        tv_hongdian_0.setText("0");
        tv_hongdian_1.setText("0");
        ll_cz_0.setOnClickListener(this);
        ll_cz_1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
                switch (view.getId()) {
            case R.id.ll_cz_0:
                //新测试任务
                startActivity(new Intent(getActivity(),RemindRwCsyActivity.class));
                break;
            case R.id.ll_cz_1:
                //被退回的报告
                startActivity(new Intent(getActivity(),RemindBgCsyActivity.class));
                break;

        }
    }

//    @OnClick({R.id.ll_cz_0,R.id.ll_cz_1})
//    public void OnButterknifeClick(View v){
//

//    }
}
