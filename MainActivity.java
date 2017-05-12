package com.bawei.cql0510;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private RecyclerView rv;
    private List<MyBean>list=new ArrayList<MyBean>();
    private List<Integer>pic=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv= (RecyclerView) findViewById(R.id.recycler);
        initdata();
        final Myadapter myadapter = new Myadapter(list, this);
        rv.setAdapter(myadapter);
        myadapter.setOnItemClickLitener(new Myadapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,"点击了"+position,Toast.LENGTH_SHORT).show();
                list.get(position).name="aaaa";
                myadapter.notifyItemChanged(position);
                myadapter.notifyItemInserted(position);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this,"长按了"+position,Toast.LENGTH_SHORT).show();
                list.remove(position);
                myadapter.notifyItemRemoved(position);
            }
        });
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        rv.setItemAnimator(new DefaultItemAnimator());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        rv.setLayoutManager(gridLayoutManager);

//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        rv.setLayoutManager(staggeredGridLayoutManager);

    }

    private void initdata() {
        pic.add(R.mipmap.pre1);
        pic.add(R.mipmap.pre2);
        pic.add(R.mipmap.pre3);
        pic.add(R.mipmap.pre4);
        pic.add(R.mipmap.pre5);
        pic.add(R.mipmap.pre6);
        pic.add(R.mipmap.pre7);
        pic.add(R.mipmap.pre8);
        pic.add(R.mipmap.pre9);
        pic.add(R.mipmap.pre12);
        pic.add(R.mipmap.pre13);
        pic.add(R.mipmap.pre14);
        pic.add(R.mipmap.pre15);
        pic.add(R.mipmap.pre16);
        pic.add(R.mipmap.pre17);
        pic.add(R.mipmap.pre19);
        pic.add(R.mipmap.pre21);
        pic.add(R.mipmap.pre22);

        for (int i = 0; i <pic.size() ; i++) {
            MyBean myBean = new MyBean();
            myBean.map=pic.get(i);
            myBean.name="这是美女"+i;
            list.add(myBean);
        }
    }
}
