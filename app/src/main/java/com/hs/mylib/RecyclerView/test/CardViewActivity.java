package com.hs.mylib.RecyclerView.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hs.mylib.R;

import java.util.ArrayList;
import java.util.List;




public class CardViewActivity extends Activity {
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview_recyclerview);
        
        
        mRecyclerView= (RecyclerView) findViewById(R.id.recycler_view);

        // 创建一个线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // 默认是Vertical，可以不写
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
        
        
//		mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//		
//		RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(manager);
        
        List<ImageInfor> list = new ArrayList<ImageInfor>();
        list.add(new ImageInfor(R.drawable.caiyilin, "蔡依林"));
        list.add(new ImageInfor(R.drawable.ulinxinru, "林心如"));
        list.add(new ImageInfor(R.drawable.caiyilin,"蔡依林"));
        list.add(new ImageInfor(R.drawable.ulinxinru, "林心如"));
        list.add(new ImageInfor(R.drawable.caiyilin,"蔡依林"));
        list.add(new ImageInfor(R.drawable.ulinxinru, "林心如"));

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        MyAdapter myAdapter = new MyAdapter(list);
        mRecyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClick(new OnItemClick(){
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplication(),"点击了：" + position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
        private List<ImageInfor> list;
        public MyAdapter(List<ImageInfor> list){
            this.list = list;
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.carditem,viewGroup,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
            myViewHolder.iv_backgroud.setBackgroundResource(list.get(i).getImageId());
            myViewHolder.tv_title.setText(list.get(i).getName());
            final int position = i;
            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClick != null){
                        onItemClick.onItemClick(view,position);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private ImageView iv_backgroud;
            private TextView tv_title;
            public MyViewHolder(View itemView) {
                super(itemView);
                iv_backgroud = (ImageView) itemView.findViewById(R.id.picture);
                tv_title = (TextView) itemView.findViewById(R.id.name);
            }
        }

        private OnItemClick onItemClick;

        public void setOnItemClick(OnItemClick onItemClick) {
            this.onItemClick = onItemClick;
        }
    }
}
