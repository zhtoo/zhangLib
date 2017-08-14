package com.hs.mylib.network;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hs.mylib.R;

import java.util.HashMap;

/**
 * 作者：zhanghaitao on 2017/8/14 14:27
 * 邮箱：820159571@qq.com
 */

public class TestNetActivity extends AppCompatActivity {

    private LoadDataTask mLoadDataTask;
    private HttpURLConnectionHelper helper =new HttpURLConnectionHelper();

    //测试地址
    public static final String BASE_URL = "http://192.168.1.186:8088/";
    //首页地址
    public static final String HOME_URL = BASE_URL + "app/account/basic.html";
    //上传图片
    public static final String UPLOAD_PICTRUE_URL = BASE_URL + "app/upload/uploadPic.html";
    //预览图片请求地址
    public static final String PEWVIEW_PICTRUE_URL = BASE_URL + "app/upload/pictureList.html";

    private HashMap baseMap = new HashMap<String, String>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_net_activity);
        baseMap.put("appkey", "59CC8095F69F3F9F1D31935C771F1957");
        baseMap.put("signa", "DC419D40DC3C39505DD89070D5B11F95");
        baseMap.put("ts", "1502694523");
        baseMap.put("mobileType", "2");
        baseMap.put("versionNumber", "1.0");

    }

    public void get(View view) {
        Toast.makeText(this, "get", Toast.LENGTH_SHORT).show();
        ThreadPoolProxyFactory.getNormalThreadPoolProxy().submit(new Runnable() {
            @Override
            public void run() {
                baseMap.put("userId", "1");
                helper.requestGet(HOME_URL, baseMap);
            }
        });
    }

    public void post(View view) {
        Toast.makeText(this, "post", Toast.LENGTH_SHORT).show();
        ThreadPoolProxyFactory.getNormalThreadPoolProxy().submit(new Runnable() {
            @Override
            public void run() {
                baseMap.put("userId", "1");
                helper.requestPost(HOME_URL, baseMap);
            }
        });
    }

    public void uploadFile(View view) {
        Toast.makeText(this, "uploadFile", Toast.LENGTH_SHORT).show();
        ThreadPoolProxyFactory.getNormalThreadPoolProxy().submit(new Runnable() {
            @Override
            public void run() {
                /**
                 /storage/emulated/0/DCIM/Screenshots/Screenshot_2017-08-14-12-26-54-751_com.tencent.mobileqq.png
                 /storage/emulated/0/DCIM/Screenshots/Screenshot_2017-08-14-12-25-49-964_com.tencent.mobileqq.png
                 /storage/emulated/0/DCIM/Screenshots/Screenshot_2017-08-14-12-25-06-566_com.tencent.mobileqq.png
                 /storage/emulated/0/DCIM/Screenshots/Screenshot_2017-08-14-12-25-19-696_com.tencent.mobileqq.png
                 /storage/sdcard/Download/test05.jpg
                 */

                /**
                 *  {
                 *  mobileType=2,
                 *  ts=1502695880,
                 *  signa=0C530B762CE251FE921626CA9E76EC94,
                 *  appkey=59CC8095F69F3F9F1D31935C771F1957,
                 *  uploads=/data/data/com.hs.doubaobao/cache/test04.jpg,
                 *  nid=borrow,
                 *  versionNumber=1.0.0,
                 *  cusId=572
                 *  }
                 */
                ThreadPoolProxyFactory.getNormalThreadPoolProxy().submit(new Runnable() {
                    @Override
                    public void run() {
                        baseMap.clear();
                        baseMap.put("mobileType", "2");
                        baseMap.put("ts", "1502695880");
                        baseMap.put("signa", "0C530B762CE251FE921626CA9E76EC94");
                        baseMap.put("appkey", "59CC8095F69F3F9F1D31935C771F1957");
                        baseMap.put("nid", "borrow");
                        baseMap.put("versionNumber", "1.0.0");
                        baseMap.put("cusId", "572");
                     //   baseMap.put("uploads", "/storage/sdcard/Download/test01.jpg");
                        helper.upLoadFile(UPLOAD_PICTRUE_URL,
                                "/storage/sdcard/Download/test05.jpg" ,
                                baseMap);
                    }
                });
            }
        });
    }

    public void downloadFile(View view) {
        Toast.makeText(this, "downloadFile", Toast.LENGTH_SHORT).show();
        ThreadPoolProxyFactory.getNormalThreadPoolProxy().submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }


    /**
     * @des 联网加载数据
     * @called 联网加载数据的时候调用
     */
    public void loadDataFromNet() {

        //异步加载
        mLoadDataTask = new LoadDataTask();
        //利用线程池管理类开启线程
        ThreadPoolProxyFactory.getNormalThreadPoolProxy().submit(mLoadDataTask);
    }

    /**
     * 下载任务栈
     */
    class LoadDataTask implements Runnable {
        @Override
        public void run() {
            //联网加载数据---由子类实现
            loadData();

            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    //刷新UI---由子类实现
                    refreshView();
                }
            });
            //置空任务
            mLoadDataTask = null;
        }
    }

    private void loadData() {

    }

    private void refreshView() {

    }


}
