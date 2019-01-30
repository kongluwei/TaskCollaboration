package pdwy.com.taskcollaboration.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pdwy.com.taskcollaboration.R;
import pdwy.com.taskcollaboration.core.BaseCommonAdapter;
import pdwy.com.taskcollaboration.model.bean.BaoGaoScy;

/**
 * Author： by MR on 2018/10/24.
 */

public class RemindBgScyAdapter extends BaseCommonAdapter {
    public RemindBgScyAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.item_bg_scy,null);
        BaoGaoScy baoGaoScy= (BaoGaoScy) list.get(i);

        TextView tv0=(TextView) view.findViewById(R.id.tv_0);
        tv0.setText(baoGaoScy.csbh);
        TextView tv1=(TextView) view.findViewById(R.id.tv_1);
        tv1.setText(baoGaoScy.sz);
        TextView tv2=(TextView) view.findViewById(R.id.tv_2);
        tv2.setText(baoGaoScy.csy);
        TextView tv3=(TextView) view.findViewById(R.id.tv_3);
        tv3.setText(baoGaoScy.csdd);
        TextView tv4=(TextView) view.findViewById(R.id.tv_4);
        tv4.setText(baoGaoScy.zq);
        if(i==0)
            view.setBackgroundColor(Color.parseColor("#E2E2E2"));
        return view;
    }
}
