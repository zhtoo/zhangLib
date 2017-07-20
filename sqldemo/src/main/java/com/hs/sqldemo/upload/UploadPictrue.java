package com.hs.sqldemo.upload;

import android.database.Observable;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanghaitao on 2017/6/27.
 */

public class UploadPictrue {

    /*private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

            *//**
                * 上传多张图片及参数
                * @param reqUrl URL地址
                * @param params 参数
                * @param pic_key 上传图片的关键字
                * @param paths 图片路径
                *//*
            public Observable<String> sendMultipart(String reqUrl, Map<String, String> params, String pic_key, List<File> files){
        return Observable.create(new Observable.OnSubscribe<String>(){

                    @Override
            public void call(Subscriber<? super String> subscriber) {
                MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder();
                multipartBodyBuilder.setType(MultipartBody.FORM);
                //遍历map中所有参数到builder
                if (params != null){
                   for (String key : params.keySet()) {
                        multipartBodyBuilder.addFormDataPart(key, params.get(key));
                        }
                    }
                //遍历paths中所有图片绝对路径到builder，并约定key如“upload”作为后台接受多张图片的key
                if (files != null){
                    for (File file : files) {
                        multipartBodyBuilder.addFormDataPart(pic_key, file.getName(), RequestBody.create(MEDIA_TYPE_PNG, file));
                        }
                    }
               //构建请求体
               RequestBody requestBody = multipartBodyBuilder.build();

               Request.Builder RequestBuilder = new Request.Builder();
               RequestBuilder.url(reqUrl);// 添加URL地址
               RequestBuilder.post(requestBody);
               Request request = RequestBuilder.build();
               mOkHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    subscriber.onError(e);
                    subscriber.onCompleted();
                    call.cancel();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                    String str = response.body().string();
                        subscriber.onNext(str);
                        subscriber.onCompleted();
                        call.cancel();
                        }
                    });
                }
            });
        }
*/
}
