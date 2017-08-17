package com.hs.mylib.okHttp.callback;


public interface IGenericsSerializator {
    <T> T transform(String response, Class<T> classOfT);
}
