package com.example.myapplication2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/*
* scale effect recyclerview
* */
public class TempRecyclerView extends RecyclerView {

    public TempRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public TempRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {}

    LinearLayoutManager linearLayoutManager;
    @Override
    public void setLayoutManager(LayoutManager layout) {
        super.setLayoutManager(layout);
        linearLayoutManager = (LinearLayoutManager) layout;
    }

    int viewHeight = 0;
    int screenCenterY;

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        // Calculate screen center Y once when the view is laid out
        if (screenCenterY == 0) {
            screenCenterY = getHeight() / 2;
        }
    }

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);

        int first = linearLayoutManager.findFirstVisibleItemPosition();
        int last = linearLayoutManager.findLastVisibleItemPosition();

        for (int i = first; i <= last; i++) {
            View view = linearLayoutManager.findViewByPosition(i);
            if (view != null) {
                int centerOfView = view.getTop() + (view.getHeight() / 2);
                int distanceFromCenter = Math.abs(screenCenterY - centerOfView);
                float scaleFactor = calculateScaleFactor(distanceFromCenter, i, last);

                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);
            }
        }
    }

    private float calculateScaleFactor(int distanceFromCenter, int position, int lastPosition) {
        // Define the maximum distance from center that will result in min scale.
        int maxDistanceForMinScale = getHeight() / 2;
        // Define the minimum scale factor for items not at the bottom.
        float minScale = 1.0f;
        // Define the maximum scale factor.
        float maxScale = 1.0f;

        if (position == lastPosition) {
            return 0.9f;
        }

        return maxScale;
    }
}