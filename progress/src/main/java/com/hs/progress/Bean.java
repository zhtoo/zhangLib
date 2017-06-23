package com.hs.progress;

/**
 * Created by zhanghaitao on 2017/6/9.
 */

public class Bean {

    private  String title ;
    private  String[] sel ;

    public Bean() {
    }

    public Bean(String title,String[] sel) {
        this.title=title;
        this.sel=sel;

    }

    public  String[] getSel() {
        return sel;
    }

    public  void setSel(String[] sel) {
        this.sel = sel;
    }

    public  String getTitle() {
        return title;
    }

    public  void setTitle(String title) {
        this.title = title;
    }




}
