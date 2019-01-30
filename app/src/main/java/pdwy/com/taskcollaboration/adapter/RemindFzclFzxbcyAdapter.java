package pdwy.com.taskcollaboration.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pdwy.com.taskcollaboration.R;
import pdwy.com.taskcollaboration.activity.FanzclFzxbcy;
import pdwy.com.taskcollaboration.core.BaseCommonAdapter;

/**
 * Author： by MR on 2018/10/19.
 */

public class RemindFzclFzxbcyAdapter extends BaseCommonAdapter {
    public RemindFzclFzxbcyAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.item_fzcl_fzxbac,null);
        FanzclFzxbcy fanzclFzxbcy= (FanzclFzxbcy) list.get(position);
        TextView tv0=convertView.findViewById(R.id.tv_0);
        tv0.setText(fanzclFzxbcy.dh);
        TextView tv1=convertView.findViewById(R.id.tv_1);
        tv1.setText(fanzclFzxbcy.yjr);
        TextView tv2=convertView.findViewById(R.id.tv_2);
        tv2.setText(fanzclFzxbcy.yjrq);
        if(position==0)
            convertView.setBackgroundColor(Color.parseColor("#E2E2E2"));
        return convertView;
    }
}
