package pdwy.com.taskcollaboration.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Author： by MR on 2018/8/23.
 */

public class InputData {
    MySQLiteOpenHelper msoh;

    public InputData(Context c) {
        msoh = new MySQLiteOpenHelper(c);

    }

    private void setUser(){


    }
    public static ArrayList getSingle(ArrayList list){
        ArrayList newList = new ArrayList();     //创建新集合
        Iterator it = list.iterator();        //根据传入的集合(旧集合)获取迭代器
        while(it.hasNext()){          //遍历老集合
            Object obj = it.next();       //记录每一个元素
            if(!newList.contains(obj)){      //如果新集合中不包含旧集合中的元素
                newList.add(obj);       //将元素添加
            }
        }
        return newList;
    }

}
