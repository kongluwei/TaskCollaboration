package pdwy.com.taskcollaboration.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pdwy.com.taskcollaboration.R;
import pdwy.com.taskcollaboration.adapter.NoticeAdapter;
import pdwy.com.taskcollaboration.core.BaseActivity;
import pdwy.com.taskcollaboration.model.bean.NoticeGgXq;

public class NoticeActivity extends Fragment {

    ListView lv_cz;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_notice, container, false);
        lv_cz=view.findViewById(R.id.lv_cz);
        onCreateAfter();
        return view;
    }


    protected void onCreateAfter() {

final List<NoticeGgXq> list=new ArrayList<>();
        NoticeAdapter noticeAdapter=new NoticeAdapter(getActivity(),list);
        lv_cz.setAdapter(noticeAdapter);
        lv_cz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                    return;
                Intent intent=new Intent(view.getContext(),NoticeGgXqActivity.class);
                intent.putExtra("bt",list.get(position).bt);
                intent.putExtra("nr",list.get(position).nr);
                intent.putExtra("ggrq",list.get(position).ggrq);
                startActivity(intent);
            }
        });



        NoticeGgXq noticeGgXq=new NoticeGgXq();
        noticeGgXq.bt="标题";
        noticeGgXq.nr="内容";
        noticeGgXq.ggrq="公告日期";
        list.add(noticeGgXq);
        NoticeGgXq noticeGgXq0=new NoticeGgXq();
        noticeGgXq0.bt="系统上线了1";
        noticeGgXq0.nr="测试新版系统于2018年12月31号上线了1";
        noticeGgXq0.ggrq="2018-12-31";
        list.add(noticeGgXq0);
        NoticeGgXq noticeGgXq1=new NoticeGgXq();
        noticeGgXq1.bt="系统上线了2";
        noticeGgXq1.nr="测试新版系统于2018年12月31号上线了2";
        noticeGgXq1.ggrq="2018-12-31";
        list.add(noticeGgXq1);
        NoticeGgXq noticeGgXq2=new NoticeGgXq();
        noticeGgXq2.bt="系统上线了3";
        noticeGgXq2.nr="测试新版系统于2018年12月31号上线了3";
        noticeGgXq2.ggrq="2018-12-31";
        list.add(noticeGgXq2);
        noticeAdapter.update(list);


    }
}
