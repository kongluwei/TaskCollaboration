package pdwy.com.taskcollaboration.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pdwy.com.taskcollaboration.R;
import pdwy.com.taskcollaboration.core.BaseCommonAdapter;
import pdwy.com.taskcollaboration.model.bean.BaoGaoCz;

/**
 * Author： by MR on 2018/10/18.
 */

public class RemindCzBgAdapter extends BaseCommonAdapter {
    public RemindCzBgAdapter(Context context, List list) {
        super(context, list);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.item_baodao_cz,null);
        BaoGaoCz gaoCz= (BaoGaoCz) list.get(position);
        TextView tv0=(TextView)convertView.findViewById(R.id.tv_0);
        tv0.setText(gaoCz.csbh);
        TextView tv1=(TextView)convertView.findViewById(R.id.tv_1);
        tv1.setText(gaoCz.sz);
        TextView tv2=(TextView)convertView.findViewById(R.id.tv_2);
        tv2.setText(gaoCz.tjr);
        TextView tv3=(TextView)convertView.findViewById(R.id.tv_3);
        tv3.setText(gaoCz.tjrq);
        if(position==0)
        convertView.setBackgroundColor(Color.parseColor("#E2E2E2"));
        return convertView;
    }

}
