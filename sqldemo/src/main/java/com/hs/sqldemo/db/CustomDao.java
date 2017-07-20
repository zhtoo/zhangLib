package com.hs.sqldemo.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * customerInfo
 * contactList
 * sign
 * applyLoanNeed
 * houseInfo
 * carInfo
 * Created by zhanghaitao on 2017/6/27.
 */

public class CustomDao {

    private final static String TAG = "CustomDao";

    private DBOpenHelper helper;

    public CustomDao(Context context) {
        helper = new DBOpenHelper(context);
    }

    public void add(String need) {
        SQLiteDatabase db = helper.getWritableDatabase();
        //客户信息
        db.execSQL("insert into customerInfo (need,fromWho) values (?,?)", new Object[]{need, "客户信息"});
        //担保人信息
        db.execSQL("insert into customerInfo (need,fromWho) values (?,?)", new Object[]{need, "担保人信息"});
        //联系人信息
         db.execSQL("insert into contactList (need,fromWho) values (?,?)", new Object[]{need, "联系人1"});
         db.execSQL("insert into contactList (need,fromWho) values (?,?)", new Object[]{need, "联系人2"});
         db.execSQL("insert into contactList (need,fromWho) values (?,?)", new Object[]{need, "联系人3"});
         db.execSQL("insert into contactList (need,fromWho) values (?,?)", new Object[]{need, "联系人4"});
         db.execSQL("insert into contactList (need,fromWho) values (?,?)", new Object[]{need, "联系人5"});
        //借款签字
        db.execSQL("insert into sign (need,fromWho) values (?,?)", new Object[]{need, "借款"});
        //借款需求签字
        db.execSQL("insert into sign (need,fromWho) values (?,?)", new Object[]{need, "借款需求"});
        //需求信息
        db.execSQL("insert into applyLoanNeed (need) values (?)", new Object[]{need});
        //房产信息1
        db.execSQL("insert into houseInfo (need,fromWho) values (?,?)", new Object[]{need, "房产信息1"});
        //房产信息2
        db.execSQL("insert into houseInfo (need,fromWho) values (?,?)", new Object[]{need, "房产信息2"});
        //车辆信息1
        db.execSQL("insert into carInfo (need,fromWho) values (?,?)", new Object[]{need, "车辆信息1"});
        //车辆信息2
        db.execSQL("insert into carInfo (need,fromWho) values (?,?)", new Object[]{need, "车辆信息2"});
        db.close();//释放资源
    }

    /**
     * 添加客户基本信息
     */
    public void addCustomBeseInfo(List<String> beseInfo, String fromWho) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] aar = new String[]{
                "name",
                "sex",
                "IdCard",
                "birthday",
                "province",
                "city",
                "drivingLicense",
                "maritalStatus",
                "highestEducation"};
        String sql = "update customerInfo set ";
        for (int i = 0; i < aar.length; i++) {
            sql += (aar[i] + "='" + beseInfo.get(i) + "',");
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += (" where fromWho='" + fromWho + "'");
//        Log.d(TAG, sql);
        db.execSQL(sql);
        db.close();//释放资源
    }

    /**
     * 添加客户房屋信息
     *
     * @param houseInfo
     * @param fromWho
     */
    public void addCustomHouseInfo(List<String> houseInfo, String fromWho) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] aar = new String[]{
                "housingSituation",//现住房情况
                "housingAddress",//现住房地址
                "housingPostcode",//邮编
                "ownPropertyAddress",//自有房产地址
                "ownPropertyPostcode",//邮编
                "housingTime",//现住房居住时间
                "housingArea",//现住房面积
                "ownPropertyArea",//自有房产面积
                "mobilePhone"};//移动电话
        String sql = "update customerInfo set ";
        for (int i = 0; i < aar.length; i++) {
            sql += (aar[i] + "='" + houseInfo.get(i) + "',");
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += (" where fromWho='" + fromWho + "'");
//        Log.d(TAG, sql);
        db.execSQL(sql);
        db.close();//释放资源
    }

    /**
     * 添加客户工作信息
     *
     * @param workInfo
     * @param fromWho
     */
    public void addCustomWorkInfo(List<String> workInfo, String fromWho) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] aar = new String[]{
                "workUnitsName", //现单位名称
                "workDepartment", //所在部门
                "workDepartmentPeople", //部门人数
                "monthlyIncome", //月均工资收入
                "socialSecurity", //有无社保
                "accumulationFund", //有无公积金
                "workUnitsNature", //现单位性质
                "workingYears", //现单位工龄
                "workUnitsAddress ", //现单位地址
                "workUnitsPostcode ", //邮编
                "officePhone ", //办公电话
                "eMail", //E-mail
                "mailingAddress"  //邮寄地址
        };
        String sql = "update customerInfo set ";
        for (int i = 0; i < aar.length; i++) {
            sql += (aar[i] + "='" + workInfo.get(i) + "',");
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += (" where fromWho='" + fromWho + "'");
       // Log.d(TAG, sql);
        db.execSQL(sql);
        db.close();//释放资源
    }

    /**
     * 添加客户配偶信息
     *
     * @param spouseInfo
     * @param fromWho
     */
    public void addCustomSpouseInfo(List<String> spouseInfo, String fromWho) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] aar = new String[]{
                "spouseName", //配偶姓名
                "spouseIdCard", //配偶身份证
                "spouseUnitsName", //单位名称
                "spouseDepartment", //所在部门
                "spouseDepartmentPeople", //部门人数
                "spouseMonthlyIncome", //月均工资收入
                "spouseUnitsAddress", //现单位地址
                "spouseOfficePhone", //办公电话
                "spouseMobilePhone",//移动电话
        };
        String sql = "update customerInfo set ";
        for (int i = 0; i < aar.length; i++) {
            sql += (aar[i] + "='" + spouseInfo.get(i) + "',");
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += (" where fromWho='" + fromWho + "'");
//        Log.d(TAG, sql);
        db.execSQL(sql);
        db.close();//释放资源
    }

    /**
     * 添加关系信息（担保人的时候填写）
     * "relationshipGuarantor",//保证人与借款人关系
     * "relationshipBorrower"//共同借款人与借款人关系
     *
     * @param shipInfo
     * @param fromWho
     */
    public void addRelationshipInfo(List<String> shipInfo, String fromWho) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] aar = new String[]{
                "relationshipGuarantor", //保证人与借款人关系
                "relationshipBorrower"//共同借款人与借款人关系
        };
        String sql = "update customerInfo set ";
        for (int i = 0; i < aar.length; i++) {
            sql += (aar[i] + "='" + shipInfo.get(i) + "',");
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += (" where fromWho='" + fromWho + "'");
//        Log.d(TAG, sql);
        db.execSQL(sql);
        db.close();//释放资源
    }

    /**
     * 添加联系人信息
     *
     * @param contactInfo
     */
    public void addContactInfo(List<String> contactInfo,String fromWho) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] aar = new String[]{
                "contantName",
                "contantMobile",
                "relationship"
        };
        String sql = "update contactList set ";



        for (int i = 0; i < aar.length; i++) {
            sql += (aar[i] + "='" + contactInfo.get(i) + "',");
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += (" where fromWho='" + fromWho + "'");
//        Log.d(TAG, sql);
        db.execSQL(sql);
        db.close();//释放资源
    }

    /**
     * 添加签字及日期信息
     */
    public void addSignAndDataInfo(List<String> signAndData, String fromWho) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] aar = new String[]{
                "applydate",
                "customName",
                "guarantorName"
        };
        String sql = "update sign set ";
        for (int i = 0; i < aar.length; i++) {
            sql += (aar[i] + "='" + signAndData.get(i) + "',");
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += (" where fromWho='" + fromWho + "'");
//        Log.d(TAG, sql);
        db.execSQL(sql);
        db.close();//释放资源
    }

    /**
     * 添加借款需求信息
     *
     * @param need
     */
    public void addApplyLoanNeed(List<String> loanNeed, String need) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] aar = new String[]{
                "loanNeed",
                "loanGold",
                "loanPeriod"
        };
        String sql = "update applyLoanNeed set ";
        for (int i = 0; i < aar.length; i++) {
            sql += (aar[i] + "='" + loanNeed.get(i) + "',");
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += (" where need='" + need + "'");
//        Log.d(TAG, sql);
        db.execSQL(sql);
        db.close();//释放资源
    }

    /**
     * 添加房屋信息
     *
     * @param houseInfo
     */
    public void addHouseInfo(List<String> houseInfo, String fromWho) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] aar = new String[]{
                "estateAddress", //房屋坐落
                "estateStatus", //房产状况
                "estateLoanTime", //房贷时间
                "estateLiveStatus", //居住情况
                "estateNature", //房产性质
                "estateWarrants", //房地权证
                "estateWarrantsNumber", //字第
                "estateOwner", //房地产权利人
                "estateCommonSituation", //共有情况
                "estateRegistration", //登记日期
                "estateArea", //房屋建筑面积
                "estateType", //户型
                "estateFloor", //所在楼层
                "estateTotalFloor", //总楼层
                "estateConstructionLife", //建筑年限
                "estateRightNature"   //产权性质
        };
        String sql = "update houseInfo set ";
        for (int i = 0; i < aar.length; i++) {
            sql += (aar[i] + "='" + houseInfo.get(i) + "',");
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += (" where fromWho='" + fromWho + "'");
//        Log.d(TAG, sql);
        db.execSQL(sql);
        db.close();//释放资源
    }

    /**
     * 添加车辆信息
     *
     * @param carInfo
     */

    public void addCarInfo(List<String> carInfo, String fromWho) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] aar = new String[]{
                "carStatus", //车辆状况
                "carValue", //车辆价值
                "carOwner", //车辆所有人
                "carBrand", //车辆品牌
                "carColor", //车辆颜色
                "carNumber", //车辆牌照
                "carType"  //机动车型号
        };
        String sql = "update carInfo set ";
        for (int i = 0; i < aar.length; i++) {
            sql += (aar[i] + "='" + carInfo.get(i) + "',");
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += (" where fromWho='" + fromWho + "'");
//        Log.d(TAG, sql);
        db.execSQL(sql);
        db.close();//释放资源
    }

    /**
     * 删除客户所有的信息
     * customerInfo
     * contactList
     * sign
     * applyLoanNeed
     * houseInfo
     * carInfo
     * @param need 表单名称
     */
    public void delete(String need) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from customerInfo where need=?", new Object[]{need});
        db.execSQL("delete from contactList where need=?", new Object[]{need});
        db.execSQL("delete from sign where need=?", new Object[]{need});
        db.execSQL("delete from applyLoanNeed where need=?", new Object[]{need});
        db.execSQL("delete from houseInfo where need=?", new Object[]{need});
        db.execSQL("delete from carInfo where need=?", new Object[]{need});
        db.close();//释放资源
    }

    /**
     * 修改一个客户的信息
     *
     * @param key     修改表单的字段
     * @param value   新值
     * @param tabName 表名称
     * @param fromWho    借款表单名称
     */
    public void update(String key, String value, String tabName, String fromWho) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("update " + tabName + " set " + key + " =? where fromWho=?", new Object[]{value, fromWho});
        db.close();//释放资源
    }

    /**
     * 查询客户的性别
     *
     * @param name 客户的姓名
     * @return 客户性别 null代表客户不存在
     */
    public List<String> find(String name) {
        List<String> custom = new ArrayList<String>();
        SQLiteDatabase db = helper.getReadableDatabase();
        //结果集 游标
        Cursor cursor = db.rawQuery("select * from customerInfo where need=?", new String[]{name});
        boolean result = cursor.moveToNext();
        if (result) {
            for (int i = 0; i < 12; i++) {
                custom.add(cursor.getString(i));
            }
        }
        cursor.close();//释放资源
        db.close();//关闭数据库
        return custom;
    }

    /**
     * 获取全部的客户信息（待处理）
     * <p>
     * customerInfo
     * contactList
     * sign
     * applyLoanNeed
     * houseInfo
     * carInfo
     *
     * @return
     */
    public List<String> findAll(String fromWho) {
        List<String> custom = new ArrayList<String>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from customerInfo where fromWho=?", new String[]{fromWho});
        boolean result = cursor.moveToNext();
        if (result) {
//            Log.d(TAG, cursor.getString(0));
//            Log.d(TAG, cursor.getString(1));
//            Log.d(TAG, cursor.getString(2));
//            Log.d(TAG, cursor.getString(3));
//            Log.d(TAG, cursor.getString(4));
//            Log.d(TAG, cursor.getString(5));
//            Log.d(TAG, cursor.getString(6));
//            Log.d(TAG, cursor.getString(7));
//            Log.d(TAG, cursor.getString(8));
//            Log.d(TAG, cursor.getString(9));
//            Log.d(TAG, cursor.getString(10));
//            Log.d(TAG, cursor.getString(11));
//            Log.d(TAG, cursor.getString(12));
//            Log.d(TAG, cursor.getString(13));
//            Log.d(TAG, cursor.getString(14));
//            Log.d(TAG, cursor.getString(15));
//            Log.d(TAG, cursor.getString(16));
//            Log.d(TAG, cursor.getString(17));
//            Log.d(TAG, cursor.getString(18));
//            Log.d(TAG, cursor.getString(19));
//            Log.d(TAG, cursor.getString(20));
//            Log.d(TAG, cursor.getString(21));
//            Log.d(TAG, cursor.getString(22));
//            Log.d(TAG, cursor.getString(23));
//            Log.d(TAG, cursor.getString(24));
//            Log.d(TAG, cursor.getString(25));
//            Log.d(TAG, cursor.getString(26));
//            Log.d(TAG, cursor.getString(27));
//            Log.d(TAG, cursor.getString(28));
//            Log.d(TAG, cursor.getString(29));
//            Log.d(TAG, cursor.getString(30));
//            Log.d(TAG, cursor.getString(31));
//            Log.d(TAG, cursor.getString(32));
//            Log.d(TAG, cursor.getString(33));
//            Log.d(TAG, cursor.getString(34));
//            Log.d(TAG, cursor.getString(35));
//            Log.d(TAG, cursor.getString(36));
//            Log.d(TAG, cursor.getString(37));
//            Log.d(TAG, cursor.getString(38));
//            Log.d(TAG, cursor.getString(39));
//            Log.d(TAG, cursor.getString(40));
        }


        cursor.close();
        db.close();
        return custom;
    }

    /**
     * 查询客户的基本信息
     *
     * @param fromWho
     * @return
     */
    public Map<String, String> findCustomBaseInfo(String fromWho) {
        Map<String, String> map = new LinkedHashMap<>();

        SQLiteDatabase db = helper.getReadableDatabase();
        //结果集 游标
        Cursor cursor = db.rawQuery("select " +
                //0-8
                "name, " + //借款人姓名
                "sex, " +    //借款人性别
                "IdCard," + //借款人身份证号
                "birthday," +//生日
                "province," +//省
                "city," + //市
                "drivingLicense," +//驾照
                "maritalStatus," + //婚姻状况
                "highestEducation," +//最高学历
                //9-17
                "housingSituation," + //现住房情况
                "housingAddress," + //现住房地址
                "housingPostcode," + //邮编
                "ownPropertyAddress," +//自有房产地址
                "ownPropertyPostcode," +  //邮编
                "housingTime," +//现住房居住时间
                "housingArea," +//现住房面积
                "ownPropertyArea," + //自有房产面积
                "mobilePhone," + //移动电话
                //18-30
                "workUnitsName," + //现单位名称
                "workDepartment ," + //所在部门
                "workDepartmentPeople," + //部门人数
                "monthlyIncome," + //月均工资收入
                "socialSecurity," + //有无社保
                "accumulationFund," + //有无公积金
                "workUnitsNature," + //现单位性质
                "workingYears," + //现单位工龄
                "workUnitsAddress," + //现单位地址
                "workUnitsPostcode," + //邮编
                "officePhone," + //办公电话
                "eMail," + //E-mail
                "mailingAddress " + //邮寄地址
                " from customerInfo where fromWho=?", new String[]{fromWho});
        boolean result = cursor.moveToNext();
        if (result) {
            map.put("姓名", cursor.getString(0));
            map.put("性别", cursor.getString(1));
            map.put("身份证", cursor.getString(2));
            map.put("出生日期", cursor.getString(3));
            map.put("户籍所在地", cursor.getString(4) + cursor.getString(5));
            map.put("本人驾照", cursor.getString(6));
            map.put("婚姻状况", cursor.getString(7));
            map.put("最高学历", cursor.getString(8));

            map.put("分割线1", "line");

            map.put("现住房情况", cursor.getString(9));
            map.put("现住房地址", cursor.getString(10));
            map.put("邮编", cursor.getString(11));
            map.put("自有房产地址", cursor.getString(12));
            map.put("邮编", cursor.getString(13));
            map.put("现住房居住时间", cursor.getString(14));
            map.put("现住房面积", cursor.getString(15));
            map.put("自有房产面积", cursor.getString(16));
            map.put("移动电话", cursor.getString(17));

            map.put("分割线2", "line");

            map.put("现单位名称", cursor.getString(18));
            map.put("所在部门", cursor.getString(19) + cursor.getString(20));
            map.put("月均工资收入", cursor.getString(21));
            map.put("有无社保", cursor.getString(22));
            map.put("有无公积金", cursor.getString(23));
            map.put("现单位性质", cursor.getString(24));
            map.put("现单位工龄", cursor.getString(25));
            map.put("现单位地址", cursor.getString(26));
            map.put("邮编", cursor.getString(27));
            map.put("办公电话", cursor.getString(28));
            map.put("E-mail", cursor.getString(29));
            map.put("邮寄地址", cursor.getString(30));
        }
        cursor.close();
        db.close();
        return map;
    }

    /**
     * 查询客户的配偶信息
     *
     * @param fromWho
     * @return
     */
    public Map<String, String> findCustomSpouse(String fromWho) {
        Map<String, String> map = new LinkedHashMap<>();

        SQLiteDatabase db = helper.getReadableDatabase();
        //结果集 游标
        Cursor cursor = db.rawQuery("select " +
                //0-8
                "spouseName," +//配偶姓名
                "spouseIdCard," + //配偶身份证
                "spouseUnitsName," +//单位名称
                "spouseDepartment," + //所在部门
                "spouseDepartmentPeople," + //部门人数
                "spouseMonthlyIncome," +//月均工资收入
                "spouseUnitsAddress," +//现单位地址
                "spouseOfficePhone," + //办公电话
                "spouseMobilePhone" +//移动电话
                " from customerInfo where fromWho=?", new String[]{fromWho});
        boolean result = cursor.moveToNext();
        if (result) {
            map.put("配偶姓名", cursor.getString(0));
            map.put("身份证", cursor.getString(1));
            map.put("单位名称", cursor.getString(2));
            map.put("所在部门", cursor.getString(3) + cursor.getString(4));
            map.put("月均工资收入", cursor.getString(5));
            map.put("单位地址", cursor.getString(6));
            map.put("办公电话", cursor.getString(7));
            map.put("移动电话", cursor.getString(8));
        }
        cursor.close();
        db.close();
        return map;
    }


    /**
     * 查询客户的联系人信息
     *
     * @param fromWho
     * @return
     */
    public Map<String, String> findContactInfo(String fromWho) {
        Map<String, String> map = new LinkedHashMap<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        //结果集 游标
        Cursor cursor = db.rawQuery("select " +
                //0-2
                "contantName," + //联系人姓名
                "contantMobile," + //联系人电话
                "relationship" + //联系人关系
                " from contactList where fromWho=?", new String[]{fromWho});
        boolean result = cursor.moveToNext();
        if (result) {
            map.put("联系人姓名1", cursor.getString(0));
            map.put("联系人电话1", cursor.getString(1));
            map.put("与借款人关系1", cursor.getString(2));
        }
        cursor.close();
        db.close();
        return map;
    }

    /**
     * 查询签字及日期
     *
     * @param fromWho
     * @return
     */
    public Map<String, String> findSignAndData(String fromWho) {
        Map<String, String> map = new LinkedHashMap<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        //结果集 游标
        Cursor cursor = db.rawQuery("select " +
                //0-2
                "applydate, " + //申请日期
                "customName, " + //客户名
                "guarantorName" + //担保人
                " from sign where fromWho=?", new String[]{fromWho});
        boolean result = cursor.moveToNext();
        if (result) {
            map.put("承贷人签名", cursor.getString(1));
            map.put("担保人签字", cursor.getString(2));
            map.put("日期", cursor.getString(0));
        }
        cursor.close();
        db.close();
        return map;
    }

    /**
     * 查询借款用途
     *
     * @param need
     * @return
     */
    public Map<String, String> findLoanNeed(String need) {
        Map<String, String> map = new LinkedHashMap<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        //结果集 游标
        Cursor cursor = db.rawQuery("select " +
                //0-2
                "loanNeed," + //借款需求
                "loanGold," + //借款金额
                "loanPeriod" + //借款期限
                " from applyLoanNeed where need=?", new String[]{need});
        boolean result = cursor.moveToNext();
        if (result) {
            map.put("*借款用途", cursor.getString(0));
            map.put("*申请借款金额", cursor.getString(1));
            map.put("申请期限", cursor.getString(2));
        }
        cursor.close();
        db.close();
        return map;
    }

    /**
     * 查询住房信息
     *
     * @param fromWho
     * @return
     */
    public Map<String, String> findLoanHouase(String fromWho) {
        Map<String, String> map = new LinkedHashMap<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        //结果集 游标
        Cursor cursor = db.rawQuery("select " +
                //0-15
                "estateAddress," + //房屋坐落
                "estateStatus," + //房产状况
                "estateLoanTime," + //房贷时间
                "estateLiveStatus," + //居住情况
                "estateNature," + //房产性质
                "estateWarrants," + //房地权证
                "estateWarrantsNumber," + //字第
                "estateOwner," + //房地产权利人
                "estateCommonSituation," + //共有情况
                "estateRegistration," + //登记日期
                "estateArea," + //房屋建筑面积
                "estateType," + //户型
                "estateFloor," + //所在楼层
                "estateTotalFloor," + //总楼层
                "estateConstructionLife," + //建筑年限
                "estateRightNature " + //产权性质
                " from houseInfo where fromWho=?", new String[]{fromWho});
        boolean result = cursor.moveToNext();
        if (result) {
            map.put("房屋坐落", cursor.getString(0));
            map.put("房产状况", cursor.getString(1));
            map.put("房贷时间", cursor.getString(2));
            map.put("居住情况", cursor.getString(3));
            map.put("房产性质", cursor.getString(4));
            map.put("房产权证", cursor.getString(5));
            map.put("字第", cursor.getString(6));
            map.put("房地产权利人", cursor.getString(7));
            map.put("共有情况", cursor.getString(8));
            map.put("登记日期", cursor.getString(9));
            map.put("房屋建筑面积", cursor.getString(10));
            map.put("户型", cursor.getString(11));
            map.put("所在楼层", cursor.getString(12));
            map.put("总楼层", cursor.getString(13));
            map.put("建筑年限", cursor.getString(14));
            map.put("产权性质", cursor.getString(15));
        }
        cursor.close();
        db.close();
        return map;
    }

    /**
     * 查询车辆信息
     *
     * @param fromWho
     * @return
     */
    public Map<String, String> findLoanCar(String fromWho) {
        Map<String, String> map = new LinkedHashMap<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        //结果集 游标
        Cursor cursor = db.rawQuery("select " +
                //0-6
                "carStatus," + //车辆状况
                "carValue," + //车辆价值
                "carOwner," + //车辆所有人
                "carBrand," + //车辆品牌
                "carColor," + //车辆颜色
                "carNumber," + //车辆牌照
                "carType " + //机动车型号
                " from carInfo where fromWho=?", new String[]{fromWho});
        boolean result = cursor.moveToNext();
        if (result) {
            map.put("车辆状况", cursor.getString(0));
            map.put("车辆价值", cursor.getString(1));
            map.put("车辆所有人", cursor.getString(2));
            map.put("车辆品牌", cursor.getString(3));
            map.put("车辆颜色", cursor.getString(4));
            map.put("车辆照号码", cursor.getString(5));
            map.put("机动车机型", cursor.getString(6));
        }
        cursor.close();
        db.close();
        return map;
    }
}
