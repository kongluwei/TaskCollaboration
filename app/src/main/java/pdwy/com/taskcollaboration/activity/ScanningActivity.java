package pdwy.com.taskcollaboration.activity;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.zxing.Result;

import butterknife.BindView;
import butterknife.OnClick;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import pdwy.com.taskcollaboration.R;
import pdwy.com.taskcollaboration.core.BaseActivity;
import pdwy.com.taskcollaboration.utils.MLog;
import pdwy.com.taskcollaboration.utils.ToastUtil;

public class ScanningActivity extends BaseActivity implements ZXingScannerView.ResultHandler {
    @BindView(R.id.ll_head_return)
    LinearLayout ll_head_return;
    @BindView(R.id.tv_head_title)
    TextView tv_head_title;
    @BindView(R.id.ll_head_personalcenter)
    LinearLayout ll_head_personalcenter;
    @BindView(R.id.ed_scanning)
    EditText ed_scanning;
    @BindView(R.id.bt_queren)
    Button bt_queren;
    @BindView(R.id.scanner_view)
     ZXingScannerView mScannerView;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_scanning;
    }

    @Override
    protected void onCreateAfter() {
        ll_head_return.setVisibility(View.VISIBLE);
        ll_head_personalcenter.setVisibility(View.INVISIBLE);
        tv_head_title.setVisibility(View.VISIBLE);
        tv_head_title.setText("扫描查询");
        ed_scanning.setText("2018010358");
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }
    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);

        if (rawResult != null && rawResult.getText() != null) {
            String text = rawResult.getText();
            MLog.i("二维码扫描结果：" + text);
            ed_scanning.setText(text);

        } else {
            ToastUtil.showMessage(this, "未扫描到二维码");
        }
    }
    @OnClick({R.id.bt_queren})
    public void OnButterknifeClick(View v){
            switch (ed_scanning.getText().toString()){

                case "2018010358":
                    startStringActivity(ScanQuerySqmActivity.class);
                    break;
                case "2018010359":
                    startStringActivity(ScanQueryTjmActivity.class);
                    break;
                case "2018010359A":
                    startStringActivity(ScanQueryCsbmZFzxActivity.class);
                    break;
                case "2018010359B":
                    startStringActivity(ScanQueryCsbmFzxZzxrwActivity.class);
                    break;
                case "2018010359A11BB5B9":
                    startStringActivity(ScanQueryTjsybmActivity.class);
                    break;
                case "XIN123456531":
                    startStringActivity(ScanQueryBcbhZzxActivity.class);
                    break;
                case "XIN123456532":
                    startStringActivity(ScanQueryBcbhBcyActivity.class);
                    break;
                case "XIN123456533":
                    startStringActivity(ScanQueryBcbhCsyActivity.class);
                    break;
            }
    }
    private void startStringActivity(Class clas){
        Intent intent=new Intent(ScanningActivity.this,clas);
        intent.putExtra("number",ed_scanning.getText().toString());
        startActivity(intent);
        finish();
    }
}
