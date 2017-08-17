package com.hs.mylib.okHttp.builder;


import com.hs.mylib.okHttp.OkHttpUtils;
import com.hs.mylib.okHttp.request.OtherRequest;
import com.hs.mylib.okHttp.request.RequestCall;

public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
