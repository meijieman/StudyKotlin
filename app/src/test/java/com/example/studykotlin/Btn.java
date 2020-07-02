package com.example.studykotlin;

import android.view.View;

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/29 下午11:34
 */
public class Btn {
    private View.OnClickListener mListener;

    public void setOnClickListener(View.OnClickListener l) {
        mListener = l;

    }
}
