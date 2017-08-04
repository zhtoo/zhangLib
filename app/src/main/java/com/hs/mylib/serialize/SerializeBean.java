package com.hs.mylib.serialize;

import java.io.Serializable;

/**
 * 作者：zhanghaitao on 2017/8/4 10:26
 * 邮箱：820159571@qq.com
 */

public class SerializeBean implements Serializable {

    public String name;
    public String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
