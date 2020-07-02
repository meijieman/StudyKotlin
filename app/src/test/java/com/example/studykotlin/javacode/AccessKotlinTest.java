package com.example.studykotlin.javacode;

import org.junit.Test;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/7/2 上午7:14
 */
public class AccessKotlinTest {

    @Test
    public void test() {
        JavaBean2 bean = new JavaBean2();
        // 使用 lambda
        bean.setOnClickListener(() -> System.out.println("click"));
    }

    @Test
    public void test1() {
        KotlinBean bean = new KotlinBean("major");
        bean.setName("yun");
        System.out.println(bean.getName());

        bean.isAdult();
        bean.setAdult(true);

    }

    @Test
    public void test2() {
        // 将 kt 的非空类型，在 java 赋值为 null，会导致运行时抛 IllegalArgumentException
        KotlinBean bean = new KotlinBean(null);

    }

    @Test
    public void test3() {
        KotlinBean bean = new KotlinBean("major");
//        bean.setUsername("");
//        bean.getUsername();
        // 需要访问幕后字段，则需要用 @JvmField 注解对该属性进行标记
        bean.username = "yun"; // 幕后字段
    }


    @Test
    public void test4() {
        KotlinBean.companionProperty = 2;
    }

    @Test
    public void test5() {
        Singleton.name = "singleton";
        System.out.println(Singleton.id);
        // 对于顶层成员，编译器生成了类 SingletonKt
        System.out.println(SingletonKt.MAX_INT);

    }


    @Test
    public void test6() {
        KotlinBean.Companion.foo();
        KotlinBean.fooByAnno();

        Singleton.INSTANCE.foo();
        Singleton.fooByAnno();
    }


    @Test
    public void test7() {
        Class<KotlinBean> clazz = KotlinBean.class;
        // 获取 KClass
        KClass<KotlinBean> kotlinClass = JvmClassMappingKt.getKotlinClass(clazz);
    }


    @Test
    public void test8() {
        KotlinBean bean = new KotlinBean("");
        bean.foobar("");
        bean.foobar("", 1);
        bean.foobar("", 1, "");

    }


    @Test
    public void test9() {
        // 使用默认生成的类名
        System.out.println(SingletonKt.MAX_INT);

        // @file:JvmName("GlobalUtil") 修改默认生成的类名
        // @JvmName 可以应用到函数，Setter/Getter 和属性
        GlobalUtil.getDebug();
        GlobalUtil.test();

        GlobalUtil.test100();
    }


}
