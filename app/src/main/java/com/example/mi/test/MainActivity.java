package com.example.mi.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new PostListAdapter(this, getData()));
        LinearLayout tLinearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.list_head, listView, false);
        TextView tTextView = new TextView(this);
        tTextView.setText("哈哈哈");
        tLinearLayout.addView(tTextView);
        listView.addHeaderView(tLinearLayout);
    }

    private List<String> getData(){

        List<String> data = new ArrayList<>();
        data.add("测试数据1");
        data.add("测试数据2");
        data.add("测试数据3");
        data.add("测试数据4");

        return data;
    }

    public class PostListAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater mInflater = null;
        private List<String> mPostList;

        public PostListAdapter(Context context, List<String> postList){
            this.mContext = context;
            this.mInflater = LayoutInflater.from(context);
            this.mPostList = postList;
        }

        @Override
        public int getCount() {
            if (mPostList != null) {
                return mPostList.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            if (mPostList != null) {
                if (0 <= position && position < mPostList.size()) {
                    return (Object) mPostList.get(position);
                }
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void setPostList(List<String> postList) {
            this.mPostList = postList;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder tViewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.list_text_item, parent, false);
                tViewHolder = new ViewHolder();
                tViewHolder.postInfoView = (TextView) convertView.findViewById(R.id.text);
                convertView.setTag(tViewHolder);
            }
            tViewHolder = (ViewHolder) convertView.getTag();
            String string = mPostList.get(position);
            tViewHolder.postInfoView.setText(string);
            return convertView;
        }

        private class ViewHolder {
            TextView postInfoView;
        }


    }

}
