package com.hs.sqldemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



/**
 * Created by zhanghaitao on 2017/6/27.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String TAG = "DBOpenHelper";

    public DBOpenHelper(Context context) {
        super(context, "custom.db", null, 1);
    }

    /**
     * 当数据库被创建
     * 做一个关键的值----借款名称
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "CREATE TABLE");

       //创建个人信息表（包含基本信息、住房信息、工作信息和配偶信息）
        db.execSQL("create table customerInfo (_id integer primary key autoincrement," +
               //区分字符
                "fromWho varchar(30), " + //保存的是谁的信息
                //唯一字段，保证数据的唯一性
                "need varchar(30), " + //借款表单名称
                //个人信息
                "name varchar(20), " + //借款人姓名
                "sex varchar(20), " +    //借款人性别
                "IdCard varchar(20), " + //借款人身份证号
                "birthday varchar(20), " +//生日
                "province varchar(20), " +//省
                "city varchar(20), " +    //市
                "drivingLicense varchar(20), " +//驾照
                "maritalStatus varchar(20), " + //婚姻状况
                "highestEducation varchar(20), " +//最高学历
                //住房信息
                "housingSituation varchar(20), " + //现住房情况
                "housingAddress varchar(20), " + //现住房地址
                "housingPostcode varchar(20), " + //邮编
                "ownPropertyAddress varchar(20), " + //自有房产地址
                "ownPropertyPostcode varchar(20), " + //邮编
                "housingTime varchar(20), " + //现住房居住时间
                "housingArea varchar(20), " + //现住房面积
                "ownPropertyArea varchar(20), " + //自有房产面积
                "mobilePhone varchar(20), " + //移动电话
                //工作信息
                "workUnitsName varchar(20), " + //现单位名称
                "workDepartment varchar(20), " + //所在部门
                "workDepartmentPeople varchar(20), " + //部门人数
                "monthlyIncome varchar(20), " + //月均工资收入
                "socialSecurity varchar(20), " + //有无社保
                "accumulationFund varchar(20), " + //有无公积金
                "workUnitsNature varchar(20), " + //现单位性质
                "workingYears varchar(20), " + //现单位工龄
                "workUnitsAddress varchar(20), " + //现单位地址
                "workUnitsPostcode varchar(20), " + //邮编
                "officePhone varchar(20), " + //办公电话
                "eMail varchar(20), " + //E-mail
                "mailingAddress varchar(20), " + //邮寄地址
                //配偶信息
                "spouseName varchar(20), " + //配偶姓名
                "spouseIdCard varchar(20), " + //配偶身份证
                "spouseUnitsName varchar(20), " + //单位名称
                "spouseDepartment varchar(20), " + //所在部门
                "spouseDepartmentPeople varchar(20), " + //部门人数
                "spouseMonthlyIncome varchar(20), " + //月均工资收入
                "spouseUnitsAddress varchar(20), " + //现单位地址
                "spouseOfficePhone varchar(20), " + //办公电话
                "spouseMobilePhone varchar(20), " + //移动电话
                //关系
                "relationshipGuarantor varchar(20), " +//保证人与借款人关系
                "relationshipBorrower varchar(6))");//共同借款人与借款人关系

        //联系人表
        db.execSQL("create table contactList (_id integer primary key autoincrement," +
                //唯一字段，保证数据的唯一性
                "fromWho varchar(30), " + //保存的是谁的信息
                "need varchar(30), " + //借款表单名称
                "contantName varchar(20), " + //联系人姓名
                "contantMobile varchar(20), " + //联系人电话
                "relationship varchar(20) " + //联系人关系
                ")");

        //签字及日期（共用）
        db.execSQL("create table sign (_id integer primary key autoincrement," +
                //区分字符
                "fromWho varchar(30), " + //保存的是谁的信息
                //唯一字段，保证数据的唯一性
                "need varchar(30), " + //借款表单名称
                "applydate varchar(20), " + //申请日期
                "customName  varchar(20), " + //客户名
                "guarantorName varchar(20) " + //担保人
                ")");

        //借款需求
        db.execSQL("create table applyLoanNeed (_id integer primary key autoincrement," +
                //唯一字段，保证数据的唯一性
                "need varchar(30), " + //借款表单名称
                "loanNeed varchar(50), " + //借款需求
                "loanGold  varchar(20), " + //借款金额
                "loanPeriod varchar(20) " + //借款期限
                ")");

        //房产信息（共用）
        db.execSQL("create table houseInfo (_id integer primary key autoincrement," +
                //区分字符
                "fromWho varchar(30), " + //保存的是谁的信息
                //唯一字段，保证数据的唯一性
                "need varchar(30), " + //借款表单名称
                "estateAddress varchar(50), " + //房屋坐落
                "estateStatus  varchar(20), " + //房产状况
                "estateLoanTime varchar(20), " + //房贷时间
                "estateLiveStatus varchar(20), " + //居住情况
                "estateNature varchar(20), " + //房产性质
                "estateWarrants varchar(20)," + //房地权证
                "estateWarrantsNumber varchar(20), " + //字第
                "estateOwner varchar(20), " + //房地产权利人
                "estateCommonSituation varchar(20), " + //共有情况
                "estateRegistration varchar(20), " + //登记日期
                "estateArea varchar(20), " + //房屋建筑面积
                "estateType varchar(20), " + //户型
                "estateFloor varchar(20) ," + //所在楼层
                "estateTotalFloor varchar(20), " + //总楼层
                "estateConstructionLife varchar(20), " + //建筑年限
                "estateRightNature varchar(20) " + //产权性质
                ")");

        //车辆信息（共用）
        db.execSQL("create table carInfo (_id integer primary key autoincrement," +
                //区分字符
                "fromWho varchar(30), " + //保存的是谁的信息
                //唯一字段，保证数据的唯一性
                "need varchar(30), " + //借款表单名称
                "carStatus varchar(50), " + //车辆状况
                "carValue varchar(20), " + //车辆价值
                "carOwner varchar(20), " + //车辆所有人
                "carBrand varchar(20), " + //车辆品牌
                "carColor varchar(20), " + //车辆颜色
                "carNumber varchar(20), " + //车辆牌照
                "carType varchar(20) " + //机动车型号
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
