package pdwy.com.taskcollaboration.adapter;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import pdwy.com.taskcollaboration.core.BaseCommonAdapter;

/**
 * Author： by MR on 2018/10/29.
 */

public class Main2FragmentAdapter extends FragmentPagerAdapter {

    List<android.support.v4.app.Fragment> list;

    public Main2FragmentAdapter(FragmentManager fm, List<android.support.v4.app.Fragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
