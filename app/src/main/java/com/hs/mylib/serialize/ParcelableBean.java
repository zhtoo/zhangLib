package com.hs.mylib.serialize;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 作者：zhanghaitao on 2017/8/4 10:28
 * 邮箱：820159571@qq.com
 */

public class ParcelableBean implements Parcelable {

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.state);
    }

    public ParcelableBean() {
    }

    protected ParcelableBean(Parcel in) {
        this.name = in.readString();
        this.state = in.readString();
    }

    public static final Parcelable.Creator<ParcelableBean> CREATOR = new Parcelable.Creator<ParcelableBean>() {
        @Override
        public ParcelableBean createFromParcel(Parcel source) {
            return new ParcelableBean(source);
        }

        @Override
        public ParcelableBean[] newArray(int size) {
            return new ParcelableBean[size];
        }
    };
}
