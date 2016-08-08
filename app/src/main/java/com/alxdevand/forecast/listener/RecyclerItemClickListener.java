package com.alxdevand.forecast.listener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    public interface OnItemClickListener {
        void onItemClick(int position);
        void onItemLongClick();
    }

    private OnItemClickListener mListener;
    private GestureDetector mGestureDetector;


    public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, final OnItemClickListener mListener) {
        this.mListener = mListener;
        this.mGestureDetector = new GestureDetector(context, new
                GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        return true;
                    }

                    @Override
                    public void onLongPress(MotionEvent e) {
                        View child = recyclerView.findChildViewUnder(e.getX(),
                                e.getY());
                        if (child != null && mListener != null) {
                            mListener.onItemLongClick();
                        }
                    }

                });
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {

        View child = view.findChildViewUnder(e.getX(), e.getY());
        if (child != null && mListener != null && mGestureDetector.
                onTouchEvent(e)) {
            mListener.onItemClick(view.getChildPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

}
