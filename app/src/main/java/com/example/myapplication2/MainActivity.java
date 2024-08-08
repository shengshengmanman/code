package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.animation.Animator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewtwo;

    ScrollBar scrollBar;

    MyHandler handler;


    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerViewtwo = findViewById(R.id.myrecyclertwo);
        scrollBar = findViewById(R.id.myscrollbar);

        handler = new MyHandler();

        List<BluetoothCallLog> datas = new ArrayList();
        datas.add(new BluetoothCallLog("张三1","23"));
        datas.add(new BluetoothCallLog("风格2","23"));
        datas.add(new BluetoothCallLog("更好3","23"));
        datas.add(new BluetoothCallLog("wiu4","23"));
        datas.add(new BluetoothCallLog("张三5","23"));
        datas.add(new BluetoothCallLog("符合6","23"));
        datas.add(new BluetoothCallLog("合法7","54"));
        datas.add(new BluetoothCallLog("规划8","23"));
        datas.add(new BluetoothCallLog("认同9","23"));
        datas.add(new BluetoothCallLog("干货10","64"));
        datas.add(new BluetoothCallLog("但是11","23"));
        datas.add(new BluetoothCallLog("品牌12","86"));
        datas.add(new BluetoothCallLog("张三13","23"));
        datas.add(new BluetoothCallLog("风格14","23"));
        datas.add(new BluetoothCallLog("更好15","23"));
        datas.add(new BluetoothCallLog("wiu16","23"));
        datas.add(new BluetoothCallLog("张三17","23"));
        datas.add(new BluetoothCallLog("符合18","23"));
        datas.add(new BluetoothCallLog("合法19","54"));
        datas.add(new BluetoothCallLog("规划20","23"));
        datas.add(new BluetoothCallLog("认同21","23"));
        datas.add(new BluetoothCallLog("干货22","64"));
        datas.add(new BluetoothCallLog("但是23","23"));
        datas.add(new BluetoothCallLog("品牌24","86"));
        datas.add(new BluetoothCallLog("张三1","23"));
        datas.add(new BluetoothCallLog("风格2","23"));
        datas.add(new BluetoothCallLog("更好3","23"));
        datas.add(new BluetoothCallLog("wiu4","23"));
        datas.add(new BluetoothCallLog("张三5","23"));
        datas.add(new BluetoothCallLog("符合6","23"));
        datas.add(new BluetoothCallLog("合法7","54"));
        datas.add(new BluetoothCallLog("规划8","23"));
        datas.add(new BluetoothCallLog("认同9","23"));
        datas.add(new BluetoothCallLog("干货10","64"));
        datas.add(new BluetoothCallLog("但是11","23"));
        datas.add(new BluetoothCallLog("品牌12","86"));
        datas.add(new BluetoothCallLog("张三13","23"));
        datas.add(new BluetoothCallLog("风格14","23"));
        datas.add(new BluetoothCallLog("更好15","22"));
        datas.add(new BluetoothCallLog("wiu16","23"));
        datas.add(new BluetoothCallLog("张三17","23"));
        datas.add(new BluetoothCallLog("符合18","23"));
        datas.add(new BluetoothCallLog("合法19","54"));
        datas.add(new BluetoothCallLog("规划20","23"));
        datas.add(new BluetoothCallLog("认同21","23"));
        datas.add(new BluetoothCallLog("干货22","64"));
        datas.add(new BluetoothCallLog("但是23","23"));
        datas.add(new BluetoothCallLog("品牌24","86"));


        LinearLayoutManager linearLayoutManagertwo = new LinearLayoutManager(this);
        recyclerViewtwo.setLayoutManager(linearLayoutManagertwo);
        recyclerViewtwo.setAdapter(new CallLogAdapter(datas));
        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadFreshData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        scrollBar.setRecycleView(recyclerViewtwo);

        recyclerViewtwo.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {

                Log.i(TAG,"onScrollStateChanged newState:"+newState);

                super.onScrollStateChanged(recyclerView, newState);
                switch (newState){
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE://滑动结束
                        Log.e("monkey","mScrollBarLayout INVISIBLE");
                        handler.sendEmptyMessageDelayed(1,800);
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL://开始滑动
                        handler.removeMessages(2);//移除所有标识符为2的消息
                        scrollBar.setAlpha(1f);//设置scrollBar的组件的透明度为完全不透明
                        scrollBar.setVisibility(View.VISIBLE);
                    default:
                        break;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {

                Log.i(TAG,"onScrolled dx:"+dx + " ; dy:"+dy);

                super.onScrolled(recyclerView, dx, dy);
                if(scrollBar!=null){
                    scrollBar.sroll();
                }
            }
        });


    }
    private void loadFreshData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<BluetoothCallLog> datas = new ArrayList();
                datas.add(new BluetoothCallLog("今天","1"));
                datas.add(new BluetoothCallLog("天气","2"));
                datas.add(new BluetoothCallLog("很好","3"));
                ((CallLogAdapter) recyclerViewtwo.getAdapter()).setData(datas);
                ((CallLogAdapter) recyclerViewtwo.getAdapter()).notifyDataSetChanged();
            }
        },2000);
    }


    class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {

            switch (msg.what){
                case 1:

                    if(recyclerViewtwo.getScrollState() != AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
                        return;
                    }
                    //创建一个动画，使scrollBar的透明度逐渐从完全不透明变为完全透明
                    scrollBar.animate()
                            .alpha(0f)
                            .setDuration(200)
                            .setListener(new Animator.AnimatorListener() {
                                @Override
                                public void onAnimationStart(Animator animator) {

                                }

                                @Override
                                public void onAnimationEnd(Animator animator) {
                                    scrollBar.setVisibility(View.INVISIBLE);
                                }

                                @Override
                                public void onAnimationCancel(Animator animator) {

                                }

                                @Override
                                public void onAnimationRepeat(Animator animator) {

                                }
                            });

                    break;

            }

        }
    }
}
