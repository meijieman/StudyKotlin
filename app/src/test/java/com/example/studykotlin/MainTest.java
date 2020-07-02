package com.example.studykotlin;

import android.view.View;

import org.junit.Test;

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/28 上午11:43
 */
public class MainTest {

    @Test
    public void test() {
        System.out.println("file in kt");
    }


    public void test2() {
        Btn btn = new Btn();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("over");
            }
        });
    }
}



