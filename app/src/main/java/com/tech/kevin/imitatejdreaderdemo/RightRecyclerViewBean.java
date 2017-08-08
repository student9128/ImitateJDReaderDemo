package com.tech.kevin.imitatejdreaderdemo;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/7/14 21:29.
 * <div>Blog: http://blog.csdn.net/student9128.</div>
 * <h3>Description:</h3>
 * <p/>
 * <p/>
 */


public class RightRecyclerViewBean {
    private String item1;
    private String item2;
    private int imageRes;

    public RightRecyclerViewBean() {

    }

    public RightRecyclerViewBean(String item1, String item2, int imageRes) {
        this.item1 = item1;
        this.item2 = item2;
        this.imageRes = imageRes;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }
}
