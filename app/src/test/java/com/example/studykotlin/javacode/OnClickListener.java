package com.example.studykotlin.javacode;

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/7/2 上午7:07
 */
// 函数式接口，需要使用 jdk8
public interface OnClickListener {

    default void onTouch() {
        System.out.println("xxxxx");
    }

    void onClick();
}
