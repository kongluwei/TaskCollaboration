package pdwy.com.taskcollaboration.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pdwy.com.taskcollaboration.R;
import pdwy.com.taskcollaboration.core.BaseCommonAdapter;
import pdwy.com.taskcollaboration.model.bean.FanCaiScy;

/**
 * Author： by MR on 2018/10/18.
 */

public class RemindFcScyAdapter extends BaseCommonAdapter {
    public RemindFcScyAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.item_fc__scy,null);
        FanCaiScy fanCaiScy= (FanCaiScy) list.get(position);
        TextView tv0=(TextView)convertView.findViewById(R.id.tv_0);
        tv0.setText(fanCaiScy.dh);
        TextView tv1=(TextView)convertView.findViewById(R.id.tv_1);
        tv1.setText(fanCaiScy.jsr);
        TextView tv2=(TextView)convertView.findViewById(R.id.tv_2);
        tv2.setText(fanCaiScy.sdrq);
        if(position==0)
            convertView.setBackgroundColor(Color.parseColor("#E2E2E2"));
        return convertView;
    }
}
