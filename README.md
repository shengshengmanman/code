ScrollBar

1、ScrollBar.java:自定义的RecyclerView侧边滚动条
2、ScrollBar滑动条和滑动条背景外框均可用xml自定义绘制，参考scroll_view.xml
3、xml添加ScrollBar，自定义位置和大小
	<com.example.myapplication2.ScrollBar
        android:id="@+id/myscrollbar"
        android:layout_marginTop="5dp"
        android:layout_width="6dp"
        android:layout_height="50dp"
        android:visibility="invisible"/>
4、activity中关联recyclerview，为recyclerview添加滚动监听器
	scrollBar.setRecycleView(recyclerViewtwo);
	recyclerViewtwo.addOnScrollListener(new RecyclerView.OnScrollListener() {});

TempRecyclerView

1、TempRecyclerView.java:自定义的缩放效果的recyclerview,可更改缩放比例
2、使用参考recyclerview




     



