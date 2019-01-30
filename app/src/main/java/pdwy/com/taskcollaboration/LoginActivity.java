package pdwy.com.taskcollaboration;


import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;
import pdwy.com.taskcollaboration.core.BaseActivity;
import pdwy.com.taskcollaboration.utils.SharePreferencesUtils;

/**
 * Author： by MR on 2018/7/25.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.tv_username)
    TextView tv_username;
    @BindView(R.id.tv_pwawrod)
    TextView tv_pwawrod;

    @BindView(R.id.cb_remember)
    CheckBox cb_remember;
    @BindView(R.id.ll_login)
    LinearLayout ll_login;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login_layout;
    }

    @Override
    protected void onCreateAfter() {
        ll_login.setBackgroundDrawable(getDrawableMipmap(R.mipmap.login));
        tv_username.setText(SharePreferencesUtils.getString(getString(R.string.user_name),""));
        if("".equals(SharePreferencesUtils.getString(getString(R.string.user_paw),"")))
        tv_pwawrod.setText("");
        else {
            tv_username.setText(SharePreferencesUtils.getString(getString(R.string.user_name),"admin"));
            tv_pwawrod.setText(SharePreferencesUtils.getString(getString(R.string.user_paw), ""));
            cb_remember.setChecked(true);
        }
    }
    @OnClick(R.id.tv_login)
    public void signIn(View v){
        if(tv_username.getText()==null||"".equals(tv_username.getText().toString().trim())||tv_pwawrod.getText()==null||"".equals(tv_pwawrod.getText().toString().trim())){
            Toast.makeText(this,"账号密码不能为空",Toast.LENGTH_SHORT).show();
        }else{

            if(signInAsynchronous()==1) {


                SharePreferencesUtils.putString(getString(R.string.user_id), tv_username.getText().toString());
                SharePreferencesUtils.putString(getString(R.string.user_name), tv_username.getText().toString());

                switch (tv_username.getText().toString()){
                    case "admin0":
                        SharePreferencesUtils.putString(getString(R.string.user_identity), "处长");
                        SharePreferencesUtils.putString(getString(R.string.user_fullName), "周海涛0");
                        break;
                    case "admin1":
                        SharePreferencesUtils.putString(getString(R.string.user_identity), "审查员");
                        SharePreferencesUtils.putString(getString(R.string.user_fullName), "周海涛1");
                        break;
                    case "admin2":
                        SharePreferencesUtils.putString(getString(R.string.user_identity), "分中心主任");
                        SharePreferencesUtils.putString(getString(R.string.user_fullName), "周海涛2");
                        break;
                    case "admin3":
                        SharePreferencesUtils.putString(getString(R.string.user_identity), "测试员");
                        SharePreferencesUtils.putString(getString(R.string.user_fullName), "周海涛3");
                        break;
                    case "admin4":
                        SharePreferencesUtils.putString(getString(R.string.user_identity), "分中心保藏员");
                        SharePreferencesUtils.putString(getString(R.string.user_fullName), "周海涛4");
                        break;
                }
                if(cb_remember.isChecked()) {
                      SharePreferencesUtils.putString(getString(R.string.user_paw), tv_pwawrod.getText().toString());

                }
                else{
                    SharePreferencesUtils.putString(getString(R.string.user_paw),"");

                }
                Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,MainActivity.class));
                finish();


            }
        }

    }
    int signInAsynchronous(){
        if("admin".equals(tv_pwawrod.getText().toString())){
            return 1;
        }
        else{
            Toast.makeText(this,"账号密码错误",Toast.LENGTH_SHORT).show();
            return 0;
        }

    }
}
