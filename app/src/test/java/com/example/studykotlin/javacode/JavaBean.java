package com.example.studykotlin.javacode;

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/7/2 上午6:26
 */
public class JavaBean {
    private String name;
    private boolean enabled;

    public JavaBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean is(String name) {
        return this.name.equals(name);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getA() {
        return "A";
    }

    public void setA(String a) {

    }
}
