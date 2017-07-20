package com.hs.sqldemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hs.sqldemo.db.CustomDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestDBActivity extends AppCompatActivity {


    private static final String TAG = "TestDBActivity";
    private Button add;
    private Button delete;
    private Button updata;
    private Button query;
    private Button addData;
    private TextView textView;
    private CustomDao dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_db);
        add = (Button) findViewById(R.id.add);
        delete = (Button) findViewById(R.id.delete);
        updata = (Button) findViewById(R.id.updata);
        query = (Button) findViewById(R.id.query);
        addData = (Button) findViewById(R.id.add_data);
        textView = (TextView) findViewById(R.id.textView);
        dao = new CustomDao(this);
    }

    public void add(View view) {
        dao.add("张亚鹏说相声");
    }

    public void delete(View view) {
        dao.delete("张亚鹏说相声");
    }

    public void query(View view) {
        Map<String, String> baseInfo = dao.findCustomBaseInfo("客户信息");
        for (String key :baseInfo.keySet()){
            Log.d(TAG,key + "="+baseInfo.get(key));
        }
        Map<String, String> spouseInfo = dao.findCustomSpouse("客户信息");
        for (String key :spouseInfo.keySet()){
            Log.d(TAG,key + "=" + spouseInfo.get(key));
        }

        Map<String, String> contactInfo = dao.findContactInfo("联系人1");
        for (String key :contactInfo.keySet()){
            Log.d(TAG,key + "=" + contactInfo.get(key));
        }

        Map<String, String> signInfo = dao.findSignAndData("借款");
        for (String key :signInfo.keySet()){
            Log.d(TAG,key + "=" + signInfo.get(key));
        }

        Map<String, String> loanNeedInfo = dao.findLoanNeed("张亚鹏说相声");
        for (String key :loanNeedInfo.keySet()){
            Log.d(TAG,key + "=" + loanNeedInfo.get(key));
        }

        Map<String, String> loanHoaueInfo = dao.findLoanHouase("房产信息1");
        for (String key :loanHoaueInfo.keySet()){
            Log.d(TAG,key + "=" + loanHoaueInfo.get(key));
        }

        Map<String, String> loanCarInfo = dao.findLoanCar("车辆信息1");
        for (String key :loanCarInfo.keySet()){
            Log.d(TAG,key + "=" + loanCarInfo.get(key));
        }

    }

    public void updata(View view) {

    }

    public void addData(View view) {
        List<String> baseInfo = new ArrayList<>();
        baseInfo.add("张亚鹏");
        baseInfo.add("男");
        baseInfo.add("421566199210253894");
        baseInfo.add("1992-10-25");
        baseInfo.add("安徽");
        baseInfo.add("安庆");
        baseInfo.add("有");
        baseInfo.add("未婚");
        baseInfo.add("本科");
        dao.addCustomBeseInfo(baseInfo, "客户信息");

        List<String> houseInfo = new ArrayList<>();
        houseInfo.add("租房");
        houseInfo.add("安徽省合肥市包河区绿地中心A");
        houseInfo.add("100365");
        houseInfo.add("安徽省合肥市包河区绿地中心B");
        houseInfo.add("100365");
        houseInfo.add("5");
        houseInfo.add("80");
        houseInfo.add("80");
        houseInfo.add("18005466366");
        dao.addCustomHouseInfo(houseInfo, "客户信息");

        List<String> workInfo = new ArrayList<>();
        workInfo.add("安徽汇生网络科技有限公司");
        workInfo.add("技术部");
        workInfo.add("8");
        workInfo.add("10000.00");
        workInfo.add("有");
        workInfo.add("有");
        workInfo.add("民营");
        workInfo.add("88");
        workInfo.add("安徽省合肥市包河区绿地中心C");
        workInfo.add("100365");
        workInfo.add("18005466366");
        workInfo.add("826647333@qq.com");
        workInfo.add("现单位地址");
        dao.addCustomWorkInfo(workInfo, "客户信息");

        List<String> spouseInfo = new ArrayList<>();
        spouseInfo.add("张晓婷");
        spouseInfo.add("421566199210253894");
        spouseInfo.add("安徽友汇金融");
        spouseInfo.add("客服部");
        spouseInfo.add("6");
        spouseInfo.add("9000.00");
        spouseInfo.add("安徽省合肥市包河区绿地中心D");
        spouseInfo.add("15266668888");
        spouseInfo.add("010-866554433");
        dao.addCustomSpouseInfo(spouseInfo, "客户信息");

        List<String> contactInfo = new ArrayList<>();
        contactInfo.add("张亚鹏说相声");
        contactInfo.add("张大千");
        contactInfo.add("1010102132");
        contactInfo.add("父子");
        dao.addContactInfo(contactInfo,"联系人1");

        List<String> signAndData = new ArrayList<>();
        signAndData.add("2017-11-06");
        signAndData.add("张亚鹏");
        signAndData.add("张晓婷");
        dao.addSignAndDataInfo(signAndData,"借款");

        List<String> loanNeed = new ArrayList<>();
        loanNeed.add("借款买小黄车");
        loanNeed.add("60万");
        loanNeed.add("24期");
        dao.addApplyLoanNeed(loanNeed,"张亚鹏说相声");

        List<String> loanhouseInfo = new ArrayList<>();
        loanhouseInfo.add("安徽省合肥市包河区绿地中心F");
        loanhouseInfo.add("有房有贷（月还：3000.00元）");
        loanhouseInfo.add("6-12月");
        loanhouseInfo.add("公司宿舍");
        loanhouseInfo.add("住宅");
        loanhouseInfo.add("防长啊肥东");
        loanhouseInfo.add("102546541号");
        loanhouseInfo.add("张亚鹏");
        loanhouseInfo.add("没有共有人");
        loanhouseInfo.add("2008-08-08");
        loanhouseInfo.add("100");
        loanhouseInfo.add("三室一厅");
        loanhouseInfo.add("12");
        loanhouseInfo.add("30");
        loanhouseInfo.add("70");
        loanhouseInfo.add("个人产权");
        dao.addHouseInfo(loanhouseInfo,"房产信息1");

        List<String> loanCarInfo = new ArrayList<>();
        loanCarInfo.add("有车无贷款");
        loanCarInfo.add("5-10万");
        loanCarInfo.add("张亚鹏");
        loanCarInfo.add("捷达");
        loanCarInfo.add("黑色");
        loanCarInfo.add("皖A.8888");
        loanCarInfo.add("奥迪A6");
        dao.addCarInfo(loanCarInfo,"车辆信息1");


    }


}
