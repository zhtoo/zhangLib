package com.hs.recyclerviewadd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.hs.recyclerviewadd.R;

/**
 * Created by zhanghaitao on 2017/6/14.
 */

public class HeaderBottomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //item类型
    //在这里还是可以添加其他类型的。
    public static final int ITEM_TYPE_HEADER = 0;//头布局
    public static final int ITEM_TYPE_CONTENT = 1;//条目布局
    public static final int ITEM_TYPE_BOTTOM = 2;//脚布局

    //模拟数据（后期可以通过构造函数添加，也可以交给继承HeaderBottomAdapter的子类）
    public String[] texts = {"java", "python", "C++", "Php", ".NET", "js", "Ruby", "Swift", "OC",
            "java", "python", "C++", "Php", ".NET", "js", "Ruby", "Swift"};
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private int mHeaderCount = 1;//头部View个数
    private int mBottomCount = 1;//底部View个数

    /**
     * 构造函数（不多解释）
     *
     * @param context
     */
    public HeaderBottomAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    /**
     * 获取内容的长度
     *
     * @return
     */
    public int getContentItemCount() {
        return texts.length;
    }

    /**
     * 判断当前item是否是HeadView
     *
     * @param position
     * @return
     */
    public boolean isHeaderView(int position) {
        return mHeaderCount != 0 && position < mHeaderCount;
    }

    /**
     * 判断当前item是否是FooterView
     *
     * @param position
     * @return
     */
    public boolean isBottomView(int position) {
        return mBottomCount != 0 && position >= (mHeaderCount + getContentItemCount());
    }

    /**
     * 判断当前item类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        int dataItemCount = getContentItemCount();
        if (mHeaderCount != 0 && position < mHeaderCount) {
            //头部View
            return ITEM_TYPE_HEADER;
        } else if (mBottomCount != 0 && position >= (mHeaderCount + dataItemCount)) {
            //底部View
            return ITEM_TYPE_BOTTOM;
        } else {
            //内容View
            return ITEM_TYPE_CONTENT;
        }
    }

    /**
     * 内容 ViewHolder类
     */
    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ContentViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_item_text);
        }
    }

    /**
     * 头部 ViewHolder
     */
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);

        }
    }

    //底部 ViewHolder
    public static class BottomViewHolder extends RecyclerView.ViewHolder {
        public BottomViewHolder(View itemView) {
            super(itemView);
        }
    }

    //接下来的方法是大家熟悉的方法，不作解释
    /**
     * 这个方法不能反悔为空，需要继承父类或者返回一个视图。
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_HEADER) {
            return new HeaderViewHolder(mLayoutInflater.inflate(R.layout.rv_header, parent, false));
        } else if (viewType == mHeaderCount) {
            return new ContentViewHolder(mLayoutInflater.inflate(R.layout.rv_item, parent, false));
        } else if (viewType == ITEM_TYPE_BOTTOM) {
            return new BottomViewHolder(mLayoutInflater.inflate(R.layout.rv_footer, parent, false));
        }
        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).itemView.setVisibility(View.GONE);
        } else if (holder instanceof ContentViewHolder) {
            ((ContentViewHolder) holder).textView.setText(texts[position - mHeaderCount]);
        } else if (holder instanceof BottomViewHolder) {
        }
    }

    @Override
    public int getItemCount() {
        return mHeaderCount + getContentItemCount() + mBottomCount;
    }
}