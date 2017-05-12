package com.bawei.cql0510;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by chengqianlang on 2017/5/10.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private Context mContext;
    private List<MyBean>mList;
    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public Myadapter(List<MyBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.myrecycler, parent, false);
        final ViewHolder holder = new ViewHolder(view);
//        holder.myview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//                MyBean myBean = mList.get(position);
//                Intent intent = new Intent(mContext, Main2Activity.class);
//                mContext.startActivity(intent);
//            }
//        });
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                MyBean myBean = mList.get(position);
                Toast.makeText(mContext,myBean.name,Toast.LENGTH_SHORT).show();
            }
        });
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                MyBean myBean = mList.get(position);
                Toast.makeText(mContext,"图片"+position,Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        MyBean myBean = mList.get(position);
        holder.iv.setImageResource(mList.get(position).map);
        holder.tv.setText(mList.get(position).name);

        if (mOnItemClickLitener != null)
        {
            holder.myview.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.myview, pos);
                }
            });

            holder.myview.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.myview, pos);
                    return true;
                }
            });
        }
    }



    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        View myview;

        public ViewHolder(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.myiv);
            tv= (TextView) itemView.findViewById(R.id.mytv);
            myview=itemView;
        }
    }


}
