package pdwy.com.taskcollaboration.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pdwy.com.taskcollaboration.R;
import pdwy.com.taskcollaboration.core.BaseCommonAdapter;
import pdwy.com.taskcollaboration.model.bean.NoticeGgXq;

/**
 * Author： by MR on 2018/10/19.
 */

public class NoticeAdapter extends BaseCommonAdapter {
    public NoticeAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.item_notice,null);
        NoticeGgXq noticeGgXq= (NoticeGgXq) list.get(position);
        TextView tv0=convertView.findViewById(R.id.tv_0);
        tv0.setText(noticeGgXq.bt);
        TextView tv1=convertView.findViewById(R.id.tv_1);
        tv1.setText(noticeGgXq.nr);
        TextView tv2=convertView.findViewById(R.id.tv_2);
        tv2.setText(noticeGgXq.ggrq);
        if(position==0)
            convertView.setBackgroundColor(Color.parseColor("#E2E2E2"));
        return convertView;
    }
}
