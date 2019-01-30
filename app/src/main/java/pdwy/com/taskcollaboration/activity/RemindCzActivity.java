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

public class RemindCzActivity extends Fragment {
    TextView tv_cz_0_0;
    TextView tv_cz_0_1;
    TextView tv_hongdian;
    LinearLayout ll_cz_0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_remind_cz,null);

        onCreateAfter(view);
        return view;
    }

    protected int getLayoutId() {
        return R.layout.activity_remind_cz;
    }

    protected void onCreateAfter(View view) {
        tv_cz_0_0=view.findViewById(R.id.tv_cz_0_0);
        tv_cz_0_1=view.findViewById(R.id.tv_cz_0_0);
        tv_hongdian=view.findViewById(R.id.tv_hongdian);
        ll_cz_0=view.findViewById(R.id.ll_cz_0);

        tv_cz_0_0.setText("2018-07-25");
        tv_cz_0_1.setText("您有2个报告待审批");
        tv_hongdian.setText("0");
        ll_cz_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),RemindCzBgActivity.class));
            }
        });

    }
    @OnClick({R.id.ll_cz_0})
    public void OnButterknifeClick(View v){
        //待批准的报告
//        startActivity(RemindCzBgActivity.class,false);

    }
}
