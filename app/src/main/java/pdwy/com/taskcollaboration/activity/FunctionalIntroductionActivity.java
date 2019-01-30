package pdwy.com.taskcollaboration.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import butterknife.BindView;
import pdwy.com.taskcollaboration.R;
import pdwy.com.taskcollaboration.core.BaseActivity;

/**
 * 功能介绍
 * Author： by MR on 2018/8/15.
 */

public class FunctionalIntroductionActivity extends BaseActivity {
    @BindView(R.id.ll_head_return)
    LinearLayout ll_head_return;
    @BindView(R.id.ll_head_personalcenter)
    LinearLayout ll_head_personalcenter;
    @BindView(R.id.tv_head_title)
    TextView tv_head_title;

    @Override
    protected int getLayoutId() {
        return R.layout.acrivity_functional_introduction;
    }

    @Override
    protected void onCreateAfter() {
        ll_head_return.setVisibility(View.VISIBLE);
        ll_head_personalcenter.setVisibility(View.INVISIBLE);
        tv_head_title.setVisibility(View.VISIBLE);
        tv_head_title.setText("功能介绍");
    }
}
