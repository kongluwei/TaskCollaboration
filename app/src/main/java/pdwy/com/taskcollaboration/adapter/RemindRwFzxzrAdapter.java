package pdwy.com.taskcollaboration.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pdwy.com.taskcollaboration.R;
import pdwy.com.taskcollaboration.core.BaseCommonAdapter;
import pdwy.com.taskcollaboration.model.bean.RenWuFzxzr;

/**
 * Author： by MR on 2018/10/19.
 */

public class RemindRwFzxzrAdapter extends BaseCommonAdapter {
    public RemindRwFzxzrAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.item_rw_fzxzr,null);
        RenWuFzxzr renWuFzxzr= (RenWuFzxzr) list.get(position);
        TextView tv0=convertView.findViewById(R.id.tv_0);
        tv0.setText(renWuFzxzr.csbh);
        TextView tv1=convertView.findViewById(R.id.tv_1);
        tv1.setText(renWuFzxzr.sz);
        TextView tv2=convertView.findViewById(R.id.tv_2);
        tv2.setText(renWuFzxzr.xdr);
        TextView tv3=convertView.findViewById(R.id.tv_3);
        tv3.setText(renWuFzxzr.xdrq);
        if(position==0)
            convertView.setBackgroundColor(Color.parseColor("#E2E2E2"));
        return convertView;
    }
}
